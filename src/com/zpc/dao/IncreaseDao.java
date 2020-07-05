package com.zpc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**该类属于数据库收入支出表增加操作
*@author PC
*@version V1
*/
public class IncreaseDao {
	
	private PreparedStatement pstmt;
	
	/**
	 * 该方法是收入表数据增加
	 * @param money 金额
	 * @param time 时间
	 * @param project 项目
     * @param remarks 备注
     * @param con 数据库连接
     */
	public void increaseIncome(float money,Date time,String project,String remarks,Connection con) {
		String sql="insert t_income(i_money,i_time,i_project,i_remarks) values(?,?,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setFloat(1,money);
			pstmt.setDate(2,(java.sql.Date) time);
			pstmt.setString(3,project);
			pstmt.setString(4,remarks);
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
	 * 该方法是支出表数据增加
	 * @param money 金额
	 * @param time 时间
	 * @param project 项目
     * @param remarks 备注
     * @param con 数据库连接
     */
	public void increaseExpend(float money,Date time,String project,String remarks,Connection con) {
		String sql="insert t_expend(e_money,e_time,e_project,e_remarks) values(?,?,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setFloat(1,money);
			pstmt.setDate(2,(java.sql.Date) time);
			pstmt.setString(3,project);
			pstmt.setString(4,remarks);
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
