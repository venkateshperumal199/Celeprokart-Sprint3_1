<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.celeprokart.bean.*"%>
<%@page import="com.celeprokart.DAO.*"%>    
<jsp:useBean id="obj" class="com.celeprokart.bean.SignUpCelebrityBean"/>
<jsp:setProperty property="*" name="obj"/>  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Celebrities</title>
</head>
<body>
<%  
String[] listOFCelebrities = request.getParameterValues("listOFCelebrities");
boolean status=true;  
if(status){  
session.setAttribute("session","TRUE"); 
%>
<jsp:include page="adminHomeProcess.jsp"></jsp:include>
<%
}  
else  
{  
out.print("Unable to update celebrities back ground verification");
%>  
<jsp:include page="index.jsp"></jsp:include>  
<%  
}  
%>
</body>
</html>