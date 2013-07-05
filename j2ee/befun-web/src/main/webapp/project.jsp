<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
    	<title>比房网 | ${view.name}</title>
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
	        		<h2><c:out value="${view.name}" /> <span><c:out value="${view.suburbName}" /> / <c:out value="${view.priceRange}" /></span></h2>
	        		<div class="tile">
						<div class="gallery">
							<div id="gallery-main">
								<img src="${view.medias[0].mediumUrl}" width="630" height="423" alt=""/>
							</div>
							<div id="gallery-list">
								<a href="javascript:;" class="prev"></a>
								<div class="scrollable">
									<div class="items">
										<c:forEach items="${view.medias }" var="m" varStatus="stat">
											<c:if test="${stat.last || (stat.index > 0 && (stat.index mod 6) eq 0) }">
												</div>
											</c:if>
											<c:if test="${(stat.index mod 6) eq 0 }">
												<div id="${stat.index }">
											</c:if>
												<a href="${m.mediumUrl }" <c:if test="${stat.index eq 0 }">class="active"</c:if>><img src="${m.mediumUrl }" width="89" height="59" /></a>
										</c:forEach>
									</div>
								</div>
								<a href="javascript:;" class="next"></a>
							</div>
						</div>
					</div>
					
					<div class="tile">
						<h3>检索当前项目户型</h3>
						<div class="floorplans clearfix">
							<jsp:include page="includes/floorplan_filter.jsp" />
							<div id="floorplans">
								<div id="floorplan-list">
									<a href="javascript:;" class="prev nav"></a>
									<div class="scrollable">
										<div class="items">
											<!--
											<div data-id="0"><a data-id="412" class="item" href="javascript:;"><img alt="" src="/img/fp/small/F-P-G58.jpg"></a><a data-id="373" class="item" href="javascript:;"><img alt="" src="/img/fp/small/D-P-G25.jpg"></a><a data-id="421" class="item" href="javascript:;"><img alt="" src="/img/fp/small/G-P-173,273,372.jpg"></a></div>
											-->
											<c:forEach items="${view.floorplans }" var="f" varStatus="stat">
												<c:if test="${stat.last || (stat.index > 0 && (stat.index mod 3) eq 0) }">
													</div>
												</c:if>
												<c:if test="${(stat.index mod 3) eq 0 }">
													<div id="${stat.index }">
												</c:if>
													<a data-id="${f.id }" class="item" href="${f.publicPicture.largeUrl}" target="_blank"><img alt="" src="${f.publicPicture.smallUrl}"></a>
											</c:forEach>
										</div>
									</div>
									<a href="javascript:;" class="next nav"></a>
								</div>
							</div>
						</div>
					</div>
					
					<div class="tile">
						<div class="tabs">     			
							<a class="active first" href="#tab-project-overview">项目信息</a>
							<a href="#tab-project-feature">项目特色</a>
							<a href="#tab-project-finish">内饰品牌</a>
							<!--<a href="#tab-sales">区域分析</a>-->
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
						</div>						
					</div>
					
					<div class="tile">
						<h3>地图</h3>
						<div id="googlemap">
				
						</div>
					</div>
				</div>
				<div id="right">
					<div class="affix">
						<div class="social">
							<span>分享这个项目: </span>
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
								pic:"http://www.befun.com.au${view.medias[0].mediumUrl}",
								hideMore:false
							}
							</script>
							<script type="text/javascript" src="http://v3.jiathis.com/code/jia.js" charset="utf-8"></script>
							<!-- JiaThis Button END -->
						</div>
						<div class="contactus widget" style="margin-top:0px;">
							<h3>免费咨询</h3>
							<form action="" method="post">
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
										<textarea placeholder="例如：关于这个项目，我想了解更多。"></textarea>
									</div>
								</div>
								<div class="buttons">
									<input type="submit" class="btn red" value="提 交"></a>
								</div>
							</form>
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
				</div>
         	</div>
         	<footer>
				&copy; 2012 Befun Property 
			</footer>
		</div>
		<jsp:include page="includes/script.jsp" />
        <script>
        	$(function(){
        		Main.currentProjectId = <c:out value="${view.id}" />
				ProjectPage.init();
				ProjectPage.initGoogleMap(<c:out value="${view.latitude}" />, <c:out value="${view.longitude}" />);
				FloorPlanFilter.init(true);
			})
        </script>
	</body>
</html>
