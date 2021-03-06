<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<script>
	$(function() {
		$("#menuCache").menu();
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
			<ul id="menuArea">
				<li><a href="<c:url value='/admin/data/demandArea.action'/>"> Area </a>
					<ul>
						<s:url var="e" action="admin/data/createPageArea.action" namespace="/" />
						<li><a href="#" onclick="showDialog('${e}')">Create</a></li>
					</ul></li>
			</ul>
		</div>
		<div class="menu-div">
			<ul id="menuSuburb">
				<li><a href="<c:url value='/admin/data/demandSuburb.action'/>"> Suburb </a>
					<ul>
						<s:url var="e" action="admin/data/createPageSuburb.action" namespace="/" />
						<li><a href="#" onclick="showDialog('${e}')">Create</a></li>
					</ul></li>
			</ul>
		</div>
		<div class="menu-div">
			<ul id="menuProject">
				<li><a href="<c:url value='/admin/data/demandProject.action'/>"> Project </a>
					<ul>
						<s:url var="e" action="admin/data/createPageProject.action" namespace="/" />
						<li><a href="#" onclick="showDialog('${e}')">Create</a></li>
					</ul></li>
			</ul>
		</div>
		<div class="menu-div">
			<ul id="menuProjectMedia">
				<li><a href="<c:url value='/admin/data/demandProjectMedia.action'/>"> ProjectMedia </a>
					<ul>
						<s:url var="e" action="admin/data/createPageProjectMedia.action" namespace="/" />
						<li><a href="#" onclick="showDialog('${e}')">Create</a></li>
					</ul></li>
			</ul>
		</div>
		<div class="menu-div">
			<ul id="menuStage">
				<li><a href="<c:url value='/admin/data/demandStage.action'/>"> Stage </a>
					<ul>
						<s:url var="e" action="admin/data/createPageStage.action" namespace="/" />
						<li><a href="#" onclick="showDialog('${e}')">Create</a></li>
					</ul></li>
			</ul>
		</div>
		<div class="menu-div">
			<ul id="menuBuilding">
				<li><a href="<c:url value='/admin/data/demandBuilding.action'/>"> Building </a>
					<ul>
						<s:url var="e" action="admin/data/createPageBuilding.action" namespace="/" />
						<li><a href="#" onclick="showDialog('${e}')">Create</a></li>
					</ul></li>
			</ul>
		</div>
		<div class="menu-div">
			<ul id="menuFloorplan">
				<li><a href="<c:url value='/admin/data/demandFloorplan.action'/>"> Floorplan </a>
					<ul>
						<s:url var="e" action="admin/data/createPageFloorplan.action" namespace="/" />
						<li><a href="#" onclick="showDialog('${e}')">Create</a></li>
					</ul></li>
			</ul>
		</div>
		<div class="menu-div">
			<ul id="menuApartment">
				<li><a href="<c:url value='/admin/data/demandApartment.action'/>"> Apartment </a>
					<ul>
						<s:url var="e" action="admin/data/createPageApartment.action" namespace="/" />
						<li><a href="#" onclick="showDialog('${e}')">Create</a></li>
					</ul></li>
			</ul>
		</div>
		<div class="menu-div">
			<ul id="menuMedia">
				<li><a href="<c:url value='/admin/data/demandMedia.action'/>"> Media </a>
					<ul>
						<s:url var="e" action="admin/data/createPageMedia.action" namespace="/" />
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