package com.zpc.service;

import java.sql.SQLException;
import java.util.List;

import com.zpc.dao.LoginDao;
import com.zpc.tools.JDBCtools;
import com.zpc.vo.UserTable;


/**�����ṩ��¼�жϷ���
*@author PC
*@version V1
*/
public class Login {
	
	private JDBCtools dao = new JDBCtools();
	/**
     * �ж��˺������Ƿ���ȷ
     * @param account �˺�
     * @param password ����
     * @return ���سɹ�ʧ��
     */
	public int LoginUser(String account,String password) throws SQLException, Exception {
		
		int i = 0;
		List<UserTable> list = new LoginDao().userdata(dao.getCon());
		for (UserTable ud : list)
		{
			if(ud.getAccount().equals(account) && ud.getPassword().equals(password)) {
				i=1;
				break;
			}
		}
		dao.closeCon(dao.getCon());
		return i;
	}
	
	
	/**
     * �ж��˺������Ƿ���ȷ
     * @param account �˺�
     * @param password ����
     * @return ���سɹ�ʧ��
     */
    public int LoginAdministrator(String account,String password) throws SQLException, Exception {
		
		int i = 0;
		List<UserTable> list = new LoginDao().administratordata(dao.getCon());
		for (UserTable ud : list)
		{
			if(ud.getAccount().equals(account) && ud.getPassword().equals(password)) {
				i=1;
				break;
			}
		}
		dao.closeCon(dao.getCon());
		return i;
	}
	
	

}
