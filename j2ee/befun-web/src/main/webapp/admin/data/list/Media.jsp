<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="jmesa" uri="http://code.google.com/p/jmesa"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Suburbs</title>
</head>
<body>
	<form name="suburbForm" action="" method="post">
		<input type="hidden" name="tableName" value="suburb_table" />
		<jmesa:struts2TableModel items="${pgb.models}" id="suburb_table" var="bean" stateAttr="restore"
			totalCount="${pgb.totalCount}">
			<jmesa:htmlTable width="600" caption="Suburbs">
				<jmesa:htmlRow uniqueProperty="id">
					<jmesa:htmlColumn property="id" />
					<jmesa:htmlColumn sortable="false" property="bid" />
					<jmesa:htmlColumn property="name" />
					<jmesa:htmlColumn sortable="false" property="smallUrl"  >
						<a href="${bean.smallUrl }">small</a>
					</jmesa:htmlColumn>
					<jmesa:htmlColumn sortable="false" property="mediumUrl" >
						<a href="${bean.mediumUrl }">medium</a>
					</jmesa:htmlColumn>
					<jmesa:htmlColumn sortable="false" property="largeUrl" >
						<a href="${bean.largeUrl }">large</a>
					</jmesa:htmlColumn>
					<jmesa:htmlColumn property="mediaType" />
					<jmesa:htmlColumn property="contentType" />
					<jmesa:htmlColumn property="enabled" />
					<jmesa:htmlColumn sortable="false" title="Operation">
						<s:url var="e" action="admin/data/editSuburb.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Edit" onclick="showDialog('${e}')" />
						<s:url var="r" action="admin/data/removeSuburb.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Remove" onclick="showDialog('${r}')" />
						
						<s:url var="r" action="admin/data/enableSuburb.action" namespace="/">
							<s:param name="id">${bean.id}</s:param>
						</s:url>
						<input type="button" value="Enable" onclick="showDialog('${r}')" />
						<s:url var="r" action="admin/data/disableSuburb.action" namespace="/">
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