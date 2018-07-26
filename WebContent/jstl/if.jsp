<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>

<body>
	<% pageContext.setAttribute("jstl", 10); %>
	
	${jstl}
	
	<c:if test="${jstl > 20 }">
		成功20
	</c:if>
	
	<c:if test="${jstl > 5 }">
		成功5
	</c:if>
	
	<c:choose>
		<c:when test="1>2">123</c:when>
	</c:choose>
	
	<c:if test="5>10" var="result" scope="page" />
	
	<%=pageContext.getAttribute("result") %>
	
</body>
</html>