/*
 * @author Manimaran Selvan
 * Proprietary datastore of marketinline
 */
package com.emrg.smile.miledb;

import java.util.Collection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class MileDataStore.
 *
 * @param <T> the generic type
 */
public abstract class MileDataStore<T>
{
	
	/** The Constant logger. */
	protected static final Logger logger = LoggerFactory.getLogger(MileDataStore.class);

	/** The mile serializer. */
	protected MileSerializer<T> mileSerializer;
	
	/** The cached. */
	protected boolean cached = true;
	
	/**
	 * Put.
	 *
	 * @param key the key
	 * @param value the value
	 */
	public abstract void put(String key, T value);
	
	/**
	 * Gets the.
	 *
	 * @param key the key
	 * @return the t
	 */
	public abstract T get(String key);
	
	/**
	 * Removes the.
	 *
	 * @param key the key
	 */
	public abstract void remove(String key);
	
	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	public abstract Collection<T> getAll();
	
	/**
	 * Put all.
	 *
	 * @param map the map
	 */
	public abstract void putAll(Map<String, T> map);
	
	/**
	 * Checks if it is cached.
	 *
	 * @return true, if it is cached
	 */
	public boolean isCached()
	{
		return cached;
	}
	
	/**
	 * Sets the cached.
	 *
	 * @param cached the cached
	 */
	public void setCached(boolean cached)
	{
		this.cached = cached;
	}
	
	/**
	 * Gets the mile serializer.
	 *
	 * @return the mile serializer
	 */
	public MileSerializer<T> getMileSerializer()
	{
		return mileSerializer;
	}
	
	/**
	 * Sets the mile serializer.
	 *
	 * @param mileSerializer the mile serializer
	 */
	public void setMileSerializer(MileSerializer<T> mileSerializer)
	{
		this.mileSerializer = mileSerializer;
	}	
}
