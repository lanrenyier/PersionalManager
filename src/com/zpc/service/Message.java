package com.zpc.service;

import java.io.IOException;
import com.zpc.bean.TextDate;

/**��������IO�������԰�ľ������
*@author PC
*@version V1
*/
public class Message {
	
	/**
	 * �÷����ǻ�ȡ���԰���ʾ����
     * @param text ����
     */
	public void MessageIn(String text) {
		try {
			new TextDate().readMessage(text);
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} 
	}
	
	
	/**
	 * �÷��������԰��ȡ��ʾ����
     * @return �����ı�����
     */
	public String MessageOut() throws IOException {
		
		String ss = new TextDate().writeMessage();
		return ss;
	}

}
