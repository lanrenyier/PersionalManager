package com.zpc.service;

import java.util.List;

import com.zpc.factory.InFactory;
import com.zpc.vo.DateTable;

public class AccountIncome implements Account1{
	/**
	 * 该方法是收入表金额统计
	 * @return 返回收入总金额
	 * @throws Exception 
     */
	public String Account() throws Exception{
		float incomecoun = 0;
		List<DateTable> list = InFactory.getInstance("income");
		System.out.println(list);
		for (DateTable ud : list) {
			incomecoun = incomecoun+ud.getMoney();
		}
		String s = Float.toString(incomecoun);
		return s;
	}
	

}
