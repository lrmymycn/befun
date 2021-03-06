<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<div id="panel">
	<span class="close"></span>
	<div class="top">
		<div class="title">
			<span id="project-name"></span>
		</div>      			
		<div class="tabs">     			
			<a href="#tab-overview" class="active first">项目图集</a>
			<a href="#tab-details">项目信息</a>
			<a href="#tab-floorplans">户型筛选</a>
			<!--<a href="#tab-suburb">区域分析</a>
			<a href="#tab-comments">住户交流</a>-->
			<a href="#tab-contactus">免费咨询</a>
			<a href="#" target="_blank" id="view-project">更多项目详情</a>
		</div>
	</div>     		
	<div class="content">
		<div id="tab-overview" class="shown tab-block">
			<ul class="brochure">
				
			</ul>
		</div>	
		<div id="tab-details" class="hidden tab-block">
			<div class="sub-tabs">
    			<a href="#subtab-description" class="active">基本信息</a>
    			<a href="#subtab-feature">项目特色</a>
    			<a href="#subtab-finish">内饰品牌</a>
    			<a href="#subtab-amenity">项目设施</a>
			</div>
			<div id="subtab-description" class="shown detailbox">
				<span class="arrow"></span>
				<div class="detail">

				</div>
			</div>
			<div id="subtab-feature" class="hidden detailbox">
				<span class="arrow"></span>
				<div class="detail">
					
				</div>
			</div>
			<div id="subtab-finish" class="hidden detailbox">
				<span class="arrow"></span>
				<div class="detail">
					
				</div>
			</div>
			<div id="subtab-amenity" class="hidden detailbox">
				<span class="arrow"></span>
				<div class="detail">
					<ul class="amenity">
						<li><i data-bind="css: {tick: reception(), cross: !reception()}"></i> 前台</li>
						<li><i data-bind="css: {tick: swimmingPool(), cross: !swimmingPool()}"></i> 游泳池</li>
						<li><i data-bind="css: {tick: sauna(), cross: !sauna()}"></i> 桑拿房</li>
						<li><i data-bind="css: {tick: tennisCourt(), cross: !tennisCourt()}"></i> 网球场</li>
						<li><i data-bind="css: {tick: funcRoom(), cross: !funcRoom()}"></i> 会客室</li>
						<li><i data-bind="css: {tick: theatreCinema(), cross: !theatreCinema()}"></i> 影音室</li>
						<li><i data-bind="css: {tick: library(), cross: !library()}"></i> 图书馆</li>
						<li><i data-bind="css: {tick: bbq(), cross: !bbq()}"></i> 烧烤设施</li>
						<li><i data-bind="css: {tick: landScaping(), cross: !landScaping()}"></i> 社区绿化</li>
						<li><i data-bind="css: {tick: skyGarden(), cross: !skyGarden()}"></i> 空中花园</li>
						<li><i data-bind="css: {tick: visitorParking(), cross: !visitorParking()}"></i> 访客停车位</li>
						<li><i data-bind="css: {tick: gym(), cross: !gym()}"></i> 健身房</li>
						<li><i data-bind="css: {tick: kidsPlayGround(), cross: !kidsPlayGround()}"></i> 儿童游乐场</li>
						<li><i data-bind="css: {tick: playRoom(), cross: !playRoom()}"></i> 活动室</li>
						<li><i data-bind="css: {tick: recreationPlace(), cross: !recreationPlace()}"></i> 休闲广场</li>
						<li><i data-bind="css: {tick: musicRoom(), cross: !musicRoom()}"></i> 音乐室</li>
					</ul>
				</div>
			</div>
		</div>
		<div id="tab-floorplans" class="hidden">
			<jsp:include page="floorplan_filter.jsp" />
			<div id="floorplans">
				<!--<div class="title">Search Results:</div>-->
				<div id="floorplan-list">
					<a href="javascript:;" class="prev nav"></a>
					<div class="scrollable">
						<div class="items">
							
						</div>
					</div>
					<a href="javascript:;" class="next nav"></a>
				</div>
			</div>
		</div>
		<div id="tab-suburb" class="hidden tab-block">
			<div class="box">
				
			</div>
		</div>
		<!--
		<div id="tab-comments" class="hidden tab-block">
			<div class="box">
				<div id="add-comment">
					<a href="#">+ 发表我的看法</a>
				</div>
				<ul>
					<li>
						<div class="name">Sam <span class="date">Jun 20, 2013</span></div>
						<div class="comment"><p>附近住个奇怪的大叔喜欢穿着风衣吓人。好可怕。</p></div>
					</li>
					<li>
						<div class="name">Ryan <span class="date">Jun 20, 2013</span></div>
						<div class="comment"><p>那一天，人類終於回想起了，曾經一度支配他們的恐懼，還有被囚禁於鳥籠中的屈辱。</p></div>
					</li>
					<li>
						<div class="name">Bourne <span class="date">May 19, 2013</span></div>
						<div class="comment"><p>杰森·伯恩在意大利被人从海上救起，他失去了记忆，除了臀部的瑞士银行帐号之外，他完全没有办法证明自己的身份。</p>
<p>杰森从瑞士银行找到了大量的现金，六本护照，一把枪，同时他发现自己格斗、枪械、和语言等方面的能力，他开始追查自己的身份，并且把陌生女子玛丽也卷了进来。两人从瑞士到巴黎，一路上受到神秘杀手组织的追杀，危机重重。</p>
<p>杰森能否化险为夷，找到自己的真实身份？他是否有勇气面对真相？</p></div>
					</li>
				</ul>
			</div>
		</div>
		-->
		<div id="tab-contactus" class="hidden tab-block">
			<div class="box">
				<div>关于 <b class="project"></b> 如果您想了解更多，我们会第一时间给您答复。</div>
				<form action="" method="post">
					<div class="row clearfix">
						<div class="input">
							<input type="text" name="name" value="" class="required" placeholder="姓名(必填)"/>
						</div>
						<div class="input" style="margin-left:10px;">
							<input type="text" name="mobile" value="" placeholder="手机(选填)"/>
						</div>
					</div>
					<div class="row clearfix">
						<div class="input">
							<input type="email" name="email" value="" class="required" placeholder="Email(必填)" style="width:483px;"/>
						</div>
					</div>
					<div class="row clearfix">
						<div class="input">
							<textarea name="message" class="required"></textarea>
						</div>
					</div>
					<div class="buttons">
						<input type="submit" class="btn red" value="提 交"></a>
					</div>
				</form>
				<div class="thankyou" style="display:none;">
					<p>谢谢，我们的销售人员会第一时间与您联系。</p>
				</div>
			</div>
		</div>
	</div>
</div>