package com.zpc.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.zpc.vo.DateTable;

/**该类属于查询数据接口
*@author PC
*@version V1
*/
public interface InquireDao {
	
	/**
	 * 该方法是收入表数据获取
	 * @param con 数据库连接
	 * @return 返回收入表数据
     */
	public List<DateTable> incomedata(Connection con) throws SQLException;
     /**
	 * 该方法是支出表数据获取
	 * @param con 数据库连接
	 * @return 返回支出表数据
     */
	public List<DateTable> expenddata(Connection con) throws SQLException;

}
