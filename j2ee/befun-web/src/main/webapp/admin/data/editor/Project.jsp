<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Project ID:${view.id},LN:${view.name}</title>
</head>
<body>
	<s:form action="saveProject.action" method="post">
		<s:hidden name="view.id"></s:hidden>
		<s:hidden name="view.bid"></s:hidden>
		<s:label name="view.id" label="ID"></s:label>
		<s:label name="view.bid" label="BID"></s:label>
		<s:textfield name="view.areaId" label="areaId"></s:textfield>
		<s:textfield name="view.suburbId" label="suburbId"></s:textfield>
		<s:textfield name="view.pictureId" label="pictureId"></s:textfield>
		<s:textfield name="view.logoId" label="logoId"></s:textfield>
		<s:textfield name="view.name" label="name"></s:textfield>
		<s:textfield name="view.block" label="block"></s:textfield>
		<s:textfield name="view.siteUrl" label="siteUrl"></s:textfield>
		<s:textfield name="view.developer" label="developer"></s:textfield>
		<s:textfield name="view.address" label="address"></s:textfield>
		<s:textfield name="view.postcode" label="postcode"></s:textfield>
		<s:textarea name="view.features" label="features" labelposition="left" cols="40"></s:textarea>
		<s:textarea name="view.finishSchema" label="finishSchema" labelposition="left" cols="40"></s:textarea>
		<sx:datetimepicker name="view.finishDate" label="finishDate" />
		<s:textfield name="view.distanceToCity" label="distanceToCity"></s:textfield>
		<s:textfield name="view.longitude" label="longitude"></s:textfield>
		<s:textfield name="view.latitude" label="latitude"></s:textfield>
		<tr>
			<td class="tdLabel">
			<label>Amenity:</label>
			</td>
			<td>
				<table><tr>
					<td><s:checkbox name="view.swimmingPool" theme="simple"/></td><td>swimmingPool</td>
					<td><s:checkbox name="view.gym" theme="simple"/></td><td>gym</td>
					<td><s:checkbox name="view.sauna" theme="simple"/></td><td>sauna</td>
					<td><s:checkbox name="view.tennisCourt" theme="simple"/></td><td>tennisCourt</td>
					<td><s:checkbox name="view.playRoom" theme="simple"/></td><td>playRoom</td>
					<td><s:checkbox name="view.funcRoom" theme="simple"/></td><td>funcRoom</td>
					</tr>
					<tr>
					<td><s:checkbox name="view.theatreCinema" theme="simple"/></td><td>theatreCinema</td>
					<td><s:checkbox name="view.musicRoom" theme="simple"/></td><td>musicRoom</td>
					<td><s:checkbox name="view.library" theme="simple"/></td><td>library</td>
					<td><s:checkbox name="view.bbq" theme="simple"/></td><td>bbq</td>
					<td><s:checkbox name="view.visitorParking" theme="simple"/></td><td>visitorParking</td>
					<td><s:checkbox name="view.kidsPlayGround" theme="simple"/></td><td>kidsPlayGround</td>
					<tr>
					<td><s:checkbox name="view.skyGarden" theme="simple"/></td><td>skyGarden</td>
					<td><s:checkbox name="view.landScaping" theme="simple"/></td><td>landScaping</td>
					<td><s:checkbox name="view.recreationPlace" theme="simple"/></td><td>recreationPlace</td>
					<td><s:checkbox name="view.carWashBay" theme="simple"/></td><td>carWashBay</td>
					<td><s:checkbox name="view.others" theme="simple"/></td><td>others</td>
				</tr></table>
			</td>
		</tr>
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