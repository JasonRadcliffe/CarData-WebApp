<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">

    <title>New Repair</title>
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
	$('#NewRepairLink').addClass('is-active');
	</script>
	




    <div id="main" role="main">
        <article class="block prose">

            <h1>Enter the Details of the Repair</h1>
            <!-- changing the action from http://localhost:8080/CarDB/Repair -->
		  	<form id="repairForm" method="post" action="Repair">
		  	<formElement>
		  		Car
		  		<select name="car">
		  			${carOptions}
		 		</select><br>
	 		</formElement>
	 		<formElement>
		 		Service Station
		 		<select name="station">
		 			${stationOptions }
		 		</select><br>
	 		</formElement>
	 		<formElement>
		 		Purchase Date
		 		<input name="purchaseDate" type="date" style="width:170px;"/><br>
	 		</formElement>
	 		<formElement>
		 		Odometer Reading
		 		<input name="odometerReading" type="number"  style="width:150px;" max="999999" step=".1"><br>
	 		</formElement>
	 		<formElement>
		 		Cost $
		 		<input name="cost" type="number"  style="width:90px;" step=".01" ><br>
	 		</formElement>
	 		<formElement>
		 		Description
		 		<textarea name="description" form = "repairForm" style="width:200px;x" ></textarea><br>
	 		</formElement>
	 		<formElement>
		 		Mechanic Name
		 		<input name="mechanicName" type="text"  style="width:130px;"><br>
	 		</formElement>
	 		<formElement>
		 		<input type="submit" value="Submit"/>
	 		</formElement>
		  	</form>
            <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
            <br><br>

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