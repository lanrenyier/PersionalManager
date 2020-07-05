package com.zpc.factory;

import java.sql.SQLException;

import com.zpc.service.AccountBalance;
import com.zpc.service.AccountExpend;
import com.zpc.service.AccountIncome;


/**������������ѯ���㹤����
*@author PC
*@version V1
*/
public class BaFactory {
	
	/**
	 * �÷�������������������
	 * @return �������
     */
	public static String getInstance(String dateString) throws SQLException, Exception{
		String s = null;
		if(dateString.equals("income")){
			s = new AccountIncome().Account();
		}
		if(dateString.equals("expend")){
			s = new AccountExpend().Account();
		}
		if(dateString.equals("balance")){
			s = new AccountBalance().Account();
		}
		return s;
}
}
