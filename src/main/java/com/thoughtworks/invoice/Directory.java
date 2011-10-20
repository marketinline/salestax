/*
 * @author Manimaran Selvan
 */
package com.thoughtworks.invoice;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Directory
{
	private static final Logger logger = LoggerFactory.getLogger(Directory.class);
	private Map<String, String> itemType;
	private Map<String, BigDecimal> taxType;
	public Directory()
	{
		 try
		{
			 
		}
		catch(Exception e)
		{
			logger.error("Exception Raised: ",e);
		}
	}
	
	/**
	 * Gets the item map.
	 * Currently, this serves as a mock interface for returning the item map
	 * Eventually, in a live system, this will be loaded from a datastore (db,cache etc)
	 *
	 * @return the item type map
	 */
	public Map<String, String> getItemTypeMap()
	{
		return null;		
	}
	
	
	
	public static BigDecimal applyRoundingFactor(BigDecimal value)
	{
		BigDecimal result = new BigDecimal(Math.ceil(value.doubleValue()));
		value.add(value.setScale(0,RoundingMode.FLOOR).negate());
		//return value;
        return value.add(value.setScale(0,RoundingMode.HALF_DOWN).negate());//result.setScale(2, RoundingMode.HALF_EVEN);        
	}
	
	public static BigDecimal getTaxPercentage(String itemID)
	{
		return null;
	}
}