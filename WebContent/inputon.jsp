<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String ran = UUID.randomUUID().toString();
		session.setAttribute("token", ran);
	
	%>
	
	<form action="input" method="post">
		<input type="hidden" value=<%=ran %> name="token">
		数据:<input type="text" name="data" size="10" maxlength="10">
		<br>
		<input type="submit" value="提交">
	</form>
</body>
</html>