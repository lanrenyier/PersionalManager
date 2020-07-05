package com.zpc.view;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.zpc.factory.InFactory;
import com.zpc.service.Increase;
import com.zpc.vo.DateTable;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Font;
import java.awt.event.ActionEvent;

/**该类提供了收入增加的视图
*@author PC
*@version V1
*/
public class IncomeIncrease extends JFrame{
 
	private static final long serialVersionUID = -7374216931349943998L;
	private JTable table;//表格
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	/**
     * 界面初始化
     */
	public IncomeIncrease() {
		// TODO Auto-generated constructor stub
		this.setBounds(500, 400, 600, 400);
		getContentPane().setLayout(null);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new QueryIncome();
			}
		});
		button.setBounds(455, 313, 113, 27);
		getContentPane().add(button);
		
		JLabel label = new JLabel("\u91D1\u989D  \uFF1A");
		label.setBounds(14, 213, 72, 18);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(87, 210, 86, 24);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u65F6\u95F4  \uFF1A");
		label_1.setBounds(351, 213, 72, 18);
		getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(426, 210, 86, 24);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("\u9879\u76EE  \uFF1A");
		label_2.setBounds(14, 257, 72, 18);
		getContentPane().add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(87, 254, 86, 24);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("\u5907\u6CE8  \uFF1A");
		label_3.setBounds(351, 257, 72, 18);
		getContentPane().add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(426, 254, 86, 24);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		//增加数据
		JButton button_1 = new JButton("\u589E\u52A0");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Increase<Object>().IncomeIncrease(textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText());
					updateDate();
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				
			}
		});
		button_1.setBounds(14, 313, 113, 27);
		getContentPane().add(button_1);
		
		JLabel label_4 = new JLabel("\uFF08\u4E0D\u4E3A\u7A7A\uFF09");
		label_4.setBounds(181, 213, 86, 18);
		getContentPane().add(label_4);
		
		JLabel label_4_1 = new JLabel("\uFF08\u4E0D\u4E3A\u7A7A\uFF09");
		label_4_1.setBounds(181, 257, 86, 18);
		getContentPane().add(label_4_1);
		
		JLabel label_4_2 = new JLabel("\uFF08\u4E0D\u4E3A\u7A7A\uFF09");
		label_4_2.setBounds(514, 213, 86, 18);
		getContentPane().add(label_4_2);
		new JTextField();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		try{
			Object title[] = { "金额", "时间", "项目", "备注" };
			List<DateTable> list = InFactory.getInstance("income");
			System.out.println(list);
			Object data[][] = new Object[list.size()][6];
			int i = 0;
			for (DateTable ud : list) {
				data[i][0] = ud.getMoney();
				data[i][1] = ud.getTime();
				data[i][2] = ud.getProject();
				data[i][3] = ud.getRemarks();
				i++;
			}
			table = new JTable(data, title);
			table.setFont(new Font("宋体", Font.PLAIN, 20));
			table.setColumnSelectionAllowed(true);
			table.setRowHeight(30);
			
			JScrollPane jsp = new JScrollPane(table);
			jsp.setBounds(0, 0, 582, 200);
			getContentPane().add(jsp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
     * 该方法是操作成功后的界面刷新
     */
	public void updateDate() throws Exception {
		Object title[] = { "金额", "时间", "项目", "备注" };
		List<DateTable> list = InFactory.getInstance("income");
		System.out.println(list);
		Object data[][] = new Object[list.size()][6];
		int i = 0;
		for (DateTable ud : list) {
			data[i][0] = ud.getMoney();
			data[i][1] = ud.getTime();
			data[i][2] = ud.getProject();
			data[i][3] = ud.getRemarks();
			i++;
		}
		table = new JTable(data, title);
		table.setFont(new Font("宋体", Font.PLAIN, 20));
		table.setColumnSelectionAllowed(true);
		table.setRowHeight(30);
		
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(0, 0, 582, 200);
		getContentPane().add(jsp);
	}

	/**
     * 主调用
     * @param
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new IncomeIncrease();
	}
}