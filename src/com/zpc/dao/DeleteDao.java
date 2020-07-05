package com.zpc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/**�����������ݿ�ɾ������
*@author PC
*@version V1
*/
public class DeleteDao{
	
	private PreparedStatement pstmt;
	
	/**
	 * �÷��������������ɾ��
	 * @param project ��Ŀ
     * @param time ʱ��
     * @param con ���ݿ�����
     */
	public void deleteIncome(String project,Date time,Connection con) {
		try{
			String sql="delete from t_income where i_project=? and i_time=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,project);
			pstmt.setDate(2,time);
			if(pstmt.executeUpdate()==1){
				System.out.println("ɾ���ɹ�");
				}
			else
				System.out.println("ɾ��ʧ��");
		}catch(Exception a){
			System.out.println("ɾ�����ݳ���");
			a.printStackTrace();
		}
	}
	
	/**
	 * �÷�����֧��������ɾ��
	 * @param project ��Ŀ
     * @param time ʱ��
     * @param con ���ݿ�����
     */
	public void deleteExpend(String project,Date time,Connection con) {
		try{
			String sql="delete from t_expend where e_project=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,project);
			if(pstmt.executeUpdate()==1){
				System.out.println("ɾ���ɹ�");
				}
			else
				System.out.println("ɾ��ʧ��");
		}catch(Exception a){
			System.out.println("ɾ�����ݳ���");
			a.printStackTrace();
		}
	}
}