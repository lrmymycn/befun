<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="jmesa" uri="http://code.google.com/p/jmesa"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Floorplans</title>
</head>
<body>
	<form name="floorplanForm" action="" method="post">
		<input type="hidden" name="tableName" value="floorplan_table" />
		<jmesa:struts2TableModel items="${pgb.models}" id="floorplan_table" var="bean" stateAttr="restore"
			totalCount="${pgb.totalCount}">
			<jmesa:htmlTable width="600" caption="Floorplans">
				<jmesa:htmlRow uniqueProperty="id">
					<jmesa:htmlColumn property="id" />
					<jmesa:htmlColumn sortable="false" property="bid" />
					<jmesa:htmlColumn property="buildingId" title="Building">
						<s:url var="u" action="admin/data/viewBuilding.action" namespace="/">
							<s:param name="id">${bean.buildingId}</s:param>
						</s:url>
						<input type="button" value="${bean.buildingId }" onclick="showDialog('${u}')" />
					</jmesa:htmlColumn>
					<jmesa:htmlColumn sortable="false" property="publicPictureId" title="Public Picture">
						<s:url var="u" action="admin/data/editMedia.action" namespace="/">
							<s:param name="id">${bean.publicPictureId}</s:param>
						</s:url>
						<input type="button" value="${bean.publicPictureId }" onclick="showDialog('${u}')" />
					</jmesa:htmlColumn>
					<jmesa:htmlColumn sortable="false" property="salePictureId" title="Sale Picture">
						<s:url var="u" action="admin/data/editMedia.action" namespace="/">
							<s:param name="id">${bean.salePictureId}</s:param>
						</s:url>
						<input type="button" value="${bean.salePictureId }" onclick="showDialog('${u}')" />
					</jmesa:htmlColumn>
					<jmesa:htmlColumn property="type" />
					<jmesa:htmlColumn property="split" />
					<jmesa:htmlColumn property="studio" />
					<jmesa:htmlColumn property="bedRoomCount" />
					<jmesa:htmlColumn property="bathroomCount" />
					<jmesa:htmlColumn property="studyroomCount" />
					<jmesa:htmlColumn property="internalSize" />
					<jmesa:htmlColumn property="externalSize" />
					<jmesa:htmlColumn property="totalSize" />
					<jmesa:htmlColumn property="landSize" />
					<jmesa:htmlColumn property="sold" />
					<jmesa:htmlColumn property="soldOut" />
					<jmesa:htmlColumn property="enabled" />
					<jmesa:htmlColumn sortable="false" title="Operation">
						<s:url var="e" action="admin/data/editFloorplan.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Edit" onclick="showDialog('${e}')" />
						<s:url var="r" action="admin/data/removeFloorplan.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Remove" onclick="showDialog('${r}')" />
						
						<s:url var="r" action="admin/data/enableFloorplan.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Enable" onclick="showDialog('${r}')" />
						<s:url var="r" action="admin/data/disableFloorplan.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Disable" onclick="showDialog('${r}')" />
					</jmesa:htmlColumn>
				</jmesa:htmlRow>
			</jmesa:htmlTable>
		</jmesa:struts2TableModel>
	</form>
	<script type="text/javascript">
		function onInvokeAction(id) {
			$.jmesa.setExportToLimit(id, '');
			$.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
		}
	</script>
</body>
</html>