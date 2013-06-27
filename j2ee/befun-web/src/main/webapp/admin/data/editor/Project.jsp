<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Project ID:${view.id},Name:${view.name}</title>
<script>
	tinymce.init({
		selector : "textarea",
		plugins : "image code table advlist autolink lists link",
		extended_valid_elements: "a[href|rel|target]",
		toolbar: "undo redo | styleselect fontsizeselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image",
		rel_list: [
			{title: 'Description', value: 'description'},
			{title: 'Feature', value: 'feature'},
			{title: 'Finish', value: 'finish'}
		],
		height : 400
	});

	function initPage() {
		$("#tabs").tabs();
	}
</script>
</head>
<body>
	<s:form action="saveProject.action" method="post" theme="simple">
		<div id="tabs">
			<ul>
				<li><a href="#tabs-1">General</a></li>
				<li><a href="#tabs-2">Description</a></li>
				<li><a href="#tabs-3">Features</a></li>
				<li><a href="#tabs-4">Scheme</a></li>
			</ul>
			<div id="tabs-1">
				<table>
					<s:hidden name="view.id"></s:hidden>
					<s:hidden name="view.bid"></s:hidden>
					<tr>
						<td class="tdLabel"><label>ID: </label></td>
						<td><s:label name="view.id" /></td>
					</tr>
					<tr>
						<td class="tdLabel"><label>BID: </label></td>
						<td><s:label name="view.bid" /></td>
					</tr>
					<tr>
						<td class="tdLabel"><label>Area: </label></td>
						<td><select id="areaCombobox" name="view.areaId" onChange="getSuburbByArea($('#areaCombobox'), $('#suburbCombobox'));">
								<c:forEach items="${qcAreas }" var="a">
									<option value="${a.id }" <c:if test="${view.areaId eq a.id}">selected="selected"</c:if>>${a.name }</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td class="tdLabel"><label>Suburb: </label></td>
						<td><select id="suburbCombobox" name="view.suburbId">
								<c:forEach items="${qcSuburbs }" var="s">
									<option value="${s.id }" <c:if test="${view.suburbId eq s.id}">selected="selected"</c:if>>${s.name }</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td class="tdLabel"><label>pictureId: </label></td>
						<td><s:textfield name="view.pictureId" /></td>
					</tr>

					<tr>
						<td class="tdLabel"><label>logoId: </label></td>
						<td><s:textfield name="view.logoId" /></td>
					</tr>
					<tr>
						<td class="tdLabel"><label>type: </label></td>
						<td><s:textfield name="view.type" /></td>
					</tr>
					<tr>
						<td class="tdLabel"><label>priceRange: </label></td>
						<td><s:textfield name="view.priceRange" /></td>
					</tr>
					<tr>
						<td class="tdLabel"><label>shortDescription: </label></td>
						<td><s:textfield name="view.shortDescription" /></td>
					</tr>
					<tr>
						<td class="tdLabel"><label>stageCount: </label></td>
						<td><s:textfield name="view.stageCount" /></td>
					</tr>
					<tr>
						<td class="tdLabel"><label>buildingCount: </label></td>
						<td><s:textfield name="view.buildingCount" /></td>
					</tr>
					<tr>
						<td class="tdLabel"><label>name: </label></td>
						<td><s:textfield name="view.name" /></td>
					</tr>
					<tr>
						<td class="tdLabel"><label>block: </label></td>
						<td><s:textfield name="view.block" /></td>
					</tr>
					<tr>
						<td class="tdLabel"><label>siteUrl: </label></td>
						<td><s:textfield name="view.siteUrl" /></td>
					</tr>
					<tr>
						<td class="tdLabel"><label>developer: </label></td>
						<td><s:textfield name="view.developer" /></td>
					</tr>
					<tr>
						<td class="tdLabel"><label>address: </label></td>
						<td><s:textfield name="view.address" /></td>
					</tr>
					<tr>
						<td class="tdLabel"><label>postcode: </label></td>
						<td><s:textfield name="view.postcode" /></td>
					</tr>
					<tr>
						<td class="tdLabel"><label>finishDate: </label></td>
						<td><sx:datetimepicker name="view.finishDate" /></td>
					</tr>
					<tr>
						<td class="tdLabel"><label>distanceToCity: </label></td>
						<td><s:textfield name="view.distanceToCity" /></td>
					</tr>
					<tr>
						<td class="tdLabel"><label>latitude: </label></td>
						<td><s:textfield name="view.latitude" /></td>
					</tr>
					<tr>
						<td class="tdLabel"><label>longitude: </label></td>
						<td><s:textfield name="view.longitude" /></td>
					</tr>
					<tr>
						<td class="tdLabel"><label>Amenity:</label></td>
						<td>
							<table>
								<tr>
									<td><s:checkbox name="view.swimmingPool" theme="simple" /></td>
									<td>swimmingPool</td>
									<td><s:checkbox name="view.gym" theme="simple" /></td>
									<td>gym</td>
									<td><s:checkbox name="view.sauna" theme="simple" /></td>
									<td>sauna</td>
									<td><s:checkbox name="view.tennisCourt" theme="simple" /></td>
									<td>tennisCourt</td>
									<td><s:checkbox name="view.playRoom" theme="simple" /></td>
									<td>playRoom</td>
								</tr>
								<tr>
									<td><s:checkbox name="view.funcRoom" theme="simple" /></td>
									<td>funcRoom</td>
									<td><s:checkbox name="view.theatreCinema" theme="simple" /></td>
									<td>theatreCinema</td>
									<td><s:checkbox name="view.musicRoom" theme="simple" /></td>
									<td>musicRoom</td>
									<td><s:checkbox name="view.library" theme="simple" /></td>
									<td>library</td>
									<td><s:checkbox name="view.bbq" theme="simple" /></td>
									<td>bbq</td>
								<tr>
									<td><s:checkbox name="view.visitorParking" theme="simple" /></td>
									<td>visitorParking</td>
									<td><s:checkbox name="view.kidsPlayGround" theme="simple" /></td>
									<td>kidsPlayGround</td>
									<td><s:checkbox name="view.skyGarden" theme="simple" /></td>
									<td>skyGarden</td>
									<td><s:checkbox name="view.landScaping" theme="simple" /></td>
									<td>landScaping</td>
									<td><s:checkbox name="view.recreationPlace" theme="simple" /></td>
									<td>recreationPlace</td>
								</tr>
								<tr>
									<td><s:checkbox name="view.carWashBay" theme="simple" /></td>
									<td>carWashBay</td>
									<td><s:checkbox name="view.others" theme="simple" /></td>
									<td>others</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td class="tdLabel"><label>sold: </label></td>
						<td><s:textfield name="view.sold" /></td>
					</tr>
					<tr>
						<td class="tdLabel"><label>soldOut: </label></td>
						<td><s:checkbox name="view.soldOut" labelposition="left" /></td>
					</tr>
				</table>
			</div>

			<div id="tabs-2">
				<s:textarea name="view.description" cols="40" rows="12"></s:textarea>
			</div>
			<div id="tabs-3">
				<s:textarea name="view.features" cols="40" rows="12"></s:textarea>
			</div>
			<div id="tabs-4">
				<s:textarea name="view.finishSchema" cols="40" rows="12"></s:textarea>
			</div>
			<tr>
				<td colspan="2"><div align="right">
						<s:if test="editable">
							<s:submit theme="simple" />
							<s:reset theme="simple" />
						</s:if>
						<input type="button" value="Close" onclick="closeCurrentWindow();" />
					</div></td>
			</tr>
		</div>
	</s:form>
</body>
</html>