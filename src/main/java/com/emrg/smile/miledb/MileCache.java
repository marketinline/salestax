/*
 * @author Manimaran Selvan
 * Proprietary datastore of marketinline
 */
package com.emrg.smile.miledb;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * The Class MileCache.
 *
 * @param <T> the generic type
 */
public class MileCache<T>
{
	
	/** The mile cache map. */
	private Map<String, T> mileCacheMap = new HashMap<String, T>();

	/**
	 * Gets the mile cache map.
	 *
	 * @return the mile cache map
	 */
	public Map<String, T> getMileCacheMap()
	{
		return mileCacheMap;
	}

	/**
	 * Sets the mile cache map.
	 *
	 * @param mileCache the mile cache
	 */
	public void setMileCacheMap(Map<String, T> mileCache)
	{
		this.mileCacheMap = mileCache;
	}
	
	/**
	 * Gets the.
	 *
	 * @param key the key
	 * @return the t
	 */
	public T get(String key)
	{
		return mileCacheMap.get(key);
	}
	
	/**
	 * Put.
	 *
	 * @param key the key
	 * @param value the value
	 */
	public void put(String key, T value)
	{
		if(key!=null)
		{
			mileCacheMap.put(key, value);
		}
	}
	
	/**
	 * Put all.
	 *
	 * @param map the map
	 */
	public void putAll(Map<String, T> map)
	{
		mileCacheMap.putAll(map);
	}
	
	/**
	 * Removes the.
	 *
	 * @param key the key
	 */
	public void remove(String key)
	{
		if(mileCacheMap.containsKey(key))
			mileCacheMap.remove(key);
	}
	
	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	public Collection<T> getAll()
	{
		return mileCacheMap.values();
	}
}
