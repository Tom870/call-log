<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
<form action="/call-log/LoginServlet" method="post">
ユーザーID<input type="text" name="userid"><br>
パスワード<input type="password" name="pass"><br>
<input type="submit" name="login" value="ログイン">
</form>
</body>
</html>