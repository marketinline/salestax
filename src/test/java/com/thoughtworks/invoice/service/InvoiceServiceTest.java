/*
 * @author Manimaran Selvan
 */
package com.thoughtworks.invoice.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.thoughtworks.invoice.Invoice;
import com.thoughtworks.invoice.Item;
import com.thoughtworks.invoice.Tax;
import com.thoughtworks.invoice.renderer.InvoiceRenderer;
import com.thoughtworks.invoice.util.InvoiceUtils;

/**
 * The Class InvoiceServiceTest.
 */
public class InvoiceServiceTest
{
	
	private InvoiceService service;
	
	@Before
	public void setUp() throws Exception
	{
		/*
		 * Load cache as there is no database or serializer implemented to load data
		 */
		Tax localTax = new Tax();
		localTax.setTaxName("local.tax");
		Tax importTax = new Tax();
		importTax.setTaxName("import.tax");
		Map<String, Item> itemMap = new HashMap<String, Item>();
		
		Item book = new Item();
		book.setItemID("L-BOO-1");
		book.setName("book");
		book.setQuantity(new BigDecimal("10"));
		book.setPrice(new BigDecimal("12.49"));
		itemMap.put(book.getItemID(), book);
		
		Item music = new Item();
		music.setItemID("L-MUS-1");
		music.setName("music CD");
		music.setQuantity(new BigDecimal("10"));
		music.setPrice(new BigDecimal("14.99"));
		music.getTaxes().add(localTax.clone());
		itemMap.put(music.getItemID(), music);
		
		Item choc1 = new Item();
		choc1.setItemID("L-CHO-1");
		choc1.setName("chocolate bar");
		choc1.setQuantity(new BigDecimal("10"));
		choc1.setPrice(new BigDecimal("0.85"));
		itemMap.put(choc1.getItemID(), choc1);
		
		Item ichoc1 = new Item();
		ichoc1.setItemID("I-CHO-1");
		ichoc1.setName("imported box of chocolates");
		ichoc1.setQuantity(new BigDecimal("10"));
		ichoc1.setPrice(new BigDecimal("10.00"));
		ichoc1.getTaxes().add(importTax.clone());
		itemMap.put(ichoc1.getItemID(), ichoc1);
		
		Item iperf1 = new Item();
		iperf1.setItemID("I-PER-1");
		iperf1.setName("imported bottle of perfume");
		iperf1.setQuantity(new BigDecimal("10"));
		iperf1.setPrice(new BigDecimal("47.50"));
		iperf1.getTaxes().add(importTax.clone());
		iperf1.getTaxes().add(localTax.clone());
		itemMap.put(iperf1.getItemID(), iperf1);
		
		Item iperf2 = new Item();
		iperf2.setItemID("I-PER-2");
		iperf2.setName("imported bottle of perfume");
		iperf2.setQuantity(new BigDecimal("10"));
		iperf2.setPrice(new BigDecimal("27.99"));
		iperf2.getTaxes().add(importTax.clone());
		iperf2.getTaxes().add(localTax.clone());
		itemMap.put(iperf2.getItemID(), iperf2);
		
		Item perf1 = new Item();
		perf1.setItemID("L-PER-1");
		perf1.setName("bottle of perfume");
		perf1.setQuantity(new BigDecimal("10"));
		perf1.setPrice(new BigDecimal("18.99"));
		perf1.getTaxes().add(localTax.clone());
		itemMap.put(perf1.getItemID(), perf1);
		
		Item pills1 = new Item();
		pills1.setItemID("L-PIL-1");
		pills1.setName("packet of headache pills");
		pills1.setQuantity(new BigDecimal("10"));
		pills1.setPrice(new BigDecimal("9.75"));
		itemMap.put(pills1.getItemID(), pills1);
		
		Item ichoc2 = new Item();
		ichoc2.setItemID("I-CHO-2");
		ichoc2.setName("box of imported chocolates");
		ichoc2.setQuantity(new BigDecimal("10"));
		ichoc2.setPrice(new BigDecimal("11.25"));
		ichoc2.getTaxes().add(importTax.clone());
		itemMap.put(ichoc2.getItemID(), ichoc2);
		
		ApplicationContext springContext = SpringServiceFactory.getInstance().getContext();
		service = (InvoiceService) springContext.getBean("invoiceService");
		service.loadStockStore(itemMap);
	}

	@After
	public void tearDown() throws Exception
	{
		/*
		 * Not implemented as of now
		 */
		service.clearStockStore();
	}

	/**
	 * Test sample invoice1.
	 */
	@Test
	public void testSampleInvoice1()
	{
		Item book = new Item();
		book.setItemID("L-BOO-1");
		book.setQuantity(new BigDecimal("1"));
		
		Item music = new Item();
		music.setItemID("L-MUS-1");
		music.setQuantity(new BigDecimal("1"));
		
		Item choc1 = new Item();
		choc1.setItemID("L-CHO-1");
		choc1.setQuantity(new BigDecimal("1"));
		
		service.accumulateItem(book);
		service.accumulateItem(music);
		service.accumulateItem(choc1);
		
		Invoice invoice = service.getCurrentInvoice();
		invoice = InvoiceUtils.calculateInvoice(invoice);
		InvoiceRenderer renderer = new InvoiceRenderer(System.out);
		renderer.render(invoice);
		
		service.counterTransaction();
	}
	
	/**
	 * Test sample invoice2.
	 */
	@Test
	public void testSampleInvoice2()
	{
		Item ichoc1 = new Item();
		ichoc1.setItemID("I-CHO-1");
		ichoc1.setQuantity(new BigDecimal("1"));
		
		Item iperf1 = new Item();
		iperf1.setItemID("I-PER-1");
		iperf1.setQuantity(new BigDecimal("1"));
		
		service.accumulateItem(ichoc1);
		service.accumulateItem(iperf1);
		
		Invoice invoice = service.getCurrentInvoice();
		invoice = InvoiceUtils.calculateInvoice(invoice);
		InvoiceRenderer renderer = new InvoiceRenderer(System.out);
		renderer.render(invoice);
		
		service.counterTransaction();
	}
	
	/**
	 * Test sample invoice3.
	 */
	@Test
	public void testSampleInvoice3()
	{

		Item iperf2 = new Item();
		iperf2.setItemID("I-PER-2");
		iperf2.setQuantity(new BigDecimal("1"));
		
		Item perf1 = new Item();
		perf1.setItemID("L-PER-1");
		perf1.setQuantity(new BigDecimal("1"));
		
		Item pills1 = new Item();
		pills1.setItemID("L-PIL-1");
		pills1.setQuantity(new BigDecimal("1"));

		Item ichoc2 = new Item();
		ichoc2.setItemID("I-CHO-2");
		ichoc2.setQuantity(new BigDecimal("1"));
		
		service.accumulateItem(iperf2);
		service.accumulateItem(perf1);
		service.accumulateItem(pills1);
		service.accumulateItem(ichoc2);
		
		Invoice invoice = service.getCurrentInvoice();
		invoice = InvoiceUtils.calculateInvoice(invoice);
		InvoiceRenderer renderer = new InvoiceRenderer(System.out);
		renderer.render(invoice);
		
		service.counterTransaction();
		
	}
	
	/**
	 * Test all sample invoices.
	 */
	@Test
	public void testAllSampleInvoices()
	{
		testSampleInvoice1();
		testSampleInvoice2();
		testSampleInvoice3();
	}
}
