package com.zpc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zpc.vo.UserTable;

/**�����ṩ�����ݿ��ȡ�û���
*@author PC
*@version V1
*/
public class LoginDao {
	
	/**
     * ��ȡ���ݿ��û���
     * @param con ���ݿ�����
     * @return ���ؼ���
     */
	public List<UserTable> userdata(Connection con) throws SQLException {
		String sql="select * from t_user ORDER BY u_account DESC";
		//ִ�в�ѯ����ȡ���
		PreparedStatement pstmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet set=pstmt.executeQuery();	
    	List<UserTable> list = new ArrayList<UserTable>();
    	UserTable  pc;
    	while (set.next()) {
			// ����ȡ������
			pc = new UserTable();
			pc.setAccount(set.getString(1));
			pc.setPassword(set.getString(2));
			list.add(pc);
		}
		return list;
	}
	
	/**
     * ��ȡ���ݿ����Ա��
     * @param con ���ݿ�����
     * @return ���ؼ���
     */
	public List<UserTable> administratordata(Connection con) throws SQLException {
		String sql="select * from t_administrator";
		//ִ�в�ѯ����ȡ���
		PreparedStatement pstmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet set=pstmt.executeQuery();	
    	List<UserTable> list = new ArrayList<UserTable>();
    	UserTable  pc;
    	while (set.next()) {
			// ����ȡ������
			pc = new UserTable();
			pc.setAccount(set.getString(1));
			pc.setPassword(set.getString(2));
			list.add(pc);
		}
		return list;
	}
	

}
