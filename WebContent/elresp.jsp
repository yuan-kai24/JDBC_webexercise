<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>普通显示</h1>
	<hr>
	request:<%=request.getAttribute("person") %>
	<br>
	
	
	<h1>El显示</h1>
	<hr>
	<br>id:${person.id}
	<br>name:${person["name"]}
	<br>sex:${person.sex?"男":"女"}
	<br>list:${person.getList()[1]}
	<br>info:${person.info["w.y.c"] }
	<br>information:${person }
</body>
</html>