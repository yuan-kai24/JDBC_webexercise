<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<b style="color:red;font-size: 24px;">${errorlogin}</b>
	<form action="rlogin" method="post">
		<br>用户名：<input type="text" size="20" name="username"><br>
		<br> 密   码：<input type="password" size="20" name="password"><br>
		<br>验证码：<input type="text" size="5" name="randomcode">
		<img  src="randomcode" style="cursor: pointer;" id="rcode" onclick="randomChange()">
		
		<br>
		<br>
		<input type="submit" value="提 交">
	</form>
</body>
	<script type="text/javascript">
		function randomChange()
		{
			document.getElementById("rcode").src = "randomcode?" + new Date().getTime();
		}
	</script>
</html>