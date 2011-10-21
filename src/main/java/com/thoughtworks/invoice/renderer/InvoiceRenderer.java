/*
 * @author Manimaran Selvan
 */
package com.thoughtworks.invoice.renderer;

import java.io.OutputStream;
import java.io.PrintStream;

import com.thoughtworks.invoice.Invoice;
import com.thoughtworks.invoice.Item;

/**
 * The Class InvoiceRenderer.
 */
public class InvoiceRenderer
{
	
	/** The out stream. */
	private PrintStream out = null;

	/**
	 * Instantiates a new invoice renderer.
	 *
	 * @param out the out stream
	 */
	public InvoiceRenderer(OutputStream out)
	{
		this.out = new PrintStream(out);
	}

	/**
	 * Render the invoice.
	 *
	 * @param invoice the invoice pojo
	 */
	public void render(Invoice invoice)
	{
		out.println();
		out.println("Invoice ID: "+invoice.getInvoiceID());
		out.println();
		for(Item item : invoice.getItemMap().values())
		{
			out.println(item.getQuantity()+" "+item.getName()+" at "+item.getItemAmount());
		}
		out.println();
		out.println("Sales Tax :"+invoice.getTotalTax());
		out.println("Total :"+invoice.getTotalAmount());
		out.println();
	}
}
