/*
 * @author Manimaran Selvan
 */
package com.thoughtworks.invoice.dal;

import java.math.BigDecimal;

import com.emrg.smile.miledb.MileSerializer;
import com.thoughtworks.invoice.Item;

/**
 * The Class StockSerializer.
 */
public class StockSerializer extends MileSerializer<Item>
{
	
	/**
	 * Enquire stock availability.
	 *
	 * @param itemID the item id
	 * @param quantity the quantity
	 * @return the boolean
	 */
	public Boolean enquireStockAvailability(String itemID, BigDecimal quantity)
	{
		/*
		 * Implementation when serializer available
		 */
		return Boolean.TRUE;
	}
	
	/**
	 * Update stock.
	 *
	 * @param itemID the item id
	 * @param quantity the quantity
	 * @return the boolean
	 */
	public Boolean updateStock(String itemID, BigDecimal quantity)
	{
		if(enquireStockAvailability(itemID, quantity))
		{
			/*
			 * Implementation when serializer available
			 */
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
}
