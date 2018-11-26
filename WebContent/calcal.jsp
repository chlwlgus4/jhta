<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산기</title>
</head>
<body>
<form action="calcal" method="post">

<table>
<tr><td>
<input type="text" name="tbtn1" value="${nbtn3}"/>
<input type="hidden" name="tbtn" value="${nbtn}"/>
</td></tr>
<tr>
<td>
<input type="text" name="restotal" value="${restotal}"/>
</td>
</tr>
<tr>
<td>
<c:forEach var="i" begin="7" end="9">
<input type="submit" name="cmd" value="${i}"/>
</c:forEach>
<input type="submit" name="cmd" value="/"/>
<input type="submit" name="cmd" value="C"/>
</td>
</tr>


<tr>
<td>
<c:forEach var="i" begin="4" end="6">
<input type="submit" name="cmd" value="${i}"/>
</c:forEach>
<input type="submit" name="cmd" value="*"/>
<input type="submit" name="cmd" value="-"/>
</tr>
</tr>

<tr>
<td>
<c:forEach var="i" begin="1" end="3">
<input type="submit" name="cmd" value="${i}"/>
</c:forEach>
<input type="submit" name="cmd" value="+"/>
</td>
</tr>

<tr>
<td>
<input type="submit" name="cmd" value="±"/>
<input type="submit" name="cmd" value="0"/>
<input type="submit" name="cmd" value=" ."/>
<input type="submit" name="cmd" value="="/>
</td>
</tr>
<tr>
<td>
<input type="hidden" name="nbtn2" value="${nbtn2}"/>
</td>
</tr>
</table>
</form>
</body>
</html>