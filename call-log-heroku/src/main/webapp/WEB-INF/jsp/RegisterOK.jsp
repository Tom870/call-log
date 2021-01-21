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
<p>ケースID:<c:out value="${case_id}"></c:out></p>
<p>名前：<c:out value="${name}"></c:out></p>
<p>電話番号:<c:out value="${phone}"></c:out></p>
<p>問い合わせ内容：<c:out value="${contents}"></c:out></p>
<p>担当窓口：<c:out value="${charge}"></c:out></p>
<p><a href="/call-log/TopServlet">トップへ</a>
</body>
</html>