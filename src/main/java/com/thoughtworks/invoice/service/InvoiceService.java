/*
 * @author Manimaran Selvan
 */
package com.thoughtworks.invoice.service;

import java.math.BigDecimal;
import java.util.Map;

import com.thoughtworks.invoice.Invoice;
import com.thoughtworks.invoice.Item;
import com.thoughtworks.invoice.dal.InvoiceDaoImpl;

/**
 * The Class InvoiceService.
 */
public class InvoiceService
{
	
	/** The invoice dao. */
	private InvoiceDaoImpl invoiceDao;
	
	/** The current invoice. */
	private Invoice currentInvoice;
	
	/**
	 * Instantiates a new invoice service.
	 *
	 * @param invoiceDao the invoice dao
	 */
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
	
	/**
	 * Accumulate item.
	 *
	 * @param item the item
	 * @return the boolean
	 */
	public Boolean accumulateItem(Item item)
	{
		if(invoiceDao.updateQuantity(item, item.getQuantity().negate()))
		{
			Map<String, Item> itemMap = currentInvoice.getItemMap();
			String itemID = item.getItemID();
			if(itemMap.containsKey(itemID))
			{
				Item inCartItem = itemMap.get(itemID);
				BigDecimal availableInCart = inCartItem.getQuantity();
				BigDecimal boughtNow = item.getQuantity();
				inCartItem.setQuantity(availableInCart.add(boughtNow));
				invoiceDao.createOrUpdateInvoice(currentInvoice);
			}
			else
			{
				Item itemFromStore = invoiceDao.fetchItemFromStore(itemID);
				Item clonedItem = itemFromStore.cloneBasicFields();
				clonedItem.setQuantity(item.getQuantity());
				itemMap.put(itemID, clonedItem);
				invoiceDao.createOrUpdateInvoice(currentInvoice);
			}
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
		
	/**
	 * Counter transaction.
	 */
	public void counterTransaction()
	{
		Map<String, Item> itemMap = currentInvoice.getItemMap();
		for(Item item : itemMap.values())
		{
			invoiceDao.updateQuantity(item, item.getQuantity());
		}
		currentInvoice = new Invoice();
	}
	
	/**
	 * Enquire stock availability.
	 *
	 * @param item the item
	 * @return the boolean
	 */
	public Boolean enquireStockAvailability(Item item)
	{
		return invoiceDao.enquireStockAvailability(item);
	}
	
	/**
	 * Gets the current invoice.
	 *
	 * @return the current invoice
	 */
	public Invoice getCurrentInvoice()
	{
		return currentInvoice;
	}
	
	/**
	 * Load stock store.
	 *
	 * @param itemMap the item map
	 */
	public void loadStockStore(Map<String, Item> itemMap)
	{
		invoiceDao.loadStockStore(itemMap);
	}
	
	/**
	 * Clear stock store.
	 */
	public void clearStockStore()
	{
		// TODO Need to implement
	}
}
