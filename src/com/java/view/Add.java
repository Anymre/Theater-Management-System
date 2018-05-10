package com.java.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Dialog.ModalExclusionType;

public class Add extends JFrame {
	private JPanel contentPane;
	private JTextField 电影名;
	private JTextField 导演;
	private JTextField 主演;
	private JTextField 上映日期;
	private JTextField 影片时长;
	private JTextField 简介;
	private Dbutil dbutil = new Dbutil();
	private JTextField 排片id;
	private JTextField 电影名_1;
	private JTextField 放映厅id;
	private JTextField 场次;
	private JTextField 价格;
	private JTextField 用户id;
	private JTextField 姓名;
	private JTextField 密码;
	private JTextField 性别;
	private int confirm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add frame = new Add();
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
	public Add() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 853, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel label = new JLabel("\u6DFB\u52A0\u7535\u5F71");

		JLabel lblNewLabel = new JLabel("\u7535\u5F71\u540D");

		电影名 = new JTextField();
		电影名.setColumns(10);

		JLabel label_1 = new JLabel("\u5BFC\u6F14");

		导演 = new JTextField();
		导演.setColumns(10);

		JLabel label_2 = new JLabel("\u4E3B\u6F14");

		主演 = new JTextField();
		主演.setColumns(10);

		JLabel label_3 = new JLabel("\u4E0A\u6620\u65E5\u671F");

		上映日期 = new JTextField();
		上映日期.setColumns(10);

		JLabel label_4 = new JLabel("\u5F71\u7247\u65F6\u957F");

		影片时长 = new JTextField();
		影片时长.setColumns(10);

		JLabel label_5 = new JLabel("\u7B80\u4ECB");

