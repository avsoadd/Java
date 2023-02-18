<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%-- Java入門 購入結果画面 --%>
<!DOCTYPE html>
<html>
	<head>
		<title>Java入門</title>
		<link href="/schoo/WEB-sample13_14_ans/css/shopping.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		<h1>購入結果</h1>
		<p>購入しました。<img src="/schoo/WEB-sample13_14_ans/img/Thankyou.jpg" width="100" height="100"/></p>
		<form action="./ShoppingServlet_ans" method="post">
			<input class="common_button" type="submit" value="一覧に戻る">
		</form>
	</body>
</html>