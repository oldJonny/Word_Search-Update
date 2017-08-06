package com.test;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
 * ���ݿ�����
 */
public class Conn {

	// ����jar��·��
	private static String driver = "com.mysql.jdbc.Driver";

	// ���ݿ�·��
	private static String url = "jdbc:mysql://localhost:3306/carsystem";

	// �û���
	private static String userName = "root";

	// ����
	private static String password = "root";

	static {
		try {
			Class.forName(driver);
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, userName, password);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void main(String[] args) {
		System.out.println(new Conn().getConnection());
	}

}
