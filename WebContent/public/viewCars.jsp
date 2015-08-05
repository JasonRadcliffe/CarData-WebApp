<!-- TODO - change URL to not be in a seperate directory - rethink naming conventions -->


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.jasonradcliffe.hibernate.Car" %>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">

    <title>View Cars</title>
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
	$('#ViewCarsLink').addClass('is-active');
	</script>
	




    <div id="main" role="main">
        <article class="block prose">

            <h1>Here is the Table of Cars:</h1>
            <table class="viewAllTable" id="viewCarsTable" border="1">
            	<th>Number</th><th>License Plate</th><th>Make</th><th>Model</th><th>Year</th><th>Odometer</th>
            	<%
            	List<Car> carsList = (List<Car>)request.getAttribute("viewCarsList");
            	for(int index=0; index < carsList.size(); index++){
            		Car currentCar = (Car)carsList.get(index);
           		%><tr>
            		<td><%out.println(currentCar.getCarID()); %></td>
            		<td><%out.println(currentCar.getLicensePlate()); %></td>
            		<td><%out.println(currentCar.getMake()); %></td>
            		<td><%out.println(currentCar.getModel()); %></td>
            		<td><%out.println(currentCar.getModelYear()); %></td>
            		<td><%out.println(currentCar.getOdometerReading()); %></td>
            		
            		
           		</tr><%
            	}
            	%>
            	
            	
            </table>
            
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