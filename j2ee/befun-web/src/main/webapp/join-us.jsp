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
    	<title>澳洲比房网 | 期房 楼花 现房 | 加入我们</title>
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
			<h2>加入我们</h2>
			<div class="about-main clearfix">
				<div class="side-nav">
					<ul>
						<li><a href="<c:url value="about-us.jsp"/>"><span>关于我们</span></a></li>
						<li><a href="<c:url value="join-us.jsp"/>" class="active"><span>加入我们</span></a></li>
						<li><a href="<c:url value="disclaimer.jsp"/>"><span>免责声明</span></a></li>
						<li><a href="<c:url value="contact-us.jsp"/>"><span>联系我们</span></a></li>
					</ul>
				</div>
				<div class="main">
					<h3>我们期待您的加入</h3>
					<p>无论你是学生还是职员, 无论你是否有房地产的经验, 无论你想做全职或是兼职，只要你有热情，有激情，有活力，就可以加入比房置业这个充满朝气的团队。</p>
					<p>比房置业为你提供最便捷的客户获取渠道（比房网），最先进的数字平台（比房网Sales工具），最有吸引力的销售回报以及最完善的培训体系。</p>
					<p><a href="mailto:info@befun.com.au">发送简历</a></p>
				</div>
			</div>
			<jsp:include page="includes/footer.jsp" />
		</div>
	</body>
</html>