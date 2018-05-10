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
	private JTextField ��Ӱ��;
	private JTextField ����;
	private JTextField ����;
	private JTextField ��ӳ����;
	private JTextField ӰƬʱ��;
	private JTextField ���;
	private Dbutil dbutil = new Dbutil();
	private JTextField ��Ƭid;
	private JTextField ��Ӱ��_1;
	private JTextField ��ӳ��id;
	private JTextField ����;
	private JTextField �۸�;
	private JTextField �û�id;
	private JTextField ����;
	private JTextField ����;
	private JTextField �Ա�;
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

		��Ӱ�� = new JTextField();
		��Ӱ��.setColumns(10);

		JLabel label_1 = new JLabel("\u5BFC\u6F14");

		���� = new JTextField();
		����.setColumns(10);

		JLabel label_2 = new JLabel("\u4E3B\u6F14");

		���� = new JTextField();
		����.setColumns(10);

		JLabel label_3 = new JLabel("\u4E0A\u6620\u65E5\u671F");

		��ӳ���� = new JTextField();
		��ӳ����.setColumns(10);

		JLabel label_4 = new JLabel("\u5F71\u7247\u65F6\u957F");

		ӰƬʱ�� = new JTextField();
		ӰƬʱ��.setColumns(10);

		JLabel label_5 = new JLabel("\u7B80\u4ECB");

		��� = new JTextField();
		���.setColumns(10);

		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Addmovie();
			}

		});

		JLabel label_6 = new JLabel("\u6DFB\u52A0\u6392\u7247");

		JLabel lblid = new JLabel("\u6392\u7247id");

		��Ƭid = new JTextField();
		��Ƭid.setColumns(10);

		JLabel label_7 = new JLabel("\u7535\u5F71\u540D");

		��Ӱ��_1 = new JTextField();
		��Ӱ��_1.setColumns(10);

		JLabel lblid_1 = new JLabel("\u653E\u6620\u5385id");

		��ӳ��id = new JTextField();
		��ӳ��id.setColumns(10);

		JLabel label_8 = new JLabel("\u573A\u6B21");

		���� = new JTextField();
		����.setColumns(10);

		JLabel label_9 = new JLabel("\u4EF7\u683C");

		�۸� = new JTextField();
		�۸�.setColumns(10);

		JButton button_1 = new JButton("\u6DFB\u52A0");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addpaipian();
			}

		});

		JLabel label_10 = new JLabel("\u6DFB\u52A0\u7528\u6237");

		JLabel lblid_2 = new JLabel("\u7528\u6237id");

		�û�id = new JTextField();
		�û�id.setColumns(10);

		JLabel label_11 = new JLabel("\u59D3\u540D");

		���� = new JTextField();
		����.setColumns(10);

		JLabel label_12 = new JLabel("\u5BC6\u7801");

		���� = new JTextField();
		����.setColumns(10);

		JLabel label_13 = new JLabel("\u6027\u522B");

		�Ա� = new JTextField();
		�Ա�.setColumns(10);

		JLabel label_14 = new JLabel("\u7C7B\u578B");

		JComboBox ���� = new JComboBox();
		����.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				confirm = ����.getSelectedIndex();
			}
		});
		����.setModel(new DefaultComboBoxModel(new String[] {"\u4F1A\u5458", "\u7BA1\u7406\u5458"}));
		����.setToolTipText("");
		����.setFont(new Font("������", Font.PLAIN, 13));

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
																		.addGap(18).addComponent(���))
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(lblNewLabel)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(��Ӱ��, GroupLayout.PREFERRED_SIZE, 104,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(18)
																.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 36,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(����, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(28)
																.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 36,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(4)
																.addComponent(
																		����, GroupLayout.PREFERRED_SIZE, 77,
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
																.addComponent(�û�id, GroupLayout.PREFERRED_SIZE, 99,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 36,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(
																		����, GroupLayout.PREFERRED_SIZE, 66,
																		GroupLayout.PREFERRED_SIZE))
														.addGroup(Alignment.LEADING, gl_contentPane
																.createSequentialGroup()
																.addComponent(lblid, GroupLayout.PREFERRED_SIZE, 36,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(��Ƭid, GroupLayout.PREFERRED_SIZE, 29,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 36,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(
																		��Ӱ��_1, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(lblid_1)))
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_contentPane.createSequentialGroup()
																		.addComponent(��ӳ��id, GroupLayout.PREFERRED_SIZE,
																				34, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.UNRELATED)
																		.addComponent(
																				label_8, GroupLayout.PREFERRED_SIZE, 36,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(����, GroupLayout.PREFERRED_SIZE,
																				123, GroupLayout.PREFERRED_SIZE)
																		.addGap(18).addComponent(label_9,
																				GroupLayout.PREFERRED_SIZE, 38,
																				GroupLayout.PREFERRED_SIZE))
																.addGroup(gl_contentPane.createSequentialGroup()
																		.addComponent(label_12,
																				GroupLayout.PREFERRED_SIZE, 36,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(����, GroupLayout.PREFERRED_SIZE,
																				90, GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(label_13,
																				GroupLayout.PREFERRED_SIZE, 38,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(�Ա�, GroupLayout.PREFERRED_SIZE,
																				34, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.UNRELATED)
																		.addComponent(label_14,
																				GroupLayout.PREFERRED_SIZE, 36,
																				GroupLayout.PREFERRED_SIZE)))))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(��ӳ����, GroupLayout.PREFERRED_SIZE, 77,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 59,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(18).addComponent(
																		ӰƬʱ��, GroupLayout.PREFERRED_SIZE, 77,
																		GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_contentPane.createSequentialGroup()
																.addGroup(gl_contentPane
																		.createParallelGroup(Alignment.TRAILING)
																		.addComponent(����, GroupLayout.PREFERRED_SIZE,
																				66, GroupLayout.PREFERRED_SIZE)
																		.addComponent(�۸�, GroupLayout.PREFERRED_SIZE,
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
								.addComponent(��Ӱ��, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1)
								.addComponent(����, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2)
								.addComponent(����, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label_3)
								.addComponent(��ӳ����, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label_4).addComponent(ӰƬʱ��, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(label_5)
								.addComponent(���, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(button))
						.addGap(27).addComponent(label_6, GroupLayout.PREFERRED_SIZE, 15,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblid)
								.addComponent(��Ƭid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label_7)
								.addComponent(��Ӱ��_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblid_1)
								.addComponent(��ӳ��id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label_8)
								.addComponent(����, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_9)
								.addComponent(�۸�, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(button_1))
						.addGap(51).addComponent(
								label_10)
						.addGap(28)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblid_2)
								.addComponent(�û�id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label_11)
								.addComponent(����, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label_12)
								.addComponent(����, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_13)
								.addComponent(�Ա�, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label_14)
								.addComponent(����, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_2))
						.addContainerGap(85, Short.MAX_VALUE)));
		setSize(1024, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane.setLayout(gl_contentPane);
	}

	private void Addmovie() {
		String ��Ӱ�� = this.��Ӱ��.getText();
		String ���� = this.����.getText();
		String ���� = this.����.getText();
		String ��Ӱʱ�� = this.ӰƬʱ��.getText();
		String ��ӳ���� = this.��ӳ����.getText();
		String ��� = this.���.getText();
		Connection con = null;
		try {
			con = dbutil.getCon();
			Statement st = con.createStatement();
			if(��Ӱ��!=null) {
			String sql = "insert into ��Ӱ(��Ӱ��,����,����,ӰƬʱ��,��ӳ����,���) values('" + ��Ӱ�� + "','" + ���� + "','" + ���� + "','"
					+ ��Ӱʱ�� + "','" + ��ӳ���� + "','" + ��� + "')";// ��ӵ�Ӱ
			int result = st.executeUpdate(sql);
			if (result > 0) {
				JOptionPane.showMessageDialog(null, "��Ӱ��ӳɹ���");
			} else {
				JOptionPane.showMessageDialog(null, "��Ӱ���ʧ�ܣ�");
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "��Ӱ���ʧ�ܣ�");
		} finally {
			try {
				dbutil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	private void addpaipian() {
		String one = this.��Ƭid.getText();
		String two = this.��Ӱ��_1.getText();
		String three = this.��ӳ��id.getText();
		String four = this.����.getText();
		String five = this.�۸�.getText();
		Connection con = null;
		try {
			con = dbutil.getCon();
			Statement st = con.createStatement();
			String sql = "exec �����Ƭ " + one + " ,'" + two + "'," + three + ",'" + four + "'," + five + "";// �����Ƭ
			int result = st.executeUpdate(sql);
			if (result > 0) {
				JOptionPane.showMessageDialog(null, "��Ƭ��ӳɹ���");
			} else {
				JOptionPane.showMessageDialog(null, "��Ƭ���ʧ�ܣ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "��Ƭ���ʧ�ܣ�");
		} finally {
			try {
				dbutil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	private void adduser() {
		String one = this.�û�id.getText();
		String two = this.����.getText();
		String three = this.����.getText();
		String four = this.�Ա�.getText();
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
			String sql = "insert\r\n" + "into �û�(�û�id,����,����,�Ա�,����)\r\n" + "values( " + one + " ,'" + two + "','" + three
					+ "','" + four + "'," + five + ")"; // ����û�
			int result = st.executeUpdate(sql);
			if (result > 0) {
				JOptionPane.showMessageDialog(null, "�û���ӳɹ���");
			} else {
				JOptionPane.showMessageDialog(null, "�û����ʧ�ܣ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "�û����ʧ�ܣ�");
		} finally {
			try {
				dbutil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}
