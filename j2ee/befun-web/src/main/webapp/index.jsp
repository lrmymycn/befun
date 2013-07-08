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
    	<title>比房网 | 澳洲期房,楼花,现房</title>
    	<meta name="Description" content="比房网是一个智能的一站式置业网站，在这里你可以搜索，对比，直接购买澳洲最新上市的澳洲期房和现房。"/>
    	<meta name="Keywords" content="澳洲楼花,澳洲期房,澳洲现房,悉尼楼花,悉尼现房,悉尼期房,悉尼房产,悉尼,楼花,现房,期房,雪梨,楼花价格,期房价格"/>
        <jsp:include page="includes/head.jsp" />
    </head>
	<body class="standard">
		<header style="position:absolute;">
        	<div class="inner">
        		<div class="top">
					<a href="/"><h1 class="logo"><img src="/img/logo.png" width="165" height="63" alt="Befun Property"/></h1></a>
					<div class="menu">
						<ul>
							<sec:authorize access="isAuthenticated()">
							<%
								Long currentClientId = null; 
								try{
									Object obj = session.getAttribute("befunContainer");
									if(obj != null && obj instanceof SessionContainer){
										SessionContainer sc =(SessionContainer)obj;
										currentClientId = (Long)sc.getProperty("currentClient");
									}
								}catch(Exception ex){
					
								}
							%>
							<sec:authentication property="principal" var="authentication" />
							<li><a href="javascript:;" id="change-client">Hi ${authentication.username} <span id="clientname" data-id="<%= currentClientId %>"></span></a> <a href="client.jsp" id="view-client">(view)</a></li>
								<li class="more"><a href="javascript:;">More<i class="arrow-down-grap"></i></a>
								<ul>
									<li><a href="clientlist.jsp">Clients</a></li>
									<li><a href="#">Cases</a></li>
									<li><a href="<c:url value='/j_spring_security_logout' />">注销</a></li>
								</ul>
							</li>
						</sec:authorize>
						<sec:authorize access="isAnonymous()">
							<li><a href="javascript:;" id="login-link">登陆</a></li>
							<li><a href="mailto:info@befun.com.au">加入我们</a></li>
							<li class="phone"><i class="phone"></i> 02 7902 0866</li>
						</sec:authorize>
						</ul>
					</div>
					<jsp:include page="includes/login.jsp" />
					<jsp:include page="includes/change_client.jsp" />
				</div>
        	</div>
        </header>
        <img src="/img/login.jpg" width="100%" alt="" class="bg-login"/>
		<div id="home">
			<img src="/img/slogan.png" width="254" height="71" alt="Befun property" class="slogan"/>
			<img src="/img/demo.png" width="542" height="371" alt="" class="demo"/>
			<div class="search" id="home-filter">
				<div class="filter-group pricerange-group clearfix">
					<span class="label">价格:</span>
					<div class="field">
						<div class="pricerange">
							<select name="minprice" class="selectbox">
								<option value="0" selected="true">不限</option>
								<option value="1">$450,000</option>
								<option value="2">$550,000</option>
								<option value="3">$650,000</option>
								<option value="4">$750,000</option>
								<option value="5">$850,000</option>
							</select>
						</div>
						<div class="pricerangeto">
							至
						</div>
						<div class="pricerange">
							<select name="maxprice" class="selectbox">
								<option value="0">不限</option>
								<option value="1">$450,000</option>
								<option value="2">$550,000</option>
								<option value="3">$650,000</option>
								<option value="4">$750,000</option>
								<option value="5">$850,000</option>
								<option value="6">$850,000+</option>
							</select>
						</div>
					</div>
				</div>
				<div class="filter-group clearfix">
					<span class="label">卧室:</span>
					<div class="field">
						<select name="bedrooms" class="selectbox">
							<option value="">不限</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="3+">3+</option>
						</select>
					</div>
				</div>
				<div class="filter-group clearfix">
					<span class="label">浴室:</span>
					<div class="field">
						<select name="bathrooms" class="selectbox">
							<option value="">不限</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="2+">2+</option>
						</select>
					</div>
				</div>
				<div class="filter-group clearfix">
					<span class="label">车位:</span>
					<div class="field">
						<select name="carspace" class="selectbox">
							<option value="">不限</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="2+">2+</option>
						</select>
					</div>
				</div>
				<div class="buttons">
					<a id="btn-search4" href="javascript:;">搜索</a>
				</div>
				
				<div class="hotspots">
					<a href="<c:url value="/search.jsp"/>" class="city">Sydney</a><br/>
					<ul class="suburbs clearfix">
						<li><a href="javascript:;" data-id="-2">Zetland</a></li>
						<li><a href="javascript:;" data-id="2">Wolli Creak</a></li>
						<li><a href="javascript:;" data-id="-4">Macquarie Park</a></li>
						<li><a href="javascript:;" data-id="-3">Rhodes</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div id="home-bottom">
			<img src="/img/bottom-text.png" width="478" height="38" alt="" />
		</div>
		<jsp:include page="includes/script.jsp" />
		<script>
			$(function(){
				$('img.bg-login').height($(window).height() - 66);
				$('#home-filter .selectbox').selectbox();

				$('ul.suburbs a').click(function(){
					var id = $(this).data('id');
					Search.conditions.suburbId = id;
					Search.saveLandingConditions();
					window.location.href = Main.root + "search.jsp";
				});
			})
			
			$(window).resize(function(){
				$('img.bg-login').height($(window).height() - 66);
			});
			
			
		</script>
	</body>
</html>