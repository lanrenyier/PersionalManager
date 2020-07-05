package com.zpc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/**该类属于数据库删除操作
*@author PC
*@version V1
*/
public class DeleteDao{
	
	private PreparedStatement pstmt;
	
	/**
	 * 该方法是收入表数据删除
	 * @param project 项目
     * @param time 时间
     * @param con 数据库连接
     */
	public void deleteIncome(String project,Date time,Connection con) {
		try{
			String sql="delete from t_income where i_project=? and i_time=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,project);
			pstmt.setDate(2,time);
			if(pstmt.executeUpdate()==1){
				System.out.println("删除成功");
				}
			else
				System.out.println("删除失败");
		}catch(Exception a){
			System.out.println("删除数据出错");
			a.printStackTrace();
		}
	}
	
	/**
	 * 该方法是支出表数据删除
	 * @param project 项目
     * @param time 时间
     * @param con 数据库连接
     */
	public void deleteExpend(String project,Date time,Connection con) {
		try{
			String sql="delete from t_expend where e_project=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,project);
			if(pstmt.executeUpdate()==1){
				System.out.println("删除成功");
				}
			else
				System.out.println("删除失败");
		}catch(Exception a){
			System.out.println("删除数据出错");
			a.printStackTrace();
		}
	}
}