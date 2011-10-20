package com.thoughtworks.invoice.dal;

import java.math.BigDecimal;

import com.emrg.smile.miledb.MileSerializer;
import com.thoughtworks.invoice.Item;

public class StockSerializer extends MileSerializer<Item>
{
	public Boolean enquireStockAvailability(String itemID, BigDecimal quantity)
	{
		/*
		 * Implementation when serializer available
		 */
		return Boolean.TRUE;
	}
	
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
