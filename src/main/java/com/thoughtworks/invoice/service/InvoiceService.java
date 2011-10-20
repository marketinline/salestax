package com.thoughtworks.invoice.service;

import java.math.BigDecimal;
import java.util.Map;

import com.thoughtworks.invoice.Invoice;
import com.thoughtworks.invoice.Item;
import com.thoughtworks.invoice.dao.InvoiceDaoImpl;

public class InvoiceService
{
	private InvoiceDaoImpl invoiceDao;
	public void accumulateItem(Item item)
	{
		Invoice currentInvoice = invoiceDao.getCurrentInvoice();
		Map<String, Item> itemMap = currentInvoice.getItemMap();
		String itemID = item.getItemID();
		if(itemMap.containsKey(itemID))
		{
			Item inCartItem = itemMap.get(itemID);
			BigDecimal availableInCart = inCartItem.getQuantity();
			BigDecimal boughtNow = item.getQuantity();
			inCartItem.setQuantity(availableInCart.add(boughtNow));
		}
		else
		{
			itemMap.put(itemID, item);
		}
		BigDecimal totalSalesTax = item.getSalesTax().add(currentInvoice.getTotalSalesTax());
		currentInvoice.setTotalSalesTax(totalSalesTax);
	}
}
