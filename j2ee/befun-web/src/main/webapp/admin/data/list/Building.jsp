<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="jmesa" uri="http://code.google.com/p/jmesa"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Buildings</title>
<script>
	function initPage(){
		$( "#areaCombobox" ).combobox();
		$( "#suburbCombobox" ).combobox();
		$( "#projectCombobox" ).combobox();
		$( "#stageCombobox" ).combobox();
		$( "#readyHouseCombobox" ).combobox();
		$( "#enabledCombobox" ).combobox();
	}
</script>
</head>
<body>
		<form action="" method="post">
			<table width="1000">
			<tr><td width="50"><label>Area: </label></td>
			<td width="200">
			<select id="areaCombobox" name="qc.proQC.suburbQC.areaId" onChange="getSuburbByArea($('#areaCombobox'), $('#suburbCombobox'));">
				<option value="" <c:if test="${empty qc.proQC.suburbQC.areaId}">selected="selected"</c:if>>Select Area</option>
				<c:forEach items="${qcAreas }" var="a">
					<option value="${a.id }" <c:if test="${qc.proQC.suburbQC.areaId eq a.id}">selected="selected"</c:if>>${a.name }</option>
				</c:forEach>
			</select></td>
			<td width="50"><label>Suburb: </label></td>
			<td width="200">
			<select id="suburbCombobox" name="qc.proQC.suburbId" onChange="getProjectBySuburb($('#suburbCombobox'), $('#projectCombobox'));">
				<option value="" <c:if test="${empty qc.proQC.suburbId}">selected="selected"</c:if>>Select Suburb</option>
				<c:forEach items="${qcSuburbs }" var="s">
					<option value="${s.id }" <c:if test="${qc.proQC.suburbId eq s.id}">selected="selected"</c:if>>${s.name }</option>
				</c:forEach>
			</select></td>
			<td width="50"><label>Project: </label></td>
			<td width="200">
			<select id="projectCombobox" name="qc.projectId" onChange="getStageByProject($('#projectCombobox'), $('#stageCombobox'));">
				<option value="" <c:if test="${empty qc.projectId}">selected="selected"</c:if>>Select Project</option>
				<c:forEach items="${qcProjects }" var="s">
					<option value="${s.id }" <c:if test="${qc.projectId eq s.id}">selected="selected"</c:if>>${s.name }</option>
				</c:forEach>
			</select></td>
			<td width="50"><label>Stage: </label></td>
			<td width="200">
			<select id="stageCombobox" name="qc.stageId">
				<option value="" <c:if test="${empty qc.stageId}">selected="selected"</c:if>>Select Stage</option>
				<c:forEach items="${qcStages }" var="s">
					<option value="${s.id }" <c:if test="${qc.stageId eq s.id}">selected="selected"</c:if>>${s.name }</option>
				</c:forEach>
			</select></td></tr>
			<tr>
			<td width="50"><label>Ready: </label></td>
			<td width="200">
			<select id="readyHouseCombobox" name="qc.readyHouse">
				<option value="null">All</option>
				<option value="true" <c:if test="${qc.readyHouse == true}">selected="selected"</c:if>>Is</option>
				<option value="false" <c:if test="${qc.readyHouse == false}">selected="selected"</c:if>>Not</option>
			</select>
			</td>
			<td width="50"><label>Number: </label></td>
			<td width="200">
			<input name="qc.buildingNumber" type="text" value="${qc.buildingNumber }" />
			</td>
			<td width="50"><label>Enabled: </label></td>
			<td width="200">
			<select id="enabledCombobox" name="qc.enabled">
				<option value="null">All</option>
				<option value="true" <c:if test="${qc.enabled == true}">selected="selected"</c:if>>Enabled</option>
				<option value="false" <c:if test="${qc.enabled == false}">selected="selected"</c:if>>Disabled</option>
			</select>
			</td>
			<td align="right" colspan="10"><input id="queryButton" type="button" value="Query" onclick="jQuery.jmesa.removeAllFiltersFromLimit('building_table');onInvokeAction('building_table','clear')" /></td></tr>
			</table>
		<input type="hidden" name="tableName" value="building_table" />
		<jmesa:struts2TableModel items="${pgb.models}" id="building_table" var="bean" stateAttr="restore"
			totalCount="${pgb.totalCount}">
			<jmesa:htmlTable width="600" caption="Buildings">
				<jmesa:htmlRow uniqueProperty="id">
					<jmesa:htmlColumn property="id" />
					<jmesa:htmlColumn sortable="false" property="bid" />
					<jmesa:htmlColumn property="stageId" title="Stage">
						<s:url var="u" action="admin/data/viewState.action" namespace="/">
							<s:param name="id">${bean.stageId}</s:param>
						</s:url>
						<input type="button" value="${bean.stageId }" onclick="showDialog('${u}')" />
					</jmesa:htmlColumn>
					<jmesa:htmlColumn property="buildingNumber" />
					<jmesa:htmlColumn property="finishDate" />
					<jmesa:htmlColumn property="floorCount" />
					<jmesa:htmlColumn property="orientation" />
					<jmesa:htmlColumn property="readyHouse" />
					<jmesa:htmlColumn property="sold" />
					<jmesa:htmlColumn property="soldOut" />
					<jmesa:htmlColumn property="enabled" />
					<jmesa:htmlColumn sortable="false" title="Operation">
						<s:url var="e" action="admin/data/editBuilding.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Edit" onclick="showDialog('${e}')" />
						<!-- 
						<s:url var="r" action="admin/data/removeBuilding.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Remove" onclick="showDialog('${r}')" />
						-->
						
						<c:if test="${!bean.enabled }">
						<s:url var="r" action="admin/data/enableBuilding.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Enable" onclick="showModalDialog('${r}')" />
						</c:if>
						<c:if test="${bean.enabled }">
						<s:url var="r" action="admin/data/disableBuilding.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Disable" onclick="showModalDialog('${r}')" />
						</c:if>
						<sec:authorize url="/admin/data/removeBuilding.action">
						<s:url var="r" action="admin/data/removeBuilding.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Remove" onclick="showModalDialog('${r}')" />
						</sec:authorize>
					</jmesa:htmlColumn>
				</jmesa:htmlRow>
			</jmesa:htmlTable>
		</jmesa:struts2TableModel>
	</form>
	<script type="text/javascript">
		function onInvokeAction(id) {
			$.jmesa.setExportToLimit(id, '');
			$.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
		}
	</script>
</body>
</html>