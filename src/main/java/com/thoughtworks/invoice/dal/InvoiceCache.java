/*
 * @author Manimaran Selvan
 */
package com.thoughtworks.invoice.dal;

import java.math.BigDecimal;
import java.util.Map;

import com.emrg.smile.miledb.MileCache;
import com.thoughtworks.invoice.Invoice;
import com.thoughtworks.invoice.Item;

/**
 * The Class InvoiceCache.
 */
public class InvoiceCache extends MileCache<Invoice>
{
	
	/**
	 * Update invoice.
	 *
	 * @param invoiceID the invoice id
	 * @param itemID the item id
	 * @param quantity the quantity
	 * @return the invoice
	 */
	public Invoice updateInvoice(String invoiceID, String itemID, BigDecimal quantity)
	{
		Invoice invoice = getMileCacheMap().get(invoiceID);
		Map<String, Item> itemMap = invoice.getItemMap();
		itemMap.get(itemID).getQuantity().add(quantity);
		return invoice;
	}
}
