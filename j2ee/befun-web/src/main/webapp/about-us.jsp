<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.befun.web.box.SessionContainer"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
    	<title>澳洲比房网 | 期房 楼花 现房 | 关于我们</title>
    	<meta name="Description" content="比房置业投资有限公司是澳洲第一家以网络为平台的新型房地产公司，打造最准确的分析与定位进行智能选房，无论身处海外还是澳洲比房置业将主动权交给客户，让客户通过比房置业强大的房源搜索引擎筛选出最优质的房产。"/>
    	<meta name="Keywords" content="澳洲楼花,澳洲期房,澳洲现房,悉尼楼花,悉尼现房,悉尼期房,悉尼房产,悉尼,楼花,现房,期房,雪梨,楼花价格,期房价格"/>
        <jsp:include page="includes/head.jsp" />
    </head>
	<body class="standard about">
		<header style="position:absolute;">
        	<div class="inner">
				<jsp:include page="includes/search.jsp" />
			</div>
        </header>
		<div id="content">
			<h2>关于我们</h2>
			<div class="about-main clearfix">
				<div class="side-nav">
					<ul>
						<li><a href="<c:url value="about-us.jsp"/>" class="active"><span>关于我们</span></a></li>
						<li><a href="<c:url value="join-us.jsp"/>"><span>加入我们</span></a></li>
						<li><a href="<c:url value="disclaimer.jsp"/>"><span>免责声明</span></a></li>
						<li><a href="<c:url value="contact-us.jsp"/>"><span>联系我们</span></a></li>
					</ul>
				</div>
				<div class="main">
					<h3>比房置业(Befun Property Pty Ltd)</h3>
					<p>比房置业是一家以网络媒体为平台，以客户需求为导向的社交型房地产公司，摆脱以往传统的房地产销售模式转变为网络化，社交化，平台化，客户定制化的地产公司。</p>
					<p>比房置业拥有独特的网络平台，提倡新一代的互动体验，是澳洲第一家以网络为平台的新型楼盘销售公司。通过我们的系统，客户可以搜索，查找，比较各个热点区域的全新楼盘。我们的网络平台提供海量的楼盘基本信息，地区特色，环境, sales也可以告别厚重的文件夹，实现高效的无纸化办公。比房置业秉承打造最准确的分析与定位进行智能选房，无论身处海外还是澳洲，比房置业将主动权交给客户，让客户挑选到最满意的物业！</p>
					<p>比房置业的团队拥有专业先锋、富有朝气和极度敬业的服务团队，将以专业的造作水平和严谨的服务态度，让每位客户都能得到满意和信赖，我们秉承打造澳洲最具现代网络化和最权威的地产公司。</p>
					<p>每一个比房员工，极致服务, 您的满意就是我们的成功。您我未来,共获丰远！</p>
				</div>
			</div>
			<jsp:include page="includes/footer.jsp" />
		</div>
	</body>
</html>