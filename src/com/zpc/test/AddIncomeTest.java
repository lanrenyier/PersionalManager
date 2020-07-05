package com.zpc.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.zpc.service.Increase;

public class AddIncomeTest {

	@Test
	public void test() throws Exception {
		
		Increase<?> income = new Increase<Object>();
			
		
		income.IncomeIncrease("30", "2020-07-01", "°ÚÌ¯", "");
		income.IncomeIncrease("30", "2020-07-02", "°ÚÌ¯", "");
		income.IncomeIncrease("30", "2020-07-03", "°ÚÌ¯", "");
		income.IncomeIncrease("30", "2020-07-04", "°ÚÌ¯", "");
		income.IncomeIncrease("30", "2020-07-05", "°ÚÌ¯", "");
		income.IncomeIncrease("30", "2020-07-06", "°ÚÌ¯", "");
		assertNotNull(income);
	}

}
