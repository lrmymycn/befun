<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="jmesa" uri="http://code.google.com/p/jmesa"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<title>Projects</title>
<script>
	function initPage(){
		$( "#areaCombobox" ).combobox();
		$( "#suburbCombobox" ).combobox();
		$( "#enabledCombobox" ).combobox();
	}
</script>
</head>
<body>
	<form action="" method="post">
		<table width="1000">
			<tr><td width="50"><label>Area: </label></td>
			<td width="200">
			<select id="areaCombobox" name="qc.suburbQC.areaId" onChange="getSuburbByArea($('#areaCombobox'), $('#suburbCombobox'));">
				<option value="" <c:if test="${empty qc.suburbQC.areaId}">selected="selected"</c:if>>Select Area</option>
				<c:forEach items="${qcAreas }" var="a">
					<option value="${a.id }" <c:if test="${qc.suburbQC.areaId eq a.id}">selected="selected"</c:if>>${a.name }</option>
				</c:forEach>
			</select></td>
			<td width="50"><label>Suburb: </label></td>
			<td width="200">
			<select id="suburbCombobox" name="qc.suburbId">
				<option value="" <c:if test="${empty qc.suburbId}">selected="selected"</c:if>>Select Suburb</option>
				<c:forEach items="${qcSuburbs }" var="s">
					<option value="${s.id }" <c:if test="${qc.suburbId eq s.id}">selected="selected"</c:if>>${s.name }</option>
				</c:forEach>
			</select></td>
			<td width="50"><label>Enabled: </label></td>
			<td width="200">
			<select id="enabledCombobox" name="qc.enabled">
				<option value="null">All</option>
				<option value="true" <c:if test="${qc.enabled == true}">selected="selected"</c:if>>Enabled</option>
				<option value="false" <c:if test="${qc.enabled == false}">selected="selected"</c:if>>Disabled</option>
			</select>
			</td>
			<td align="right" colspan="10"><input id="queryButton" type="button" value="Query" onclick="jQuery.jmesa.removeAllFiltersFromLimit('project_table');onInvokeAction('project_table','clear')" /></td></tr>
		</table>
		<input type="hidden" name="tableName" value="project_table" />
		<jmesa:struts2TableModel items="${pgb.models}" id="project_table" var="bean" stateAttr="restore"
			totalCount="${pgb.totalCount}">
			<jmesa:htmlTable width="600" caption="Projects">
				<jmesa:htmlRow uniqueProperty="id">
					<jmesa:htmlColumn property="id" />
					<jmesa:htmlColumn sortable="false" property="bid" />
					<jmesa:htmlColumn property="suburbId" title="Suburb">
						<s:url var="u" action="admin/data/viewSuburb.action" namespace="/">
							<s:param name="id">${bean.suburbId}</s:param>
						</s:url>
						<input type="button" value="${bean.suburbName }" onclick="showDialog('${u}')" />
					</jmesa:htmlColumn>
					<jmesa:htmlColumn property="name" />
					<jmesa:htmlColumn property="block" />
					<jmesa:htmlColumn sortable="false" property="logoId" title="Logo">
						<s:url var="u" action="admin/data/viewMedia.action" namespace="/">
							<s:param name="id">${bean.logoId}</s:param>
						</s:url>
						<input type="button" value="${bean.logoId }" onclick="showDialog('${u}')" />
					</jmesa:htmlColumn>
					<jmesa:htmlColumn property="postCode" />
					<jmesa:htmlColumn property="siteUrl"  >
						<a href="${bean.siteUrl }">Web Site</a>
					</jmesa:htmlColumn>
					<jmesa:htmlColumn property="sold" />
					<jmesa:htmlColumn property="soldOut" />
					<jmesa:htmlColumn property="enabled" />
					<jmesa:htmlColumn sortable="false" title="Operation">
						<s:url var="e" action="admin/data/editProject.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Edit" onclick="showDialog('${e}',700,450)" />
						
						<!-- 
						<s:url var="r" action="admin/data/removeProject.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Remove" onclick="showDialog('${r}')" />
						-->
						
						<c:if test="${!bean.enabled }">
						<s:url var="r" action="admin/data/enableProject.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Enable" onclick="showModalDialog('${r}')" />
						</c:if>
						<c:if test="${bean.enabled }">
						<s:url var="r" action="admin/data/disableProject.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Disable" onclick="showModalDialog('${r}')" />
						</c:if>
						<sec:authorize url="/admin/data/removeProject.action">
						<s:url var="r" action="admin/data/removeProject.action" namespace="/">
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