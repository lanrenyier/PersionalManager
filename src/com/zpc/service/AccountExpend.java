package com.zpc.service;

import java.util.List;

import com.zpc.factory.InFactory;
import com.zpc.vo.DateTable;

public class AccountExpend implements Account1{
	
	/**
	 * �÷�����֧������ͳ��
	 * @return ����֧���ܽ��
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
