package com.zpc.service;

import java.util.List;

import com.zpc.factory.InFactory;
import com.zpc.vo.DateTable;

public class AccountBalance implements Account1{
	/**
	 * 该方法是余额统计
	 * @return 返回余额
     */
	public String Account() throws Exception {
		    float incomecoun = 0;
		    List<DateTable> list = InFactory.getInstance("income");
		    System.out.println(list);
		    for (DateTable ud : list) {
			    incomecoun = incomecoun+ud.getMoney();
		    }
			float expendcoun = 0;
			List<DateTable> list1 = InFactory.getInstance("expend");
			System.out.println(list1);
			for (DateTable ud : list1) {
				expendcoun = expendcoun+ud.getMoney();
			}
			float balance = incomecoun - expendcoun;
			String s = Float.toString(balance);
			return s;
		}

}
