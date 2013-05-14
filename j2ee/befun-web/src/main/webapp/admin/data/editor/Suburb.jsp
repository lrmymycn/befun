<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Suburb ID:${view.id},LN:${view.name}</title>
</head>
<body>
	<s:form action="saveSuburb.action" method="post">
		<s:hidden name="view.id"></s:hidden>
		<s:label name="view.id" label="ID"></s:label>
		<s:label name="view.bid" label="BID"></s:label>
		<s:select name="view.areaId" label="area" list="qcAreas" listKey="id" listValue="name"/>
		<s:textfield name="view.name" label="name"></s:textfield>
		<s:textfield name="view.postCode" label="postCode"></s:textfield>
		<s:textfield name="view.longitude" label="longitude"></s:textfield>
		<s:textfield name="view.latitude" label="latitude"></s:textfield>
		<s:textfield name="view.vacancyRate" label="vacancyRate"></s:textfield>
		<s:checkbox name="view.universities" label="universities" labelposition="left"></s:checkbox>
		<s:checkbox name="view.schools" label="schools" labelposition="left"></s:checkbox>
		<s:checkbox name="view.shoppingCenter" label="shoppingCenter" labelposition="left"></s:checkbox>
		<s:checkbox name="view.train" label="train" labelposition="left"></s:checkbox>
		<s:checkbox name="view.chineseCommunity" label="chineseCommunity" labelposition="left"></s:checkbox>
		<s:textarea name="view.description" label="Description" labelposition="left" cols="40"></s:textarea>
		<s:textarea name="view.polylinesString" label="Polylines" labelposition="left" cols="40" rows="8"></s:textarea>
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