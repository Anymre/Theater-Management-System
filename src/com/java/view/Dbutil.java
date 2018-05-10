package com.java.view;


import java.sql.*;




public class Dbutil {
	private String jdbcName= "com.microsoft.sqlserver.jdbc.SQLServerDriver";// 驱动名称
	private String dbUrl="jdbc:sqlserver://localhost;DatabaseName=电影院";//目标数据库
	private String dbUserName="sa";							    // 用户名
	private String dbPassword="c1234567"; 						// 密码


	public Connection getCon()throws Exception{					//获取数据库连接
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}
	public void closeCon(Connection con)throws Exception{		//关闭数据库连接
		if(con!=null){
			con.close();
		}
	}
	public static void main(String[] args) {
		Dbutil dbUtil=new Dbutil();
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL数据库引擎
		String connectDB ="jdbc:sqlserver://localhost;DatabaseName=电影院"; 
		try {
			Class.forName(JDriver);// 加载数据库引擎，返回给定字符串名的类
		    }
		catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("加载数据库引擎失败");
			System.exit(0);
		   }
		System.out.println("数据库驱动成功");
		try {
			dbUtil.getCon();
			System.out.println("数据库连接成功！");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
	}
}

