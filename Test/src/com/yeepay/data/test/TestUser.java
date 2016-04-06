package com.yeepay.data.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestUser {

	public static void main(String[] args) throws Exception {
		String driverClassName = "com.mysql.jdbc.Driver";
		Class.forName(driverClassName);

		String url = "jdbc:mysql://localhost:3306/dev?useUnicode=true&characterEncoding=utf-8&useSSL=false";
		String user = "dev";
		String password = "dev";
		Connection conn = DriverManager.getConnection(url, user, password);

		Statement stmt = conn.createStatement();
		String sql = "select id, number, name, birth_date, description, status, create_time, update_time from tbl_user";
		ResultSet rs = stmt.executeQuery(sql);

		System.out.println("id\tnumber\tname");
		System.out.println("--\t------\t----");
		while (rs.next()) {
			int id = rs.getInt("id");
			String number = rs.getString("number");
			String name = rs.getString("name");
			System.out.println(id + "\t" + number + "\t" + name);
		}

		rs.close();
		stmt.close();
		conn.close();
	}
}
