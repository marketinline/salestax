package com.thoughtworks.invoice.util;

import java.math.BigDecimal;

import com.thoughtworks.invoice.Invoice;
import com.thoughtworks.invoice.Item;
import com.thoughtworks.invoice.Tax;

public class InvoiceUtils
{
	private static final BigDecimal PERCENTAGE = new BigDecimal("100");
	private static final BigDecimal ROUND_OFF_FACTOR = new BigDecimal("0.05");
	
	public static Invoice calculateInvoice(Invoice invoice)
	{
		BigDecimal totalTax = new BigDecimal("0");
		BigDecimal totalAmount = new BigDecimal("0");
		for(Item item : invoice.getItemMap().values())
		{
			ItemTaxFiller.getInstance().fillTaxPercentage(item);
			BigDecimal singlePrice = item.getPrice();
			BigDecimal quantity = item.getQuantity();
			BigDecimal taxPercentage = new BigDecimal("0");
			for(Tax tax : item.getTaxes())
			{
				BigDecimal singlePercentage = tax.getTaxPercentage();
				taxPercentage = taxPercentage.add(singlePercentage);
			}
			BigDecimal itemTax = ((singlePrice.multiply(taxPercentage)).divide(PERCENTAGE)).multiply(quantity);
			BigDecimal roundedTax = applyRoundingFactor(itemTax);
			item.setTax(roundedTax);
			totalTax = totalTax.add(roundedTax);
			totalAmount = totalAmount.add(item.getItemAmount());
		}
		invoice.setTotalTax(totalTax);
		invoice.setTotalAmount(totalAmount);
		return invoice;
	}
	private static BigDecimal applyRoundingFactor(BigDecimal value)
	{
		BigDecimal result = new BigDecimal(Math.ceil(value.doubleValue()/ROUND_OFF_FACTOR.doubleValue())).multiply(ROUND_OFF_FACTOR);
		result = result.setScale(2);
		return result;
	}
}
