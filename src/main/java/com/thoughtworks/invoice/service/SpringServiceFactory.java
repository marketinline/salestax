package com.thoughtworks.invoice.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringServiceFactory 
{
	private static SpringServiceFactory factory=new SpringServiceFactory();
	private ApplicationContext context;
	
	private SpringServiceFactory()
	{
		context = new ClassPathXmlApplicationContext(new String[] {"spring_context.xml"});
		
	}
	
	public ApplicationContext getContext()
	{
		return this.context;
	}
	public static  SpringServiceFactory getInstance()
	{
		return factory;
	}

}
