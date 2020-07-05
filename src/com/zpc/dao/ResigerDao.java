package com.zpc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**�����������ݿ��û������Ӳ���
*@author PC
*@version V1
*/
public class ResigerDao {
	
private PreparedStatement pstmt;
	
	/**
	 * �÷������û�����������
	 * @param account �˺�
	 * @param password ����
	 * @param con ���ݿ�����
     */
	public void userIncome(String account,String password,Connection con) {
		String sql="insert t_user(u_account,u_password) values(?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,account);
			pstmt.setString(2,password);
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
	 * �÷������û�������ɾ��
	 * @param account �˺�
	 * @param password ����
	 * @param con ���ݿ�����
     */
	public void userDelete(String account,Connection con) {
		String sql="delete from t_user where u_account=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,account);
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
	 * �÷����ǹ���Ա����������
	 * @param account �˺�
	 * @param password ����
	 * @param con ���ݿ�����
     */
	public void AdministratorIncome(String account,String password,Connection con) {
		String sql="insert t_administrator(a_account,a_password) values(?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,account);
			pstmt.setString(2,password);
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
