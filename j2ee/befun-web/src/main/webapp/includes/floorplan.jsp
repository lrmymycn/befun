<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<sec:authorize access="isAuthenticated()">
	<div id="lightbox" style="display:none;">
		<span class="close"></span>
		<div class="top">
			<div class="title">
				<a href="javascript:;" class="btn red" id="befun">Add to Compare List</a>
				<a href="javascript:;" class="btn" id="interest">Add to Interest List</a>
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
			<div class="left"> 			
				<div id="apartments">
			
				</div>
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
</sec:authorize>

<sec:authorize access="isAnonymous()">
	<div id="lightbox" class="public" style="display:none;">
		<span class="close"></span>
		<div class="top">
			<div class="title">
				<a href="#" class="btn" id="befun">查看详情</a>
				<!--<a href="javascript:;" class="btn red" id="befun">Add to Compare List</a>-->
			</div> 
		</div>
		<div class="content">
			<div class="left">
				<div id="apartments">
			
				</div>
				<div class="contactus">
					<strong>如果您想了解更多，我们会第一时间给答复给您：</strong>
					<form action="" method="post">
						<div class="row clearfix">
							<span class="title">项目:</span>
							<div class="input">
								<span class="project">Oceanvale</span>
							</div>
						</div>
						<div class="row clearfix">
							<span class="title">姓名*:</span>
							<div class="input">
								<input type="text" name="name" value="" class="required"/>
							</div>
						</div>
						<div class="row clearfix">
							<span class="title">Email*:</span>
							<div class="input">
								<input type="email" name="email" value="" class="required"/>
							</div>
						</div>
						<div class="row clearfix">
							<span class="title">手机:</span>
							<div class="input">
								<input type="text" name="mobile" value=""/>
							</div>
						</div>
						<div class="row clearfix">
							<span class="title">留言:</span>
							<div class="input">
								<textarea placeholder="例如：这个户型的具体价格是多少？"></textarea>
							</div>
						</div>
						<div class="buttons">
							<input type="submit" class="btn red" value="提交"></a>
						</div>
					</form>
				</div>
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
		</div>
	</div>
</sec:authorize>