package com.java.view;


import java.sql.*;




public class Dbutil {
	private String jdbcName= "com.microsoft.sqlserver.jdbc.SQLServerDriver";// ��������
	private String dbUrl="jdbc:sqlserver://localhost;DatabaseName=��ӰԺ";//Ŀ�����ݿ�
	private String dbUserName="sa";							    // �û���
	private String dbPassword="c1234567"; 						// ����


	public Connection getCon()throws Exception{					//��ȡ���ݿ�����
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}
	public void closeCon(Connection con)throws Exception{		//�ر����ݿ�����
		if(con!=null){
			con.close();
		}
	}
	public static void main(String[] args) {
		Dbutil dbUtil=new Dbutil();
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL���ݿ�����
		String connectDB ="jdbc:sqlserver://localhost;DatabaseName=��ӰԺ"; 
		try {
			Class.forName(JDriver);// �������ݿ����棬���ظ����ַ���������
		    }
		catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("�������ݿ�����ʧ��");
			System.exit(0);
		   }
		System.out.println("���ݿ������ɹ�");
		try {
			dbUtil.getCon();
			System.out.println("���ݿ����ӳɹ���");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ��");
		}
	}
}

