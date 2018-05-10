package com.java.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import javax.swing.JPasswordField;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTabbedPane;

public class login extends JFrame {
	private JPanel contentPane;
	//private JTextField txtUserName;
	//private JPasswordField txtPassword;
	private JTextField txtPassword_1;
	private Dbutil dbUtil =new Dbutil();
	private  JTextField txtUserName_1;
	private JComboBox Usertype_1;
	public static int Usertype;
	public static int Userid;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setTitle("\u7535\u5F71\u552E\u7968\u7CFB\u7EDF");
		setIconImage(Toolkit.getDefaultToolkit().getImage(login.class.getResource("/images/base.png")));
		setFont(new Font("宋体", Font.PLAIN, 12));
		//setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 396);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u7535\u5F71\u552E\u7968\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel.setIcon(new ImageIcon(login.class.getResource("/images/1123.png")));
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setIcon(new ImageIcon("D:\\sql\\logo\\userName.png"));
		
		//txtUserName = new JTextField();
		//txtUserName.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5BC6  \u7801\uFF1A");
		label_1.setIcon(new ImageIcon("D:\\sql\\logo\\password.png"));
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		//txtPassword = new JPasswordField();
		JButton butLogin = new JButton("\u767B\u5F55");
		butLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logon();
			}


		});
		
		


			
		butLogin.setIcon(new ImageIcon("D:\\sql\\logo\\login.png"));
		
		
		
		txtPassword_1 = new JTextField();
		setTxtUserName_1(new JTextField());
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(219)
					.addComponent(butLogin, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(229, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(138)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
							.addGap(75)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtPassword_1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
								.addComponent(getTxtUserName_1(), GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
							.addGap(93))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(115)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addGap(58)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(getTxtUserName_1(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPassword_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(57)
					.addComponent(butLogin, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(43))
		);
		contentPane.setLayout(gl_contentPane);
		


	}
	private void logon() {
	String user=getTxtUserName_1().getText().trim();
	String password=txtPassword_1.getText().trim();
	Connection con=null;
	
	try {
		con=dbUtil.getCon();
		java.sql.Statement stmt=con.createStatement();
		String sql = "select * from 用户  where 用户id='"+ user +"' and 密码='"+ password +"'"; //进行登陆验证
		PreparedStatement pstm = con.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			Usertype =  rs.getInt("类型");
			Userid= rs.getInt("用户id");				
			Admin frmMain3=new Admin();frmMain3.setVisible(true);dispose();						
		}
		else{
			JOptionPane.showMessageDialog(null, "账号或密码错误！");
			return;
		}	
	} 
	catch (Exception e) {
		JOptionPane.showMessageDialog(null, "账号或密码错误！");
		e.printStackTrace();
	}	
	finally {
		try {
			dbUtil.closeCon(con);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	}

	public JTextField getTxtUserName_1() {
		return txtUserName_1;
	}

	public void setTxtUserName_1(JTextField txtUserName_1) {
		this.txtUserName_1 = txtUserName_1;
	}
	}
