<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
 <body>
		<div align="center">
		<form action="" method="post">
			<input type="text" name="userEmail" placeholder="请输入邮箱" /><br/>
			<input type="text" name="userName" placeholder="请输入用户名" /><br/>
			<input type="password" name="userPassword" placeholder="请输入密码"/><br/>
			<input type="text" name="" placeholder="验证码"/><br/>
			<img src="#" /><br/>
			
			<input type="button" value="注册" />
		</form>
		</div>
	</body>
</html>
