/*
 * @author Manimaran Selvan
 * Proprietary datastore of marketinline
 */
package com.emrg.smile.miledb;

import java.util.Collection;
import java.util.Map;

/**
 * The Class MileSerializer.
 *
 * @param <T> the generic type
 */
public class MileSerializer<T>
{
	/*
	 * This class should spawn a thread to serialize the data to some other persistence store, say mysql
	 * Class is stub for now	
	 */
	/**
	 * Put.
	 *
	 * @param key the key
	 * @param value the value
	 */
	public void put(String key, T value)
	{
		
	}
	
	/**
	 * Put all.
	 *
	 * @param map the map
	 */
	public void putAll(Map<String, T> map)
	{
		
	}
	
	/**
	 * Removes the.
	 *
	 * @param key the key
	 */
	public void remove(String key)
	{
		
	}
	
	/**
	 * Gets the.
	 *
	 * @param key the key
	 * @return the t
	 */
	public T get(String key)
	{
		return null;
	}
	
	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	public Collection<T> getAll()
	{
		return null;
	}
}
