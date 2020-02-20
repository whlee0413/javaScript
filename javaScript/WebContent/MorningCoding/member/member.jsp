<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String name = request.getParameter("myName");
String id = request.getParameter("ID");
String password = request.getParameter("myPass");
String major = request.getParameter("myMajor");
String sex = request.getParameter("sex");

out.print( "NAME: " +name +" ID: " + id +" MAJOR: "+ major +" PASSWORD: " +password +" MAJOR: " +major + " SEX: " +sex);
%>
</body>
</html>