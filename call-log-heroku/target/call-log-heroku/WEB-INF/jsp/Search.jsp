<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索</title>
</head>
<body>
<h1>検索</h1>
<form action="/call-log/SearchServlet" method="post">
<p>ケースID</p><input type="text" name="case_id" pattern="\d{1,}" title="数字を半角で入力してください。">
<p>電話番号</p><input type="tel" name="phone" pattern="\d{1,5}-\d{1,4}-\d{4,5}"
title="市外局番からハイフンを入れ、半角で入力してください。">
<input type="submit" name="search" value="検索">
</form>
</body>
</html>