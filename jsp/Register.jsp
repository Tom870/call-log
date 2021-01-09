<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録</title>
</head>
<body>
<form action="/call-log/RegisterServlet" method="post">
<p>名前</p><input type="text" required name="name">
<p>電話番号</p><input type ="text" required name="phone">
<p>問い合わせ内容</p><textarea name="contents" required rows="6" cols="50"></textarea>
<p>担当窓口</p><select name="charge">
<option value="エアコン">エアコン</option>
<option value="換気扇">換気扇</option>
</select>
<input type="submit" value="登録">
</form>
</body>
</html>