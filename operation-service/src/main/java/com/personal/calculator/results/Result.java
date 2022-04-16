package com.personal.calculator.results;

import java.math.BigDecimal;

public class Result {
	private BigDecimal result;
	
	public Result(BigDecimal result)
	{
		this.result = result;
	}

	public BigDecimal getResult() {
		return result;
	}

	public void setResult(BigDecimal result) {
		this.result = result;
	}

}
