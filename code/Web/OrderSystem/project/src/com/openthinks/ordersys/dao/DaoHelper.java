/**
 * 
 */
package com.openthinks.ordersys.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author DAD2SZH
 *
 */
public final class DaoHelper {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConn() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://172.17.0.6:3306/order_db?characterEncoding=utf8", "tester",
				"test123");
	}

	public static void close(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
		if (rs != null && !rs.isClosed()) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}

		if (conn != null) {
			conn.close();
		}

	}
}
