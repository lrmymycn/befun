<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="jmesa" uri="http://code.google.com/p/jmesa"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Medias</title>
<script>
	function initPage(){
		$( "#projectCombobox" ).combobox();
		$( "#mediaTypeCombobox" ).combobox();
		$( "#contentTypeCombobox" ).combobox();
		$( "#enabledCombobox" ).combobox();
	}
</script>
</head>
<body>
	<form name="mediaForm" action="" method="post">
		<table width="1000">
			<tr>
			<td width="50"><label>Project: </label></td>
			<td width="200">
			<select id="projectCombobox" name="qc.projectId">
				<option value="" <c:if test="${empty qc.projectId}">selected="selected"</c:if>>Select Project</option>
				<c:forEach items="${qcProjects }" var="s">
					<option value="${s.id }" <c:if test="${qc.projectId eq s.id}">selected="selected"</c:if>>${s.name }</option>
				</c:forEach>
			</select></td>
			<td width="50"><label>Media Type: </label></td>
			<td width="200">
			<select id="mediaTypeCombobox" name="qc.mediaType">
				<option value="" <c:if test="${empty qc.mediaType}">selected="selected"</c:if>>Select Media Type</option>
				<c:forEach items="${mediaTypes }" var="s">
					<option value="${s }" <c:if test="${qc.mediaType eq s}">selected="selected"</c:if>>${s }</option>
				</c:forEach>
			</select></td>
			<td width="50"><label>Content Type: </label></td>
			<td width="200">
			<select id="contentTypeCombobox" name="qc.contentType">
				<option value="" <c:if test="${empty qc.contentType}">selected="selected"</c:if>>Select Content Type</option>
				<c:forEach items="${contentTypes }" var="s">
					<option value="${s }" <c:if test="${qc.contentType eq s}">selected="selected"</c:if>>${s }</option>
				</c:forEach>
			</select></td>
			<td width="50"><label>Key: </label></td>
			<td width="200">
			<input name="qc.key" type="text" value="${qc.key }"/>
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
			<td align="right" colspan="10"><input id="queryButton" type="button" value="Query" onclick="jQuery.jmesa.removeAllFiltersFromLimit('media_table');onInvokeAction('media_table','clear')" /></td></tr>
		</table>
		<input type="hidden" name="tableName" value="media_table" />
		<jmesa:struts2TableModel items="${pgb.models}" id="media_table" var="bean" stateAttr="restore"
			totalCount="${pgb.totalCount}">
			<jmesa:htmlTable width="600" caption="Suburbs">
				<jmesa:htmlRow uniqueProperty="id">
					<jmesa:htmlColumn property="id" />
					<jmesa:htmlColumn sortable="false" property="bid" />
					<jmesa:htmlColumn property="projectId" title="Project">
						<s:url var="u" action="admin/data/viewProject.action" namespace="/">
							<s:param name="id">${bean.projectId}</s:param>
						</s:url>
						<input type="button" value="${bean.projectId }" onclick="showDialog('${u}')" />
					</jmesa:htmlColumn>
					<jmesa:htmlColumn property="name" width="200"/>
					<jmesa:htmlColumn sortable="false" property="smallUrl"  >
						<a href="${bean.smallUrl }">small</a>
					</jmesa:htmlColumn>
					<jmesa:htmlColumn sortable="false" property="mediumUrl" >
						<a href="${bean.mediumUrl }">medium</a>
					</jmesa:htmlColumn>
					<jmesa:htmlColumn sortable="false" property="largeUrl" >
						<a href="${bean.largeUrl }">large</a>
					</jmesa:htmlColumn>
					<jmesa:htmlColumn property="mediaType" />
					<jmesa:htmlColumn property="contentType" />
					<jmesa:htmlColumn property="enabled" />
					<jmesa:htmlColumn sortable="false" title="Operation">
						<s:url var="e" action="admin/data/editMedia.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Edit" onclick="showDialog('${e}')" />
						
						<!-- 
						<s:url var="r" action="admin/data/removeMedia.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Remove" onclick="showDialog('${r}')" />
						-->
						
						<c:if test="${!bean.enabled }">
						<s:url var="r" action="admin/data/enableMedia.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Enable" onclick="showModalDialog('${r}')" />
						</c:if>
						<c:if test="${bean.enabled }">
						<s:url var="r" action="admin/data/disableMedia.action" namespace="/">
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