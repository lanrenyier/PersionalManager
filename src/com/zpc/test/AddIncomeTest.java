package com.zpc.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.zpc.service.Increase;

public class AddIncomeTest {

	@Test
	public void test() throws Exception {
		
		Increase<?> income = new Increase<Object>();
			
		
		income.IncomeIncrease("30", "2020-07-01", "��̯", "");
		income.IncomeIncrease("30", "2020-07-02", "��̯", "");
		income.IncomeIncrease("30", "2020-07-03", "��̯", "");
		income.IncomeIncrease("30", "2020-07-04", "��̯", "");
		income.IncomeIncrease("30", "2020-07-05", "��̯", "");
		income.IncomeIncrease("30", "2020-07-06", "��̯", "");
		assertNotNull(income);
	}

}
