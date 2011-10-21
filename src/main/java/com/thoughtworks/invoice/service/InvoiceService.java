package com.thoughtworks.invoice.service;

import java.math.BigDecimal;
import java.util.Map;

import com.thoughtworks.invoice.Invoice;
import com.thoughtworks.invoice.Item;
import com.thoughtworks.invoice.dal.InvoiceDaoImpl;

public class InvoiceService
{
	private InvoiceDaoImpl invoiceDao;
	private Invoice currentInvoice;
	
	public InvoiceService(InvoiceDaoImpl invoiceDao)
	{
		this.invoiceDao = invoiceDao;
		if(currentInvoice==null)
		{
			Invoice invoice = new Invoice();
			this.currentInvoice = invoice;
			invoiceDao.createOrUpdateInvoice(invoice);
		}
	}
	
	public Boolean accumulateItem(Item item)
	{
		if(invoiceDao.updateQuantity(currentInvoice, item))
		{
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
			invoiceDao.createOrUpdateInvoice(currentInvoice);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
		
	public void counterTransaction()
	{
		Map<String, Item> itemMap = currentInvoice.getItemMap();
		for(Item item : itemMap.values())
		{
			item.setQuantity(item.getQuantity().negate());
			invoiceDao.updateQuantity(currentInvoice, item);
		}
		itemMap.clear();
	}
	
	public Boolean enquireStockAvailability(Item item)
	{
		return invoiceDao.enquireStockAvailability(item);
	}
	
	public Invoice getCurrentInvoice()
	{
		return currentInvoice;
	}
}
