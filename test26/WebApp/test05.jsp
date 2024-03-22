<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %> 
<%@ page import="org.kh.dto.Member" %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set scope="application" var="num3" value="30"/>
<%
	pageContext.setAttribute("num1", 9);
	pageContext.setAttribute("num2", 10);
	pageContext.setAttribute("nullStr", null);
	pageContext.setAttribute("emptyStr", "");
	pageContext.setAttribute("lengthZero", new Integer[0]);
	pageContext.setAttribute("sizeZero", new ArrayList[0]);
	
	session.setAttribute("sid","kim"); ;//"kim"이라는 아이디로 로그인 중이라는 의미
%>


<%@ include file="menu.jsp" %>

<h2>표현언어의 비교문장</h2> //String ~~~~ 보다 간단함
<div>
	<c:if test="${sid.equals('admin') }"> //로그인한 아이디가 admin이라면
		<p>관리자 로그인 중</p>
	</c:if>
	<c:if test="${not empty sid }"> // id 값이 비어있다면
		<p>${sid }님 로그인 중</p>
	</c:if>
	<c:if test="${empty sid }">
		<p>현재 로그인 중이 아닙니다.</p>
	</c:if>
</div>
<hr>
<div>
	<h3>Empty 비교 확인</h3>
	<p>empty nullStr :${empty nullStr}</p>
	<p>empty emptyStr :${empty  emptyStr}</p>
	<p>empty lengthZero :${empty lengthZero}</p>
	<p>empty sizeZero :${empty sizeZero}</p>
	
</div>
<hr>
<div>
	<h3>삼항 연산자</h3>
	<p>num1 &gt; num2 ? "참" : "거짓" => ${num1 gt num2 ? "num1이 더 크다" :"num2가 더 크다"" }</p>

</div>
	<h3>null연산자 </h3>
	<p>null + 10 = ${null +10}</p>
	<p>nullStr +10 =${nullStr +10}</p>
	<p>param.noVar > 10 =${param.noVar > 10}</p>
	<p>num3 = ${num3}</p>
</div>
</body>
</html>