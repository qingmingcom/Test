package com.yeepay.data.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDb2 {

	public static void main(String[] args) throws Exception {
		String driverClassName = "com.mysql.jdbc.Driver";
		Class.forName(driverClassName);

		String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false";
		String user = "test";
		String password = "test";
		Connection conn = DriverManager.getConnection(url, user, password);

		Statement stmt = conn.createStatement();
		String sql = "select 1 cnt from dual";
		ResultSet rs = stmt.executeQuery(sql);

		rs.next();
		int cnt = rs.getInt("cnt");
		System.out.println(cnt);

		rs.close();
		stmt.close();
		conn.close();
	}
}
