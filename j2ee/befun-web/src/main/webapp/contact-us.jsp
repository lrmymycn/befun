<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.befun.web.box.SessionContainer"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
    	<title>澳洲比房网 | 期房 楼花 现房 | 联系我们</title>
    	<meta name="Description" content="比房置业投资有限公司是澳洲第一家以网络为平台的新型房地产公司，打造最准确的分析与定位进行智能选房，无论身处海外还是澳洲比房置业将主动权交给客户，让客户通过比房置业强大的房源搜索引擎筛选出最优质的房产。"/>
    	<meta name="Keywords" content="澳洲楼花,澳洲期房,澳洲现房,悉尼楼花,悉尼现房,悉尼期房,悉尼房产,悉尼,楼花,现房,期房,雪梨,楼花价格,期房价格"/>
        <jsp:include page="includes/head.jsp" />
    </head>
	<body class="standard about">
		<header style="position:absolute;">
        	<div class="inner">
				<jsp:include page="includes/search.jsp" />
			</div>
        </header>
		<div id="content">
			<h2>联系我们</h2>
			<div class="about-main clearfix">
				<div class="side-nav">
					<ul>
						<li><a href="<c:url value="about-us.jsp"/>"><span>关于我们</span></a></li>
						<li><a href="<c:url value="join-us.jsp"/>"><span>加入我们</span></a></li>
						<li><a href="<c:url value="disclaimer.jsp"/>"><span>免责声明</span></a></li>
						<li><a href="<c:url value="contact-us.jsp"/>" class="active"><span>联系我们</span></a></li>
					</ul>
				</div>
				<div class="main">
					<h3>Sydney 办公室</h3>
					<p>地址: Suite 1612, 87-89 Liverpool St Sydney, NSW 2000</p>
					<p>电话: +61 2 7902 0866</p>
					<p>Email: <a href="mailto:info@befun.com.au" target="_blank">info@befun.com.au</a></p>
					
					<div id="office-map"></div>
				</div>
			</div>
			<jsp:include page="includes/footer.jsp" />
		</div>
		<jsp:include page="includes/script.jsp" />
		<script>
			$(function(){
				var latLng = new google.maps.LatLng(-33.876188,151.206847);
				var mapOptions = {
					zoom: 15,
					minZoom: 11,
					maxZoom: 20,
					center: latLng,
					mapTypeId: google.maps.MapTypeId.ROADMAP,
					mapTypeControl: false,
					streetViewControl: false,
					panControl: false,
					zoomControlOptions: {
						position: google.maps.ControlPosition.LEFT_CENTER
					}
				}
				var map = new google.maps.Map(document.getElementById("office-map"), mapOptions);
		
				var marker = new google.maps.Marker({
					position: latLng,
					map: map
				});
			});
		</script>
	</body>
</html>