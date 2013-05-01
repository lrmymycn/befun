<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Apartment ID:${view.id},LN:${view.lotNumber}</title>
</head>
<body>
	<s:form action="saveApartment.action" method="post">
		<s:hidden name="view.id"></s:hidden>
		<s:hidden name="view.bid"></s:hidden>
		<s:label name="view.id" label="ID"></s:label>
		<s:label name="view.bid" label="BID"></s:label>
		<s:textfield name="view.floorplanId" label="Floorplan"></s:textfield>
		<s:textfield name="view.unitNumber" label="Unit Number"></s:textfield>
		<s:textfield name="view.lotNumber" label="Lot Number"></s:textfield>
		<s:textfield name="view.floorLevel" label="Floor Level"></s:textfield>
		<s:textfield name="view.price" label="Price"></s:textfield>
		<s:textfield name="view.unitEntitlement" label="UnitEntitlement"></s:textfield>
		<s:textfield name="view.colorScheme" label="ColorScheme"></s:textfield>
		<s:textfield name="view.carParkingCount" label="CarParking Count"></s:textfield>
		<s:textfield name="view.storageRoomCount" label="StorageRoom Count"></s:textfield>
		<s:checkbox name="view.pentHouse" label="Pent House" labelposition="left"></s:checkbox>
		<s:checkbox name="view.soldOut" label="Sold Out" labelposition="left"></s:checkbox>
		<s:textarea name="view.description" label="Description" labelposition="left" cols="40"></s:textarea>
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