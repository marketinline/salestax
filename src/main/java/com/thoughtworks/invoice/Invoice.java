/*
 * @author Manimaran Selvan
 */
package com.thoughtworks.invoice;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Invoice implements Serializable
{
	
	/** System generated Serial Version UID. */
	private static final long serialVersionUID = -337811426736633536L;
	
	private String invoiceID;
	private Map<String, Item> itemMap = new HashMap<String, Item>();
	private BigDecimal totalSalesTax = new BigDecimal("0");
	
	public Invoice()
	{
		invoiceID = UUID.randomUUID().toString();
	}	
	
	/**
	 * @return the itemMap
	 */
	public Map<String, Item> getItemMap()
	{
		return itemMap;
	}

	/**
	 * @param itemMap the itemMap to set
	 */
	public void setItemMap(Map<String, Item> itemMap)
	{
		this.itemMap = itemMap;
	}

	/**
	 * @return the totalSalesTax
	 */
	public BigDecimal getTotalSalesTax()
	{
		return totalSalesTax;
	}

	/**
	 * @param totalSalesTax the totalSalesTax to set
	 */
	public void setTotalSalesTax(BigDecimal totalSalesTax)
	{
		this.totalSalesTax = totalSalesTax;
	}

	public String getInvoiceID()
	{
		return invoiceID;
	}
}
