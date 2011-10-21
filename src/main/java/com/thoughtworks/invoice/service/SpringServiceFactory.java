/*
 * @author Manimaran Selvan
 */
package com.thoughtworks.invoice.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * A factory for creating SpringService objects.
 */
public class SpringServiceFactory 
{
	
	/** The factory. */
	private static SpringServiceFactory factory=new SpringServiceFactory();
	
	/** The context. */
	private ApplicationContext context;
	
	/**
	 * Instantiates a new spring service factory.
	 */
	private SpringServiceFactory()
	{
		context = new ClassPathXmlApplicationContext(new String[] {"spring_context.xml"});
		
	}
	
	/**
	 * Gets the context.
	 *
	 * @return the context
	 */
	public ApplicationContext getContext()
	{
		return this.context;
	}
	
	/**
	 * Gets the single instance of SpringServiceFactory.
	 *
	 * @return single instance of SpringServiceFactory
	 */
	public static  SpringServiceFactory getInstance()
	{
		return factory;
	}

}
