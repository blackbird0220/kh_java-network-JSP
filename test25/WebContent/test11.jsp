<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
pageContext.setAttribute("name","김응원");
pageContext.setAttribute("age", "36");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>디렉티브를 이용한 include</h2>	<!-- 디렉티브 사용하기 -->
	<%@ include file="infile.jsp" %>
	<hr>
	<h2>액션태그를 활용한 include</h2> 
	<jsp:include page="infile.jsp"></jsp:include>
	<hr>
</body>
</html>