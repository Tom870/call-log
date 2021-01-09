<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録</title>
</head>
<body>
ケースID：<c:out value="${case_id}"></c:out><br>
名前：<c:out value="${name}"></c:out><br>
電話番号：<c:out value="${phone}"></c:out><br>
問い合わせ内容<br><c:out value="${contents}"></c:out><br>
担当窓口：<c:out value="${charge}"></c:out><br>
<p><a href="/call-log/TopServlet">トップへ</a></p>
</body>
</html>