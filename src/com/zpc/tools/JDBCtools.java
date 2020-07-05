
package com.zpc.tools;

import java.sql.Connection;
import java.sql.DriverManager;

/**该类属于工具类，用于数据库连接
*@author PC
*@version V1
*/
public class JDBCtools{
	private String drivename="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=Manager";
	private String username="sa";
	private String password="123456";
	
	/**
     * 该方法是连接数据库
     * @return 返回数据库连接
     */
	public Connection getCon() throws Exception{
		Class.forName(drivename);
		Connection con=DriverManager.getConnection(dbURL,username,password);
		return con;
	}
	
	/**
	 * 该方法是关闭数据库
     * @param con 数据库连接
     */
	public void closeCon(Connection con) throws Exception {
		if(con!=null)
    		con.close();
	}
	
	/**
     * 测试数据库
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