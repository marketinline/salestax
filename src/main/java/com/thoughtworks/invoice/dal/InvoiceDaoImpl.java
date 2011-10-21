package com.thoughtworks.invoice.dal;

import java.math.BigDecimal;
import java.util.Map;

import com.thoughtworks.invoice.Invoice;
import com.thoughtworks.invoice.Item;

public class InvoiceDaoImpl
{
	private StockDataStore stockDataStore;
	private InvoiceDataStore invoiceDataStore;
	
	public void createOrUpdateInvoice(Invoice invoice)
	{
		getInvoiceDataStore().put(invoice.getInvoiceID(), invoice);
	}
	
	public Item fetchItemFromStore(String itemID)
	{
		return stockDataStore.get(itemID);
	}
	public Boolean updateQuantity(Item item, BigDecimal quantity)
	{
		return getStockDataStore().updateStock(item, quantity);
	}
		
	public Boolean enquireStockAvailability(Item item)
	{
		return getStockDataStore().enquireStockAvailability(item);
	}
	
	public void loadStockStore(Map<String, Item> itemMap)
	{
		getStockDataStore().putAll(itemMap);
	}

	public InvoiceDataStore getInvoiceDataStore()
	{
		return invoiceDataStore;
	}

	public void setInvoiceDataStore(InvoiceDataStore invoiceDataStore)
	{
		this.invoiceDataStore = invoiceDataStore;
	}

	public StockDataStore getStockDataStore()
	{
		return stockDataStore;
	}

	public void setStockDataStore(StockDataStore stockDataStore)
	{
		this.stockDataStore = stockDataStore;
	}
	
}
