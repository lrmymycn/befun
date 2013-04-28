<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Project ID:${view.id},LN:${view.name}</title>
</head>
<body>
	<s:form action="saveProject.action" method="post">
		<s:hidden name="view.id"></s:hidden>
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
		<s:textfield name="view.finishDate" label="finishDate"></s:textfield>
		<s:textfield name="view.distanceToCity" label="distanceToCity"></s:textfield>
		<s:textfield name="view.longitude" label="longitude"></s:textfield>
		<s:textfield name="view.latitude" label="latitude"></s:textfield>
		<s:checkbox name="view.swimmingPool" label="swimmingPool" labelposition="left"></s:checkbox>
		<s:checkbox name="view.gym" label="gym" labelposition="left"></s:checkbox>
		<s:checkbox name="view.sauna" label="sauna" labelposition="left"></s:checkbox>
		<s:checkbox name="view.tennisCourt" label="tennisCourt" labelposition="left"></s:checkbox>
		<s:checkbox name="view.playRoom" label="playRoom" labelposition="left"></s:checkbox>
		<s:checkbox name="view.funcRoom" label="funcRoom" labelposition="left"></s:checkbox>
		<s:checkbox name="view.theatreCinema" label="theatreCinema" labelposition="left"></s:checkbox>
		<s:checkbox name="view.musicRoom" label="musicRoom" labelposition="left"></s:checkbox>
		<s:checkbox name="view.library" label="library" labelposition="left"></s:checkbox>
		<s:checkbox name="view.bbq" label="bbq" labelposition="left"></s:checkbox>
		<s:checkbox name="view.visitorParking" label="visitorParking" labelposition="left"></s:checkbox>
		<s:checkbox name="view.kidsPlayGround" label="kidsPlayGround" labelposition="left"></s:checkbox>
		<s:checkbox name="view.skyGarden" label="skyGarden" labelposition="left"></s:checkbox>
		<s:checkbox name="view.landScaping" label="landScaping" labelposition="left"></s:checkbox>
		<s:checkbox name="view.recreationPlace" label="recreationPlace" labelposition="left"></s:checkbox>
		<s:checkbox name="view.carWashBay" label="carWashBay" labelposition="left"></s:checkbox>
		<s:checkbox name="view.others" label="others" labelposition="left"></s:checkbox>
		<s:textfield name="view.sold" label="sold"></s:textfield>
		<s:checkbox name="view.soldOut" label="soldOut" labelposition="left"></s:checkbox>
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