package com.emrg.smile.miledb;

import java.util.Collection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class MileDataStore<T>
{
	protected static final Logger logger = LoggerFactory.getLogger(MileDataStore.class);

	protected MileSerializer<T> mileSerializer;
	protected boolean cached = true;
	public abstract void put(String key, T value);
	public abstract T get(String key);
	public abstract void remove(String key);
	public abstract Collection<T> getAll();
	public abstract void putAll(Map<String, T> map);
	
	public boolean isCached()
	{
		return cached;
	}
	public void setCached(boolean cached)
	{
		this.cached = cached;
	}
	public MileSerializer<T> getMileSerializer()
	{
		return mileSerializer;
	}
	public void setMileSerializer(MileSerializer<T> mileSerializer)
	{
		this.mileSerializer = mileSerializer;
	}	
}
