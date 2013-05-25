<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="jmesa" uri="http://code.google.com/p/jmesa"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>ClientRequirements</title>
<script>
	function initPage(){
		$( "#clientCombobox" ).combobox();
	}
</script>
</head>
<body>
	<form action="" method="post">
		<table width="1000">
			<tr>
				<td width="50"><label>Client: </label></td>
				<td width="200">
					<select id="clientCombobox" name="qc.clientId">
						<option value="" <c:if test="${empty qc.clientId}">selected="selected"</c:if>>Select Client</option>
						<c:forEach items="${paramClients }" var="a">
							<option value="${a.id }" <c:if test="${qc.clientId eq a.id}">selected="selected"</c:if>>${a.username }</option>
						</c:forEach>
					</select>
				</td>
				<td align="right" colspan="10"><input id="queryButton" type="button" value="Query" onclick="jQuery.jmesa.removeAllFiltersFromLimit('ClientRequirement_table');onInvokeAction('ClientRequirement_table','clear')" /></td>
			</tr>
		</table>
		<input type="hidden" name="tableName" value="ClientRequirement_table" />
		<jmesa:struts2TableModel items="${pgb.models}" id="ClientRequirement_table" var="bean" stateAttr="restore"
			totalCount="${pgb.totalCount}">
			<jmesa:htmlTable width="600" caption="ClientRequirements">
				<jmesa:htmlRow uniqueProperty="id">
					<jmesa:htmlColumn property="id" />
					<jmesa:htmlColumn property="client.id" title="Client" >
						<s:url var="u" action="admin/profile/viewClient.action" namespace="/">
							<s:param name="id">${bean.client.id}</s:param>
						</s:url>
						<input type="button" value="${bean.client.username }" onclick="showDialog('${u}')" />
					</jmesa:htmlColumn>
					<jmesa:htmlColumn property="minPrice" />
					<jmesa:htmlColumn property="maxPrice" />
					<jmesa:htmlColumn property="pentHouse" />
					<jmesa:htmlColumn property="bedRoomCountStr" />
					<jmesa:htmlColumn property="bathRoomCountStr" />
					<jmesa:htmlColumn property="studyroomCountStr" />
					<jmesa:htmlColumn property="courtyardCountStr" />
					<jmesa:htmlColumn property="enclosedBaclonyCountStr" />
					<jmesa:htmlColumn property="distanceToCity" />
					<jmesa:htmlColumn property="universities" />
					<jmesa:htmlColumn property="schools" />
					<jmesa:htmlColumn sortable="false" title="Operation">
						<s:url var="e" action="admin/profile/editClientRequirement.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Edit" onclick="showDialog('${e}')" />
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