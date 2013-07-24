<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<script>
	$(function() {
		$("#menuCacheStatistics").menu();
		$("#menuArea").menu();
		$("#menuEmployee").menu();
		initPage();
	});
</script>
<style>
.ui-menu {
	width: 108px;
}

.menu-div {
	width: 114px;
	height: 20px;
	float: left;
}
</style>
</head>
<body>
	<div id="childrenDiv"></div>
	<div class="ui-widget" style="width: 1200px; height: 30px;">
		<div class="menu-div">
			<ul id="menuCacheStatistics">
				<li><a href="<c:url value='/admin/elementCacheStatistics.action'/>"> Cache </a>
					<ul>
						<s:url var="e" action="admin/queryCacheStatistics.action" namespace="/" />
						<li><a href="${e}" >Query</a></li>
					</ul></li>
			</ul>
		</div>
		<div class="menu-div">
			<ul id="menuArea">
				<li><a href="<c:url value='/admin/data/demandArea.action'/>"> Area </a></li>
			</ul>
		</div>
		<div class="menu-div">
			<ul id="menuEmployee">
				<li><a href="<c:url value='/admin/profile/demandEmployee.action'/>"> Profile </a></li>
			</ul>
		</div>
	</div>
</body>
</html>