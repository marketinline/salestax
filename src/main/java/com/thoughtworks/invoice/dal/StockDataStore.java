package com.thoughtworks.invoice.dal;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.emrg.smile.miledb.MileDataStore;
import com.thoughtworks.invoice.Item;

public class StockDataStore extends MileDataStore<Item>
{
	private Map<String, StockCache> stockCacheMap = new HashMap<String, StockCache>();
	
	public StockDataStore(StockCache stockCache, StockSerializer stockSerializer) 
	{
		super();
		logger.debug("Store initialized with parameters");
		/*
		 * This will be opened up when the serializer is complete functional
		 */
		/*if(cached)
		{
			Collection<Item> collection = stockSerializer.getAll();
			for(Item item : collection)
			{
				stockCache.put(item.getItemID(), item);
			}
		}*/
		this.stockCacheMap.put("default", stockCache);
		this.mileSerializer = stockSerializer;
	}

	private StockCache getDefaultCache()
	{
		return stockCacheMap.get("default");
	}
	
	@Override
	public void put(String key, Item value)
	{
		if(key!=null)
		{
			if(isCached())
			{
				StockCache defaultCache = getDefaultCache();
				defaultCache.put(key, value);
			}
			getMileSerializer().put(key, value);
		}
		
	}

	@Override
	public Item get(String key)
	{
		if(cached)
		{
			StockCache defaultCache = getDefaultCache();
			return defaultCache.get(key);			
		}
		return (Item) mileSerializer.get(key);
	}

	@Override
	public void remove(String key)
	{
		if(cached)
		{
			StockCache defaultCache = getDefaultCache();
			defaultCache.remove(key);			
		}
		mileSerializer.remove(key);
		
	}

	@Override
	public Collection<Item> getAll()
	{
		// TODO Implementation to fetch all the items
		return null;
	}

	@Override
	public void putAll(Map<String, Item> map)
	{
		if(map!=null && !map.isEmpty())
		{
			if(isCached())
			{
				StockCache defaultCache = getDefaultCache();
				defaultCache.putAll(map);
			}
			getMileSerializer().putAll(map);
		}	
	}
	
	public Boolean updateStock(Item item, BigDecimal quantity)
	{
		if(cached)
		{
			StockCache defaultCache = getDefaultCache();
			return defaultCache.updateStock(item.getItemID(), quantity);			
		}
		return ((StockSerializer)mileSerializer).updateStock(item.getItemID(), quantity);
	}
	
	public Boolean enquireStockAvailability(Item item)
	{
		if(cached)
		{
			StockCache defaultCache = getDefaultCache();
			return defaultCache.enquireStockAvailability(item.getItemID(), item.getQuantity());			
		}
		return ((StockSerializer)mileSerializer).enquireStockAvailability(item.getItemID(), item.getQuantity());
	}

}
