<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="jmesa" uri="http://code.google.com/p/jmesa"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Suburbs</title>
<script>
	function initPage(){
		$( "#areaCombobox" ).combobox();
		$( "#enabledCombobox" ).combobox();
		/*
		$( "#areaToggle" ).click(function() {
			$( "#areaCombobox" ).toggle();
		});*/
	}
</script>
</head>
<body>
	<form action="" method="post">
		<table width="1000">
			<tr><td width="50"><label>Area: </label></td>
			<td width="200">
			<select id="areaCombobox" name="qc.areaId">
				<option value="" <c:if test="${empty qc.areaId}">selected="selected"</c:if>>Select Area</option>
				<c:forEach items="${qcAreas }" var="a">
					<option value="${a.id }" <c:if test="${qc.areaId eq a.id}">selected="selected"</c:if>>${a.name }</option>
				</c:forEach>
			</select>
			</td>
			<td width="50"><label>Enabled: </label></td>
			<td width="200">
			<select id="enabledCombobox" name="qc.enabled">
				<option value="null">All</option>
				<option value="true" <c:if test="${qc.enabled == true}">selected="selected"</c:if>>Enabled</option>
				<option value="false" <c:if test="${qc.enabled == false}">selected="selected"</c:if>>Disabled</option>
			</select>
			</td>
			<td align="right" colspan="10"><input id="queryButton" type="button" value="Query" onclick="jQuery.jmesa.removeAllFiltersFromLimit('suburb_table');onInvokeAction('suburb_table','clear')" /></td></tr>
		</table>
		<input type="hidden" name="tableName" value="suburb_table" />
		<jmesa:struts2TableModel items="${pgb.models}" id="suburb_table" var="bean" stateAttr="restore"
			totalCount="${pgb.totalCount}">
			<jmesa:htmlTable width="600" caption="Suburbs">
				<jmesa:htmlRow uniqueProperty="id">
					<jmesa:htmlColumn property="id" />
					<jmesa:htmlColumn sortable="false" property="bid" />
					<jmesa:htmlColumn sortable="false" property="areaId" title="Area">
						<s:url var="u" action="admin/data/viewArea.action" namespace="/">
							<s:param name="id">${bean.areaId}</s:param>
						</s:url>
						<input type="button" value="${bean.areaName }" onclick="showDialog('${u}')" />
					</jmesa:htmlColumn>
					<jmesa:htmlColumn property="name" />
					<jmesa:htmlColumn property="postCode" />
					<jmesa:htmlColumn property="universities" />
					<jmesa:htmlColumn property="schools" />
					<jmesa:htmlColumn property="shoppingCenter" />
					<jmesa:htmlColumn property="train" />
					<jmesa:htmlColumn property="chineseCommunity" />
					<jmesa:htmlColumn property="enabled" />
					<jmesa:htmlColumn sortable="false" title="Operation">
						<s:url var="e" action="admin/data/editSuburb.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Edit" onclick="showDialog('${e}')" />
						<!-- 
						<s:url var="r" action="admin/data/removeSuburb.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Remove" onclick="showDialog('${r}')" />
						-->
						
						<c:if test="${!bean.enabled }">
						<s:url var="r" action="admin/data/enableSuburb.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Enable" onclick="showModalDialog('${r}')" />
						</c:if>
						<c:if test="${bean.enabled }">
						<s:url var="r" action="admin/data/disableSuburb.action" namespace="/">
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