<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Suburb ID:${view.id},LN:${view.name}</title>
<script>
	tinymce.init({
		selector : "textarea.tiny",
		plugins : "image code table advlist autolink lists link",
		toolbar: "undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image",
		height : 400
	});

	function initPage() {
		$("#tabs").tabs();
	}
</script>
</head>
<body>
	<s:form action="saveSuburb.action" method="post" theme="simple">
		<div id="tabs">
			<ul>
				<li><a href="#tabs-1">General</a></li>
				<li><a href="#tabs-2">Description</a></li>
			</ul>
			<div id="tabs-1">
				<table>
					<s:hidden name="view.id"></s:hidden>
					<tr>
						<td class="tdLabel"><label>ID: </label></td>
						<td><s:label name="view.id" /></td>
					</tr>
					<tr>
						<td class="tdLabel"><label>BID: </label></td>
						<td><s:label name="view.bid" /></td>
					</tr>
					<tr>
						<td class="tdLabel"><label>area: </label></td>
						<td><s:select name="view.areaId" label="area" list="qcAreas" listKey="id" listValue="name" /></td>
					</tr>
					<tr>
						<td class="tdLabel"><label>name: </label></td>
						<td><s:textfield name="view.name" /></td>
					</tr>
					<tr>
						<td class="tdLabel"><label>postCode: </label></td>
						<td><s:textfield name="view.postCode" /></td>
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
						<td class="tdLabel"><label>vacancyRate: </label></td>
						<td><s:textfield name="view.vacancyRate" /></td>
					</tr>
					<tr>
						<td class="tdLabel"><label>universities: </label></td>
						<td><s:checkbox name="view.universities" /></td>
					</tr>
					<tr>
						<td class="tdLabel"><label>schools: </label></td>
						<td><s:checkbox name="view.schools" /></td>
					</tr>
					<tr>
						<td class="tdLabel"><label>shoppingCenter</label></td>
						<td><s:checkbox name="view.shoppingCenter" /></td>
					</tr>
					<tr>
						<td class="tdLabel"><label>train: </label></td>
						<td><s:checkbox name="view.train" /></td>
					</tr>
					<tr>
						<td class="tdLabel"><label>chineseCommunity: </label></td>
						<td><s:checkbox name="view.chineseCommunity" /></td>
					</tr>
					<tr>
						<td class="tdLabel"><label>polylinesString: </label></td>
						<td><s:textarea name="view.polylinesString" cols="40" rows="12"/></td>
					</tr>
				</table>
			</div>

			<div id="tabs-2">
				<s:textarea name="view.description" cssClass="tiny"/>
			</div>
			<tr>
				<td colspan="2"><div align="right">
						<s:if test="editable">
							<input type="submit" value="Submit" />
							<input type="reset" value="Reset" />
						</s:if>
						<input type="button" value="Close" onclick="closeCurrentWindow();" />
					</div></td>
			</tr>
		</div>
	</s:form>
</body>
</html>