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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Delete extends JFrame {

	private JPanel contentPane;
	private JTextField ��ӳ��id;
	private Dbutil dbutil =new Dbutil();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete frame = new Delete();
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
	public Delete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblid = new JLabel("\u653E\u6620\u5385id");

		��ӳ��id = new JTextField();
		��ӳ��id.setColumns(10);

		JButton button = new JButton("\u5220\u9664");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblid)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(��ӳ��id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 167, Short.MAX_VALUE).addComponent(button)
						.addGap(72)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(25)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblid)
								.addComponent(��ӳ��id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(button))
						.addContainerGap(195, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
	private void Delete() {
		int Id=Integer.parseInt(this.��ӳ��id.getText());
		Connection con=null;
		try{
			con=dbutil.getCon();
			Statement stmt = null;
			stmt = con.createStatement();
			 String sql = "delete \r\n" + 
			 		"from ��ӳ��\r\n" + 
			 		"where ��ӳ��id='1'";
			 boolean rs = stmt.execute(sql);
			 if(rs=true)
				JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
		}
		 catch(Exception e1)
		    {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
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

