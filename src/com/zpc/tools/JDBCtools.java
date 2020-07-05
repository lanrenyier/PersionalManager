
package com.zpc.tools;

import java.sql.Connection;
import java.sql.DriverManager;

/**�������ڹ����࣬�������ݿ�����
*@author PC
*@version V1
*/
public class JDBCtools{
	private String drivename="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=Manager";
	private String username="sa";
	private String password="123456";
	
	/**
     * �÷������������ݿ�
     * @return �������ݿ�����
     */
	public Connection getCon() throws Exception{
		Class.forName(drivename);
		Connection con=DriverManager.getConnection(dbURL,username,password);
		return con;
	}
	
	/**
	 * �÷����ǹر����ݿ�
     * @param con ���ݿ�����
     */
	public void closeCon(Connection con) throws Exception {
		if(con!=null)
    		con.close();
	}
	
	/**
     * �������ݿ�
     * @param 
     */
	@SuppressWarnings("unused")
	public static void main(String arg[]){
		JDBCtools dao = new JDBCtools();
		if(dao!=null){
    		System.out.println("success");	
    		}
		else {
			System.out.println("fail");
		}
	}
	
}