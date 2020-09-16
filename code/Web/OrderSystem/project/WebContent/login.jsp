<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta content="charset=UTF-8">
<title>登录页</title>
<link href="/OrderWeb/static/style.css" rel="stylesheet" type="text/css" >
</head>
<body>
	<form action="/OrderWeb/Login" method="post">
		<div class="login_div">
			登录名称:<input name="user_name" class="login_input" value="dailey"/>
		</div>
		<div class="login_div">
			登录密码:<input name="user_pass" type="password" class="login_input" value="1234"/>
		</div>
		<div class="login_div">
			<button type="submit">Submit</button>
			<button type="reset">Reset</button>
		</div>
	</form>
</body>
</html>