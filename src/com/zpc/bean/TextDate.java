package com.zpc.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;



/**�����ṩ�ļ����ݲ���
*@author PC
*@version V1
*/
public class TextDate {
	
	
	private String path = "E:\\\\Eclipes\\\\�½��ļ���\\\\PersonalManager\\\\text\\\\Message.txt";
	
	
	/**
     * ��ȡ�ļ�
     * @param text �ļ�����
     */
    public void readMessage(String text) throws IOException {
		
		File f = new File(path);
		FileOutputStream fop = new FileOutputStream(f);
		
		OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
		writer.append(text);
		writer.close();
		fop.close();
	}
    
    /**
     * ��ȡ�ļ�
     * @return �����ļ�����
     */
    public String writeMessage() throws IOException {
		File f = new File(path);
		FileInputStream fip = new FileInputStream(f);
		InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
		
		StringBuffer sb = new StringBuffer();
        while (reader.ready()) {
            sb.append((char) reader.read());
        }
        reader.close();
 
        fip.close();
		return sb.toString();
	}

}
