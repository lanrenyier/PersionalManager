package com.zpc.service;

import java.util.List;

import com.zpc.dao.LoginDao;
import com.zpc.dao.ResigerDao;
import com.zpc.tools.JDBCtools;
import com.zpc.vo.UserTable;

/**���������û������
*@author PC
*@version V1
*/
public class Resiger {
	
	private JDBCtools dao = new JDBCtools();
	/**
	 * �÷������û�����������
	 * @param account �˺�
	 * @param password ����
	 * @throws Exception 
     */
	public void UserIncome(String account,String password) throws Exception {
		new ResigerDao().userIncome(account,password,dao.getCon());
		dao.closeCon(dao.getCon());
	}
	
	/**
	 * �÷������û������ݶ�ȡ
	 * @return �����û�������
	 * @throws Exception 
     */
	public List<UserTable> UserDate() throws Exception {
		List<UserTable> list = new LoginDao().userdata(dao.getCon());
		dao.closeCon(dao.getCon());
		return list;
	}
	
	/**
	 * �÷������û�������ɾ��
	 * @throws Exception 
     */
	public void UserDelete(String account) throws Exception {
		new ResigerDao().userDelete(account,dao.getCon());
		dao.closeCon(dao.getCon());
	}
	
	/**
	 * �÷����ǹ���Ա��������
	 * @param account �˺�
	 * @param password ����
	 * @throws Exception 
     */
	public void AdministratorIncome(String account,String password) throws Exception {
		new ResigerDao().AdministratorIncome(account,password,dao.getCon());
		dao.closeCon(dao.getCon());
	}
	
	
	
	

}
