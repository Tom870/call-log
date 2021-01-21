<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Top.css">
<meta charset="UTF-8">
<title>トップ</title>
</head>
<body>
<h1>トップメニュー</h1>
<table>
<tr>
<td><button id="register" onclick="location.href='/call-log/RegisterServlet'" >登録</button></td>
<td><button id="search" onclick="location.href='/call-log/SearchServlet'" >検索</button>
</tr>
</table>
</body>
</html>