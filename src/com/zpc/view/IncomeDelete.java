package com.zpc.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Font;
import java.awt.event.ActionEvent;

import com.zpc.factory.InFactory;
import com.zpc.service.Delete;
import com.zpc.vo.DateTable;

/**该类提供了收入删除的视图
*@author PC
*@version V1
*/
public class IncomeDelete extends JFrame{

	private static final long serialVersionUID = -7374216931349943998L;
	private JTable table;//表格
	private JTextField textField;
	
	private JTextField textField_1;
	/**
     * 界面初始化
     */
	public IncomeDelete() {
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
		
		
		//按项目删除
		JButton button_1 = new JButton("\u5220\u9664");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Delete().IncomeDelete(textField.getText(),textField_1.getText());
					updateDate();
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		button_1.setBounds(14, 313, 113, 27);
		getContentPane().add(button_1);
		
		textField = new JTextField();
		textField.setBounds(171, 220, 86, 24);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u8981\u5220\u9664\u7684\u9879\u76EE\uFF1A");
		label.setBounds(32, 223, 105, 18);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u9879\u76EE\u5177\u4F53\u65F6\u95F4\uFF1A");
		label_1.setBounds(32, 267, 122, 18);
		getContentPane().add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(171, 264, 86, 24);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
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
		//addListenter();
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
		new IncomeDelete();
	}
}