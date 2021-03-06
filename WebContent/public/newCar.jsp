<!-- TODO - change URL to not be in a seperate directory - rethink naming conventions -->


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">

    <title>New Car</title>
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
    
    
	<!-- Including the list of links that is the same on every page -->
	<%@ include file="ref/menu.html" %>
	
	<!-- Adding the is-active class to current page -->
	<script type="text/javascript">
	
	$('#NewCarLink').addClass('is-active');
	</script>
	




    <div id="main" role="main">
        <article class="block prose">

            <h1>Enter the Details of Your New Car</h1>
            <p>Testing: <a href="/CarDB/New-Car?action=newjason">New Car</a></p>
		  	<form method="post" action="NewCar">
		  	<formElement>
		  		License Plate:
		  		<input name="licensePlate" type="text" size="11"/><br>
		  	</formElement>
		  	<formElement>
		  		Make:
		  		<input name="make" type="text" size="14"/><br>
		  	</formElement>
		  	<formElement>
		  		Model:
		  		<input name="model" type="text" size="14"/><br>
	  		</formElement>
	  		<formElement>
		  		Model Year:
		  		<input name="modelYear" type="number" max="2020" min = "1950"/><br>
	  		</formElement>
	  		<formElement>  		
		 		Odometer Reading
		 		<input name="odometerReading" type="number"  style="width:150px;" max="999999" step=".1"><br>
	 		</formElement>
	 		<formElement>		 		
		 		<input type="submit" value="Submit"/>
	 		</formElement>
		  	</form>
            <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
            <br><br><br>

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