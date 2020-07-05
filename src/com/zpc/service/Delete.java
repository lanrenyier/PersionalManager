package com.zpc.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.zpc.dao.DeleteDao;
import com.zpc.tools.JDBCtools;

/**该类属于删除操作
*@author PC
*@version V1
*/
public class Delete {
	private JDBCtools dao = new JDBCtools();
	
	
	/**
	 * 该方法是收入表数据删除
     * @param project 项目
     * @param time 时间
     */
	public void IncomeDelete(String project,String time) throws Exception {  
	
		//string和date转换
		System.out.println(time);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date tim = sf.parse(time);
		//java时间转sql时间
		java.sql.Date sqlTime = new java.sql.Date(tim.getTime());
		
	    new DeleteDao().deleteIncome(project,sqlTime,dao.getCon());
	    dao.closeCon(dao.getCon());
	}  
	
	/**
	 * 该方法是支出表数据删除
     * @param project 项目
     * @param time 时间
     */
	public void ExpendDelete(String project,String time) throws Exception {  
		
		//string和date转换
		System.out.println(time);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date tim = sf.parse(time);
		//java时间转sql时间
		java.sql.Date sqlTime = new java.sql.Date(tim.getTime());
				
	    new DeleteDao().deleteExpend(project,sqlTime,dao.getCon());
	    dao.closeCon(dao.getCon());
	}  
	
}
