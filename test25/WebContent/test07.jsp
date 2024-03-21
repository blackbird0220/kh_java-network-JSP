<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>웹의 객체 전달과 스코프(Scope)알기</title>
</head>
<body>
<h2>웹의 객체 전달과 스코프(Scope) 알기</h2>
<%
	List<String> lst = new ArrayList<String>();
	lst.add("이정희");
	lst.add("이원석");
	lst.add("김응원");
	lst.add("이예린");
	lst.add("이연정");
	lst.add("이성하");
	request.setAttribute("lst", lst);
	
	Set<String> set = new HashSet<>();
	set.add("조대신");
	set.add("조우진");
	set.add("한태역");
	set.add("최태영");
	
	request.setAttribute("set",set);
	
	Map<Integer, String> map = new HashMap<>();
	map.put(1, "김동연");
	map.put(2, "김민식");
	map.put(3, "김민아");
	map.put(4, "김윤식");
	map.put(5, "김필규");
	map.put(6, "정도준");
	request.setAttribute("map", map);
	
	RequestDispatcher rd= request.getRequestDispatcher("test08.jsp"); //목적지 지정
	rd.forward(request, response);	//데이터 전달
	response.sendRedirect("test08.jsp");	//데이터이동(화면 이동x) :url은 페이지 이동

%>
</body>
<h2>객체 데이터 전달하기</h2>
</html>