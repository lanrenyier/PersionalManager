package com.zpc.service;

import java.util.List;

import com.zpc.dao.LoginDao;
import com.zpc.dao.ResigerDao;
import com.zpc.tools.JDBCtools;
import com.zpc.vo.UserTable;

/**该类属于用户表操作
*@author PC
*@version V1
*/
public class Resiger {
	
	private JDBCtools dao = new JDBCtools();
	/**
	 * 该方法是用户表数据增加
	 * @param account 账号
	 * @param password 密码
	 * @throws Exception 
     */
	public void UserIncome(String account,String password) throws Exception {
		new ResigerDao().userIncome(account,password,dao.getCon());
		dao.closeCon(dao.getCon());
	}
	
	/**
	 * 该方法是用户表数据读取
	 * @return 返回用户表数据
	 * @throws Exception 
     */
	public List<UserTable> UserDate() throws Exception {
		List<UserTable> list = new LoginDao().userdata(dao.getCon());
		dao.closeCon(dao.getCon());
		return list;
	}
	
	/**
	 * 该方法是用户表数据删除
	 * @throws Exception 
     */
	public void UserDelete(String account) throws Exception {
		new ResigerDao().userDelete(account,dao.getCon());
		dao.closeCon(dao.getCon());
	}
	
	/**
	 * 该方法是管理员数据增加
	 * @param account 账号
	 * @param password 密码
	 * @throws Exception 
     */
	public void AdministratorIncome(String account,String password) throws Exception {
		new ResigerDao().AdministratorIncome(account,password,dao.getCon());
		dao.closeCon(dao.getCon());
	}
	
	
	
	

}
