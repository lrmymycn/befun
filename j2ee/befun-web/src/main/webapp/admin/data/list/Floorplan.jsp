<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="jmesa" uri="http://code.google.com/p/jmesa"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Floorplans</title>
<script>
	function initPage(){
		$( "#areaCombobox" ).combobox();
		$( "#suburbCombobox" ).combobox();
		$( "#projectCombobox" ).combobox();
		$( "#stageCombobox" ).combobox();
		$( "#buildingCombobox" ).combobox();
		$( "#floorplanTypeCombobox" ).combobox();
		$( "#splitCombobox" ).combobox();
		$( "#enabledCombobox" ).combobox();
	}
</script>
</head>
<body>
	<form action="" method="post">
		<table width="1000">
			<tr><td width="50">
			<label>Area: </label></td>
			<td width="200">
			<select id="areaCombobox" name="qc.bdQC.proQC.suburbQC.areaId" onChange="getSuburbByArea($('#areaCombobox'), $('#suburbCombobox'));">
				<option value="" <c:if test="${empty qc.bdQC.proQC.suburbQC.areaId}">selected="selected"</c:if>>Select Area</option>
				<c:forEach items="${qcAreas }" var="a">
					<option value="${a.id }" <c:if test="${qc.bdQC.proQC.suburbQC.areaId eq a.id}">selected="selected"</c:if>>${a.name }</option>
				</c:forEach>
			</select></td>
			<td width="50">
			<label>Suburb: </label></td>
			<td width="200">
			<select id="suburbCombobox" name="qc.bdQC.proQC.suburbId" onChange="getProjectBySuburb($('#suburbCombobox'), $('#projectCombobox'));">
				<option value="" <c:if test="${empty qc.bdQC.proQC.suburbId}">selected="selected"</c:if>>Select Suburb</option>
				<c:forEach items="${qcSuburbs }" var="s">
					<option value="${s.id }" <c:if test="${qc.bdQC.proQC.suburbId eq s.id}">selected="selected"</c:if>>${s.name }</option>
				</c:forEach>
			</select></td>
			<td width="50">
			<label>Project: </label></td>
			<td width="200">
			<select id="projectCombobox" name="qc.bdQC.projectId" onChange="getStageByProject($('#projectCombobox'), $('#stageCombobox'));">
				<option value="" <c:if test="${empty qc.bdQC.projectId}">selected="selected"</c:if>>Select Project</option>
				<c:forEach items="${qcProjects }" var="s">
					<option value="${s.id }" <c:if test="${qc.bdQC.projectId eq s.id}">selected="selected"</c:if>>${s.name }</option>
				</c:forEach>
			</select></td>
			<td width="50">
			<label>Stage: </label></td>
			<td width="200">
			<select id="stageCombobox" name="qc.bdQC.stageId" onChange="getBuildingByStage($('#stageCombobox'), $('#buildingCombobox'));">
				<option value="" <c:if test="${empty qc.bdQC.stageId}">selected="selected"</c:if>>Select Stage</option>
				<c:forEach items="${qcStages }" var="s">
					<option value="${s.id }" <c:if test="${qc.bdQC.stageId eq s.id}">selected="selected"</c:if>>${s.name }</option>
				</c:forEach>
			</select></td></tr>
			<tr>
			<td width="50">
			<label>Building: </label></td>
			<td width="200">
			<select id="buildingCombobox" name="qc.buildingId">
				<option value="" <c:if test="${empty qc.buildingId}">selected="selected"</c:if>>Select Building</option>
				<c:forEach items="${qcBuildings }" var="s">
					<option value="${s.id }" <c:if test="${qc.buildingId eq s.id}">selected="selected"</c:if>>${s.buildingNumber }</option>
				</c:forEach>
			</select></td>
			<td width="50">
			<label>Type: </label></td>
			<td width="200">
			<select id="floorplanTypeCombobox" name="qc.floorplanType">
				<option value="" <c:if test="${empty qc.floorplanType}">selected="selected"</c:if>>Select Type</option>
				<c:forEach items="${floorplanTypes }" var="s">
					<option value="${s }" <c:if test="${qc.floorplanType eq s}">selected="selected"</c:if>>${s }</option>
				</c:forEach>
			</select>
			</td>
			<td width="50">
			<label>Split: </label></td>
			<td width="200">
			<select id="splitCombobox" name="qc.split">
				<option value="null">All</option>
				<option value="true" <c:if test="${qc.split == true}">selected="selected"</c:if>>Is</option>
				<option value="false" <c:if test="${qc.split == false}">selected="selected"</c:if>>Not</option>
			</select>
			</td>
			<td width="50">
			<label>Enabled: </label></td>
			<td width="200">
			<select id="enabledCombobox" name="qc.enabled">
				<option value="null">All</option>
				<option value="true" <c:if test="${qc.enabled == true}">selected="selected"</c:if>>Enabled</option>
				<option value="false" <c:if test="${qc.enabled == false}">selected="selected"</c:if>>Disabled</option>
			</select>
			</td>
			</tr>
			<tr><td align="right" colspan="10"><input id="queryButton" type="button" value="Query" onclick="jQuery.jmesa.removeAllFiltersFromLimit('floorplan_table');onInvokeAction('floorplan_table','clear')" /></td></tr>
		</table>
		<input type="hidden" name="tableName" value="floorplan_table" />
		<jmesa:struts2TableModel items="${pgb.models}" id="floorplan_table" var="bean" stateAttr="restore"
			totalCount="${pgb.totalCount}">
			<jmesa:htmlTable width="600" caption="Floorplans">
				<jmesa:htmlRow uniqueProperty="id">
					<jmesa:htmlColumn property="id" />
					<jmesa:htmlColumn sortable="false" property="bid" />
					<jmesa:htmlColumn property="buildingId" title="Building">
						<s:url var="u" action="admin/data/viewBuilding.action" namespace="/">
							<s:param name="id">${bean.buildingId}</s:param>
						</s:url>
						<input type="button" value="${bean.buildingNum }" onclick="showDialog('${u}')" />
					</jmesa:htmlColumn>
					<jmesa:htmlColumn sortable="false" property="publicPictureId" title="Public Picture">
						<s:url var="u" action="admin/data/editMedia.action" namespace="/">
							<s:param name="id">${bean.publicPictureId}</s:param>
						</s:url>
						<input type="button" value="${bean.publicPictureId }" onclick="showDialog('${u}')" />
					</jmesa:htmlColumn>
					<jmesa:htmlColumn sortable="false" property="salePictureId" title="Sale Picture">
						<s:url var="u" action="admin/data/editMedia.action" namespace="/">
							<s:param name="id">${bean.salePictureId}</s:param>
						</s:url>
						<input type="button" value="${bean.salePictureId }" onclick="showDialog('${u}')" />
					</jmesa:htmlColumn>
					<jmesa:htmlColumn property="type" />
					<jmesa:htmlColumn property="split" />
					<jmesa:htmlColumn property="studio" />
					<jmesa:htmlColumn property="bedRoomCount" />
					<jmesa:htmlColumn property="bathroomCount" />
					<jmesa:htmlColumn property="studyroomCount" />
					<jmesa:htmlColumn property="internalSize" />
					<jmesa:htmlColumn property="externalSize" />
					<jmesa:htmlColumn property="totalSize" />
					<jmesa:htmlColumn property="landSize" />
					<jmesa:htmlColumn property="sold" />
					<jmesa:htmlColumn property="soldOut" />
					<jmesa:htmlColumn property="enabled" />
					<jmesa:htmlColumn sortable="false" title="Operation">
						<s:url var="e" action="admin/data/editFloorplan.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Edit" onclick="showDialog('${e}')" />
						<!-- 
						<s:url var="r" action="admin/data/removeFloorplan.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Remove" onclick="showDialog('${r}')" />
						-->
						
						<c:if test="${!bean.enabled }">
						<s:url var="r" action="admin/data/enableFloorplan.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Enable" onclick="showModalDialog('${r}')" />
						</c:if>
						<c:if test="${bean.enabled }">
						<s:url var="r" action="admin/data/disableFloorplan.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Disable" onclick="showModalDialog('${r}')" />
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