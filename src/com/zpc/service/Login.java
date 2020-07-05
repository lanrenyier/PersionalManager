package com.zpc.service;

import java.sql.SQLException;
import java.util.List;

import com.zpc.dao.LoginDao;
import com.zpc.tools.JDBCtools;
import com.zpc.vo.UserTable;


/**该类提供登录判断方法
*@author PC
*@version V1
*/
public class Login {
	
	private JDBCtools dao = new JDBCtools();
	/**
     * 判断账号密码是否正确
     * @param account 账号
     * @param password 密码
     * @return 返回成功失败
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
     * 判断账号密码是否正确
     * @param account 账号
     * @param password 密码
     * @return 返回成功失败
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
