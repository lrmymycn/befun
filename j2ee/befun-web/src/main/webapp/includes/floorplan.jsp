<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<div id="lightbox" style="display:none;">
	<span class="close"></span>
	<div class="top">
		<div class="title">
			<a href="#" class="btn red" id="befun">Add to Compare List</a>
			<div class="sort">
				<label>Sort:</label>
				<div class="button-group">
					<a href="javascript:;" class="btn active" data-type="price">Price</a>
					<a href="javascript:;" class="btn" data-type="sqm">Price/sqm</a>
					<a href="javascript:;" class="btn" data-type="area">Area</a>
				</div>			
			</div>
		</div> 
	</div>
	<div class="content">  			
		<div id="apartments">
			
		</div>
		<div class="floorplan">
			<a href="#" class="zoom" target="_blank"></a>
			<div class="image">

			</div>
			<div id="floorplan-list2">
				<a href="javascript:;" class="prev nav"></a>
				<div class="scrollable">
					<div class="items">
						
					</div>
				</div>
				<a href="javascript:;" class="next nav"></a>
			</div>
		</div>
		<div id="units">
			<a href="#" class="prev nav"></a>
			<div class="scrollable vertical">
				<div class="items">

			    </div>
			</div>
			<a href="#" class="next nav"></a>
		</div>
	</div>
</div>