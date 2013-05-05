<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Befun Property</title>
        <meta name="description" content="">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <link rel="stylesheet" href="css//normalize.css">
        <link rel="stylesheet" href="css/ui-lightness/jquery-ui-1.9.2.custom.min.css"/>
        <link rel="stylesheet" href="css/jquery.selectbox.css"/>
        <link rel="stylesheet" href="css/main.css">
        <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&libraries=places&sensor=true"></script>
        <script src="js/vendor/modernizr-2.6.2.min.js"></script>
    </head>
	<body>
	    <div class="home">
	        <header>
	        	<div class="inner">
	        		<jsp:include page="includes/header.jsp" />
		        	<div id="reminder">
	        			<em>Search Conditions: </em><div id="reminder-nodes"></div> <a href="/" class="reset">Reset</a>
	        		</div>
	        	</div>
	        </header>
	        <div id="content">
	        	<div id="main">
	        		<div id="map-menu">
						<div class="top">
							<div class="title">Amenity</div>
							<i class="arrow-down-grap"></i>
						</div>
						<ul>
							<li><a href="javascript:;" class="childcares"><i class="tick"></i>Childcares</a></li>
							<li><a href="javascript:;" class="hospitals"><i class="tick"></i>Hospitals</a></li>
							<li><a href="javascript:;" class="medicalcentres"><i class="tick"></i>Medical Centres</a></li>
							<li><a href="javascript:;" class="restaurants"><i class="tick"></i>Restaurants</a></li>
							<li><a href="javascript:;" class="schools"><i class="tick"></i>Schools</a></li>
							<li><a href="javascript:;" class="stores"><i class="tick"></i>Stores</a></li>
							<li><a href="javascript:;" class="distance"><i class="tick"></i>Distance tool</a></a></li>
						</ul>
			        </div>
			        <div id="map">
	        		
	        		</div>    		
	        	</div>
	        	<div id="sidebar">
	        		<div id="projectlist">
	        		
	        		</div>
	        		<footer>
	        			&copy; Befun Property. <a href="#">About</a>
	        		</footer>
	        	</div>
	        	
	        </div>
	        
	        <jsp:include page="includes/panel.jsp" />
	        <jsp:include page="includes/floorplan.jsp" />
	        <jsp:include page="includes/compare.jsp" />
        </div>
        <div id="loading"><img src="/img/loading.gif" width="60" height="60" alt="" /></div>
    	<div id="filter-overlay" class="overlay"></div>
    	<div id="panel-overlay" class="overlay"></div>
    	<div id="lightbox-overlay" class="overlay"></div>
    	<div id="compare-overlay" class="overlay"></div>

        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.8.3.min.js"><\/script>')</script>
        <script src="js/vendor/jquery-ui-1.9.2.custom.min.js"></script>
        <script src="js/plugins.js"></script>
        <script src="js/knockout-2.2.1.js"></script>
        <script src="js/json2.js"></script>
        <script src="js/jquery.selectbox-0.2.js"></script>
        <script src="js/jquery.tools.min.js"></script>
        <script src="js/jquery.cookie.js"></script>
        <script src="js/main.js"></script>	
        <script>
        	$(function(){
				Debug.enable = true;
				Main.init();
			})
        </script>
        <script>
            var _gaq=[['_setAccount','UA-40663296-1'],['_trackPageview']];
            (function(d,t){var g=d.createElement(t),s=d.getElementsByTagName(t)[0];
            g.src=('https:'==location.protocol?'//ssl':'//www')+'.google-analytics.com/ga.js';
            s.parentNode.insertBefore(g,s)}(document,'script'));
        </script>
	</body>
</html>