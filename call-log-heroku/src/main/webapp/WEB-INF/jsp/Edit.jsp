<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編集</title>
</head>
<body>
<form action="/call-log/SearchServlet?edit=done" method="post">
<h1>編集</h1>
<p>ケースID:</p><input type="text" readonly name="editcase_id" value=<c:out value="${case_id}"></c:out>><br>
<p>名前：</p><input type="text" name="editname" required pattern="\D{1,11}" title="文字のみ入力してください。"
value=<c:out value="${name}"></c:out>><br>
<p>電話番号：</p><input type="tel" name="editphone" pattern="\d{1,5}-\d{1,4}-\d{4,5}"
title="市外局番からハイフンを入れ、半角で入力してください。" value=<c:out value="${phone}"></c:out>><br>
<p>問い合わせ内容</p><textarea name="editcontents" required rows="6" cols="50" ><c:out value="${contents}"></c:out></textarea>
<p>担当窓口：</p><input type="text" name="editcharge" required value=<c:out value="${charge}"></c:out>><br>
<input type="submit" name="edit" value="完了">
</form>
</body>
</html>