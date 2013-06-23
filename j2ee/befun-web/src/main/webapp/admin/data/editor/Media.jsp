<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Media ID:${view.id},LN:${view.name}</title>
</head>
<body>
	<s:form action="saveMedia.action" method="post" enctype="multipart/form-data">
		<s:hidden name="view.id"></s:hidden>
		<s:hidden name="view.bid"></s:hidden>
		<s:label name="view.id" label="ID"></s:label>
		<s:label name="view.bid" label="BID"></s:label>
		<tr>
			<td class="tdLabel"><label>Project: </label></td>
			<td width="200">
			<select id="projectCombobox" name="view.projectId" onChange="getStageByProject($('#projectCombobox'), $('#stageCombobox'));">
				<c:forEach items="${qcProjects }" var="s">
					<option value="${s.id }" <c:if test="${view.projectId eq s.id}">selected="selected"</c:if>>${s.name }</option>
				</c:forEach>
			</select></td>
		</tr>
		<s:textfield name="view.name" label="name"></s:textfield>
		<s:file name="smallFile" label="Small Img"></s:file>
		<tr>
			<td class="tdLabel"><label>smallUrl:</label></td>
			<td><s:textfield name="view.smallUrl" theme="simple"/><c:if test="${not empty view.smallUrl }"><a href="${view.smallUrl }" target="blank">small</a></c:if></td>
		</tr>
		<s:file name="mediumFile" label="Medium Img"></s:file>
		<tr>
			<td class="tdLabel"><label>mediumUrl:</label></td>
			<td><s:textfield name="view.mediumUrl" theme="simple"/><c:if test="${not empty view.mediumUrl }"><a href="${view.mediumUrl }" target="blank">medium</a></c:if></td>
		</tr>
		<s:file name="largeFile" label="Large Img"></s:file>
		<tr>
			<td class="tdLabel"><label>largeUrl:</label></td>
			<td><s:textfield name="view.largeUrl" theme="simple"/><c:if test="${not empty view.largeUrl }"><a href="${view.largeUrl }" target="blank">large</a></c:if></td>
		</tr>
		<s:textfield name="view.alt" label="alt"></s:textfield>
		<s:select name="view.mediaType" list="mediaTypes" />
		<s:select name="view.contentType" list="contentTypes" />
		<s:textarea name="view.description" label="Description" labelposition="left" cols="40"></s:textarea>
		<tr>
			<td colspan="2"><div align="right">
				<s:if test="editable">
					<s:submit theme="simple"/>
					<s:reset theme="simple"/>
				</s:if>
				<input type="button" value="Close" onclick="closeCurrentWindow();" />
			</div></td>
		</tr>
	</s:form>
</body>
</html>