<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録完了</title>
</head>
<body>
登録完了しました。
<form action="/call-log/RegisterServlet" method="get">
<p>ケースID:<c:out value="${case_id}"></c:out></p>
<p>名前</p><input type="text" disabled name="name">
<p>電話番号</p><input type ="text" disabled name="phone" >
<p>問い合わせ内容</p><textarea disabled name="contents" rows="6" cols="50"></textarea>
<p>担当窓口</p><select name="charge" disabled>
<option value="エアコン">エアコン</option>
<option value="換気扇">換気扇</option>
</select>
<input type="submit" value="登録">
<p><a href="/call-log/TopServlet">トップへ</a>
</form>
</body>
</html>