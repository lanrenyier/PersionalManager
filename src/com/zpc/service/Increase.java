package com.zpc.service;


import java.text.SimpleDateFormat;
import java.util.Date;

import com.zpc.dao.IncreaseDao;
import com.zpc.tools.JDBCtools;

/**该类属于增加操作
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
	 * 该方法是收入表数据增加
     * @param money 金额
     * @param time 时间
     * @param project 项目
     * @param remarks 备注
     */
	public void IncomeIncrease(String money,String time,String project,String remarks) throws Exception {
		Increase<Float> mon = new Increase<Float>();
		Increase<Date> tim = new Increase<Date>();
		//string和float转换
		mon.add(Float.parseFloat(money));
		System.out.println(mon);
		//string和date转换
		System.out.println(time);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		tim.add(sf.parse(time));		
		//java时间转sql时间
		java.sql.Date sqlTime = new java.sql.Date(tim.get().getTime());
		
		new IncreaseDao().increaseIncome(mon.get(),sqlTime,project,remarks,dao.getCon());
		dao.closeCon(dao.getCon());
	}
	
	/**
	 * 该方法是支出表数据增加
     * @param money 金额
     * @param time 时间
     * @param project 项目
     * @param remarks 备注
     */
	public void ExpendIncrease(String money,String time,String project,String remarks) throws Exception {
		
		Increase<Float> mon = new Increase<Float>();
		Increase<Date> tim = new Increase<Date>();
		//string和float转换
		mon.add(Float.parseFloat(money));
		System.out.println(mon);
		//string和date转换
		System.out.println(time);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		tim.add(sf.parse(time));
		
		//java时间转sql时间
		java.sql.Date sqlTime = new java.sql.Date(tim.get().getTime());
		
		new IncreaseDao().increaseExpend(mon.get(),sqlTime,project,remarks,dao.getCon());
		dao.closeCon(dao.getCon());
	}

}
