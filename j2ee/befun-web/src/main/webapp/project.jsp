<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
    	<title>澳洲比房网 | ${view.name} | ${view.suburbName}</title>
    	<meta name="Description" content="${view.shortDescription}"/>
    	<meta name="Keywords" content="${view.suburbName}楼花,${view.suburbName}期房,${view.suburbName}现房"/>
        <jsp:include page="includes/head.jsp" />
    </head>
	<body>
		<div class="standard">
	        <header>
	        	<div class="inner">
	        		<jsp:include page="includes/search.jsp" />
	        	</div>
	        </header>
	        <div id="content" class="project clearfix">
	        	<div id="left">
	        		<h2>${view.name} (${view.block}) <span>${view.suburbName} / ${view.priceRange} </span></h2>
	        		<div class="tile">
						<div class="gallery">
							<div id="gallery-main">
								<img src="http://img.befun.com.au${view.medias[0].mediumUrl}" width="648" height="485" alt=""/>
							</div>
							<div id="gallery-list">
								<a href="javascript:;" class="prev"></a>
								<div class="scrollable">
									<div class="items">
										<div>
										<c:forEach items="${view.medias }" var="m" varStatus="stat">
											<c:if test="${(stat.index > 0 && (stat.index mod 6) eq 0) }">
												</div>
												<div id="${stat.index }">
											</c:if>
												<a href="http://img.befun.com.au${m.mediumUrl }" <c:if test="${stat.index eq 0 }">class="active"</c:if>><img src="http://img.befun.com.au${m.mediumUrl }" /></a>
										</c:forEach>
										</div>
									</div>
								</div>
								<a href="javascript:;" class="next"></a>
							</div>
						</div>
						<div class="section">
							<div class="title">检索当前项目户型</div>
							<div class="floorplans clearfix">
								<jsp:include page="includes/floorplan_filter.jsp" />
								<div id="floorplans">
									<div id="floorplan-list">
										<a href="javascript:;" class="prev nav"></a>
										<div class="scrollable">
											<div class="items">
												<div>
												<c:forEach items="${view.floorplans }" var="f" varStatus="stat">
													<c:if test="${(stat.index > 0 && (stat.index mod 3) eq 0) }">
														</div>
														<div id="${stat.index }">
													</c:if>
														<a class="item" href="<c:url value="/estate/demandFloorplanDetail.action?id=${f.id }"/>" target="_blank"><c:if test="${f.recommended}"><i class="recommended"></i></c:if><img alt="" src="http://img.befun.com.au${f.publicPicture.smallUrl}"></a>
												</c:forEach>
												</div>
											</div>
										</div>
										<a href="javascript:;" class="next nav"></a>
									</div>
								</div>
							</div>
						</div>
						<div class="section">
							<div class="title">项目信息</div>
							<div class="tabs">     			
								<a class="active first" href="#tab-project-overview">基本信息</a>
								<a href="#tab-project-feature">项目特色</a>
								<a href="#tab-project-finish">内饰品牌</a>
								<a href="#tab-project-amenity">项目设施</a>
							</div>
							<div class="tab-contents">
								<div id="tab-project-overview">
									<c:out value="${view.description}" escapeXml="false"/>
								</div>
								<div id="tab-project-feature" style="display:none">
									<c:out value="${view.features}" escapeXml="false"/>
								</div>
								<div id="tab-project-finish" style="display:none">
									<c:out value="${view.finishSchema}" escapeXml="false"/>
								</div>
								<div id="tab-project-amenity" style="display:none">
									<ul class="amenity clearfix">
										<li><i class="${view.carWashBay ? 'tick' : 'cross'}"></i> 前台</li>
										<li><i class="${view.swimmingPool ? 'tick' : 'cross'}"></i> 游泳池</li>
										<li><i class="${view.sauna ? 'tick' : 'cross'}"></i> 桑拿房</li>
										<li><i class="${view.tennisCourt ? 'tick' : 'cross'}"></i> 网球场</li>
										<li><i class="${view.funcRoom ? 'tick' : 'cross'}"></i> 会客室</li>
										<li><i class="${view.theatreCinema ? 'tick' : 'cross'}"></i> 影音室</li>
										<li><i class="${view.library ? 'tick' : 'cross'}"></i> 图书馆</li>
										<li><i class="${view.bbq ? 'tick' : 'cross'}"></i> 烧烤设施</li>
										<li><i class="${view.landScaping ? 'tick' : 'cross'}"></i> 社区绿化</li>
										<li><i class="${view.skyGarden ? 'tick' : 'cross'}"></i> 空中花园</li>
										<li><i class="${view.visitorParking ? 'tick' : 'cross'}"></i> 访客停车位</li>
										<li><i class="${view.gym ? 'tick' : 'cross'}"></i> 健身房</li>
										<li><i class="${view.kidsPlayGround ? 'tick' : 'cross'}"></i> 儿童游乐场</li>
										<li><i class="${view.playRoom ? 'tick' : 'cross'}"></i> 活动室</li>
										<li><i class="${view.recreationPlace ? 'tick' : 'cross'}"></i> 休闲广场</li>
										<li><i class="${view.musicRoom ? 'tick' : 'cross'}"></i> 音乐室</li>
									</ul>
								</div>
							</div>		
						</div>
						<div class="section">
							<div class="title">地图</div>
							<div id="googlemap">
				
							</div>
						</div>
					</div>
				</div>
				<div id="right">					
					<div class="social">
						<span>收藏或分享: </span>
						<!-- JiaThis Button BEGIN -->
						<div class="jiathis_style_24x24">
						<a class="jiathis_button_tsina"></a>
						<a class="jiathis_button_weixin"></a>
						<a class="jiathis_button_renren"></a>
						<a class="jiathis_button_qzone"></a>
						<a class="jiathis_button_fb"></a>
						<a href="http://www.jiathis.com/share" class="jiathis jiathis_txt jiathis_separator jtico jtico_jiathis" target="_blank"></a>
						</div>
						<script type="text/javascript" >
						var jiathis_config={
							summary:"",
							pic:"http://img.befun.com.au${view.medias[0].mediumUrl}",
							hideMore:false
						}
						</script>
						<script type="text/javascript" src="http://v3.jiathis.com/code/jia.js" charset="utf-8"></script>
						<!-- JiaThis Button END -->
					</div>
					<div class="sidepanel">
						<div class="title">项目简介</div>
						<table>
							<tr>
								<td class="label">编号:</td>
								<td class="value">${view.block}</td>
							</tr>
							<tr>
								<td class="label">类型:</td>
								<td class="value">${view.type}</td>
							</tr>
							<tr>
								<td class="label">价格:</td>
								<td class="value">${view.priceRange}</td>
							</tr>
							<tr>
								<td class="label">方位:</td>
								<td class="value">${view.areaName}</td>
							</tr>
							<tr>
								<td class="label">区域:</td>
								<td class="value">${view.suburbName}</td>
							</tr>
							<tr>
								<td class="label">市区距离:</td>
								<td class="value">${view.distanceToCity} km</td>
							</tr>
							<tr>
								<td colspan="2" class="description">${view.shortDescription}</td>
							</tr>
						</table>
						<div class="contactus">
							<h3>免费咨询</h3>
							<form id="contact-form" action="" method="post">
								<div class="row clearfix">
									<div class="input">
										<input type="text" name="name" value="" class="required" placeholder="姓名(必填)"/>
									</div>
								</div>
								<div class="row clearfix">
									<div class="input">
										<input type="email" name="email" value="" class="required" placeholder="Email(必填)"/>
									</div>
								</div>
								<div class="row clearfix">
									<div class="input">
										<input type="text" name="mobile" value="" placeholder="手机(选填)"/>
									</div>
								</div>
								<div class="row clearfix">
									<div class="input">
										<textarea class="required">Hi,

我在比房网上看到了${view.name}(${view.block})这个项目。

我对[2]房[2]卫的户型比较有兴趣，请和我联系。</textarea>
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
					<!--
					<div class="comments widget">
						<h3>精彩周边</h3>
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
					-->
				</div><!-- /right -->
         	</div><!-- /content -->
         	<footer>
				&copy; 2012 Befun Property 
			</footer>
		</div>
		<jsp:include page="includes/script.jsp" />
        <script>
        	$(function(){
        		Main.currentProjectId = ${view.id};
				DetailPage.initProjectPage();
				DetailPage.initGoogleMap(${view.latitude}, ${view.longitude});
				DetailPage.initForm(${view.id}, 'project');
				FloorPlanFilter.init(true);
				$('#floorplan-filter .result b').text('${fn:length(view.floorplans)}');
				$('#right .sidepanel').height($('#left .tile').outerHeight() - 1);
			})
        </script>
	</body>
</html>
