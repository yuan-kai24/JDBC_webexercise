<%@page import="com.yk.jdbc.SqlInfo"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<table cellpadding="0" cellspacing="0" align="center" width="600" border="1">
	<caption><a href="insert.jsp">添加学生</a></caption>
		<tr style="background:red;">
			<th>编号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>年龄</th>
			<th>手机</th>
			<th>邮箱</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${info}" var="sin" varStatus="num">
		
		<tr style='background:${num.count%2==0?"orange":""};'>
			<td>${sin.getID()}</td>
			<td>${sin.getName()}</td>
			<td>${sin.getSex()}</td>
			<td>${sin.getAge()}</td>
			<td>${sin.getPhone()}</td>
			<td>${sin.getE_mail()}</td>
			<td>
				<a href="delp?id=${sin.getID()}">删除</a>     |
				<a href="updo?id=${sin.getID()}">编辑</a>
			</td>
		</tr>
		</c:forEach>

	</table>
</body>
</html>