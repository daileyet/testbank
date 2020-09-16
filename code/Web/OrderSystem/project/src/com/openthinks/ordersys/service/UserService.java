package com.openthinks.ordersys.service;

import com.openthinks.ordersys.mode.SysUser;

public interface UserService {

	
	SysUser findUser(String uname,String upass);
}
