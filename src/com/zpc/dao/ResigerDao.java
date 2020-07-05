package com.zpc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**该类属于数据库用户表增加操作
*@author PC
*@version V1
*/
public class ResigerDao {
	
private PreparedStatement pstmt;
	
	/**
	 * 该方法是用户表数据增加
	 * @param account 账号
	 * @param password 密码
	 * @param con 数据库连接
     */
	public void userIncome(String account,String password,Connection con) {
		String sql="insert t_user(u_account,u_password) values(?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,account);
			pstmt.setString(2,password);
			if(pstmt.executeUpdate()==1){
				System.out.println("增加成功");
				}
			else
				System.out.println("增加失败");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	/**
	 * 该方法是用户表数据删除
	 * @param account 账号
	 * @param password 密码
	 * @param con 数据库连接
     */
	public void userDelete(String account,Connection con) {
		String sql="delete from t_user where u_account=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,account);
			if(pstmt.executeUpdate()==1){
				System.out.println("增加成功");
				}
			else
				System.out.println("增加失败");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 该方法是管理员表数据增加
	 * @param account 账号
	 * @param password 密码
	 * @param con 数据库连接
     */
	public void AdministratorIncome(String account,String password,Connection con) {
		String sql="insert t_administrator(a_account,a_password) values(?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,account);
			pstmt.setString(2,password);
			if(pstmt.executeUpdate()==1){
				System.out.println("增加成功");
				}
			else
				System.out.println("增加失败");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
