<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<script>
	$(function() {
		$("#menuCacheStatistics").menu();
		$("#menuArea").menu();
		$("#menuSuburb").menu();
		$("#menuProject").menu();
		$("#menuProjectMedia").menu();
		$("#menuStage").menu();
		$("#menuBuilding").menu();
		$("#menuFloorplan").menu();
		$("#menuApartment").menu();
		$("#menuMedia").menu();
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
				<li><a href="<c:url value='/admin/cacheStatistics.action'/>"> Cache </a>
				</li>
			</ul>
		</div>
		<div class="menu-div">
			<ul id="menuArea">
				<li><a href="<c:url value='/admin/data/demandArea.action'/>"> Area </a>
					<ul>
						<s:url var="e" action="admin/data/createPageArea.action" namespace="/"/>
						<li><a href="#" onclick="showDialog('${e}')">Create</a></li>
					</ul></li>
			</ul>
		</div>
		<sec:authorize ifAllGranted="SUPER">
			<div class="menu-div">
				<ul id="menuEmployee">
					<li><a href="<c:url value='/admin/profile/demandEmployee.action'/>"> Profile </a></li>
				</ul>			
			</div>
		</sec:authorize>
	</div>
</body>
</html>