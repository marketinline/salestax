/*
 * @author Manimaran Selvan
 */
package com.thoughtworks.invoice;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Item implements Serializable
{
	
	/** System generated Serial Version UID. */
	private static final long serialVersionUID = 1L;
	private String itemID;
	private String name;
	private BigDecimal quantity;
	private BigDecimal price;
	private BigDecimal salesTax;
	private Set<Tax> taxes = new HashSet<Tax>();
		
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
	
	/* (non-Javadoc)
	 * This should not be used as you will have to manually remove the quantity
	 * Use cloneBasicFields instead
	 * @see java.lang.Object#clone()
	 */
	@Override
	@Deprecated
	public Item clone()
	{
		Item item = new Item();
		item.setItemID(this.itemID);
		item.setName(this.name);
		item.setPrice(this.price);
		item.setQuantity(this.quantity);
		item.setSalesTax(this.salesTax);
		item.setTaxes(this.taxes);
		return item;
	}
	
	public Item cloneBasicFields()
	{
		Item item = new Item();
		item.setItemID(this.itemID);
		item.setName(this.name);
		item.setPrice(this.price);
		item.setTaxes(this.taxes);
		return item;
	}
	public Set<Tax> getTaxes()
	{
		return taxes;
	}
	public void setTaxes(Set<Tax> taxes)
	{
		this.taxes = taxes;
	}
	public BigDecimal getItemAmount()
	{
		return (price.multiply(quantity)).add(salesTax);
	}
	
}
