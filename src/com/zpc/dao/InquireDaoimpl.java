package com.zpc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zpc.vo.DateTable;

/**该类属于数据库查询操作
*@author PC
*@version V1
*/
public class InquireDaoimpl implements InquireDao{
    
    /**
	 * 该方法是收入表数据获取
     * @param con 数据库连接
     * @return 返回收入表数据
     * @throws SQLException 
     */
	public List<DateTable> incomedata(Connection con) throws SQLException {
		String sql="select * from t_income ORDER BY i_time DESC ";
		//执行查询语句获取结果
		PreparedStatement pstmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet set=pstmt.executeQuery();	
		
    	List<DateTable> list = new ArrayList<DateTable>();
    	
    	DateTable  pc;
    	while (set.next()) {
			// 依次取出数据
			pc = new DateTable();
			pc.setMoney(set.getFloat(1));
			pc.setTime(set.getDate(2));
			pc.setProject(set.getString(3));
			pc.setRemarks(set.getString(4));
			list.add(pc);
		}
		return list;
	}
	
	 /**
		 * 该方法是支出表数据获取
	     * @param con 数据库连接
	     * @return 返回支出表数据
	 * @throws SQLException 
	     */
	public List<DateTable> expenddata(Connection con) throws SQLException  {
		String sql="select * from t_expend ORDER BY e_time DESC";
		//执行查询语句获取结果
		PreparedStatement pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet set=pstmt.executeQuery();

    	List<DateTable> list = new ArrayList<DateTable>();
    	
    	DateTable  pc;
    	while (set.next()) {
			// 依次取出数据
			pc = new DateTable();
			pc.setMoney(set.getFloat(1));
			pc.setTime(set.getDate(2));
			pc.setProject(set.getString(3));
			pc.setRemarks(set.getString(4));
			list.add(pc);
		}
		return list;
	}

}
