/*
 * @author Manimaran Selvan
 */
package com.thoughtworks.invoice.dal;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.emrg.smile.miledb.MileDataStore;
import com.thoughtworks.invoice.Item;

/**
 * The Class StockDataStore.
 */
public class StockDataStore extends MileDataStore<Item>
{
	
	/** The stock cache map. */
	private Map<String, StockCache> stockCacheMap = new HashMap<String, StockCache>();
	
	/**
	 * Instantiates a new stock data store.
	 *
	 * @param stockCache the stock cache
	 * @param stockSerializer the stock serializer
	 */
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

	/**
	 * Gets the default cache.
	 *
	 * @return the default cache
	 */
	private StockCache getDefaultCache()
	{
		return stockCacheMap.get("default");
	}
	
	/* (non-Javadoc)
	 * @see com.emrg.smile.miledb.MileDataStore#put(java.lang.String, java.lang.Object)
	 */
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

	/* (non-Javadoc)
	 * @see com.emrg.smile.miledb.MileDataStore#get(java.lang.String)
	 */
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

	/* (non-Javadoc)
	 * @see com.emrg.smile.miledb.MileDataStore#remove(java.lang.String)
	 */
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

	/* (non-Javadoc)
	 * @see com.emrg.smile.miledb.MileDataStore#getAll()
	 */
	@Override
	public Collection<Item> getAll()
	{
		// TODO Implementation to fetch all the items
		return null;
	}

	/* (non-Javadoc)
	 * @see com.emrg.smile.miledb.MileDataStore#putAll(java.util.Map)
	 */
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
	
	/**
	 * Update stock.
	 *
	 * @param item the item
	 * @param quantity the quantity
	 * @return the boolean
	 */
	public Boolean updateStock(Item item, BigDecimal quantity)
	{
		if(cached)
		{
			StockCache defaultCache = getDefaultCache();
			return defaultCache.updateStock(item.getItemID(), quantity);			
		}
		return ((StockSerializer)mileSerializer).updateStock(item.getItemID(), quantity);
	}
	
	/**
	 * Enquire stock availability.
	 *
	 * @param item the item
	 * @return the boolean
	 */
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
