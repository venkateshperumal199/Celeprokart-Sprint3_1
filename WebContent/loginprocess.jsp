<%@page import="com.celeprokart.bean.LoginBean"%>
<%@page import="com.celeprokart.DAO.*"%>  
<jsp:useBean id="obj" class="com.celeprokart.bean.LoginBean"/>
<jsp:setProperty property="*" name="obj"/>  
  
<%  
LoginDao loginDao = new LoginDao();
boolean status=loginDao.validate(obj);

if(status){  
session.setAttribute("session", obj); 

LoginBean bean = (LoginBean)session.getAttribute("session");

System.out.println(bean.getEmail() + "   bean");
%>
<jsp:include page="adminHomeProcess.jsp"></jsp:include>
<%
}
else
{
	boolean status_celeb = loginDao.validateCeleb(obj);
	if(status_celeb)
	{
		session.setAttribute("session", obj); 
		LoginBean bean = (LoginBean)session.getAttribute("session");

		System.out.println(bean.getEmail() + "   bean");

%>
<jsp:include page="celebrityhomepage.jsp"></jsp:include>
<%
	}
	else
	{
		boolean status_cust = loginDao.validateCust(obj);
		if(status_cust)
		{
			session.setAttribute("session", obj); 
			
			LoginBean bean = (LoginBean)session.getAttribute("session");

			System.out.println(bean.getEmail() + "   bean");
			
			%>
			<jsp:include page="customerHomePage.jsp"></jsp:include>
			<%
		}
		
		else
		{
			out.print("Sorry, email or password error");
			%>  
			<jsp:include page="index.jsp"></jsp:include>  
			<%  
		}
	}
}	
%>
