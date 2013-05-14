<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="jmesa" uri="http://code.google.com/p/jmesa"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Employees</title>
<script>
	function initPage(){
		$( "#areaCombobox" ).combobox();
		$( "#genderCombobox" ).combobox();
		$( "#roleCodesCombobox" ).combobox();
		$( "#enabledCombobox" ).combobox();
		$( "#expiredCombobox" ).combobox();
		$( "#lockedCombobox" ).combobox();
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
				<td width="50"><label>Role: </label></td>
				<td width="200">
					<select id="roleCodesCombobox" name="qc.roleCodes">
						<option value="">Select Role</option>
						<c:forEach items="${paramRoles }" var="s">
							<option value="${s }">${s }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td width="50"><label>Enabled: </label></td>
				<td width="200">
				<select id="enabledCombobox" name="qc.enabled">
					<option value="null">All</option>
					<option value="true" <c:if test="${qc.enabled == true}">selected="selected"</c:if>>Enabled</option>
					<option value="false" <c:if test="${qc.enabled == false}">selected="selected"</c:if>>Disabled</option>
				</select>
				</td>
				<td width="50"><label>Expired: </label></td>
				<td width="200">
				<select id="expiredCombobox" name="qc.expired">
					<option value="null">All</option>
					<option value="true" <c:if test="${qc.expired == true}">selected="selected"</c:if>>Expired</option>
					<option value="false" <c:if test="${qc.expired == false}">selected="selected"</c:if>>UnExpired</option>
				</select>
				</td>
				<td width="50"><label>Locked: </label></td>
				<td width="200">
				<select id="lockedCombobox" name="qc.locked">
					<option value="null">All</option>
					<option value="true" <c:if test="${qc.locked == true}">selected="selected"</c:if>>Locked</option>
					<option value="false" <c:if test="${qc.locked == false}">selected="selected"</c:if>>Unlocked</option>
				</select>
				</td>
				<td align="right" colspan="10"><input id="queryButton" type="button" value="Query" onclick="jQuery.jmesa.removeAllFiltersFromLimit('Employee_table');onInvokeAction('Employee_table','clear')" /></td>
			</tr>
		</table>
		<input type="hidden" name="tableName" value="Employee_table" />
		<jmesa:struts2TableModel items="${pgb.models}" id="Employee_table" var="bean" stateAttr="restore"
			totalCount="${pgb.totalCount}">
			<jmesa:htmlTable width="600" caption="Employees">
				<jmesa:htmlRow uniqueProperty="id">
					<jmesa:htmlColumn property="id" />
					<jmesa:htmlColumn property="username" />
					<jmesa:htmlColumn property="gender" />
					<jmesa:htmlColumn property="surname" />
					<jmesa:htmlColumn property="givenName" />
					<jmesa:htmlColumn property="preferredName" />
					<jmesa:htmlColumn property="modification.creationDate" title="Creation"/>
					<jmesa:htmlColumn property="modification.lastModifiedDate" title="Last Modified"/>
					<jmesa:htmlColumn sortable="false" title="Operation">
						<s:url var="e" action="admin/profile/editEmployee.action" namespace="/">
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
						
						<!-- 
						<c:if test="${!bean.expired }">
						<s:url var="r" action="admin/profile/expireEmployee.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Expire" onclick="showModalDialog('${r}')" />
						</c:if>
						<c:if test="${bean.expired }">
						<s:url var="r" action="admin/profile/renewalEmployee.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Renewal" onclick="showModalDialog('${r}')" />
						</c:if>
						 -->
						<c:if test="${!bean.locked }">
						<s:url var="r" action="admin/profile/lockEmployee.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Lock" onclick="showModalDialog('${r}')" />
						</c:if>
						<c:if test="${bean.locked }">
						<s:url var="r" action="admin/profile/unlockEmployee.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Unlock" onclick="showModalDialog('${r}')" />
						</c:if>
						<s:url var="e" action="admin/profile/assignRolesPage.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Roles" onclick="showModalDialog('${e}')" />
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