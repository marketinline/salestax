/*
 * @author Manimaran Selvan
 */
package com.thoughtworks.invoice;

import java.io.Serializable;
import java.math.BigDecimal;

public class Item implements Serializable
{
	
	/** System generated Serial Version UID. */
	private static final long serialVersionUID = 1L;
	private String itemID;
	private String name;
	private BigDecimal quantity;
	private BigDecimal price;
	private BigDecimal salesTax;
	/**
	 * @return the itemID
	 */
	public String getItemID()
	{
		return itemID;
	}
	/**
	 * @param itemID the itemID to set
	 */
	public void setItemID(String itemID)
	{
		this.itemID = itemID;
	}
	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * @return the quantity
	 */
	public BigDecimal getQuantity()
	{
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(BigDecimal quantity)
	{
		this.quantity = quantity;
	}
	/**
	 * @return the price
	 */
	public BigDecimal getPrice()
	{
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price)
	{
		this.price = price;
	}
	public BigDecimal getSalesTax()
	{
		return salesTax;
	}
	public void setSalesTax(BigDecimal salesTax)
	{
		this.salesTax = salesTax;
	}
	
	
	
}
