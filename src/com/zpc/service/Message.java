package com.zpc.service;

import java.io.IOException;
import com.zpc.bean.TextDate;

/**该类属于IO流在留言板的具体操作
*@author PC
*@version V1
*/
public class Message {
	
	/**
	 * 该方法是获取留言板显示内容
     * @param text 内容
     */
	public void MessageIn(String text) {
		try {
			new TextDate().readMessage(text);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} 
	}
	
	
	/**
	 * 该方法是留言板获取显示内容
     * @return 返回文本内容
     */
	public String MessageOut() throws IOException {
		
		String ss = new TextDate().writeMessage();
		return ss;
	}

}
