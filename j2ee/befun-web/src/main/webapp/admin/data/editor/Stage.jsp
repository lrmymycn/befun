<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Stage ID:${view.id},LN:${view.name}</title>
<script>
	function initPage(){
		$( "#areaCombobox" ).combobox();
		$( "#suburbCombobox" ).combobox();
		$( "#projectCombobox" ).combobox();
	}
</script>
</head>
<body>
	<s:form action="saveStage.action" method="post">
		<s:hidden name="view.id"></s:hidden>
		<s:hidden name="view.bid"></s:hidden>
		<s:label name="view.id" label="ID"></s:label>
		<s:label name="view.bid" label="BID"></s:label>
		<tr><td class="tdLabel">
			<label>Area: </label></td>
			<td>
			<select id="areaCombobox" name="paramAreaId" onChange="getSuburbByArea($('#areaCombobox'), $('#suburbCombobox'));">
				<c:forEach items="${qcAreas }" var="a">
					<option value="${a.id }" <c:if test="${paramAreaId eq a.id}">selected="selected"</c:if>>${a.name }</option>
				</c:forEach>
			</select></td>
		</tr>
		<tr><td class="tdLabel">
			<label>Suburb: </label></td>
			<td>
			<select id="suburbCombobox" name="paramAreaId" onChange="getProjectBySuburb($('#suburbCombobox'), $('#projectCombobox'));">
				<c:forEach items="${qcSuburbs }" var="s">
					<option value="${s.id }" <c:if test="${paramAreaId eq s.id}">selected="selected"</c:if>>${s.name }</option>
				</c:forEach>
			</select></td>
		</tr>
		<tr><td class="tdLabel">
			<label>Project: </label></td>
			<td>
			<select id="projectCombobox" name="view.projectId">
				<c:forEach items="${qcProjects }" var="p">
					<option value="${p.id }" <c:if test="${view.projectId eq p.id}">selected="selected"</c:if>>${p.name }</option>
				</c:forEach>
			</select></td>
		</tr>
		<s:textfield name="view.name" label="name"></s:textfield>
		<s:textfield name="view.finishDate" label="finishDate"></s:textfield>
		<s:textfield name="view.sold" label="sold"></s:textfield>
		<s:checkbox name="view.soldOut" label="soldOut" labelposition="left"></s:checkbox>
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