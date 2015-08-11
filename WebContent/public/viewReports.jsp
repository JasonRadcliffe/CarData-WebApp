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

    <title>View Mileage Report</title>
    <link href='http://fonts.googleapis.com/css?family=Raleway:700,400' rel='stylesheet' type='text/css'>
    
    <script src="public/ref/jquery-2.1.4.min.js" type="text/javascript"></script>

    <script src="public/ref/modernizr.js" type="text/javascript"></script>
    
    <!-- Importing the amCharts files -->
	<script src="public/ref/amcharts.js" type="text/javascript"></script>
	<script src="public/ref/amcharts-xy.js" type="text/javascript"></script>
	<script src="public/ref/amcharts-serial.js" type="text/javascript"></script>
	<script src="public/ref/amcharts-dataloader.min.js" type="text/javascript"></script>
	<script type="text/javascript">
	

	var mileageChart = AmCharts.makeChart("chartdiv2", {
	    "type": "xy",
	    "marginRight": 80,
	    "dataDateFormat": "YYYY-MM-DD",
	    "startDuration": 1,
	    "trendLines": [],
	    "pathToImages": "public/images/",
	    "balloon": {
	        "adjustBorderColor": false,
	        "shadowAlpha": 0,
	        "fixedPosition":true
	    },
	    "graphs": [{
	        "balloonText": "<div style='margin:5px;'><b>[[x]]</b><br>MPG:<b>[[y]]</b><br>Gallons:<b>[[value]]</b></div>",
	        "bullet": "round",
	        "id": "AmGraph-1",
	        "lineAlpha": 0,
	        "lineColor": "#005845",
	        "valueField": "aValue",
	        "xField": "date",
	        "yField": "mpg"
	    }],
	    "valueAxes": [{
	        "id": "ValueAxis-1",
	        "axisAlpha": 0
	    }, {
	        "id": "ValueAxis-2",
	        "axisAlpha": 0,
	        "position": "bottom",
	        "type": "date"
	    }],
	    "allLabels": [],
	    "titles": [],
	    "dataLoader": {
	    	"url": "/CarDB/View-Mileage1?chartType=mileageOverTime"
    	},

	    "chartScrollbar": {
	        "offset": 15,
	        "scrollbarHeight": 5
	    }
	});
		
	
	var costChart = AmCharts.makeChart("chartdiv1", {
	    "type": "serial",
	    "marginRight": 80,
	    "dataDateFormat": "YYYY-MM-DD",
	    "startDuration": 1,
	    "dataLoader": {
	    	"url": "/CarDB/View-Mileage1?chartType=fuelSpendingByYear"
    	},
	    "pathToImages": "public/images/",
	    "valueAxes": [ {
	        "gridColor": "#FFFFFF",
	        "gridAlpha": 0.2,
	        "dashLength": 0
	      } ],
	      "gridAboveGraphs": true,
	      "startDuration": 1,
	      "graphs": [ {
	        "balloonText": "[[category]]: <b>[[value]]</b>",
	        "fillAlphas": 0.8,
	        "lineAlpha": 0.2,
	        "type": "column",
	        "valueField": "amount"
	      } ],
	      "chartCursor": {
	        "categoryBalloonEnabled": false,
	        "cursorAlpha": 0,
	        "zoomable": false
	      },
	      "categoryField": "year",
	      "categoryAxis": {
	        "gridPosition": "start",
	        "gridAlpha": 0,
	        "tickPosition": "start",
	        "tickLength": 50
	      },
	      valueAxes: [{
              title: "Amount Spent by Year",                 
              minimum: 0
          }],
	});
	
	</script>


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
	$('#ReportsLink').addClass('is-active');
	</script>
	




    <div id="main" role="main">
        <article class="block prose">

            <h1>Reports</h1>
            
            
            <p>Amount spent on gasoline per year:</p>
            
           	<div class="chartdiv" id="chartdiv1">
            </div>
            <br><br>
            <p>Fuel mileage over time, where the bubble size indicates the number of gallons purchased:</p>
           	<div class="chartdiv" id="chartdiv2">
            </div>
            
            
            <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
            <br><br><br><br><br><br><br><br><br><br><br><br><br>

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