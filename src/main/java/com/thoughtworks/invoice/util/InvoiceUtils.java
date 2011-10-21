package com.thoughtworks.invoice.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InvoiceUtils
{

	public static BigDecimal applyRoundingFactor(BigDecimal value)
	{
		BigDecimal result = new BigDecimal(Math.ceil(value.doubleValue()));
		value.add(value.setScale(0,RoundingMode.FLOOR).negate());
		//return value;
        return value.add(value.setScale(0,RoundingMode.HALF_DOWN).negate());//result.setScale(2, RoundingMode.HALF_EVEN);        
	}
}
