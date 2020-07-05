package com.zpc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zpc.vo.DateTable;

/**�����������ݿ��ѯ����
*@author PC
*@version V1
*/
public class InquireDaoimpl implements InquireDao{
    
    /**
	 * �÷�������������ݻ�ȡ
     * @param con ���ݿ�����
     * @return �������������
     * @throws SQLException 
     */
	public List<DateTable> incomedata(Connection con) throws SQLException {
		String sql="select * from t_income ORDER BY i_time DESC ";
		//ִ�в�ѯ����ȡ���
		PreparedStatement pstmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet set=pstmt.executeQuery();	
		
    	List<DateTable> list = new ArrayList<DateTable>();
    	
    	DateTable  pc;
    	while (set.next()) {
			// ����ȡ������
			pc = new DateTable();
			pc.setMoney(set.getFloat(1));
			pc.setTime(set.getDate(2));
			pc.setProject(set.getString(3));
			pc.setRemarks(set.getString(4));
			list.add(pc);
		}
		return list;
	}
	
	 /**
		 * �÷�����֧�������ݻ�ȡ
	     * @param con ���ݿ�����
	     * @return ����֧��������
	 * @throws SQLException 
	     */
	public List<DateTable> expenddata(Connection con) throws SQLException  {
		String sql="select * from t_expend ORDER BY e_time DESC";
		//ִ�в�ѯ����ȡ���
		PreparedStatement pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet set=pstmt.executeQuery();

    	List<DateTable> list = new ArrayList<DateTable>();
    	
    	DateTable  pc;
    	while (set.next()) {
			// ����ȡ������
			pc = new DateTable();
			pc.setMoney(set.getFloat(1));
			pc.setTime(set.getDate(2));
			pc.setProject(set.getString(3));
			pc.setRemarks(set.getString(4));
			list.add(pc);
		}
		return list;
	}

}
