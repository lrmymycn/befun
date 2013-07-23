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
    	<title>澳洲比房网 | 期房 楼花 现房 | 免责声明</title>
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
			<h2>免责声明</h2>
			<div class="about-main clearfix">
				<div class="side-nav">
					<ul>
						<li><a href="<c:url value="about-us.jsp"/>"><span>关于我们</span></a></li>
						<li><a href="<c:url value="join-us.jsp"/>"><span>加入我们</span></a></li>
						<li><a href="<c:url value="disclaimer.jsp"/>" class="active"><span>免责声明</span></a></li>
						<li><a href="<c:url value="contact-us.jsp"/>"><span>联系我们</span></a></li>
					</ul>
				</div>
				<div class="main">
					<p>任何用户在使用比房网（www.befun.com.au）服务之前，均应仔细阅读本声明，用户可选择不使用比房网服务，一旦使用，即被视为对本声明全部内容的认可和接受。 </p>
					<ol>
						<li>比房置业(Befun Property Pty Ltd)是一家房地产中介公司，比房网是比房置业开发和维护的一个房地产信息搜索网站。</li>
						<li>任何通过比房网技术和服务得到内容（包括楼盘信息，户型信息，户型图，报价等）均整理自其所属开发商提供的资讯。比房置业对该信息的准确性，真实性，适用性等概不负责。</li>
						<li>任何单位或个人因相信，使用比房网技术和服务得到的内容（包括楼盘信息，户型信息，户型图，报价等），或者据此进行交易等行为，而引致直接或间接的财产损失，比房置业概不负责。</li>
						<li>如果您对使用比房网技术和服务得到的内容存在疑虑，比房置业建议您先咨询本公司或者其它专业人士。</li>
						<li>对免责声明的解释、修改及更新权均属于比房置业所有。</li>
					</ol>
				</div>
			</div>
			<jsp:include page="includes/footer.jsp" />
		</div>
	</body>
</html>