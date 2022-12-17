<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<jsp:useBean id="user_db" scope="session" class="websample13_14_ans.LoginUserBean" />

<%-- Java入門 ヘッダー画面 --%>
<div align="right">
	<%-- ログイン済みの場合はIDを表示 --%>
	ようこそ「<jsp:getProperty property="name" name="user_db"/>」さん！
	<a href="/schoo/LoginServletShopping_ans?submit=history">購入履歴</a>
	<a href="/schoo/LoginServletShopping_ans?submit=logout">ログアウト</a>
</div>