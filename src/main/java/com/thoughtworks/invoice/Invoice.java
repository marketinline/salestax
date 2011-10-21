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
	private BigDecimal totalTax = new BigDecimal("0");
	private BigDecimal totalAmount = new BigDecimal("0");
	
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
	public BigDecimal getTotalTax()
	{
		return totalTax;
	}

	/**
	 * @param totalSalesTax the totalSalesTax to set
	 */
	public void setTotalTax(BigDecimal totalSalesTax)
	{
		this.totalTax = totalSalesTax;
	}

	public String getInvoiceID()
	{
		return invoiceID;
	}

	public BigDecimal getTotalAmount()
	{
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount)
	{
		this.totalAmount = totalAmount;
	}
}
