<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<script>
	$(function() {
		$("#menuCache").menu();
		$("#menuEmployee").menu();
		$("#menuClient").menu();
		$("#menuClientPreference").menu();
		$("#menuEmployeeClient").menu();
		$("#menuDepartment").menu();
		$("#menuProject").menu();
		initPage();
	});
</script>
<style>
.ui-menu {
	width: 124px;
}

.menu-div {
	width: 130px;
	height: 20px;
	float: left;
}
</style>
</head>
<body>
	<div id="childrenDiv"></div>
	<div class="ui-widget" style="width: 1200px; height: 30px;">
		<sec:authorize ifAllGranted="SUPER">
			<div class="menu-div">
				<ul id="menuCache">
					<li><a href="<c:url value='/admin/elementCacheStatistics.action'/>"> Cache </a>
						<ul>
							<s:url var="e" action="admin/queryCacheStatistics.action" namespace="/" />
							<li><a href="${e}">Query</a></li>
						</ul></li>
				</ul>
			</div>
		</sec:authorize>
		<div class="menu-div">
			<ul id="menuProject">
				<li><a href="<c:url value='/admin/data/demandProject.action'/>"> Project </a></li>
			</ul>
		</div>
		<div class="menu-div">
			<ul id="menuEmployee">
				<li><a href="<c:url value='/admin/profile/demandEmployee.action'/>"> Employee </a>
					<ul>
						<s:url var="e" action="admin/profile/createPageEmployee.action" namespace="/" />
						<li><a href="#" onclick="showDialog('${e}')">Create</a></li>
					</ul></li>
			</ul>
		</div>
		<div class="menu-div">
			<ul id="menuClient">
				<li><a href="<c:url value='/admin/profile/demandClient.action'/>"> Client </a>
					<ul>
						<s:url var="e" action="admin/profile/createPageClient.action" namespace="/" />
						<li><a href="#" onclick="showDialog('${e}')">Create</a></li>
					</ul></li>
			</ul>
		</div>
		<div class="menu-div">
			<ul id="menuEmployeeClient">
				<li><a href="<c:url value='/admin/profile/demandEmployeeClient.action'/>"> EmployeeClient </a>
					<ul>
						<s:url var="e" action="admin/profile/createPageEmployeeClient.action" namespace="/" />
						<li><a href="#" onclick="showDialog('${e}')">Create</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- 
		<div class="menu-div">
			<ul id="menuDepartment">
				<li><a href="<c:url value='/admin/profile/demandDepartment.action'/>"> Department </a>
					<ul>
						<s:url var="e" action="admin/profile/createPageDepartment.action" namespace="/"/>
						<li><a href="#" onclick="showDialog('${e}')">Create</a></li>
					</ul></li>
			</ul>
		</div> -->
	</div>
</body>
</html>