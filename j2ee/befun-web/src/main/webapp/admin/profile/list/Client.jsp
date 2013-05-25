<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="jmesa" uri="http://code.google.com/p/jmesa"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Clients</title>
<script>
	function initPage(){
		$( "#genderCombobox" ).combobox();
		$( "#saleCombobox" ).combobox();
		$( "#enabledCombobox" ).combobox();
	}
</script>
</head>
<body>
	<form action="" method="post">
		<table width="1000">
			<tr>
				<td width="50"><label>Username: </label></td>
				<td width="200"><input type="text" name="qc.username" value="${qc.username }"/></td>
				<td width="50"><label>Gender: </label></td>
				<td width="200">
					<select id="genderCombobox" name="qc.gender">
						<option value="">Select Gender</option>
						<c:forEach items="${paramGenders }" var="s">
							<option value="${s }" <c:if test="${qc.gender eq s}">selected="selected"</c:if>>${s }</option>
						</c:forEach>
					</select>
				</td>
				<td width="50"><label>Sale: </label></td>
				<td width="200">
					<select id="saleCombobox" name="qc.currentEmployeeId">
						<option value="" <c:if test="${empty qc.currentEmployeeId}">selected="selected"</c:if>>Select Sale</option>
						<c:forEach items="${paramEmployees }" var="a">
							<option value="${a.id }" <c:if test="${qc.currentEmployeeId eq a.id}">selected="selected"</c:if>>${a.username }</option>
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
			</tr>
			<tr>
				<td align="right" colspan="10"><input id="queryButton" type="button" value="Query" onclick="jQuery.jmesa.removeAllFiltersFromLimit('Client_table');onInvokeAction('Client_table','clear')" /></td>
			</tr>
		</table>
		<input type="hidden" name="tableName" value="Client_table" />
		<jmesa:struts2TableModel items="${pgb.models}" id="Client_table" var="bean" stateAttr="restore"
			totalCount="${pgb.totalCount}">
			<jmesa:htmlTable width="600" caption="Clients">
				<jmesa:htmlRow uniqueProperty="id">
					<jmesa:htmlColumn property="id" />
					<jmesa:htmlColumn property="username" />
					<jmesa:htmlColumn property="gender" />
					<jmesa:htmlColumn property="surname" />
					<jmesa:htmlColumn property="givenName" />
					<jmesa:htmlColumn property="preferredName" />
					<jmesa:htmlColumn property="Reference" title="Reference">
						<c:if test="${not empty bean.preference.id }">
						<s:url var="u" action="admin/profile/viewClientPreference.action" namespace="/">
							<s:param name="id">${bean.preference.id}</s:param>
						</s:url>
						<input type="button" value="Preference" onclick="showDialog('${u}')" />
						</c:if>
						
						<s:url var="u" action="admin/profile/demandClientRequirement.action" namespace="/">
							<s:param name="qc.clientId">${bean.id}</s:param>
						</s:url>
						<a href="${u}" target="_blank">Requirements</a>
						
						<s:url var="u" action="admin/profile/createPageClientRequirement.action" namespace="/">
							<s:param name="model.client.id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Create Req" onclick="showDialog('${u}')" />
					</jmesa:htmlColumn>
					<jmesa:htmlColumn property="currentEmployee.id" title="Current Sale" >
						<s:url var="u" action="admin/profile/viewEmployee.action" namespace="/">
							<s:param name="id">${bean.currentEmployee.id}</s:param>
						</s:url>
						<input type="button" value="${bean.currentEmployee.username }" onclick="showDialog('${u}')" />
					</jmesa:htmlColumn>
					<jmesa:htmlColumn sortable="false" title="Operation">
						<s:url var="e" action="admin/profile/editClient.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Edit" onclick="showDialog('${e}')" />
						
						<c:if test="${!bean.enabled }">
						<s:url var="r" action="admin/profile/enableEmployee.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Enable" onclick="showModalDialog('${r}')" />
						</c:if>
						<c:if test="${bean.enabled }">
						<s:url var="r" action="admin/profile/disableEmployee.action" namespace="/">
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