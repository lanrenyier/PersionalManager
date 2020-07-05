package com.zpc.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;



/**该类提供文件数据操作
*@author PC
*@version V1
*/
public class TextDate {
	
	
	private String path = "E:\\\\Eclipes\\\\新建文件夹\\\\PersonalManager\\\\text\\\\Message.txt";
	
	
	/**
     * 存取文件
     * @param text 文件内容
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
     * 读取文件
     * @return 返回文件内容
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
