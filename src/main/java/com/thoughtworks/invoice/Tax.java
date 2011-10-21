/*
 * @author Manimaran Selvan
 */
package com.thoughtworks.invoice;

import java.io.Serializable;
import java.math.BigDecimal;

public class Tax implements Serializable
{
	
	/** System generated Serial Version UID. */
	private static final long serialVersionUID = 13253278190658550L;
	private String taxName;
	private String taxDescription;
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
	 * @return the taxDescription
	 */
	public String getTaxDescription()
	{
		return taxDescription;
	}
	/**
	 * @param taxDescription the taxDescription to set
	 */
	public void setTaxDescription(String taxDescription)
	{
		this.taxDescription = taxDescription;
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
	
}
