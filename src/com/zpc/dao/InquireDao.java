package com.zpc.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.zpc.vo.DateTable;

/**�������ڲ�ѯ���ݽӿ�
*@author PC
*@version V1
*/
public interface InquireDao {
	
	/**
	 * �÷�������������ݻ�ȡ
	 * @param con ���ݿ�����
	 * @return �������������
     */
	public List<DateTable> incomedata(Connection con) throws SQLException;
     /**
	 * �÷�����֧�������ݻ�ȡ
	 * @param con ���ݿ�����
	 * @return ����֧��������
     */
	public List<DateTable> expenddata(Connection con) throws SQLException;

}
