package com.zpc.service;

import java.sql.SQLException;
import java.util.List;

import com.zpc.dao.InquireDaoimpl;
import com.zpc.tools.JDBCtools;
import com.zpc.vo.DateTable;
/**�������ڲ�ѯ֧����
*@author PC
*@version V1
*/
public class InquireExpend implements Inquire{
	
	/**
     * �÷�������������ݲ�ѯ
     * @return ��ȡ�����������
     */
	      private JDBCtools dao = new JDBCtools();
	      public List<DateTable>Date() throws SQLException, Exception{
	    	  List<DateTable> list = new InquireDaoimpl().expenddata(dao.getCon());
	  		  dao.closeCon(dao.getCon());
	    	  return list;
	      }
}

