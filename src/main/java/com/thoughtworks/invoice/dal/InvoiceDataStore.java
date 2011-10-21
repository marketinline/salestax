/*
 * @author Manimaran Selvan
 */
package com.thoughtworks.invoice.dal;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.emrg.smile.miledb.MileDataStore;
import com.thoughtworks.invoice.Invoice;

/**
 * The Class InvoiceDataStore.
 */
public class InvoiceDataStore extends MileDataStore<Invoice>
{
	
	/** The invoice cache map. */
	private Map<String, InvoiceCache> invoiceCacheMap = new HashMap<String, InvoiceCache>();
	
	/**
	 * Instantiates a new invoice data store.
	 *
	 * @param invoiceCache the invoice cache
	 */
	public InvoiceDataStore(InvoiceCache invoiceCache) 
	{
		super();
		logger.debug("Store initialized with parameters");
		this.invoiceCacheMap.put("default", invoiceCache);
	}
	
	/**
	 * Gets the default cache.
	 *
	 * @return the default cache
	 */
	public InvoiceCache getDefaultCache()
	{
		return invoiceCacheMap.get("default");
	}
	
	/**
	 * Gets the invoice cache map.
	 *
	 * @return the invoice cache map
	 */
	public Map<String, InvoiceCache> getInvoiceCacheMap()
	{
		return invoiceCacheMap;
	}

	/**
	 * Sets the invoice cache map.
	 *
	 * @param invoiceCacheMap the invoice cache map
	 */
	public void setInvoiceCacheMap(Map<String, InvoiceCache> invoiceCacheMap)
	{
		this.invoiceCacheMap = invoiceCacheMap;
	}
	
	/* (non-Javadoc)
	 * @see com.emrg.smile.miledb.MileDataStore#put(java.lang.String, java.lang.Object)
	 */
	@Override
	public void put(String key, Invoice value)
	{
		getDefaultCache().put(key, value);
	}

	/* (non-Javadoc)
	 * @see com.emrg.smile.miledb.MileDataStore#get(java.lang.String)
	 */
	@Override
	public Invoice get(String key)
	{
		return getDefaultCache().get(key);
	}

	/* (non-Javadoc)
	 * @see com.emrg.smile.miledb.MileDataStore#remove(java.lang.String)
	 */
	@Override
	public void remove(String key)
	{
		getDefaultCache().remove(key);
		
	}
	
	/**
	 * Removes the all.
	 *
	 * @param keySet the key set
	 */
	public void removeAll(Collection<String> keySet)
	{
		for(String key : keySet)
		{
			getDefaultCache().remove(key);			
		}
	}

	/* (non-Javadoc)
	 * @see com.emrg.smile.miledb.MileDataStore#getAll()
	 */
	@Override
	public Collection<Invoice> getAll()
	{
		return getDefaultCache().getAll();
	}

	/* (non-Javadoc)
	 * @see com.emrg.smile.miledb.MileDataStore#putAll(java.util.Map)
	 */
	@Override
	public void putAll(Map<String, Invoice> map)
	{
		getDefaultCache().putAll(map);
		
	}

}
