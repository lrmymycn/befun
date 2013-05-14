<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.befun.web.box.SessionContainer"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<div class="top">
	<a href="/"><h1 class="logo">BeFun Property</h1></a>
	<div class="search">
		<input type="text" name="suburb" id="search-suburb" placeholder="Enter a suburb or a postcode"/>
		<a href="javascript:;" id="btn-filter">Filter</a>
		<a href="javascript:;" id="btn-search"></a>
	</div>
	<div class="menu">
		<ul><%
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
			<li><a href="javascript:;" id="change-client">Hi! ${authentication.username} and Client:<%= currentClientId %></a></li>
			<li class="more"><a href="javascript:;">More<i class="arrow-down-grap"></i></a>
				<ul>
					<li><a href="#">Clients</a></li>
					<li><a href="#">Cases</a></li>
					<li><a href="<c:url value='/j_spring_security_logout' />">Log out</a></li>
				</ul>
			</li>
		</ul>
	</div>
	<div id="filter" class="popover" style="display:none;">
		<div class="arrow"></div>
		<div class="inner">
			<h3>Search Filters</h3>
			<div class="filter-group pricerange-group clearfix">
    			<span class="label">Price Range:</span>
    			<div class="field">
    				<div class="pricerange">
        				<select name="minprice" class="selectbox">
		        			<option value="0" selected="true">Any Price</option>
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
		        			<option value="0">Any Price</option>
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
        		<span class="label">Bedrooms:</span>
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
        		<span class="label">Bathrooms:</span>
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
	        			<input type="checkbox" value="3" name="bathrooms" id="bathroom-2plus"/>
					</span>	
					<label for="bathroom-2plus">2+</label>
        		</div>
	        </div>
	        <div class="filter-group clearfix">
        		<span class="label">Carspace:</span>
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
	        			<input type="checkbox" value="3" name="carspace" id="carspace-2plus"/>
					</span>	
					<label for="carspace-2plus">2+</label>
        		</div>
    		</div>
    		<div class="filter-group clearfix">
    			<span class="label">Distance to City:</span>
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
	        			<label for="train">Train Stations</label>
        			</li>
        			<li>
	        			<span class="checkbox">
	        				<input type="checkbox" value="1" name="shpppingcenter" id="shoppingcenter"/>
	        			</span>
	        			<label for="shoppingcenter">Shopping Centres</label>
        			</li>
        			<li class="last">			        			
	        			<span class="checkbox">
	        				<input type="checkbox" value="1" name="chinese" id="chinese"/>
	        			</span>
	        			<label for="chinese">Chinese Community</label>
        			</li>
    				<li class="first">
    					<span class="checkbox">
	        				<input type="checkbox" value="1" name="universities" id="university"/>
	        			</span>
	        			<label for="university">University Zone</label>
    				</li>
    				<li>
    					<span class="checkbox">
	        				<input type="checkbox" value="1" name="schools" id="school"/>
	        			</span>
	        			<label for="school">School Zone</label>
    				</li>
        			<li class="last">
        				
        			</li>			        			
    			</ul>
    			<div class="clearfix">
    				<span class="label">Status:</span>
        			<div class="status">
        				<select name="status" class="selectbox">
	        				<option value="">Select</option>
	        				<option value="0">Offplan</option>
	        				<option value="1">Existing</option>
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