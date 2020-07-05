package com.zpc.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.zpc.factory.BaFactory;
import com.zpc.service.Message;

import javax.swing.JTextArea;

/**该类提供了主个人界面的视图
*@author PC
*@version V1
*/
public class PersionalView extends JFrame {

	private static final long serialVersionUID = 2150057878071862707L;
	private JPanel contentPane;
	private JTextArea textArea = new JTextArea();

	/**
     * 主调用
     * @param
     */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersionalView frame = new PersionalView();
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
	public PersionalView() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 400, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		textArea.setFont(new Font("宋体", Font.PLAIN, 18));
		
		//显示留言板
		textArea.append(new Message().MessageOut());
		
		//监听事件，到收入页面
		JButton button = new JButton("\u6536\u5165");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new QueryIncome();
			}
		});
		button.setBounds(48, 204, 113, 27);
		contentPane.add(button);
		
		//监听事件，到支出页面
		JButton button_1 = new JButton("\u652F\u51FA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new QueryExpend();
			}
		});
		button_1.setBounds(48, 244, 113, 27);
		contentPane.add(button_1);
		
		JLabel label = new JLabel("\u603B\u6536\u5165  \uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(25, 38, 113, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u603B\u652F\u51FA  \uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(25, 82, 113, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u4F59\u989D  \uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(48, 126, 90, 18);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel(BaFactory.getInstance("income"));
		label_3.setFont(new Font("宋体", Font.PLAIN, 18));
		label_3.setBounds(139, 34, 72, 27);
		contentPane.add(label_3);
		
		JLabel label_3_1 = new JLabel(BaFactory.getInstance("expend"));
		label_3_1.setFont(new Font("宋体", Font.PLAIN, 18));
		label_3_1.setBounds(139, 78, 72, 27);
		contentPane.add(label_3_1);
		
		JLabel label_3_2 = new JLabel(BaFactory.getInstance("balance"));
		label_3_2.setFont(new Font("宋体", Font.PLAIN, 18));
		label_3_2.setBounds(139, 122, 72, 27);
		contentPane.add(label_3_2);
		
		JButton button_2 = new JButton("\u9000\u51FA\u7A0B\u5E8F");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		button_2.setBounds(48, 284, 113, 27);
		contentPane.add(button_2);
		
		
		textArea.setBounds(297, 24, 285, 262);
		contentPane.add(textArea);
		
		JButton button_3 = new JButton("\u4FDD\u5B58");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					new Message().MessageIn(textArea.getText());
			}
		});
		button_3.setBounds(390, 294, 113, 27);
		contentPane.add(button_3);
	}
}
