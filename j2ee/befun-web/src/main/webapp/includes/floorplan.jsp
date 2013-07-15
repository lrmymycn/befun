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
				<a href="javascript:;" class="btn" id="recommend">Recommend</a>
				<a href="#" class="btn red more" target="_blank">更多户型详情 <img src="http://img.befun.com.au/img/view-project.png" alt="" width="21" height="15" /></a>
				<div class="sort">
					<label>Sort:</label>
					<div class="button-group">
						<a href="javascript:;" class="btn active" data-type="recommend">Recommend</a>
						<a href="javascript:;" class="btn" data-type="price">Price</a>
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
				<span class="floorplanname"></span>
				<span class="summary"></span>
				<a href="#" class="btn red more" target="_blank">更多户型详情 <img src="http://img.befun.com.au/img/view-project.png" alt="" width="21" height="15" /></a>
			</div> 
		</div>
		<div class="content">
			<div class="left">
				<div class="contactus">
					<div>关于 <b class="floorplanname"></b> 如果您想了解更多，我们会第一时间给您答复。</div>
					<form action="" method="post">
						<div class="row clearfix">
							<div class="input">
								<input type="text" name="name" value="" class="required" placeholder="姓名(必填)"/>
								<input type="text" name="mobile" value="" placeholder="手机(选填)" style="margin-left:10px;"/>
							</div>
						</div>
						<div class="row clearfix">
							<div class="input">
								<input type="email" name="email" value="" class="required" placeholder="Email(必填)" style="width:307px;"/>
							</div>
						</div>
						<div class="row clearfix">
							<div class="input">
								<textarea name="message" class="required"></textarea>
							</div>
						</div>
						<div class="buttons">
							<input type="submit" class="btn red" value="提 交" />
						</div>
					</form>
					<div class="thankyou" style="display:none;">
						<p>谢谢，我们的销售人员会第一时间与您联系。</p>
					</div>
				</div>
				<div id="comments">
					<b>户型分析</b><br/>
					<p>这个项目还没户型分析</p>
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