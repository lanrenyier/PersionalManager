package com.zpc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zpc.vo.UserTable;

/**该类提供从数据库读取用户表
*@author PC
*@version V1
*/
public class LoginDao {
	
	/**
     * 读取数据库用户表
     * @param con 数据库连接
     * @return 返回集合
     */
	public List<UserTable> userdata(Connection con) throws SQLException {
		String sql="select * from t_user ORDER BY u_account DESC";
		//执行查询语句获取结果
		PreparedStatement pstmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet set=pstmt.executeQuery();	
    	List<UserTable> list = new ArrayList<UserTable>();
    	UserTable  pc;
    	while (set.next()) {
			// 依次取出数据
			pc = new UserTable();
			pc.setAccount(set.getString(1));
			pc.setPassword(set.getString(2));
			list.add(pc);
		}
		return list;
	}
	
	/**
     * 读取数据库管理员表
     * @param con 数据库连接
     * @return 返回集合
     */
	public List<UserTable> administratordata(Connection con) throws SQLException {
		String sql="select * from t_administrator";
		//执行查询语句获取结果
		PreparedStatement pstmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet set=pstmt.executeQuery();	
    	List<UserTable> list = new ArrayList<UserTable>();
    	UserTable  pc;
    	while (set.next()) {
			// 依次取出数据
			pc = new UserTable();
			pc.setAccount(set.getString(1));
			pc.setPassword(set.getString(2));
			list.add(pc);
		}
		return list;
	}
	

}
