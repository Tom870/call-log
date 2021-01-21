<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録</title>
</head>
<body>
<h1>登録画面</h1>
<form action="/call-log/RegisterServlet" method="post">
<p>名前</p><input type="text" required name="name" pattern="\D{1,11}" title="文字のみ入力してください。">
<p>電話番号</p><input type ="tel" required name="phone"pattern="\d{1,5}-\d{1,4}-\d{4,5}"
title="市外局番からハイフンを入れ、半角で入力してください。">
<p>問い合わせ内容</p><textarea name="contents" required rows="6" cols="50"></textarea>
<p>担当窓口</p><select name="charge">
<option value="エアコン">エアコン</option>
<option value="換気扇">換気扇</option>
</select>
<input type="submit" name="register" value="登録">
</form>
</body>
</html>