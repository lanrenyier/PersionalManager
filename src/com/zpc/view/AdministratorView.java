package com.zpc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.zpc.service.Resiger;
import com.zpc.vo.UserTable;

import javax.swing.JButton;
import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdministratorView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;//表格
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	/**
	 * Create the frame.
	 */
	public AdministratorView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 400, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JFrameView frame = new JFrameView();
				frame.setVisible(true);
				
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 18));
		button.setBounds(455, 313, 113, 27);
		contentPane.add(button);
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(314, 30, 72, 18);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(417, 29, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//删除用户
		JButton button_1 = new JButton("\u5220\u9664");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new Resiger().UserDelete(textField.getText());
					updateDate();
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 18));
		button_1.setBounds(455, 77, 113, 27);
		contentPane.add(button_1);
		
		JLabel label_1 = new JLabel("\u7BA1\u7406\u5458\u53F7\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		label_1.setBounds(302, 139, 113, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u7BA1\u7406\u5458\u5BC6\u7801\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 18));
		label_2.setBounds(302, 185, 113, 18);
		contentPane.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(417, 138, 86, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(417, 184, 86, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		
		//管理员增加
		JButton button_2 = new JButton("\u589E\u52A0");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String account = textField_1.getText();
				String password = textField_2.getText();
				String accountRegex = "[a-zA-Z]{1,5}";
				String passwordRegex = "[a-zA-Z0-9]{6,8}";
				if(!account.matches(accountRegex)) {
				    JOptionPane.showMessageDialog(button, "账号不满足条件(1到5个英文字母)");
				    return;
				}
				if(!password.matches(passwordRegex)){
					JOptionPane.showMessageDialog(button, "密码不满足条件(6到8个数字或英文字母)");
					return;
				}
				try {
					new Resiger().AdministratorIncome(account,password);
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(button, "管理员增加成功");
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		button_2.setFont(new Font("宋体", Font.PLAIN, 18));
		button_2.setBounds(455, 233, 113, 27);
		contentPane.add(button_2);
		
		try{
			Object title[] = { "账号", "密码"};
			List<UserTable> list = new Resiger().UserDate();
			System.out.println(list);
			Object data[][] = new Object[list.size()][6];
			int i = 0;
			for (UserTable ud : list) {
				data[i][0] = ud.getAccount();
				data[i][1] = ud.getPassword();
				i++;
			}
			table = new JTable(data, title);
			table.setFont(new Font("宋体", Font.PLAIN, 20));
			table.setColumnSelectionAllowed(true);
			table.setRowHeight(30);
			
			JScrollPane jsp = new JScrollPane(table);
			jsp.setBounds(0, 0, 288, 353);
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
		List<UserTable> list = new Resiger().UserDate();
		System.out.println(list);
		Object data[][] = new Object[list.size()][6];
		int i = 0;
		for (UserTable ud : list) {
			data[i][0] = ud.getAccount();
			data[i][1] = ud.getPassword();
			i++;
		}
		table = new JTable(data, title);
		table.setFont(new Font("宋体", Font.PLAIN, 20));
		table.setColumnSelectionAllowed(true);
		table.setRowHeight(30);
		
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(0, 0, 288, 353);
		getContentPane().add(jsp);
		
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministratorView frame = new AdministratorView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
