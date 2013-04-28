<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Floorplan ID:${view.id},LN:${view.description}</title>
</head>
<body>
	<s:form action="saveFloorplan.action" method="post">
		<s:hidden name="view.id"></s:hidden>
		<s:label name="view.id" label="ID"></s:label>
		<s:label name="view.bid" label="BID"></s:label>
		<s:textfield name="view.buildingId" label="buildingId"></s:textfield>
		<s:textfield name="view.publicPictureId" label="publicPictureId"></s:textfield>
		<s:textfield name="view.salePictureId" label="salePictureId"></s:textfield>
		<s:textfield name="view.description" label="description"></s:textfield>
		<s:textfield name="view.type" label="type"></s:textfield>
		<s:textfield name="view.minPrice" label="minPrice"></s:textfield>
		<s:textfield name="view.maxPrice" label="maxPrice"></s:textfield>
		<s:textfield name="view.orientation" label="orientation"></s:textfield>
		<s:textfield name="view.bedRoomCount" label="bedRoomCount"></s:textfield>
		<s:textfield name="view.bathroomCount" label="bathroomCount"></s:textfield>
		<s:textfield name="view.studyroomCount" label="studyroomCount"></s:textfield>
		<s:textfield name="view.openBaclonyCount" label="openBaclonyCount"></s:textfield>
		<s:textfield name="view.enclosedBaclonyCount" label="enclosedBaclonyCount"></s:textfield>
		<s:textfield name="view.courtyardCount" label="courtyardCount"></s:textfield>
		<s:textfield name="view.internalSize" label="internalSize"></s:textfield>
		<s:textfield name="view.externalSize" label="externalSize"></s:textfield>
		<s:textfield name="view.totalSize" label="totalSize"></s:textfield>
		<s:textfield name="view.landSize" label="landSize"></s:textfield>
		<s:checkbox name="view.split" label="split" labelposition="left"></s:checkbox>
		<s:checkbox name="view.studio" label="studio" labelposition="left"></s:checkbox>
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