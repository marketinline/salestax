/*
 * @author Manimaran Selvan
 */
package com.thoughtworks.invoice.util;

import java.math.BigDecimal;
import java.net.URL;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemTaxFiller
{
	private static final Logger logger = LoggerFactory.getLogger(ItemTaxFiller.class);
	public static final String CONFIG_FILE = "config.properties";
	private Properties taxProperties = new Properties();
	
	private ItemTaxFiller()
	{
		try 
		{
			URL url = ClassLoader.getSystemResource(CONFIG_FILE);
			taxProperties.load(url.openStream());
		} 
		catch(Throwable throwable) 
		{
			logger.debug("Error Occurred in loading file:", throwable);
		}
		logger.debug("Initialized singleton");
	}
	
	private static class ItemTaxFillterInitializer {
		private static final ItemTaxFiller newInstance = new ItemTaxFiller();
		public static ItemTaxFiller getInstance()
		{
			return newInstance;
		}
	}
	
	public static ItemTaxFiller getInstance()
	{
		return ItemTaxFillterInitializer.getInstance();
	}
	
	/**
	 * Gets the tax percentage.
	 * Currently, this serves as a mock interface for returning the tax percentage
	 * Eventually, in a live system, this will be loaded from a datastore (db,cache etc)
	 *
	 * @param itemID the item id
	 * @return the tax percentage
	 */
	public BigDecimal getTaxPercentage(String itemID)
	{
		
		return null;
	}
}
