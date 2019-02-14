<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/UserAction_addUser" method="post">
		用户名：<input type="text" name="user_name" /> <br>
		年龄： <input type="text" name="user_age" /><br>
		<input type="submit" value="提交" />
	</form>
	<br>
	<br>
	<br>
	<form action="${pageContext.request.contextPath }/CustomerAction_addCustomer" method="post">
		客户名称：<input type="text" name="cust_name" /> <br>
		客户来源：<input type="text" name="cust_source" /><br>
		<input type="submit" value="客户注册"/>
	</form>
</body>
</html>