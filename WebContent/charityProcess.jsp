<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.celeprokart.DAO.*"%>
<%@page import="com.celeprokart.bean.*" %>
<jsp:useBean id="obj" class="com.celeprokart.bean.AddCharityBean"/>  
 <jsp:setProperty property="*" name="obj"/> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Charity</title>
</head>
<body>

<% 

AddCharityDAO addCharityDAO = new AddCharityDAO();

boolean status=addCharityDAO.addCharity(obj);  

if(status){  
out.println("Charity is successfully added to Celeprokart");  
%>

<jsp:include page="adminHomeProcess.jsp"></jsp:include>

<%

}  
else  
{  
out.print("Charity is not added to Celeprokart");
}  
%>

</body>
</html>