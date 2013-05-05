<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="jmesa" uri="http://code.google.com/p/jmesa"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Apartments</title>
<script>
	function initPage(){
		$( "#areaCombobox" ).combobox();
		$( "#suburbCombobox" ).combobox();
		$( "#projectCombobox" ).combobox();
		$( "#stageCombobox" ).combobox();
		$( "#buildingCombobox" ).combobox();
		$( "#floorplanCombobox" ).combobox();
	}
</script>
</head>
<body>
	<form action="" method="post">
		<table width="1000">
			<tr><td width="50">
			<label>Area: </label></td>
			<td width="200">
			<select id="areaCombobox" name="qc.fpQC.bdQC.proQC.suburbQC.areaId" onChange="getSuburbByArea($('#areaCombobox'), $('#suburbCombobox'));">
				<option value="" <c:if test="${empty qc.fpQC.bdQC.proQC.suburbQC.areaId}">selected="selected"</c:if>>Select Area</option>
				<c:forEach items="${qcAreas }" var="a">
					<option value="${a.id }" <c:if test="${qc.fpQC.bdQC.proQC.suburbQC.areaId eq a.id}">selected="selected"</c:if>>${a.name }</option>
				</c:forEach>
			</select></td>
			<td width="50">
			<label>Suburb: </label></td>
			<td width="200">
			<select id="suburbCombobox" name="qc.fpQC.bdQC.proQC.suburbId" onChange="getProjectBySuburb($('#suburbCombobox'), $('#projectCombobox'));">
				<option value="" <c:if test="${empty qc.fpQC.bdQC.proQC.suburbId}">selected="selected"</c:if>>Select Suburb</option>
				<c:forEach items="${qcSuburbs }" var="s">
					<option value="${s.id }" <c:if test="${qc.fpQC.bdQC.proQC.suburbId eq s.id}">selected="selected"</c:if>>${s.name }</option>
				</c:forEach>
			</select></td>
			<td width="50">
			<label>Project: </label></td>
			<td width="200">
			<select id="projectCombobox" name="qc.fpQC.bdQC.projectId" onChange="getStageByProject($('#projectCombobox'), $('#stageCombobox'));">
				<option value="" <c:if test="${empty qc.fpQC.bdQC.projectId}">selected="selected"</c:if>>Select Project</option>
				<c:forEach items="${qcProjects }" var="s">
					<option value="${s.id }" <c:if test="${qc.fpQC.bdQC.projectId eq s.id}">selected="selected"</c:if>>${s.name }</option>
				</c:forEach>
			</select></td>
			<td width="50">
			<label>Stage: </label></td>
			<td width="200">
			<select id="stageCombobox" name="qc.fpQC.bdQC.stageId" onChange="getBuildingByStage($('#stageCombobox'), $('#buildingCombobox'));">
				<option value="" <c:if test="${empty qc.fpQC.bdQC.stageId}">selected="selected"</c:if>>Select Stage</option>
				<c:forEach items="${qcStages }" var="s">
					<option value="${s.id }" <c:if test="${qc.fpQC.bdQC.stageId eq s.id}">selected="selected"</c:if>>${s.name }</option>
				</c:forEach>
			</select></td></tr>
			<tr>
			<td width="50">
			<label>Building: </label></td>
			<td width="200">
			<select id="buildingCombobox" name="qc.fpQC.buildingId" onChange="getFloorplanByBuilding($('#buildingCombobox'), $('#floorplanCombobox'));">
				<option value="" <c:if test="${empty qc.fpQC.buildingId}">selected="selected"</c:if>>Select Building</option>
				<c:forEach items="${qcBuildings }" var="s">
					<option value="${s.id }" <c:if test="${qc.fpQC.buildingId eq s.id}">selected="selected"</c:if>>${s.buildingNumber }</option>
				</c:forEach>
			</select></td>
			<td width="50">
			<label>Floorplan: </label></td>
			<td width="200">
			<select id="floorplanCombobox" name="qc.floorplanId">
				<option value="" <c:if test="${empty qc.floorplanId}">selected="selected"</c:if>>Select Floorplan</option>
				<c:forEach items="${qcFloorplans }" var="s">
					<option value="${s.id }" <c:if test="${qc.floorplanId eq s.id}">selected="selected"</c:if>>${s.bedRoomCount }-${s.bathroomCount }-${s.totalSize }</option>
				</c:forEach>
			</select></td>
			<td width="50">
			<label>PentHouse: </label></td>
			<td width="200">
			<input name="qc.pentHouse" type="checkbox" value="true" <c:if test="${qc.pentHouse }"> checked="checked"</c:if>/>
			</td>
			<td align="right" colspan="10"><input type="submit" value="Query" /></td></tr>
		</table>
		<input type="hidden" name="tableName" value="apartment_table" />
		<jmesa:struts2TableModel items="${pgb.models}" id="apartment_table" var="bean" stateAttr="restore"
			totalCount="${pgb.totalCount}">
			<jmesa:htmlTable width="600" caption="Apartments">
				<jmesa:htmlRow uniqueProperty="id">
					<jmesa:htmlColumn property="id" />
					<jmesa:htmlColumn sortable="false" property="bid" />
					<jmesa:htmlColumn property="floorplanId" title="Floorplan">
						<s:url var="u" action="admin/data/viewFloorplan.action" namespace="/">
							<s:param name="id">${bean.floorplanId}</s:param>
						</s:url>
						<input type="button" value="${bean.floorplanId }" onclick="showDialog('${u}')" />
					</jmesa:htmlColumn>
					<jmesa:htmlColumn property="description" />
					<jmesa:htmlColumn property="lotNumber" />
					<jmesa:htmlColumn property="price" />
					<jmesa:htmlColumn property="creationDate" />
					<jmesa:htmlColumn property="soldOut" />
					<jmesa:htmlColumn property="enabled" />
					<jmesa:htmlColumn sortable="false" title="Operation">
						<s:url var="e" action="admin/data/editApartment.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Edit" onclick="showDialog('${e}')" />
						<!-- 
						<s:url var="r" action="admin/data/removeApartment.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Remove" onclick="showDialog('${r}')" />
						 -->
						<c:if test="${!bean.enabled }">
						<s:url var="r" action="admin/data/enableApartment.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Enable" onclick="showDialog('${r}')" />
						</c:if>
						<c:if test="${bean.enabled }">
						<s:url var="r" action="admin/data/disableApartment.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Disable" onclick="showDialog('${r}')" />
						</c:if>
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