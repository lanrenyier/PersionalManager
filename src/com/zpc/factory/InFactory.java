package com.zpc.factory;

import java.sql.SQLException;
import java.util.List;

import com.zpc.service.InquireExpend;
import com.zpc.service.InquireIncome;
import com.zpc.vo.DateTable;

/**该类属于数据查询工厂类
*@author PC
*@version V1
*/
public class InFactory {
	
	/**
	 * 该方法是获取各表数据
	 * @return 返回表数据
     */
	public static List<DateTable> getInstance(String dateString) throws SQLException, Exception{
		List<DateTable> list = null;
		if(dateString.equals("income")){
			list = new InquireIncome().Date();
		}
		if(dateString.equals("expend")){
			list = new InquireExpend().Date();
		}
		return list;
}
}
