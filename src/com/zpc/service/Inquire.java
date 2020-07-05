package com.zpc.service;

import java.sql.SQLException;
import java.util.List;

import com.zpc.vo.DateTable;
/**该类属于查询接口
*@author PC
*@version V1
*/
public interface Inquire {
	public List<DateTable> Date() throws SQLException, Exception;

}
