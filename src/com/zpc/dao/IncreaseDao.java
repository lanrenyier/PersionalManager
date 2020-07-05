package com.zpc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**�����������ݿ�����֧�������Ӳ���
*@author PC
*@version V1
*/
public class IncreaseDao {
	
	private PreparedStatement pstmt;
	
	/**
	 * �÷������������������
	 * @param money ���
	 * @param time ʱ��
	 * @param project ��Ŀ
     * @param remarks ��ע
     * @param con ���ݿ�����
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
				System.out.println("���ӳɹ�");
				}
			else
				System.out.println("����ʧ��");
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	/**
	 * �÷�����֧������������
	 * @param money ���
	 * @param time ʱ��
	 * @param project ��Ŀ
     * @param remarks ��ע
     * @param con ���ݿ�����
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
				System.out.println("���ӳɹ�");
				}
			else
				System.out.println("����ʧ��");
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

}
