<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.celeprokart.bean.*"%>
<%@page import="com.celeprokart.DAO.*"%>    
<jsp:useBean id="obj" class="com.celeprokart.bean.LoginBean"/>
<jsp:setProperty property="*" name="obj"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password Process</title>
</head>
<body>
<%  

ForgotPasswordDAO forgotPasswordDAO = new ForgotPasswordDAO();

String name = request.getParameter("email");

boolean status=forgotPasswordDAO.forgotPassword(name);  
if(status){  
out.println("Email is sent. Please check your password in the email");  

%>  
<jsp:include page="index.jsp"></jsp:include>  
<% 
}  
else  
{  
out.print("Sorry, email or password error");
%>  
<jsp:include page="index.jsp"></jsp:include>  
<%  
}  
%>
</body>
</html>