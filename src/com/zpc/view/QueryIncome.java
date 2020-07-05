package com.zpc.view;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.zpc.factory.InFactory;
import com.zpc.vo.DateTable;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Font;
import java.awt.event.ActionEvent;


/**�����ṩ�˸�������������ͼ
*@author PC
*@version V1
*/
public class QueryIncome extends JFrame{
 
	private static final long serialVersionUID = -7374216931349943998L;
	private JTable table;//���
	/**
     * �����ʼ��
     */
	public QueryIncome() {
		// TODO Auto-generated constructor stub
		this.setBounds(500, 400, 600, 400);
		getContentPane().setLayout(null);
		
		setTitle("��������");	
		//��������������������
		JButton button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				PersionalView frame;
				try {
					frame = new PersionalView();
					frame.setVisible(true);
				} catch (Exception e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(455, 313, 113, 27);
		getContentPane().add(button);
		
		//�����������������ӽ���
		JButton button_1 = new JButton("\u589E\u52A0");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IncomeIncrease();
			}
		});
		button_1.setBounds(25, 213, 113, 27);
		getContentPane().add(button_1);
		
		//��������������ɾ������
		JButton button_2 = new JButton("\u5220\u9664");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IncomeDelete();
			}
		});
		button_2.setBounds(25, 253, 113, 27);
		getContentPane().add(button_2);
		
		//���������������ѯ����
		JButton button_3 = new JButton("\u67E5\u8BE2");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new IncomeInquire();
			}
		});
		button_3.setBounds(25, 293, 113, 27);
		getContentPane().add(button_3);
			
		new JTextField();
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		try{	
			Object title[] = { "���", "ʱ��", "��Ŀ", "��ע" };
			new InFactory();
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
			table.setFont(new Font("����", Font.PLAIN, 20));
			table.setColumnSelectionAllowed(true);
			table.setRowHeight(30);
			
			JScrollPane jsp = new JScrollPane(table);
			jsp.setBounds(0, 0, 582, 211);
			getContentPane().add(jsp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
    /**
     * ������
     * @param
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new QueryIncome();
	}
}