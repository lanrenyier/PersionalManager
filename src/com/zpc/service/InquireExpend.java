package com.zpc.service;

import java.sql.SQLException;
import java.util.List;

import com.zpc.dao.InquireDaoimpl;
import com.zpc.tools.JDBCtools;
import com.zpc.vo.DateTable;
/**该类属于查询支出表
*@author PC
*@version V1
*/
public class InquireExpend implements Inquire{
	
	/**
     * 该方法是输入表数据查询
     * @return 获取的输入表数据
     */
	      private JDBCtools dao = new JDBCtools();
	      public List<DateTable>Date() throws SQLException, Exception{
	    	  List<DateTable> list = new InquireDaoimpl().expenddata(dao.getCon());
	  		  dao.closeCon(dao.getCon());
	    	  return list;
	      }
}

