<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit ClientPreference ID:${model.id}</title>
</head>
<body>
	<s:form action="saveClientPreference.action" method="post" > 
		<s:hidden name="model.id"></s:hidden>
		<s:label name="model.id" label="ID"/>
		<s:textfield name="model.username" label="Username" />
		<s:select name="model.currentEmployee.id" list="paramEmployees" listKey="id" listValue="username" label="Current Sale"/>
		<tr>
			<td class="tdLabel"><label>Gender: </label></td>
			<td >
				<select name="model.gender">
					<c:forEach items="${paramGenders }" var="s">
						<option value="${s }" <c:if test="${model.gender eq s}">selected="selected"</c:if>>${s }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td class="tdLabel"><label>Title: </label></td>
			<td >
				<select name="model.title">
					<c:forEach items="${paramTitles }" var="s">
						<option value="${s }" <c:if test="${model.title eq s}">selected="selected"</c:if>>${s }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td class="tdLabel"><label>Status: </label></td>
			<td >
				<select name="model.status">
					<c:forEach items="${paramStatus }" var="s">
						<option value="${s }" <c:if test="${model.status eq s}">selected="selected"</c:if>>${s }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<s:textfield name="model.surname" label="surname" />
		<s:textfield name="model.givenName" label="givenName" />
		<s:textfield name="model.preferredName" label="preferredName" />
		<s:textfield name="model.mobileNumber" label="mobileNumber" />
		<s:textfield name="model.homeAddress" label="homeAddress" />
		<s:textfield name="model.homePostcode" label="homePostcode" />
		<s:textfield name="model.email" label="email" />
		<tr>
			<td class="tdLabel"><label>Status: </label></td>
			<td style="vertical-align:top;"><s:checkbox name="model.purchaseTypeFirst" theme="simple"/>First 
			<s:checkbox name="model.purchaseTypeOwner" theme="simple"/>Owner 
			<s:checkbox name="model.purchaseTypeInverstor" theme="simple"/>Inverstor 
			<s:checkbox name="model.purchaseTypeStudent" theme="simple"/>Student 
			<s:checkbox name="model.purchaseTypeOther" theme="simple"/>Other 
			</td>
		</tr>
		<s:textarea name="model.description" label="Description" labelposition="left" cols="40"></s:textarea>
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