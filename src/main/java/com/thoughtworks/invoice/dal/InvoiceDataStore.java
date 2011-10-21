package com.thoughtworks.invoice.dal;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.emrg.smile.miledb.MileDataStore;
import com.thoughtworks.invoice.Invoice;

public class InvoiceDataStore extends MileDataStore<Invoice>
{
	private Map<String, InvoiceCache> invoiceCacheMap = new HashMap<String, InvoiceCache>();
	
	public InvoiceDataStore(InvoiceCache invoiceCache) 
	{
		super();
		logger.debug("Store initialized with parameters");
		this.invoiceCacheMap.put("default", invoiceCache);
	}
	
	public InvoiceCache getDefaultCache()
	{
		return invoiceCacheMap.get("default");
	}
	
	public Map<String, InvoiceCache> getInvoiceCacheMap()
	{
		return invoiceCacheMap;
	}

	public void setInvoiceCacheMap(Map<String, InvoiceCache> invoiceCacheMap)
	{
		this.invoiceCacheMap = invoiceCacheMap;
	}
	@Override
	public void put(String key, Invoice value)
	{
		getDefaultCache().put(key, value);
	}

	@Override
	public Invoice get(String key)
	{
		return getDefaultCache().get(key);
	}

	@Override
	public void remove(String key)
	{
		getDefaultCache().remove(key);
		
	}
	
	public void removeAll(Collection<String> keySet)
	{
		for(String key : keySet)
		{
			getDefaultCache().remove(key);			
		}
	}

	@Override
	public Collection<Invoice> getAll()
	{
		return getDefaultCache().getAll();
	}

	@Override
	public void putAll(Map<String, Invoice> map)
	{
		getDefaultCache().putAll(map);
		
	}

}
