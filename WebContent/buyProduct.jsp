<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Buy Product</title>
</head>
<body>
<%

String i = request.getParameter("productID");
System.out.println(i + "inside jsp");

%>
<div id="fullscreen_bg" class="fullscreen_bg"></div>
 <div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
        <h1 class="text-center login-title">Celeprokart</h1>
            <h2 class="text-center login-title"><i>Enter Payment Details</i></h2>
<form name="buyProductForm" action="buyProduct" method="post">
<h1 class="form-signin-heading text-muted" align="center">All Fields are mandatory</h1>
<input type="text" class="form-control" name="name"  placeholder="Name on Card" required autofocus/><br/><br/>  
<input type="text" name="CardNumber" placeholder="Card Number" required autofocus/><br/><br/>  
<input type="text" name="CVV" placeholder="CVV" required autofocus/><br/><br/> 
<input type="text" name="ExpiryDate" placeholder="expiryDate" required autofocus/><br/><br/> 
<select name="Category" id="selectboxid_category" ng-model="Category" required>
					<option value="Celebrity">Credit</option>
					<option value="Customer">Debit</option>
				</select><br/><br/>
				
<input type="hidden" name="id" value="${i}"/>				
<input type="submit" class="btn btn-lg btn-primary btn-block" value="Pay"/>
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
    color: gold;
}
h2{
color: green;
font-family:courier ;
}
  .fullscreen_bg {
  background-image: url('http://72gpf1za5iq428ekh3r7qjc1.wpengine.netdna-cdn.com/wp-content/uploads/2015/04/ecommerce.jpg');
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