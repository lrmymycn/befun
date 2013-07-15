<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% pageContext.setAttribute("newLineChar", "\n"); %>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
    	<title>澳洲比房网 | ${view.projectName} | ${view.bedRoomCount}房 ${view.bathroomCount}卫</title>
    	<meta name="Description" content="${projectView.shortDescription}"/>
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
	        		<h2>${view.projectBlock} - ${view.id} <span><a href="<c:url value="/estate/demandProjectDetail.action?id=${view.projectId }"/>" target="_blank">${view.projectName}</a> / ${view.bedRoomCount}房 ${view.bathroomCount}卫 </span></h2>
	        		<div class="tile">
	        			<div class="gallery">
	        				<a href="http://img.befun.com.au${view.publicPicture.largeUrl}" target="_blank"><img src="http://img.befun.com.au${view.publicPicture.mediumUrl}" alt="" width="100%"/></a>
	        			</div>
						<div class="section">
							<div class="title">户型分析</div>
							<c:if test="${fn:length(pgbComment.models) == 0}">
								<p>这个项目还没户型分析</p>
							</c:if>
							<ul class="comments">
								<c:forEach items="${pgbComment.models}" var="m" varStatus="stat">
									<li>
										<sec:authorize access="isAuthenticated()">
											<a href="javascript:;" data-id="${m.id}" class="edit">Edit</a>
										</sec:authorize>
										<p>${fn:replace(m.content, newLineChar, "<br/>")}</p>
									</li>
								</c:forEach>
							</ul>
							<sec:authorize access="isAuthenticated()">
								<div class="add-button">
									<a href="javascript:;" class="btn red add">添加户型解析</a>
								</div>
								<div class="add-comment" style="display:none;">
									<textarea name="comment"></textarea>
									<div class="buttons">
										<a href="javascript:;" class="btn red submit">添加</a> <a href="javascript:;" class="btn cancel">取消</a>
									</div>
								</div>
							</sec:authorize>
						</div>
						<div class="section">
							<div class="title">项目详情</div>
							<div class="clearfix">
								<div class="details">
									<h4>项目简介</h4>
									<p>${projectView.shortDescription}</p>
									<a href="<c:url value="/estate/demandProjectDetail.action?id=${view.projectId }"/>" target="_blank" class="readmore">更多项目详情 >></a>
								</div>
								<div class="amenity">
									<h4>项目设施</h4>
									<ul>
										<li><i class="${projectView.carWashBay ? 'tick' : 'cross'}"></i> 前台</li>
										<li><i class="${projectView.swimmingPool ? 'tick' : 'cross'}"></i> 游泳池</li>
										<li><i class="${projectView.sauna ? 'tick' : 'cross'}"></i> 桑拿房</li>
										<li><i class="${projectView.tennisCourt ? 'tick' : 'cross'}"></i> 网球场</li>
										<li><i class="${projectView.funcRoom ? 'tick' : 'cross'}"></i> 会客室</li>
										<li><i class="${projectView.theatreCinema ? 'tick' : 'cross'}"></i> 影音室</li>
										<li><i class="${projectView.library ? 'tick' : 'cross'}"></i> 图书馆</li>
										<li><i class="${projectView.bbq ? 'tick' : 'cross'}"></i> 烧烤设施</li>
										<li><i class="${projectView.landScaping ? 'tick' : 'cross'}"></i> 社区绿化</li>
										<li><i class="${projectView.skyGarden ? 'tick' : 'cross'}"></i> 空中花园</li>
										<li><i class="${projectView.visitorParking ? 'tick' : 'cross'}"></i> 访客停车位</li>
										<li><i class="${projectView.gym ? 'tick' : 'cross'}"></i> 健身房</li>
										<li><i class="${projectView.kidsPlayGround ? 'tick' : 'cross'}"></i> 儿童游乐场</li>
										<li><i class="${projectView.playRoom ? 'tick' : 'cross'}"></i> 活动室</li>
										<li><i class="${projectView.recreationPlace ? 'tick' : 'cross'}"></i> 休闲广场</li>
										<li><i class="${projectView.musicRoom ? 'tick' : 'cross'}"></i> 音乐室</li>
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
							pic:"http://img.befun.com.au${view.publicPicture.mediumUrl}",
							hideMore:false
						}
						</script>
						<script type="text/javascript" src="http://v3.jiathis.com/code/jia.js" charset="utf-8"></script>
						<!-- JiaThis Button END -->
					</div>
					<div class="sidepanel">
						<div class="title">户型规格</div>
						<table>
							<tr>
								<td class="label"><i class="bedroom"></i> 卧室:</td>
								<td class="value">${view.bedRoomCount}</td>
							</tr>
							<tr>
								<td class="label"><i class="bathroom"></i> 浴室:</td>
								<td class="value">${view.bathroomCount}</td>
							</tr>
							<tr>
								<td class="label"><i class="study"></i> 书房:</td>
								<td class="value">${view.studyroomCount}</td>
							</tr>
							<tr>
								<td class="label"><i class="aspect"></i> 朝向:</td>
								<td class="value" id="aspect"></td>
							</tr>
							<tr>
								<td class="label"><i class="internalarea"></i> 面积 (内):</td>
								<td class="value">${view.internalSize} m<sup>2</sup></td>
							</tr>
							<tr>
								<td class="label"><i class="externalarea"></i> 面积 (外):</td>
								<td class="value">${view.externalSize} m<sup>2</sup></td>
							</tr>
							<tr>
								<td class="label"><i class="totalarea"></i> 面积 (总):</td>
								<td class="value">${view.totalSize} m<sup>2</sup></td>
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

我在比房网上看到了(${view.projectBlock} - ${view.id})这个户型。想了解具体的价格，请和我联系。</textarea>
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
         	<footer>
				&copy; 2012 Befun Property 
			</footer>
		</div>
		<jsp:include page="includes/script.jsp" />
        <script>
        	$(function(){
        		Main.currentFloorplanId = ${view.id};
        		DetailPage.initFloorPlanPage();
        		DetailPage.initForm(${view.id}, 'floorplan');
				DetailPage.initGoogleMap(${projectView.latitude}, ${projectView.longitude});
				$('#aspect').text(Tools.getAspect(${view.orientationEast}, ${view.orientationNorth}, ${view.orientationSouth}, ${view.orientationWest}));
				$('#right .sidepanel').height($('#left .tile').outerHeight() - 1);
			})
        </script>
	</body>
</html>
