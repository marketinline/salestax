package com.thoughtworks.invoice.dal;

import com.thoughtworks.invoice.Invoice;
import com.thoughtworks.invoice.Item;

public class InvoiceDaoImpl
{
	private StockDataStore stockDataStore;
	private InvoiceDataStore invoiceDataStore;
	
	public void createOrUpdateInvoice(Invoice invoice)
	{
		invoiceDataStore.put(invoice.getInvoiceID(), invoice);
	}
	
	public Boolean updateQuantity(Invoice invoice, Item item)
	{
		return stockDataStore.updateStock(item);
	}
		
	public Boolean enquireStockAvailability(Item item)
	{
		return stockDataStore.enquireStockAvailability(item);
	}
}
