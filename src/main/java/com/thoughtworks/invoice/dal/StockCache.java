/*
 * @author Manimaran Selvan
 */
package com.thoughtworks.invoice.dal;

import java.math.BigDecimal;

import com.emrg.smile.miledb.MileCache;
import com.thoughtworks.invoice.Item;

/**
 * The Class StockCache.
 */
public class StockCache extends MileCache<Item>
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
		if(itemID!=null && getMileCacheMap().containsKey(itemID))
		{
			Item item = get(itemID);
			if(item.getQuantity().compareTo(quantity)>=0)
			{
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
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
			getMileCacheMap().get(itemID).getQuantity().add(quantity);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
}
