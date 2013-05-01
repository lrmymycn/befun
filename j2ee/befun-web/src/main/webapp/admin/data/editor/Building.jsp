<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Building ID:${view.id},LN:${view.buildingNumber}</title>
</head>
<body>
	<s:form action="saveBuilding.action" method="post">
		<s:hidden name="view.id"></s:hidden>
		<s:hidden name="view.bid"></s:hidden>
		<s:label name="view.id" label="ID"></s:label>
		<s:label name="view.bid" label="BID"></s:label>
		<s:textfield name="view.stageId" label="Stage"></s:textfield>
		<s:textfield name="view.buildingNumber" label="buildingNumber"></s:textfield>
		<s:textfield name="view.finishDate" label="finishDate"></s:textfield>
		<s:textfield name="view.floorCount" label="floorCount"></s:textfield>
		<s:textfield name="view.orientation" label="orientation"></s:textfield>
		<s:checkbox name="view.readyHouse" label="Ready House"></s:checkbox>
		<s:textarea name="view.description" label="Description" labelposition="left" cols="40"></s:textarea>
		<s:textfield name="view.sold" label="sold"></s:textfield>
		<s:checkbox name="view.soldOut" label="soldOut" labelposition="left"></s:checkbox>
		<s:if test="editable">
			<s:submit></s:submit>
			<s:reset></s:reset>
		</s:if>
		<tr>
			<td colspan="2"><div align="right">
					<input type="button" value="Close" onclick="closeCurrentWindow();" />
				</div></td>
		</tr>
	</s:form>
</body>
</html>