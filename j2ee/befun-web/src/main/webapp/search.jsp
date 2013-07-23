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
    	<title>澳洲比房网 | 搜索</title>
    	<meta name="Description" content="比房置业投资有限公司是澳洲第一家以网络为平台的新型房地产公司，打造最准确的分析与定位进行智能选房，无论身处海外还是澳洲比房置业将主动权交给客户，让客户通过比房置业强大的房源搜索引擎筛选出最优质的房产。"/>
    	<meta name="Keywords" content="澳洲楼花,澳洲期房,澳洲现房,悉尼楼花,悉尼现房,悉尼期房,悉尼房产,悉尼,楼花,现房,期房,雪梨,楼花价格,期房价格,wentworth point,zetland,parramatta,north sydney"/>
        <jsp:include page="includes/head.jsp" />
    </head>
	<body>
	    <div class="home">
	        <header>
	        	<div class="inner">
	        		<jsp:include page="includes/search.jsp" />
		        	<div id="reminder">
	        			<em>搜索条件: </em><div id="reminder-nodes"></div> <a href="<c:url value="/search.jsp"/>" class="reset">显示全部 Sydney 项目</a>
	        			<div class="result"></div>
	        		</div>
	        	</div>
	        </header>
	        <div id="content">
	        	<div id="main">
	        		<div id="map-menu">
						<div class="top">
							<div class="title">周边环境</div>
							<i class="arrow-down-grap"></i>
						</div>
						<ul>
							<li><a href="javascript:;" class="childcares"><i class="tick"></i>托儿所</a></li>
							<li><a href="javascript:;" class="hospitals"><i class="tick"></i>大型医院</a></li>
							<li><a href="javascript:;" class="medicalcentres"><i class="tick"></i>诊所</a></li>
							<li><a href="javascript:;" class="restaurants"><i class="tick"></i>餐馆</a></li>
							<li><a href="javascript:;" class="schools"><i class="tick"></i>学校</a></li>
							<li><a href="javascript:;" class="stores"><i class="tick"></i>商店</a></li>
							<li><a href="javascript:;" class="distance"><i class="tick"></i>距离查看工具</a></a></li>
						</ul>
			        </div>
			        <div id="map">
	        		
	        		</div>    		
	        	</div>
	        	<div id="sidebar">
	        		<div id="projectlist">
	        		
	        		</div>
	        		<footer>
	        			<a href="<c:url value="about-us.jsp"/>">关于我们</a><a href="<c:url value="join-us.jsp"/>">加入我们</a><a href="<c:url value="disclaimer.jsp"/>">免责声明</a><a href="<c:url value="contact-us.jsp"/>">联系我们</a>
	        		</footer>
	        	</div>
	        	
	        </div>
	        
	        <jsp:include page="includes/panel.jsp" />
	        <jsp:include page="includes/floorplan.jsp" />
	        <jsp:include page="includes/compare.jsp" />
        </div>
      	<jsp:include page="includes/script.jsp" />
        <script>
        	$(function(){
				Debug.enable = true;
				Main.init();
			})
        </script>
	</body>
</html>