package com.zpc.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.zpc.dao.DeleteDao;
import com.zpc.tools.JDBCtools;

/**��������ɾ������
*@author PC
*@version V1
*/
public class Delete {
	private JDBCtools dao = new JDBCtools();
	
	
	/**
	 * �÷��������������ɾ��
     * @param project ��Ŀ
     * @param time ʱ��
     */
	public void IncomeDelete(String project,String time) throws Exception {  
	
		//string��dateת��
		System.out.println(time);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date tim = sf.parse(time);
		//javaʱ��תsqlʱ��
		java.sql.Date sqlTime = new java.sql.Date(tim.getTime());
		
	    new DeleteDao().deleteIncome(project,sqlTime,dao.getCon());
	    dao.closeCon(dao.getCon());
	}  
	
	/**
	 * �÷�����֧��������ɾ��
     * @param project ��Ŀ
     * @param time ʱ��
     */
	public void ExpendDelete(String project,String time) throws Exception {  
		
		//string��dateת��
		System.out.println(time);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date tim = sf.parse(time);
		//javaʱ��תsqlʱ��
		java.sql.Date sqlTime = new java.sql.Date(tim.getTime());
				
	    new DeleteDao().deleteExpend(project,sqlTime,dao.getCon());
	    dao.closeCon(dao.getCon());
	}  
	
}
