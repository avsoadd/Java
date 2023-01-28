<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<jsp:useBean id="item" scope="request" class="websample13_14_ans.ItemBean"/>

<%-- Java入門 購入確認画面 --%>
<!DOCTYPE html>
<html>
	<head>
		<title>Java入門</title>
		<link href="/schoo/WEB-sample13_14_ans/css/shopping.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		<h1>購入確認</h1>
		<p>つぎの商品を購入しますか？</p>
		<form action="./ResultServlet_ans" method="post">
			<table class="table_list">
				<tbody>
					<tr>
						<th>商品ID</th>
						<th>商品名</th>
						<th>価格</th>
						<th>在庫数</th>
						<th>購入数</th>
					</tr>
					<tr>
						<%-- リクエストスコープから表示する値を取得 --%>
						<td><jsp:getProperty property="itemId" name="item"/></td>
						<td><jsp:getProperty property="itemName" name="item"/></td>
						<td class="int"><jsp:getProperty property="price" name="item"/></td>
						<td class="int"><jsp:getProperty property="quantity" name="item"/></td>
						<td class="int"><%=request.getAttribute("quantity")%></td>
						<td class="button">
							<input class="common_button" type="submit" value="購入する">
							<%-- 購入処理を行うため、hidden（画面には表示されない情報）に商品IDと購入数を設定しておく --%>
							<input type="hidden" name="item_id" value="<%=item.getItemId()%>" />
							<input type="hidden" name="item_quantity" value="<%=request.getAttribute("quantity")%>" />
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		<form action="./ShoppingServlet_ans" method="post">
			<input class="common_button" type="submit" value="一覧に戻る">
		</form>
	</body>
</html>