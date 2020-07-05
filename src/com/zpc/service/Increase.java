package com.zpc.service;


import java.text.SimpleDateFormat;
import java.util.Date;

import com.zpc.dao.IncreaseDao;
import com.zpc.tools.JDBCtools;

/**�����������Ӳ���
*@author PC
*@version V1
*/
public class Increase<T> {
	
	private T t;
	 
	  public void add(T t) {
	    this.t = t;
	  }
	 
	  public T get() {
	    return t;
	  }

	private JDBCtools dao = new JDBCtools();
	
	
	/**
	 * �÷������������������
     * @param money ���
     * @param time ʱ��
     * @param project ��Ŀ
     * @param remarks ��ע
     */
	public void IncomeIncrease(String money,String time,String project,String remarks) throws Exception {
		Increase<Float> mon = new Increase<Float>();
		Increase<Date> tim = new Increase<Date>();
		//string��floatת��
		mon.add(Float.parseFloat(money));
		System.out.println(mon);
		//string��dateת��
		System.out.println(time);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		tim.add(sf.parse(time));		
		//javaʱ��תsqlʱ��
		java.sql.Date sqlTime = new java.sql.Date(tim.get().getTime());
		
		new IncreaseDao().increaseIncome(mon.get(),sqlTime,project,remarks,dao.getCon());
		dao.closeCon(dao.getCon());
	}
	
	/**
	 * �÷�����֧������������
     * @param money ���
     * @param time ʱ��
     * @param project ��Ŀ
     * @param remarks ��ע
     */
	public void ExpendIncrease(String money,String time,String project,String remarks) throws Exception {
		
		Increase<Float> mon = new Increase<Float>();
		Increase<Date> tim = new Increase<Date>();
		//string��floatת��
		mon.add(Float.parseFloat(money));
		System.out.println(mon);
		//string��dateת��
		System.out.println(time);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		tim.add(sf.parse(time));
		
		//javaʱ��תsqlʱ��
		java.sql.Date sqlTime = new java.sql.Date(tim.get().getTime());
		
		new IncreaseDao().increaseExpend(mon.get(),sqlTime,project,remarks,dao.getCon());
		dao.closeCon(dao.getCon());
	}

}
