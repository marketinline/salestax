/*
 * @author Manimaran Selvan
 */
package com.thoughtworks.invoice.dal;

import java.math.BigDecimal;
import java.util.Map;

import com.thoughtworks.invoice.Invoice;
import com.thoughtworks.invoice.Item;

/**
 * The Class InvoiceDaoImpl.
 */
public class InvoiceDaoImpl
{
	
	/** The stock data store. */
	private StockDataStore stockDataStore;
	
	/** The invoice data store. */
	private InvoiceDataStore invoiceDataStore;
	
	/**
	 * Creates the or update invoice.
	 *
	 * @param invoice the invoice
	 */
	public void createOrUpdateInvoice(Invoice invoice)
	{
		getInvoiceDataStore().put(invoice.getInvoiceID(), invoice);
	}
	
	/**
	 * Fetch item from store.
	 *
	 * @param itemID the item id
	 * @return the item
	 */
	public Item fetchItemFromStore(String itemID)
	{
		return stockDataStore.get(itemID);
	}
	
	/**
	 * Update quantity.
	 *
	 * @param item the item
	 * @param quantity the quantity
	 * @return the boolean
	 */
	public Boolean updateQuantity(Item item, BigDecimal quantity)
	{
		return getStockDataStore().updateStock(item, quantity);
	}
		
	/**
	 * Enquire stock availability.
	 *
	 * @param item the item
	 * @return the boolean
	 */
	public Boolean enquireStockAvailability(Item item)
	{
		return getStockDataStore().enquireStockAvailability(item);
	}
	
	/**
	 * Load stock store.
	 *
	 * @param itemMap the item map
	 */
	public void loadStockStore(Map<String, Item> itemMap)
	{
		getStockDataStore().putAll(itemMap);
	}

	/**
	 * Gets the invoice data store.
	 *
	 * @return the invoice data store
	 */
	public InvoiceDataStore getInvoiceDataStore()
	{
		return invoiceDataStore;
	}

	/**
	 * Sets the invoice data store.
	 *
	 * @param invoiceDataStore the invoice data store
	 */
	public void setInvoiceDataStore(InvoiceDataStore invoiceDataStore)
	{
		this.invoiceDataStore = invoiceDataStore;
	}

	/**
	 * Gets the stock data store.
	 *
	 * @return the stock data store
	 */
	public StockDataStore getStockDataStore()
	{
		return stockDataStore;
	}

	/**
	 * Sets the stock data store.
	 *
	 * @param stockDataStore the stock data store
	 */
	public void setStockDataStore(StockDataStore stockDataStore)
	{
		this.stockDataStore = stockDataStore;
	}
	
}
