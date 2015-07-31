<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">

    <title>Please Log In</title>
    <link href='http://fonts.googleapis.com/css?family=Raleway:700,400' rel='stylesheet' type='text/css'>
    
    <script src="public/ref/jquery-2.1.4.min.js" type="text/javascript"></script>

    <script src="public/ref/modernizr.js" type="text/javascript"></script>

	<link rel="stylesheet" href="public/ref/app.css" type="text/css">
    <link rel="stylesheet" href="public/ref/menu.css" type="text/css">
    
</head>
<body>

<div id="outer-wrap">
<div id="inner-wrap">

    <!-- Including the header that is the same on every page -->
	<%@ include file="ref/header.html" %>
    
    
    
	<!-- Including the list of links that's the same on every page -->
	<%@ include file="ref/menu.html" %>
	
	<!-- Adding the is-active class to current page -->
	<script type="text/javascript">	
	$('#HomeLink').addClass('is-active');
	</script>
	




    <div id="main" role="main">
        <article class="block prose">

            <h1>Enter Your Username and Password</h1>
		  	<form method="post" action="http://localhost:8080/CarDB/login">
		  	<formElement>
		  		Username
		  		<input type = "text" name="user" style="width:170px;"/><br>
	 		</formElement>
	 		<formElement>
		 		Password
		 		<input name="password" type="password" style="width:170px;"/><br>
	 		</formElement>
	 		<formElement>
		 		
		 		<input type="submit" value="Submit"/>
	 		</formElement>
		  	</form>
            <br><br><br><br><br><br><br><br><br><br><br><br>
            <br><br><br><br><br><br>

        </article>
    </div>

	<!-- Including the footer that is the same on every page -->
	<%@ include file="ref/footer.html" %>

</div>
<!--/#inner-wrap-->
</div>
<!--/#outer-wrap-->

<script src="public/ref/main.js" type="text/javascript"></script>

</body>
</html>