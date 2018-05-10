package com.java.view;
import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Checkbox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JToolBar;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
public class User extends JFrame {

	private JPanel contentPane;
	private Dbutil dbutil =new Dbutil();
	String txt电影名;
	String txt场次;
	String txt简介;
	int txt座位;
	int txt排片id;
	int txt放映厅id;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User frame = new User();
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
	public User() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 878, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.controlHighlight);
		panel_1.setForeground(Color.LIGHT_GRAY);

		JLabel label = new JLabel("\u7535\u5F71");

		JLabel label_1 = new JLabel("\u573A\u6B21");

		JButton btnNewButton = new JButton("\u6211\u9009\u597D\u4E86\uFF0C\u53BB\u652F\u4ED8");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				try {
					con = dbutil.getCon();
					Statement st = con.createStatement();
					String sql1 = "select *  from 排片      where 电影名='"+txt电影名+"'";
					PreparedStatement pstm = con.prepareStatement(sql1);
					ResultSet rs = pstm.executeQuery();
					if (rs.next()) {
						txt排片id=rs.getInt("排片id");
						//JOptionPane.showMessageDialog(null,txt排片id);
					}
					String sql = "exec 添加订单  '"+txt场次+"',"+txt排片id+","+login.Usertype+","+txt座位+"";										 // 添加订单
					int result = st.executeUpdate(sql);
					if (result > 0) {
						JOptionPane.showMessageDialog(null, "订单添加成功！");
					} else {
						JOptionPane.showMessageDialog(null,"订单添加失败！");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "订单添加失败！");
				} finally {
					try {
						dbutil.closeCon(con);
					} catch (Exception e1) {
						e1.printStackTrace();
					}

				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JPanel panel = new JPanel();
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(30)
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(20)
									.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE))))
					.addGap(19))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(34)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(label))
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE))
							.addGap(6))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(btnNewButton)
					.addGap(23))
		);
		
		JLabel lblNewLabel = new JLabel("\u7535\u5F71\u540D");
		
		JTextPane textPane1 = new JTextPane();



		JLabel label_2 = new JLabel("\u653E\u6620\u5385");
		
		JTextPane textPane2 = new JTextPane();
		
		JTextPane textPane3 = new JTextPane();
		textPane1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Settxt(textPane1,textPane2,textPane3);
			}
		});
		JLabel label_3 = new JLabel("\u7B80\u4ECB");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textPane3, GroupLayout.PREFERRED_SIZE, 457, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textPane1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(textPane2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addComponent(textPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_2)
							.addComponent(lblNewLabel))
						.addComponent(textPane1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textPane3, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JList list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				txt电影名=(String)list.getSelectedValue();
				//JOptionPane.showMessageDialog(null, txt电影名);
				/*DefaultListModel dlm = new DefaultListModel();
				Connection con=null;
				try{
					con=dbutil.getCon();
					Statement stmt = null;
					stmt = con.createStatement();
					 String sql = "select 电影名  from 电影";
					 ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()){	
						txt简介=rs.getString("简介");
						JOptionPane.showMessageDialog(null,txt简介);
					}    
				     		       
				}
				 catch(Exception e1)
				    {
					e1.printStackTrace();
				     }
				   finally
				   {
					try {
						 dbutil.closeCon(con);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				   }*/
			}
			
		});
		DefaultListModel dlm = new DefaultListModel();
		Connection con=null;
		try{
			con=dbutil.getCon();
			Statement stmt = null;
			stmt = con.createStatement();
			 String sql = "select 电影名  from 电影  ";
			 ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){	
				//txt简介=rs.getString("简介");
				dlm.addElement(rs.getString("电影名"));
				list.setModel(dlm);	
			}    
		     		       
		}
		 catch(Exception e1)
		    {
			e1.printStackTrace();
		     }
		   finally
		   {
			try {
				 dbutil.closeCon(con);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		   }
		scrollPane.setViewportView(list);
		
		JList list_1 = new JList();
		list_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				jlistbuild(list_1);
			}
		});
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {"\u6682\u65E0"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		list_1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				txt场次=(String)list_1.getSelectedValue();
				//JOptionPane.showMessageDialog(null, txt场次);
				
				
			}
		});
		//jlistbuild(list_1);
		scrollPane_1.setViewportView(list_1 );

		JLabel label_10 = new JLabel("\u7B2C1\u6392");

		JLabel label_11 = new JLabel("\u7B2C2\u6392");

		JLabel label_12 = new JLabel("\u7B2C3\u6392");

		JLabel label_13 = new JLabel("\u7B2C5\u6392");

		JLabel label_14 = new JLabel("\u7B2C6\u6392");
		
		JRadioButton radioButton_0 = new JRadioButton("8");
		radioButton_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txt座位=18;
			}
		});

		
		JRadioButton radioButton_1 = new JRadioButton("8");
		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txt座位=28;
			}
		});
		
		JRadioButton radioButton_2 = new JRadioButton("8");
		radioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txt座位=38;
			}
		});
		
		JRadioButton radioButton_3 = new JRadioButton("8");
		radioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txt座位=48;
			}
		});
		
		JRadioButton radioButton_4 = new JRadioButton("8");
		radioButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txt座位=58;
			}
		});

		JRadioButton radioButton_5 = new JRadioButton("6");
		radioButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txt座位=16;
			}
		});
		
		JRadioButton radioButton_6 = new JRadioButton("6");
		radioButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txt座位=26;
			}
		});
		JRadioButton radioButton_7 = new JRadioButton("6");
		radioButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txt座位=36;
			}
		});
		JRadioButton radioButton_8 = new JRadioButton("6");
		radioButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txt座位=46;
			}
		});
		JRadioButton radioButton_9 = new JRadioButton("6");
		radioButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txt座位=56;
			}
		});
		JRadioButton radioButton_10 = new JRadioButton("2");
		radioButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txt座位=12;
			}
		});
		JRadioButton radioButton_11 = new JRadioButton("2");
		radioButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txt座位=22;
			}
		});
		JRadioButton radioButton_12 = new JRadioButton("2");
		radioButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txt座位=32;
			}
		});
		JRadioButton radioButton_13 = new JRadioButton("2");
		radioButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txt座位=42;
			}
		});
		JRadioButton radioButton_14 = new JRadioButton("2");
		radioButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txt座位=52;
			}
		});
		JRadioButton radioButton_15 = new JRadioButton("1");
		radioButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txt座位=11;
			}
		});
		JRadioButton radioButton_16 = new JRadioButton("1");
		radioButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txt座位=21;
			}
		});
		JRadioButton radioButton_17 = new JRadioButton("1");
		radioButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txt座位=31;
			}
		});
		JRadioButton radioButton_18 = new JRadioButton("1");
		radioButton_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txt座位=41;
			}
		});
		JRadioButton radioButton_19 = new JRadioButton("1");
		radioButton_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txt座位=51;
			}
		});
		JRadioButton radioButton_20 = new JRadioButton("3");
		radioButton_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txt座位=13;
			}
		});
		JRadioButton radioButton_21 = new JRadioButton("3");
		radioButton_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txt座位=23;
			}
		});
		JRadioButton radioButton_22 = new JRadioButton("3");
		radioButton_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txt座位=33;
			}
		});
		JRadioButton radioButton_23 = new JRadioButton("3");
		radioButton_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txt座位=43;
			}
		});
		JRadioButton radioButton_24 = new JRadioButton("3");
		radioButton_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txt座位=53;
			}
		});
		JRadioButton radioButton_25 = new JRadioButton("5");
		radioButton_25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txt座位=15;
			}
		});
		JRadioButton radioButton_26 = new JRadioButton("5");
		radioButton_26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txt座位=25;
			}
		});
		JRadioButton radioButton_27 = new JRadioButton("5");
		radioButton_27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txt座位=35;
			}
		});
		JRadioButton radioButton_28 = new JRadioButton("5");
		radioButton_28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txt座位=45;
			}
		});
		JRadioButton radioButton_29 = new JRadioButton("5");
		radioButton_29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txt座位=55;
			}
		});
		JRadioButton radioButton_30 = new JRadioButton("7");
		radioButton_30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txt座位=17;
			}
		});
		JRadioButton radioButton_31 = new JRadioButton("7");
		radioButton_31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txt座位=27;
			}
		});
		JRadioButton radioButton_32 = new JRadioButton("7");
		radioButton_32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txt座位=37;
			}
		});
		JRadioButton radioButton_33 = new JRadioButton("7");
		radioButton_33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txt座位=47;
			}
		});
		JRadioButton radioButton_34 = new JRadioButton("7");
		radioButton_34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txt座位=57;
			}
		});
		ButtonGroup radio =new ButtonGroup();
		radio.add(radioButton_0);
		radio.add(radioButton_1);
		radio.add(radioButton_2);
		radio.add(radioButton_3);
		radio.add(radioButton_4);
		radio.add(radioButton_5);
		radio.add(radioButton_6);
		radio.add(radioButton_7);
		radio.add(radioButton_8);
		radio.add(radioButton_9);
		radio.add(radioButton_10);
		radio.add(radioButton_11);
		radio.add(radioButton_12);
		radio.add(radioButton_13);
		radio.add(radioButton_14);
		radio.add(radioButton_15);
		radio.add(radioButton_16);
		radio.add(radioButton_17);
		radio.add(radioButton_18);
		radio.add(radioButton_19);
		radio.add(radioButton_20);
		radio.add(radioButton_21);
		radio.add(radioButton_22);
		radio.add(radioButton_23);
		radio.add(radioButton_24);
		radio.add(radioButton_25);
		radio.add(radioButton_26);
		radio.add(radioButton_27);
		radio.add(radioButton_28);
		radio.add(radioButton_29);
		radio.add(radioButton_30);
		radio.add(radioButton_31);
		radio.add(radioButton_32);
		radio.add(radioButton_33);
		radio.add(radioButton_34);

		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(label_10)
						.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_12, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_14, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(radioButton_0, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButton_4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButton_3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButton_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButton_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(radioButton_5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButton_6, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButton_7, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButton_8, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButton_9, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(radioButton_10, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButton_11, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButton_12, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButton_13, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButton_14, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(radioButton_15, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButton_16, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButton_17, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButton_18, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButton_19, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(radioButton_23, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addGap(34)
								.addComponent(radioButton_28, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(radioButton_22, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
								.addComponent(radioButton_27, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(radioButton_20, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(radioButton_25, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(radioButton_21, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
								.addComponent(radioButton_26, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(radioButton_24, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addComponent(radioButton_29, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
					.addGap(38)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(radioButton_34, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButton_33, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButton_32, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButton_31, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButton_30, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(20))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_10)
						.addComponent(radioButton_0)
						.addComponent(radioButton_5)
						.addComponent(radioButton_10)
						.addComponent(radioButton_15)
						.addComponent(radioButton_20)
						.addComponent(radioButton_25)
						.addComponent(radioButton_30))
					.addGap(34)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_11)
						.addComponent(radioButton_1)
						.addComponent(radioButton_6)
						.addComponent(radioButton_11)
						.addComponent(radioButton_16)
						.addComponent(radioButton_21)
						.addComponent(radioButton_26)
						.addComponent(radioButton_31))
					.addGap(32)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_12)
						.addComponent(radioButton_2)
						.addComponent(radioButton_7)
						.addComponent(radioButton_12)
						.addComponent(radioButton_17)
						.addComponent(radioButton_22)
						.addComponent(radioButton_27)
						.addComponent(radioButton_32))
					.addGap(28)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_13)
						.addComponent(radioButton_3)
						.addComponent(radioButton_8)
						.addComponent(radioButton_13)
						.addComponent(radioButton_18)
						.addComponent(radioButton_23)
						.addComponent(radioButton_28)
						.addComponent(radioButton_33))
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_14)
						.addComponent(radioButton_4)
						.addComponent(radioButton_9)
						.addComponent(radioButton_14)
						.addComponent(radioButton_19)
						.addComponent(radioButton_24)
						.addComponent(radioButton_29)
						.addComponent(radioButton_34))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);
		setSize(1000,700);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	JTextPane Settxt(JTextPane x,JTextPane y,JTextPane z)
	{
		String a=txt放映厅id+"";
		x.setText(txt电影名);
		y.setText(a);
		z.setText(txt简介);
		return z;}
	JList jlistbuild(JList listmodel)
	{
	DefaultListModel abc = new DefaultListModel();
	Connection con=null;
	try{
		
		con=dbutil.getCon();
		Statement stmt1 = null;
		stmt1 = con.createStatement();
		String sql1 = "select *  from 电影  where 电影名='"+txt电影名+"' ";
		ResultSet rs = stmt1.executeQuery(sql1);
		while(rs.next()){
		txt简介=rs.getString("简介");}
		 String sql = "select *  from 排片  where 电影名='"+txt电影名+"' ";
		ResultSet rs1 = stmt1.executeQuery(sql);
		while(rs1.next()){	
			txt放映厅id=rs1.getInt("放映厅id");
			abc.addElement(rs1.getString("场次"));
			listmodel.setModel(abc);  
		 	
		}
	}
	 catch(Exception e1)
	    {
		e1.printStackTrace();
	     }
	   finally
	   {
		try {
			 dbutil.closeCon(con);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	   }
	return listmodel;
	}
	

}
