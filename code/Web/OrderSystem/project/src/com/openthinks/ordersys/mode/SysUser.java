/**
 * 
 */
package com.openthinks.ordersys.mode;

/**
 * @author DAD2SZH
 *
 */
public class SysUser {
	private Long ID;
	private String userName;
	private String userPass;

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

}
