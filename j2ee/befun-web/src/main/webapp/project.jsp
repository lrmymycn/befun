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
	        		<div class="tile">
						<h2>Project Name</h2>	
						<div class="gallery">
							<div id="gallery-main">
								<img src="/img/render/medium/vsq-north.jpg" width="630" height="423" alt=""/>
							</div>
							<div id="gallery-list">
								<a href="javascript:;" class="prev"></a>
								<div class="scrollable">
									<div class="items">
										<div>
											<a href="/img/render/medium/oceanvale.jpg" class="active"><img src="/img/render/medium/vsq-north.jpg" width="89" height="59" /></a>
											<a href="/img/render/medium/web_oceanvale_ext_4.jpg" class=""><img src="/img/render/medium/web_oceanvale_ext_4.jpg" width="89" height="59" /></a>
											<a href="/img/render/medium/web_oceanvale_ext_3.jpg" class=""><img src="/img/render/medium/web_oceanvale_ext_3.jpg" width="89" height="59" /></a>
											<a href="/img/render/medium/web_oceanvale_ext_2.jpg" class=""><img src="/img/render/medium/web_oceanvale_ext_2.jpg" width="89" height="59" /></a>
											<a href="/img/render/medium/oceanvale-warriewood-cycling-641x432.jpg" class=""><img src="/img/render/medium/oceanvale-warriewood-cycling-641x432.jpg" width="89" height="59" /></a>
											<a href="/img/render/medium/oceanvale-warriewood-beach-641x432.jpg" class=""><img src="/img/render/medium/oceanvale-warriewood-beach-641x432.jpg" width="89" height="59" /></a>
										</div>
										<div>
											<a href="/img/render/medium/oceanvalepool-641x432.jpg" class=""><img src="/img/render/medium/oceanvalepool-641x432.jpg" width="89" height="59" /></a>
										</div>
									</div>
								</div>
								<a href="javascript:;" class="next"></a>
							</div>
						</div>
					</div>
					
					<div class="tile">
						<h3>户型检索</h3>
						<div class="floorplans clearfix">
							<jsp:include page="includes/floorplan_filter.jsp" />
						</div>
					</div>
					
					<div class="tile">
						<div class="tabs">     			
							<a class="active first" href="#tab-overview">项目信息</a>
							<a href="#tab-sales">项目特色</a>
							<a href="#tab-sales">内饰品牌</a>
							<a href="#tab-sales">区域分析</a>
						</div>
						<table>
							<tr>
								<td width="100"><strong>地址</strong></td>
								<td>661-665 Gardeners Rd Mascot NSW 2020</td>
							</tr>
							<tr>
								<td><strong>市政厅</strong></td>
								<td>Mascot</td>
							</tr>
							<tr>
								<td><strong>市中心距离</strong></td>
								<td>10km</td>
							</tr>
							<tr>
								<td><strong>开发商</strong></td>
								<td>Meriton</td>
							</tr>
							<tr>
								<td><strong>建筑商</strong></td>
								<td>Meriton</td>
							</tr>
							<tr>
								<td><strong>发布日期</strong></td>
								<td>25/05/2013</td>
							</tr>
							<tr>
								<td><strong>总期数</strong></td>
								<td>3</td>
							</tr>
							<tr>
								<td><strong>总栋数</strong></td>
								<td>3</td>
							</tr>
							<tr>
								<td><strong>项目设施</strong></td>
								<td>
									<ul class="amenity">
										<li><i class="tick"></i> Reception</li>
										<li><i class="tick"></i> Swimming Pool</li>
										<li><i class="tick"></i> Sauna Room</li>
										<li><i class="tick"></i> Tennis Court</li>
										<li><i class="tick"></i> Function Room</li>
										<li><i class="tick"></i> Theatre Cinema</li>
										<li><i class="tick"></i> Library</li>
										<li><i class="tick"></i> BBQ Fireplace</li>
										<li><i class="tick"></i> Landscaping</li>
										<li><i class="tick"></i> Sky Garden</li>
										<li><i class="tick"></i> Visitor parking</li>
										<li><i class="tick"></i> Car wash bay</li>
										<li><i class="tick"></i> Gym</li>
										<li><i class="tick"></i> Kids Play Ground</li>
										<li><i class="tick"></i> Play Room</li>
										<li><i class="tick"></i> Recreation Place</li>
										<li><i class="tick"></i> Music Room</li>
									</ul>
								</td>
							</tr>
						</table>
						
						<table>
							<tr>
								<td width="100"><strong>Wall</strong></td>
								<td>Painted Plasterboard</td>
							</tr>
							<tr>
								<td><strong>Floor</strong></td>
								<td>Carpet / Timber floor</td>
							</tr>
							<tr>
								<td><strong>Kitchen</strong></td>
								<td>Splashback (stone/nature stone)<br/>
									Cooktop (brand)<br/>
									Oven (brand)<br/>
									Rangehood (brand, ducted/recirculating)<br/>
									Dishwasher (brand)<br/>
									Microwave (brand)<br/>
									Sink (brand or material)
								</td>
							</tr>
							<tr>
								<td><strong>Bathroom</strong></td>
								<td>Shower (brand or material)<br/>
									Tub (brand)<br/>
									Tile (ceramic tiles)<br/>
									Bathroom ware (brand)
								</td>
							</tr>
							<tr>
								<td><strong>Aircon</strong></td>
								<td>Centralized</td>
							</tr>
							<tr>
								<td><strong>NBN</strong></td>
								<td>What's this?</td>
							</tr>
							<tr>
								<td><strong>Satellite TV</strong></td>
								<td>Foxtel</td>
							</tr>
						</table>
					</div>
					
					<div class="tile">
						<h3>地图</h3>
						<div id="googlemap">
				
						</div>
					</div>
				</div>
				<div id="right">
					<div class="contactus widget">
						<h3>联系我们</h3>
						<form action="" method="post">
							<div class="row clearfix">
								<div class="input">
									<input type="text" name="name" value="" class="required" placeholder="姓名"/>
								</div>
							</div>
							<div class="row clearfix">
								<div class="input">
									<input type="email" name="email" value="" class="required" placeholder="Email"/>
								</div>
							</div>
							<div class="row clearfix">
								<div class="input">
									<input type="text" name="mobile" value="" placeholder="手机"/>
								</div>
							</div>
							<div class="row clearfix">
								<div class="input">
									<textarea placeholder="例如：关于这个项目，我想了解更多。"></textarea>
								</div>
							</div>
							<div class="buttons">
								<input type="submit" class="btn red" value="提交"></a>
							</div>
						</form>
					</div>
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
				</div>
         	</div>
         	<footer>
				&copy; 2012 Befun Property 
			</footer>
		</div>
		<jsp:include page="includes/script.jsp" />
        <script>
        	$(function(){
				ProjectPage.init();
			})
        </script>
	</body>
</html>
