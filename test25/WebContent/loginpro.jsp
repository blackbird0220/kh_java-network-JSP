<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String userId = "kew";
String userName = "김응원";

%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 처리</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String name = request.getParameter("name");	//일치값 저장 
	
	if(id.equals(userId) && name.equals(userName)){
		session.setAttribute("sid", id); 	//선언된 아이디와 비번과 일치하면 로그인 처리
		session.setAttribute("sname",name);
		response.sendRedirect("test10.jsp");
	}
	else {
		response.sendRedirect("login.jsp");
	}


%>
</body>
</html>