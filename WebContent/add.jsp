<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%!private int add(int x, int y) {
		return x + y;
	}%>
<%
	int x = 3;
	int y = 4;

	int sum = x + y;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="add" method="post">
		<table>
			<tr>
				<td>덧셈 계산?</td>
			</tr>
			<tr>
				<td><label>x : </label> 
				<input type="text" name="x" /></td>
			</tr>
			<tr>
				<td><label>y : </label> <input type="text" name="y" /> 
			</tr>
			<tr>
			<td>
			<input type="submit" name="cmd" value="덧셈" />
			<input type="submit" name="cmd" value="application" />
			<input type="submit" name="cmd" value="session" />
			<input type="submit" name="cmd" value="cookie" />
			</td>
			</tr>
			<tr>
				<td>
				<label>sum : ${sum} - ${param.s}</label>
				<input type="hidden" name="sum" value="${sum}" />
				</td>
			</tr>
		</table>
	</form>
	<a href="mypage.jsp">마이페이지</a>
</body>
</html>