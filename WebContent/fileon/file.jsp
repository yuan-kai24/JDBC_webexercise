<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>

	<body>
		<form action="/Kdl_jsp/upload" method="post" enctype="multipart/form-data">
			<br />账号：<input type="text" name="username" maxlength="18" size="25" /><br />
			<br />邮箱：<input type="email" name="email" maxlength="25" size="25" /><br />
			<br />头像：<input type="file" name="headImg" value="选 择" accept="image/*" /><br />
			<br />
			<input type="submit" value="提交" />
			<i style="color:red;">${info}</i>
			<br />
		</form>
	</body>

</html>