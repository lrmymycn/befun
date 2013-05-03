<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="jmesa" uri="http://code.google.com/p/jmesa"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>ProjectMedias</title>
</head>
<body>
	<form name="projectMediaForm" action="" method="post">
		<input type="hidden" name="tableName" value="projectMedia_table" />
		<jmesa:struts2TableModel items="${pgb.models}" id="projectMedia_table" var="bean" stateAttr="restore"
			totalCount="${pgb.totalCount}">
			<jmesa:htmlTable width="600" caption="ProjectMedias">
				<jmesa:htmlRow uniqueProperty="id">
					<jmesa:htmlColumn property="id" />
					<jmesa:htmlColumn property="projectId" title="Project">
						<s:url var="u" action="admin/data/viewProject.action" namespace="/">
							<s:param name="id">${bean.projectId}</s:param>
						</s:url>
						<input type="button" value="${bean.projectId }" onclick="showDialog('${u}')" />
					</jmesa:htmlColumn>
					<jmesa:htmlColumn sortable="false" property="media.id" />
					<jmesa:htmlColumn sortable="false" property="media.smallUrl">
						<a href="${bean.media.smallUrl }">Small Url</a>
					</jmesa:htmlColumn>
					<jmesa:htmlColumn sortable="false" title="Operation">
						<s:url var="e" action="admin/data/editProjectMedia.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Edit" onclick="showDialog('${e}')" />
						
						<!-- 
						<s:url var="r" action="admin/data/removeProjectMedia.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Remove" onclick="showDialog('${r}')" />
						-->
						
						<c:if test="${!bean.enabled }">
						<s:url var="r" action="admin/data/enableProjectMedia.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Enable" onclick="showDialog('${r}')" />
						</c:if>
						<c:if test="${bean.enabled }">
						<s:url var="r" action="admin/data/disableProjectMedia.action" namespace="/">
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