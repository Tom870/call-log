<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索</title>
</head>
<body>
<form action="/call-log/SearchServlet" method="post">
<p>ケースID</p><input type="text" name="case_id">
<p>電話番号</p><input type="text" required name="phone">
<input type="submit" name="search" value="検索">
</form>
</body>
</html>