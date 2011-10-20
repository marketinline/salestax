package com.emrg.smile.miledb;

import java.util.Collection;
import java.util.Map;

public class MileSerializer<T>
{
	/*
	 * This class should spawn a thread to serialize the data to some other persistence store, say mysql
	 * Class is stub for now	
	 */
	public void put(String key, T value)
	{
		
	}
	
	public void putAll(Map<String, T> map)
	{
		
	}
	
	public void remove(String key)
	{
		
	}
	public T get(String key)
	{
		return null;
	}
	
	public Collection<T> getAll()
	{
		return null;
	}
}
