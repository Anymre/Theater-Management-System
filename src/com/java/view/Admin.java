package com.java.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class Admin extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table =null;
	private JTextField Userid;
	private JTable table_1;
	private Dbutil dbutil =new Dbutil();
	private JTextField ����id;
	private JTextField �û�id;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setTitle("\u552E\u7968\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u552E\u7968\u7BA1\u7406");
		mnNewMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnNewMenu.setIcon(new ImageIcon(Admin.class.getResource("/images/base.png")));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_2 = new JMenu("\u7BA1\u7406");
		mnNewMenu_2.setIcon(new ImageIcon(Admin.class.getResource("/images/bookManager.png")));
		mnNewMenu.add(mnNewMenu_2);
		
		JMenuItem menuItem_2 = new JMenuItem("\u6DFB\u52A0\u7535\u5F71\uFF0C\u6392\u7247\uFF0C\u7528\u6237");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Add frmMain=new Add();frmMain.setVisible(true);
			}
		});


		menuItem_2.setIcon(new ImageIcon(Admin.class.getResource("/images/add.png")));
		mnNewMenu_2.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u653E\u6620\u5385\u7BA1\u7406");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Delete frmMain=new Delete();frmMain.setVisible(true);

			}
		});
		menuItem_3.setIcon(new ImageIcon(Admin.class.getResource("/images/edit.png")));
		mnNewMenu_2.add(menuItem_3);
		
		JMenu menu = new JMenu("\u4E70\u7968");
		menu.setIcon(new ImageIcon(Admin.class.getResource("/images/base.png")));
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u4E0B\u8BA2\u5355");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User frmMain=new User();frmMain.setVisible(true);dispose();
			}
		});
		menuItem.setIcon(new ImageIcon(Admin.class.getResource("/images/add.png")));
		menu.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u8F93\u5165\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel ������ = new JLabel("\u7528\u6237id");
		panel.add(������);
		
		Userid = new JTextField();
		Userid.setColumns(15);
		panel.add(Userid);
		
		JSeparator separator = new JSeparator();
		panel.add(separator);
		
		JButton ���� = new JButton("\u641C\u7D22");
		����.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				research();
			}
		});
		panel.add(����);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		
		JButton btnNewButton = new JButton("\u67E5\u770B\u6240\u6709\u8BA2\u5355");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dtm=(DefaultTableModel)table_1.getModel();
				dtm.setRowCount(0); // ���ó�0��*/
			///�������ݿ�	
				Connection con=null;
				try{
					con=dbutil.getCon();
					Statement stmt = null;
					stmt = con.createStatement();
					 String sql = "select * from �鿴����";
					 ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()){
						Vector v=new Vector();
						v.add(rs.getString("����id"));
						v.add(rs.getString("�û�id"));
						v.add(rs.getString("��Ӱ��"));
						v.add(rs.getString("��ӳ��id"));
						v.add(rs.getString("����"));
						v.add(rs.getString("����ʱ��"));
						v.add(rs.getString("ʵ�����"));
						dtm.addRow(v);	
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
				
			}
			
		});
		
		JLabel lblid = new JLabel("\u8BA2\u5355id");
		
		����id = new JTextField();
		����id.setColumns(15);
		
		�û�id = new JTextField();
		�û�id.setColumns(15);
		
		JLabel lblid_1 = new JLabel("\u7528\u6237id");
		
		JButton button = new JButton("\u5220\u9664\u8BA2\u5355");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteOrder();
			}

		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(34)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 455, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(button)
										.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE))
									.addGap(18)
									.addComponent(btnNewButton))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(65)
							.addComponent(lblid, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(����id, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addGap(81)
							.addComponent(lblid_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(�û�id, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(123)
							.addComponent(btnNewButton)))
					.addGap(58)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblid_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(�û�id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(button)))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblid, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addComponent(����id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
		);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BA2\u5355id", "\u7528\u6237id", "\u7535\u5F71\u540D", "\u653E\u6620\u5385id", "\u573A\u6B21", "\u8D2D\u4E70\u65F6\u95F4", "\u5B9E\u4ED8\u91D1\u989D"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(58);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(54);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(83);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(62);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(135);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(130);
		scrollPane.setViewportView(table_1);
		contentPane.setLayout(gl_contentPane);
		setSize(800,600);
		if(login.Usertype==1)
		{
			mnNewMenu.setVisible(false);
			btnNewButton.setEnabled(false);
			button.setEnabled(false);
			Userid.setEnabled(false);
		}
		// ����JFrame���
	}
	private void research() {
		DefaultTableModel dtm=(DefaultTableModel)table_1.getModel();
		dtm.setRowCount(0); // ���ó�0��*/
		String id=this.Userid.getText();
		if(login.Usertype==1)
		{
			id=String.valueOf(login.Userid);
		}
	///�������ݿ�	
		Connection con=null;
		try{
			con=dbutil.getCon();
			Statement stmt = null;
			stmt = con.createStatement();
			 String sql = "select * from �鿴����   where �û�id="+id+"";
			 ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				Vector v=new Vector();
				v.add(rs.getString("����id"));
				v.add(rs.getString("�û�id"));
				v.add(rs.getString("��Ӱ��"));
				v.add(rs.getString("��ӳ��id"));
				v.add(rs.getString("����"));
				v.add(rs.getString("����ʱ��"));
				v.add(rs.getString("ʵ�����"));
				dtm.addRow(v);	
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
		
	}

	private void DeleteOrder() {
	///�������ݿ�
		int OrderId=Integer.parseInt(this.����id.getText());
		int UserId=Integer.parseInt(this.�û�id.getText());
		Connection con=null;
		try{
			con=dbutil.getCon();
			Statement stmt = null;
			stmt = con.createStatement();
			 String sql = "exec ȡ������ "+OrderId+","+UserId+"";
			 boolean rs = stmt.execute(sql);
			 if(rs=true)
				JOptionPane.showMessageDialog(null, "�����ɹ�ɾ����");
		}
		 catch(Exception e1)
		    {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "����ɾ��ʧ�ܣ�");
		     }
		   finally
		   {
			try {
				 dbutil.closeCon(con);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		   }
		
		}
		
}
		



