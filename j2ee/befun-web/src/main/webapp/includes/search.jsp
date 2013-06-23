<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.befun.web.box.SessionContainer"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<div class="top">
	<a href="/"><h1 class="logo"><img src="/img/logo.png" width="165" height="63" alt="Befun Property"/></h1></a>
	<div class="search">
		<input type="text" name="suburb" id="search-suburb" placeholder="Enter a suburb or a postcode"/>
		<a href="javascript:;" id="btn-filter">Filter</a>
		<a href="javascript:;" id="btn-search"></a>
	</div>
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
						<li><a href="<c:url value='/j_spring_security_logout' />">Log out</a></li>
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
	<jsp:include page="login.jsp" />
	<div id="client-panel" class="popover">
		<div class="arrow"></div>
		<div class="inner">
			<span class="title">Change client</span>
			<div class="change long">
				<select name="client" class="selectbox">
					<option value="" selected="true">Select</option>
				</select>
			</div>
			<span class="title">OR</span>
			<div class="button">
				<a href="client.jsp" class="btn red">Create a New Client</a>
			</div>
		</div>
	</div>
	<div id="filter" class="popover" style="display:none;">
		<div class="arrow"></div>
		<div class="inner">
			<h3>Search Filters</h3>
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
	        			to
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
        			<span class="checkbox">
        				<input type="checkbox" value="1" name="bedrooms" id="bedroom-1"/> 
        			</span>
        			<label for="bedroom-1">1</label>
        			<span class="checkbox">
	        			<input type="checkbox" value="2" name="bedrooms" id="bedroom-2">
	        		</span>
	        		<label for="bedroom-2">2</label>
	        		<span class="checkbox">
	        			<input type="checkbox" value="3" name="bedrooms" id="bedroom-3"/>
					</span>	
					<label for="bedroom-3">3</label>
					<span class="checkbox">        		
	        			<input type="checkbox" value="3+" name="bedrooms" id="bedroom-3plus"/>
	        		</span>
	        		<label form="bedroom-3plus">3+</label>
        		</div>
	       	</div>
	       	<div class="filter-group clearfix">	
        		<span class="label">浴室:</span>
        		<div class="field">
        			<span class="checkbox">
        				<input type="checkbox" value="1" name="bathrooms" id="bathroom-1"/> 
        			</span>
        			<label for="bathroom-1">1</label>
        			<span class="checkbox">
	        			<input type="checkbox" value="2" name="bathrooms" id="bathroom-2">
	        		</span>
	        		<label for="bathroom-2">2</label>
	        		<span class="checkbox">
	        			<input type="checkbox" value="2+" name="bathrooms" id="bathroom-2plus"/>
					</span>	
					<label for="bathroom-2plus">2+</label>
        		</div>
	        </div>
	        <div class="filter-group clearfix">
        		<span class="label">车位:</span>
        		<div class="field">
        			<span class="checkbox">
        				<input type="checkbox" value="1" name="carspace" id="carspace-1"/> 
        			</span>
        			<label for="carspace-1">1</label>
        			<span class="checkbox">
	        			<input type="checkbox" value="2" name="carspace" id="carspace-2">
	        		</span>
	        		<label for="carspace-2">2</label>
	        		<span class="checkbox">
	        			<input type="checkbox" value="2+" name="carspace" id="carspace-2plus"/>
					</span>	
					<label for="carspace-2plus">2+</label>
        		</div>
    		</div>
    		<div class="filter-group clearfix">
    			<span class="label">市区距离:</span>
    			<div class="field">
	        		<select name="distancetocity" class="selectbox">
	        			<option value="">Select</option>
	        			<option value="0">CBD</option>
	        			<option value="5">5km</option>
	        			<option value="10">10km</option>
	        			<option value="15">15km</option>
	        			<option value="20">20km</option>
	        			<option value="20+">20km+</option>
	        		</select>
        		</div>
        	</div>    		
    		<div id="features-filter">
    			<ul class="checkbox-list clearfix">
    				<li class="first">
        				<span class="checkbox">
	        				<input type="checkbox" value="1" name="train" id="train"/>
	        			</span>
	        			<label for="train">火车站</label>
        			</li>
        			<li>
	        			<span class="checkbox">
	        				<input type="checkbox" value="1" name="shpppingcenter" id="shoppingcenter"/>
	        			</span>
	        			<label for="shoppingcenter">购物中心</label>
        			</li>
        			<li class="last">			        			
	        			<span class="checkbox">
	        				<input type="checkbox" value="1" name="chinese" id="chinese"/>
	        			</span>
	        			<label for="chinese">华人社区</label>
        			</li>
    				<li class="first">
    					<span class="checkbox">
	        				<input type="checkbox" value="1" name="universities" id="university"/>
	        			</span>
	        			<label for="university">学区房(大学)</label>
    				</li>
    				<li>
    					<span class="checkbox">
	        				<input type="checkbox" value="1" name="schools" id="school"/>
	        			</span>
	        			<label for="school">学区房(中小学)</label>
    				</li>
        			<li class="last">
        				
        			</li>			        			
    			</ul>
    			<div class="clearfix">
    				<span class="label">状态:</span>
        			<div class="status">
        				<select name="status" class="selectbox">
	        				<option value="">选择</option>
	        				<option value="0">楼花</option>
	        				<option value="1">现房</option>
	        			</select>
        			</div>
    			</div>
    			
    			
    		</div>
		</div>
		<div class="buttons">
			<a href="javascript:;" id="btn-search2">SEARCH</a>
		</div>	        		
	</div>
</div>