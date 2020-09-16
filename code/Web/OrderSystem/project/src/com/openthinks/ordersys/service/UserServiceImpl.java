/**
 * 
 */
package com.openthinks.ordersys.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.openthinks.ordersys.dao.DaoHelper;
import com.openthinks.ordersys.mode.SysUser;

/**
 * @author DAD2SZH
 *
 */
public class UserServiceImpl implements UserService {

	@Override
	public SysUser findUser(String uname, String upass) {
		SysUser user = null;
		String sql = "select * from sys_user where user_name = ?";

		try {
			Connection conn = DaoHelper.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String user_pass = rs.getString("user_pass");
				if (user_pass.equals(upass)) {
					user = new SysUser();
					user.setID(rs.getLong("ID"));
					user.setUserName(uname);
					user.setUserPass(user_pass);
					break;
				}
			}
			DaoHelper.close(conn, ps, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

}
