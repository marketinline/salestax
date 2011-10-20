package com.emrg.smile.miledb;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MileCache<T>
{
	private Map<String, T> mileCacheMap = new HashMap<String, T>();

	public Map<String, T> getMileCacheMap()
	{
		return mileCacheMap;
	}

	public void setMileCacheMap(Map<String, T> mileCache)
	{
		this.mileCacheMap = mileCache;
	}
	
	public T get(String key)
	{
		return mileCacheMap.get(key);
	}
	
	public void put(String key, T value)
	{
		if(key!=null)
		{
			mileCacheMap.put(key, value);
		}
	}
	
	public void putAll(Map<String, T> map)
	{
		mileCacheMap.putAll(map);
	}
	
	public void remove(String key)
	{
		if(mileCacheMap.containsKey(key))
			mileCacheMap.remove(key);
	}
	
	public Collection<T> getAll()
	{
		return mileCacheMap.values();
	}
}
