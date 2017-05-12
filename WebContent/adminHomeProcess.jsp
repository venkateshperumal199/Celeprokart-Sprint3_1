<%@page import="com.celeprokart.DAO.*"%>
<%@page import="com.celeprokart.bean.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.Collection,
                 java.util.ArrayList"%>

<jsp:useBean id="obj" class="com.celeprokart.bean.LoginBean"/>
<jsp:setProperty property="*" name="obj"/>  

<jsp:useBean id="obj_bean" class="com.celeprokart.bean.SignUpCelebrityBean"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Admin Home Page</title>
</head>
<body>
<%  

AdminHomePageDAO adminHomePageDAO = new AdminHomePageDAO();

ArrayList<AddCharityBean> listOfCharities=adminHomePageDAO.listCharity();  
request.setAttribute("charities", listOfCharities);

ArrayList<SignUpCelebrityBean> listOfCelebrities=adminHomePageDAO.listAdminCelebrities();  
request.setAttribute("celebrities", listOfCelebrities);

String[] selectedStudentIds = request.getParameterValues("flag");

if(selectedStudentIds!=null){  
	request.setAttribute("listOFCelebrities", selectedStudentIds); 
}

ArrayList<ProductBean> listOfProducts=adminHomePageDAO.listProducts(); 
request.setAttribute("products", listOfProducts);

%>
<div id="fullscreen_bg" class="fullscreen_bg"></div>
 <div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
       <img src="http://www.clker.com/cliparts/j/a/Z/z/q/w/purple-crown-hi.png"style="width:300px;height:100px;">
        <h1 class="text-center login-title">Celeprokart</h1>
            <h4 class="text-center login-title"><i>DreamIt,BuyIt!!</i></h4>
<a href="Logout.jsp">Logout</a>
<form action="UpdateCharity.jsp" method="post">

<font color="black">List of Charities</font><br/><br/>
<div style="width:100px;height:150px;overflow:auto;padding:5px;">

<c:forEach var="charity" items="${charities}">
<tr class="form-textcolor">
<td class="form-textcolor">
<input type="hidden" name="charity_id" value="<c:out value="${charity.id}"/>">
 <font color="black"><input type="submit" value="<c:out value="${charity.name}"/>"></font> 
  </td>
  </tr>
    </c:forEach>
</div><br/>
</form>
<form action="AddCharity.jsp" method="post">
<input type="submit" value="Add Charity"/> <br/><br/>
</form>

<form name="setPriceForm" action="setPriceProduct.jsp">
<font color="black">List of Products</font><br/><br/>
<div style="width:150px;height:150px;overflow:auto;padding:5px;" >
<c:forEach var="product" items="${products}">
<tr class="form-textcolor">
<td class="form-textcolor">
 <font color="black">
 <input type="hidden" name="product_id" value="<c:out value="${product.product_id}"/>">
 <input type="submit" name="submit" value="<c:out value="${product.product_name}"/>"></font> 
  </td>
  <td>
  </tr>
    </c:forEach>
</div><br/>
</form>

</div>
</div>
</div>



</body>
<style type="text/css">

 body {
    padding-top: 40px;
    padding-bottom: 0px;
    background-color: #eee;
  }
  h1 {
    color: black;
}
h2{
color: green;
font-family:courier ;
}
  .fullscreen_bg {
  background-image: url('http://cityoftruesdalemo.org/wp-content/uploads/2014/04/admin-man.jpg');
    position: fixed;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    background-size: cover;
    background-position: 80% 80%;
    
  }
  .form-Login {
    max-width: 1000px;
    padding: 15px;
    margin: 0 auto;
  }
  .form-Login .form-Login-heading, .form-Login {
    margin-bottom: 10px;
  }
  .form-Login .form-control {
    position: relative;
    font-size: 16px;
    height: auto;
    padding: 10px;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
  }
  .form-Login .form-control:focus {
    z-index: 2;
  }
  .form-signin input[type="text"] {
    margin-bottom: -1px;
    border-bottom-left-radius: 0px;
    border-bottom-right-radius: 0;
    border-top-style: solid;
    border-right-style: solid;
    border-bottom-style: none;
    border-left-style: solid;
    border-color: #000;
  }
  .form-Login input[type="password"] {
    margin-bottom: 10px;
    border-top-left-radius: 0;
    border-top-right-radius: 0;
    border-top-style: none;
    border-right-style: solid;
    border-bottom-style: solid;
    border-left-style: solid;
    border-color: #000;
  }
  .form-Login-heading {
    color: #ffff;
    text-align: center;
    text-shadow: 0 2px 2px rgba(0,0,0,0.5);
  }
   .navbar {
      margin-bottom: 50px;
      border-radius: 0;
      
    }
    
    /* Remove the jumbotron's default bottom margin */ 
   .carousel img{
   width:100%;
   height:300px;
   } 
    
   
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color:red;
      padding: 25px;
    }
  
</style>
</html>