package com.zpc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.zpc.service.Login;

import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JRadioButton;

/**�����ṩ�˵�¼�������ͼ
*@author PC
*@version V1
*/
public class JFrameView extends JFrame {

	private static final long serialVersionUID = -5786623709090337705L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
     * ������
     * @param
     */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameView frame = new JFrameView();
					frame.setTitle("������֧����ϵͳ");
					frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
     * �����ʼ��
     */
	public JFrameView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 400, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//�û���
		textField = new JTextField();
		textField.setBounds(303, 198, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		//����
		textField_1 = new JTextField();
		textField_1.setBounds(303, 249, 86, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		//��¼�����¼�
		JButton button = new JButton("\u767B\u5F55");
		
		button.setFont(new Font("����", Font.PLAIN, 18));
		button.setBounds(137, 302, 113, 27);
		contentPane.add(button);
		
		JLabel label = new JLabel("\u7528\u6237\u540D  \uFF1A");
		label.setFont(new Font("����", Font.PLAIN, 18));
		label.setBounds(187, 193, 102, 34);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801    \uFF1A");
		label_1.setFont(new Font("����", Font.PLAIN, 18));
		label_1.setBounds(187, 252, 113, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u4E2A\u4EBA\u6536\u652F\u7BA1\u7406\u7CFB\u7EDF");
		label_2.setFont(new Font("����", Font.BOLD | Font.ITALIC, 32));
		label_2.setBounds(148, 41, 309, 103);
		contentPane.add(label_2);
		
		JButton button_1 = new JButton("\u6CE8\u518C");
		button_1.setFont(new Font("����", Font.PLAIN, 18));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				RegisterView frame = new RegisterView();
				frame.setVisible(true);
			}
		});
		button_1.setBounds(341, 302, 113, 27);
		contentPane.add(button_1);
		
		JButton btnNewButton = new JButton("\u91CD\u7F6E");
		btnNewButton.setFont(new Font("����", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
			}
		});
		btnNewButton.setBounds(257, 305, 76, 24);
		contentPane.add(btnNewButton);
		
		//����Ա�û�����
		ButtonGroup group = new ButtonGroup();
		
		JRadioButton radioButton = new JRadioButton("\u7BA1\u7406\u5458");
		radioButton.setBounds(190, 169, 73, 27);
		contentPane.add(radioButton);
		group.add(radioButton);
		//����Ա����
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							int s= new Login().LoginAdministrator(textField.getText(), textField_1.getText());
							if(s == 0) {
							      JOptionPane.showMessageDialog(button, "�˺Ų����ڻ��������");
						          return;
							}
						    dispose();
						    AdministratorView frame = new AdministratorView();
						    frame.setVisible(true);	 		
						} catch (SQLException e1) {
							// TODO �Զ����ɵ� catch ��
							e1.printStackTrace();
						} catch (Exception e1) {
							// TODO �Զ����ɵ� catch ��
							e1.printStackTrace();
						}
						
					}
				});
			}
		});

		JRadioButton radioButton_1 = new JRadioButton("\u7528\u6237");
		radioButton_1.setBounds(311, 169, 63, 27);
		contentPane.add(radioButton_1);
		group.add(radioButton_1);
		//�û�����
		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int s= new Login().LoginUser(textField.getText(), textField_1.getText());
					if(s == 0) {
					      JOptionPane.showMessageDialog(button, "�˺Ų����ڻ��������");
				          return;
					}
				    dispose();
				    PersionalView frame = new PersionalView();
				    frame.setVisible(true);	 		
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
				
			}
		});

			}
		});
	}
}
