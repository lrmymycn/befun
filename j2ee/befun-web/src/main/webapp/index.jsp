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
        <jsp:include page="includes/head.jsp" />
    </head>
	<body>
	    <div class="home">
	        <header>
	        	<div class="inner">
	        		<jsp:include page="includes/search.jsp" />
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
	        <jsp:include page="includes/client.jsp" />
        </div>
        <div id="loading"><img src="/img/loading.gif" width="60" height="60" alt="" /></div>
    	<div id="filter-overlay" class="overlay"></div>
    	<div id="panel-overlay" class="overlay"></div>
    	<div id="lightbox-overlay" class="overlay"></div>
    	<div id="compare-overlay" class="overlay"></div>

      	<jsp:include page="includes/script.jsp" />
        <script>
        	$(function(){
				Debug.enable = true;
				Main.init();
			})
        </script>
	</body>
</html>