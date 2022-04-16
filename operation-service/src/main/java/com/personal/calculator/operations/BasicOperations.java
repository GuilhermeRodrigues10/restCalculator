package com.personal.calculator.operations;

import java.math.BigDecimal;
import java.math.MathContext;

import com.personal.calculator.results.Result;

public class BasicOperations {		
	public Result sum(BigDecimal a, BigDecimal b)
	{
		return new Result(a.add(b));
	}
	
	public Result subtration(BigDecimal a, BigDecimal b)
	{
		return new Result(a.subtract(b));
	}
	
	public Result multiplication(BigDecimal a, BigDecimal b)
	{
		return new Result (a.multiply(b));
	}

	public Result division(BigDecimal a, BigDecimal b)
	{
		return new Result (a.divide(b,  MathContext.DECIMAL32));
	}
}
