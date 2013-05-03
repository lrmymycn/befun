<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="jmesa" uri="http://code.google.com/p/jmesa"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Buildings</title>
</head>
<body>
	<form name="buildingForm" action="" method="post">
		<input type="hidden" name="tableName" value="building_table" />
		<jmesa:struts2TableModel items="${pgb.models}" id="building_table" var="bean" stateAttr="restore"
			totalCount="${pgb.totalCount}">
			<jmesa:htmlTable width="600" caption="Buildings">
				<jmesa:htmlRow uniqueProperty="id">
					<jmesa:htmlColumn property="id" />
					<jmesa:htmlColumn sortable="false" property="bid" />
					<jmesa:htmlColumn property="stageId" title="Stage">
						<s:url var="u" action="admin/data/viewState.action" namespace="/">
							<s:param name="id">${bean.stageId}</s:param>
						</s:url>
						<input type="button" value="${bean.stageId }" onclick="showDialog('${u}')" />
					</jmesa:htmlColumn>
					<jmesa:htmlColumn property="buildingNumber" />
					<jmesa:htmlColumn property="finishDate" />
					<jmesa:htmlColumn property="floorCount" />
					<jmesa:htmlColumn property="orientation" />
					<jmesa:htmlColumn property="readyHouse" />
					<jmesa:htmlColumn property="sold" />
					<jmesa:htmlColumn property="soldOut" />
					<jmesa:htmlColumn property="enabled" />
					<jmesa:htmlColumn sortable="false" title="Operation">
						<s:url var="e" action="admin/data/editBuilding.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Edit" onclick="showDialog('${e}')" />
						<!-- 
						<s:url var="r" action="admin/data/removeBuilding.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Remove" onclick="showDialog('${r}')" />
						-->
						
						<c:if test="${!bean.enabled }">
						<s:url var="r" action="admin/data/enableBuilding.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Enable" onclick="showDialog('${r}')" />
						</c:if>
						<c:if test="${bean.enabled }">
						<s:url var="r" action="admin/data/disableBuilding.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Disable" onclick="showDialog('${r}')" />
						</c:if>
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