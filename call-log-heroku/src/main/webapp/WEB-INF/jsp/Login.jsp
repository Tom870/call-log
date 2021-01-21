<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
<h1>ログイン画面</h1>
<form action="/call-log/LoginServlet" method="post">
ユーザーID<p><input type="text" required name="userid"  pattern="\w{1,10}" title="半角英数字で入力してください。"><p><br>
パスワード<p><input type="password" required name="pass" pattern="\w{1,15}" title="半角英数字で入力してください。"></p><br>
<input type="submit" name="login" value="ログイン">
</form>
</body>
</html>