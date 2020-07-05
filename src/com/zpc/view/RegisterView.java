package com.zpc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.zpc.service.Resiger;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

/**该类提供了登录界面的视图
*@author PC
*@version V1
*/
public class RegisterView extends JFrame {

	private static final long serialVersionUID = -5786623709090337705L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
     * 主调用
     * @param
     */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterView frame = new RegisterView();
					frame.setTitle("注册");
					frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
     * 界面初始化
     */
	public RegisterView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 400, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//用户名
		textField = new JTextField();
		textField.setBounds(291, 162, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		//密码
		textField_1 = new JTextField();
		textField_1.setBounds(291, 226, 86, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("\u7528\u6237\u540D  \uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(175, 155, 102, 34);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801    \uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		label_1.setBounds(174, 227, 113, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u8D26\u53F7\u6CE8\u518C");
		label_2.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 32));
		label_2.setBounds(195, 39, 309, 103);
		contentPane.add(label_2);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.setFont(new Font("宋体", Font.PLAIN, 18));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				textField_1.setText("");
			}
		});
		button_1.setBounds(267, 302, 69, 27);
		contentPane.add(button_1);
		
		JButton button = new JButton("\u6CE8\u518C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String account = textField.getText();
				String password = textField_1.getText();
				String accountRegex = "[a-zA-Z]{1,5}";
				String passwordRegex = "[a-zA-Z0-9]{6,8}";
				if(!account.matches(accountRegex)) {
				    JOptionPane.showMessageDialog(button, "用户名不满足条件(1到5个英文字母)");
				    return;
				}
				if(!password.matches(passwordRegex)){
					JOptionPane.showMessageDialog(button, "用户名不满足条件(1到5个英文字母)");
					return;
				}
				
				try {
					new Resiger().UserIncome(account,password);
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(button, "用户注册成功，回到登录界面");
				
				//返回登录界面
				JFrameView frame = new JFrameView();
				dispose();
				frame.setVisible(true);
			}
		});
		button.setBounds(140, 304, 113, 27);
		contentPane.add(button);
		
		JLabel label_3 = new JLabel("\uFF08\u75311\u52306\u4F4D\u82F1\u6587\u5B57\u6BCD\u7EC4\u6210\uFF09");
		label_3.setFont(new Font("宋体", Font.PLAIN, 10));
		label_3.setBounds(391, 165, 177, 18);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\uFF08\u75316\u52308\u4F4D\u6570\u5B57\u6216\u82F1\u6587\u5B57\u6BCD\u7EC4\u6210\uFF09");
		label_4.setFont(new Font("宋体", Font.PLAIN, 10));
		label_4.setBounds(391, 229, 177, 18);
		contentPane.add(label_4);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				JFrameView frame = new JFrameView();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(350, 304, 113, 27);
		contentPane.add(btnNewButton);
	}
}
