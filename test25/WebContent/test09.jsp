<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스코프 데이터 추적하기</title>
</head>
<body>
<h2>스코프 데이터 추적하기</h2>
<%
	String msg = request.getParameter("msg");
	String pageData = (String) pageContext.getAttribute("pageData");
	String reqData = (String) request.getAttribute("reqData");
	String sesData = (String) session.getAttribute("appData");
	String appData = (String) application.getAttribute("appData");
%>	
<div>
	<p>msg(request on) : <%=msg %></p>
	<p>pageData(pageContext) : <%=pageData %></p>
	<p>reqData(request off) : <%=reqData %></p>
	<p>sesData(request off) : <%=sesData %></p>
	<p>appData(request off) : <%=appData %></p>
	
<% 
	session.invalidate();	//세션 종료 =>로그 아웃 null값 나옴
%>
	<p>세션종료후</p>
	<p>sesData(request off) : <%=sesData %></p>
	<p>appData(request off) : <%=appData %></p>
	<p>web.xml 전역 변수 : <%=application.getInitParameter("admin") %></p>
	
	
</div>
<hr>
<div>
<a href="index.jsp">홈으로</a><br>
<a href="test06.jsp">테스트06 페이지</a><br>

</div>
</body>
</html>