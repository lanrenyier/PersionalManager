package com.zpc.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.zpc.factory.InFactory;
import com.zpc.vo.DateTable;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Font;
import java.awt.event.ActionEvent;

/**�����ṩ��֧����ѯ����ͼ
*@author PC
*@version V1
*/
public class ExpendInquire extends JFrame{
 
	private static final long serialVersionUID = -7374216931349943998L;
	private JTable table;//���
	private DefaultTableModel model;//�������ģ��
	private JTextField textField;
	
	/**
     * �����ʼ��
     */
	public ExpendInquire() {
		// TODO Auto-generated constructor stub
		this.setBounds(500, 400, 600, 400);
		getContentPane().setLayout(null);
		
		//����������֧������
		JButton button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new QueryExpend();
			}
		});
		button.setBounds(455, 313, 113, 27);
		getContentPane().add(button);
		
		//��ʱ�����Ŀ��ѯ
		JButton button_3 = new JButton("\u67E5\u8BE2");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
				table.setRowSorter(sorter);
				sorter.setRowFilter(RowFilter.regexFilter(textField.getText()));
			}
		});
		button_3.setBounds(27, 313, 113, 27);
		getContentPane().add(button_3);
		
		textField = new JTextField();
		textField.setBounds(177, 224, 86, 24);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u67E5\u8BE2\u7684\u65F6\u95F4\u6216\u9879\u76EE\uFF1A");
		label.setBounds(27, 226, 136, 21);
		getContentPane().add(label);

		new JTextField();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		try{
			List<DateTable> list = InFactory.getInstance("expend");
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
			table=new JTable();
			table.setFont(new Font("����", Font.PLAIN, 20));
			table.setColumnSelectionAllowed(true);
			table.setRowHeight(30);
			model=new DefaultTableModel();
			table.setModel(model);
			
			JScrollPane jsp=new JScrollPane(table);
			jsp.setBounds(0, 0, 582, 211);
			getContentPane().add(jsp);
			model.addColumn("��Ǯ");
	    	model.addColumn("ʱ��");
	    	model.addColumn("��Ŀ");
	    	model.addColumn("��ע");
	    	for(int j=0;j<i;j++)
	    	{
	    		model.addRow(data[j]);
	    	}
//			table = new JTable(data, title);
//			table.setFont(new Font("����", Font.PLAIN, 20));
//			table.setColumnSelectionAllowed(true);
//			table.setRowHeight(30);
//			
//			JScrollPane jsp = new JScrollPane(table);
//			jsp.setBounds(0, 0, 582, 211);
//			getContentPane().add(jsp);
		}catch(Exception e){
			e.printStackTrace();
		}
		//addListenter();
	}
    /**
     * ������
     * @param
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ExpendInquire();
	}
}