		简介 = new JTextField();
		简介.setColumns(10);

		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Addmovie();
			}

		});

		JLabel label_6 = new JLabel("\u6DFB\u52A0\u6392\u7247");

		JLabel lblid = new JLabel("\u6392\u7247id");

		排片id = new JTextField();
		排片id.setColumns(10);

		JLabel label_7 = new JLabel("\u7535\u5F71\u540D");

		电影名_1 = new JTextField();
		电影名_1.setColumns(10);

		JLabel lblid_1 = new JLabel("\u653E\u6620\u5385id");

		放映厅id = new JTextField();
		放映厅id.setColumns(10);

		JLabel label_8 = new JLabel("\u573A\u6B21");

		场次 = new JTextField();
		场次.setColumns(10);

		JLabel label_9 = new JLabel("\u4EF7\u683C");

		价格 = new JTextField();
		价格.setColumns(10);

		JButton button_1 = new JButton("\u6DFB\u52A0");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addpaipian();
			}

		});

		JLabel label_10 = new JLabel("\u6DFB\u52A0\u7528\u6237");

		JLabel lblid_2 = new JLabel("\u7528\u6237id");

		用户id = new JTextField();
		用户id.setColumns(10);

		JLabel label_11 = new JLabel("\u59D3\u540D");

		姓名 = new JTextField();
		姓名.setColumns(10);

		JLabel label_12 = new JLabel("\u5BC6\u7801");

		密码 = new JTextField();
		密码.setColumns(10);

		JLabel label_13 = new JLabel("\u6027\u522B");

		性别 = new JTextField();
		性别.setColumns(10);

		JLabel label_14 = new JLabel("\u7C7B\u578B");

		JComboBox 类型 = new JComboBox();
		类型.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				confirm = 类型.getSelectedIndex();
			}
		});
		类型.setModel(new DefaultComboBoxModel(new String[] {"\u4F1A\u5458", "\u7BA1\u7406\u5458"}));
		类型.setToolTipText("");
		类型.setFont(new Font("新宋体", Font.PLAIN, 13));

		JButton button_2 = new JButton("\u6DFB\u52A0");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adduser();
			}

		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(
												label_6, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
										.addComponent(label)
										.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
												.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
														.createParallelGroup(Alignment.LEADING, false).addGroup(
																gl_contentPane
																		.createSequentialGroup().addComponent(label_5)
																		.addGap(18).addComponent(简介))
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(lblNewLabel)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(电影名, GroupLayout.PREFERRED_SIZE, 104,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(18)
																.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 36,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(导演, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(28)
																.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 36,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(4)
																.addComponent(
																		主演, GroupLayout.PREFERRED_SIZE, 77,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(18).addComponent(label_3,
																		GroupLayout.PREFERRED_SIZE, 59,
																		GroupLayout.PREFERRED_SIZE)))
												.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
														.createParallelGroup(Alignment.TRAILING, false)
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(lblid_2, GroupLayout.PREFERRED_SIZE, 36,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(用户id, GroupLayout.PREFERRED_SIZE, 99,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 36,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(
																		姓名, GroupLayout.PREFERRED_SIZE, 66,
																		GroupLayout.PREFERRED_SIZE))
														.addGroup(Alignment.LEADING, gl_contentPane
																.createSequentialGroup()
																.addComponent(lblid, GroupLayout.PREFERRED_SIZE, 36,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(排片id, GroupLayout.PREFERRED_SIZE, 29,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 36,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(
																		电影名_1, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(lblid_1)))
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_contentPane.createSequentialGroup()
																		.addComponent(放映厅id, GroupLayout.PREFERRED_SIZE,
																				34, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.UNRELATED)
																		.addComponent(
																				label_8, GroupLayout.PREFERRED_SIZE, 36,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(场次, GroupLayout.PREFERRED_SIZE,
																				123, GroupLayout.PREFERRED_SIZE)
																		.addGap(18).addComponent(label_9,
																				GroupLayout.PREFERRED_SIZE, 38,
																				GroupLayout.PREFERRED_SIZE))
																.addGroup(gl_contentPane.createSequentialGroup()
																		.addComponent(label_12,
																				GroupLayout.PREFERRED_SIZE, 36,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(密码, GroupLayout.PREFERRED_SIZE,
																				90, GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(label_13,
																				GroupLayout.PREFERRED_SIZE, 38,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(性别, GroupLayout.PREFERRED_SIZE,
																				34, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.UNRELATED)
																		.addComponent(label_14,
																				GroupLayout.PREFERRED_SIZE, 36,
																				GroupLayout.PREFERRED_SIZE)))))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(上映日期, GroupLayout.PREFERRED_SIZE, 77,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 59,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(18).addComponent(
																		影片时长, GroupLayout.PREFERRED_SIZE, 77,
																		GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_contentPane.createSequentialGroup()
																.addGroup(gl_contentPane
																		.createParallelGroup(Alignment.TRAILING)
																		.addComponent(类型, GroupLayout.PREFERRED_SIZE,
																				66, GroupLayout.PREFERRED_SIZE)
																		.addComponent(价格, GroupLayout.PREFERRED_SIZE,
																				44, GroupLayout.PREFERRED_SIZE))
																.addGap(110)
																.addGroup(gl_contentPane
																		.createParallelGroup(Alignment.TRAILING)
																		.addComponent(button)
																		.addComponent(button_1,
																				GroupLayout.PREFERRED_SIZE, 69,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(button_2,
																				GroupLayout.PREFERRED_SIZE, 69,
																				GroupLayout.PREFERRED_SIZE)))))
										.addComponent(label_10, GroupLayout.PREFERRED_SIZE, 57,
												GroupLayout.PREFERRED_SIZE))
								.addContainerGap(50, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addComponent(label)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
								.addComponent(电影名, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1)
								.addComponent(导演, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2)
								.addComponent(主演, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label_3)
								.addComponent(上映日期, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label_4).addComponent(影片时长, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(label_5)
								.addComponent(简介, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(button))
						.addGap(27).addComponent(label_6, GroupLayout.PREFERRED_SIZE, 15,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblid)
								.addComponent(排片id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label_7)
								.addComponent(电影名_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblid_1)
								.addComponent(放映厅id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label_8)
								.addComponent(场次, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_9)
								.addComponent(价格, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(button_1))
						.addGap(51).addComponent(
								label_10)
						.addGap(28)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblid_2)
								.addComponent(用户id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label_11)
								.addComponent(姓名, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label_12)
								.addComponent(密码, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_13)
								.addComponent(性别, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label_14)
								.addComponent(类型, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_2))
						.addContainerGap(85, Short.MAX_VALUE)));
		setSize(1024, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane.setLayout(gl_contentPane);
	}

	private void Addmovie() {
		String 电影名 = this.电影名.getText();
		String 导演 = this.导演.getText();
		String 主演 = this.主演.getText();
		String 电影时长 = this.影片时长.getText();
		String 上映日期 = this.上映日期.getText();
		String 简介 = this.简介.getText();
		Connection con = null;
		try {
			con = dbutil.getCon();
			Statement st = con.createStatement();
			if(电影名!=null) {
			String sql = "insert into 电影(电影名,导演,主演,影片时长,上映日期,简介) values('" + 电影名 + "','" + 导演 + "','" + 主演 + "','"
					+ 电影时长 + "','" + 上映日期 + "','" + 简介 + "')";// 添加电影
			int result = st.executeUpdate(sql);
			if (result > 0) {
				JOptionPane.showMessageDialog(null, "电影添加成功！");
			} else {
				JOptionPane.showMessageDialog(null, "电影添加失败！");
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "电影添加失败！");
		} finally {
			try {
				dbutil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	private void addpaipian() {
		String one = this.排片id.getText();
		String two = this.电影名_1.getText();
		String three = this.放映厅id.getText();
		String four = this.场次.getText();
		String five = this.价格.getText();
		Connection con = null;
		try {
			con = dbutil.getCon();
			Statement st = con.createStatement();
			String sql = "exec 添加排片 " + one + " ,'" + two + "'," + three + ",'" + four + "'," + five + "";// 添加排片
			int result = st.executeUpdate(sql);
			if (result > 0) {
				JOptionPane.showMessageDialog(null, "排片添加成功！");
			} else {
				JOptionPane.showMessageDialog(null, "排片添加失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "排片添加失败！");
		} finally {
			try {
				dbutil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	private void adduser() {
		String one = this.用户id.getText();
		String two = this.姓名.getText();
		String three = this.密码.getText();
		String four = this.性别.getText();
		int five = 0;
		switch (confirm) {
		case 0:
			five =0;
			break;
		case 1:
			five =1;
			break;
		}
		Connection con = null;
		try {
			con = dbutil.getCon();
			Statement st = con.createStatement();
			String sql = "insert\r\n" + "into 用户(用户id,姓名,密码,性别,类型)\r\n" + "values( " + one + " ,'" + two + "','" + three
					+ "','" + four + "'," + five + ")"; // 添加用户
			int result = st.executeUpdate(sql);
			if (result > 0) {
				JOptionPane.showMessageDialog(null, "用户添加成功！");
			} else {
				JOptionPane.showMessageDialog(null, "用户添加失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "用户添加失败！");
		} finally {
			try {
				dbutil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}
