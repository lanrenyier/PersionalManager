package com.zpc.service;

import java.util.List;

import com.zpc.factory.InFactory;
import com.zpc.vo.DateTable;

public class AccountExpend implements Account1{
	
	/**
	 * 该方法是支出表金额统计
	 * @return 返回支出总金额
     */
	public String Account() throws Exception {
		float expendcoun = 0;
		List<DateTable> list = InFactory.getInstance("expend");
		System.out.println(list);
		for (DateTable ud : list) {
			expendcoun = expendcoun+ud.getMoney();
		}
		String s = Float.toString(expendcoun);
			return s;	
		}
	

}
