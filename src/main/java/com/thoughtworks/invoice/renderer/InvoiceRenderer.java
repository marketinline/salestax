package com.thoughtworks.invoice.renderer;

import java.io.OutputStream;
import java.io.PrintStream;

import com.thoughtworks.invoice.Invoice;
import com.thoughtworks.invoice.Item;

public class InvoiceRenderer
{
	private PrintStream out = null;

	public InvoiceRenderer(OutputStream out)
	{
		this.out = new PrintStream(out);
	}

	public void render(Invoice invoice)
	{

		for(Item item : invoice.getItemMap().values())
		{
			out.println(item.getQuantity()+" "+item.getName()+" at "+item.getItemAmount());
		}
		out.println();
		out.println("Sales Tax :"+invoice.getTotalTax());
		out.println("Total :"+invoice.getTotalAmount());
	}
}
