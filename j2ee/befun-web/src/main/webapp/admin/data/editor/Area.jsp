<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Area ID:${view.id},LN:${view.name}</title>
</head>
<body>
	<s:form action="saveArea.action" method="post">
		<s:hidden name="view.id"></s:hidden>
		<s:label name="view.id" label="ID"></s:label>
		<s:label name="view.bid" label="BID"></s:label>
		<s:textfield name="view.name" label="Name"></s:textfield>
		<s:textfield name="view.longitude" label="Longitude"></s:textfield>
		<s:textfield name="view.latitude" label="Latitude"></s:textfield>
		<s:textarea name="view.description" label="Description" labelposition="left" cols="40"></s:textarea>
		<s:textarea name="view.polylines" label="Polylines" labelposition="left" cols="40"></s:textarea>
		<s:submit></s:submit>
		<s:reset></s:reset>
		<tr>
			<td colspan="2"><div align="right">
					<input type="button" value="Close" onclick="closeCurrentWindow();" />
				</div></td>
		</tr>
	</s:form>
</body>
</html>