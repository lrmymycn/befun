<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Employee ID:${model.id},Name:${model.username}</title>
</head>
<body>
	<s:form action="saveEmployee.action" method="post">
		<s:hidden name="model.id"></s:hidden>
		<s:label name="model.id" label="ID"></s:label>
		<s:textfield name="model.username" label="username"></s:textfield>
		<s:password name="model.password" label="password"></s:password>
		<s:password name="repeatPassword" label="repeatPassword"></s:password>
		<tr>
			<td ><label>Gender: </label></td>
			<td >
				<select name="model.gender">
					<c:forEach items="${paramGenders }" var="s">
						<option value="${s }" <c:if test="${model.gender eq s}">selected="selected"</c:if>>${s }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<s:textfield name="model.surname" label="surname"></s:textfield>
		<s:textfield name="model.givenName" label="givenName"></s:textfield>
		<s:textfield name="model.preferredName" label="preferredName"></s:textfield>
		<s:textfield name="model.mobileNumber" label="mobileNumber"></s:textfield>
		<s:textfield name="model.homeAddress" label="homeAddress"></s:textfield>
		<s:textfield name="model.homePostcode" label="homePostcode"></s:textfield>
		<s:textfield name="model.email" label="email"></s:textfield>
		<s:textfield name="model.title" label="title"></s:textfield>
		<s:textfield name="model.rank" label="rank"></s:textfield>
		<s:textfield name="model.employeeNumber" label="employeeNumber"></s:textfield>
		<s:textfield name="model.abn" label="abn"></s:textfield>
		<s:textfield name="model.gst" label="gst"></s:textfield>
		<s:checkbox name="model.enabled" label="enabled" labelposition="left"></s:checkbox>
		<s:checkbox name="model.expired" label="expired" labelposition="left"></s:checkbox>
		<s:checkbox name="model.credentialsExpired" label="credentialsExpired" labelposition="left"></s:checkbox>
		<s:checkbox name="model.locked" label="locked" labelposition="left"></s:checkbox>
		<s:textarea name="model.description" label="Description" labelposition="left" cols="40"></s:textarea>
		<tr>
			<td colspan="2"><div align="right">
					<s:if test="editable">
						<input type="submit" value="Submit" />
						<input type="reset" value="Reset" />
					</s:if>
					<input type="button" value="Close" onclick="closeCurrentWindow();" />
				</div></td>
		</tr>
	</s:form>
</body>
</html>