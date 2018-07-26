<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<center>

		<form action="updp" method="post">
			<input type="hidden" name="id" value='${info["id"]}'>
			<br>
			<br>姓 名: <input type="text" name="name" maxlength="15" size="20" value='${info["name"]}'>
			<br>
			<br>性 别: <input type="text" name="sex" maxlength="15" size="20" value='${info["sex"]}'>
			<br>
			<br>年 龄: <input type="text" name="age" maxlength="15" size="20" value='${info["age"]}'>
			<br>
			<br>电 话: <input type="text" name="phone" maxlength="15"
				size="20" value='${info["phone"]}'> <br>
			<br>邮箱: <input type="text" name="[e-mail]" maxlength="15"
				size="20" value='${info["[e-mail]"]}'> <br>
			<br>
			<input type="submit" value="修 改">

		</form>
	</center>

</body>
</html>