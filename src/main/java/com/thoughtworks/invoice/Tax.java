/*
 * @author Manimaran Selvan
 */
package com.thoughtworks.invoice;

import java.io.Serializable;
import java.math.BigDecimal;

import com.thoughtworks.invoice.util.ItemTaxFiller;

public class Tax implements Serializable
{
	
	/** System generated Serial Version UID. */
	private static final long serialVersionUID = 13253278190658550L;
	private String taxName;
	private BigDecimal taxPercentage;
	
	/**
	 * @return the taxName
	 */
	public String getTaxName()
	{
		return taxName;
	}
	/**
	 * @param taxName the taxName to set
	 */
	public void setTaxName(String taxName)
	{
		this.taxName = taxName;
	}
	/**
	 * @return the taxPercentage
	 */
	public BigDecimal getTaxPercentage()
	{
		return taxPercentage;
	}
	/**
	 * @param taxPercentage the taxPercentage to set
	 */
	public void setTaxPercentage(BigDecimal taxPercentage)
	{
		this.taxPercentage = taxPercentage;
	}
	
	@Override
	public Tax clone()
	{
		Tax tax = new Tax();
		tax.taxName = this.taxName;
		tax.taxPercentage = this.taxPercentage;
		return tax;
	}
	
}
