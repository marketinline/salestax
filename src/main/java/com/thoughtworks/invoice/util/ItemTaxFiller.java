/*
 * @author Manimaran Selvan
 */
package com.thoughtworks.invoice.util;

import java.math.BigDecimal;
import java.net.URL;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.invoice.Item;
import com.thoughtworks.invoice.Tax;

/**
 * The Singleton Class ItemTaxFiller.
 */
public class ItemTaxFiller
{
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(ItemTaxFiller.class);
	
	/** The Constant TAX_CONFIG. */
	private static final String TAX_CONFIG = "tax.properties";
	
	/** The tax properties. */
	private Properties taxProperties = new Properties();
	
	/**
	 * Instantiates a new item tax filler.
	 */
	private ItemTaxFiller()
	{
		try 
		{
			URL url = ClassLoader.getSystemResource(TAX_CONFIG);
			taxProperties.load(url.openStream());
		} 
		catch(Throwable throwable) 
		{
			logger.debug("Error Occurred in loading file:", throwable);
		}
		logger.debug("Initialized singleton");
	}
	
	/**
	 * The Class ItemTaxFillterInitializer.
	 */
	private static class ItemTaxFillterInitializer {
		
		/** The Constant newInstance. */
		private static final ItemTaxFiller newInstance = new ItemTaxFiller();
		
		/**
		 * Gets the single instance of ItemTaxFillterInitializer.
		 *
		 * @return single instance of ItemTaxFillterInitializer
		 */
		public static ItemTaxFiller getInstance()
		{
			return newInstance;
		}
	}
	
	/**
	 * Gets the single instance of ItemTaxFiller.
	 *
	 * @return single instance of ItemTaxFiller
	 */
	public static ItemTaxFiller getInstance()
	{
		return ItemTaxFillterInitializer.getInstance();
	}
	
	/**
	 * Fills the tax percentage.
	 * Currently, this serves as a mock interface for returning the tax percentage from a property file
	 * Eventually, in a live system, this will be loaded from a datastore (db,cache etc)
	 * But it can be used as is for a sub standard system
	 *
	 * @param item the item itself
	 * @return the tax percentage
	 */
	public BigDecimal fillTaxPercentage(Item item)
	{
		BigDecimal taxPercentage = new BigDecimal("0");
		for(Tax tax : item.getTaxes())
		{
			tax.setTaxPercentage(getTaxPercentage(tax.getTaxName()));
			taxPercentage.add(tax.getTaxPercentage());
		}
		return taxPercentage;
	}
	
	/**
	 * Gets the tax percentage.
	 *
	 * @param taxName the tax name
	 * @return the tax percentage
	 */
	public BigDecimal getTaxPercentage(String taxName)
	{
		BigDecimal taxPercentage = new BigDecimal(taxProperties.getProperty(taxName));
		return taxPercentage;
	}
}
