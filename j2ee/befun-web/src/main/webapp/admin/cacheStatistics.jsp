<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="jmesa" uri="http://code.google.com/p/jmesa"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Secondary cache</title>
</head>
<body>
	<form name="cacheForm" action="" method="post">
		<table width="1000">
			<tr>
			<td width="50"><label>Enabled: </label></td>
			<td width="200">
			<select id="enabledCombobox" name="qc.enabled">
				<option value="null">All</option>
				<option value="true" <c:if test="${qc.enabled == true}">selected="selected"</c:if>>Enabled</option>
				<option value="false" <c:if test="${qc.enabled == false}">selected="selected"</c:if>>Disabled</option>
			</select>
			</td>
			<td align="right" colspan="10"><input id="queryButton" type="button" value="Query" onclick="jQuery.jmesa.removeAllFiltersFromLimit('cache_table');onInvokeAction('cache_table','clear')" /></td></tr>
		</table>
		<input type="hidden" name="tableName" value="cache_table" />
		<jmesa:struts2TableModel items="${secondCacheStatistics }" id="cache_table" var="bean" stateAttr="restore"
			totalCount="${secondCacheStatisticsSize}" maxRows="200" maxRowsIncrements="200">
			<jmesa:htmlTable width="600" caption="Second cache statistics">
				<jmesa:htmlRow uniqueProperty="name">
					<jmesa:htmlColumn property="name" sortable="true"/>
					<jmesa:htmlColumn property="st.sizeInMemory" />
					<jmesa:htmlColumn property="st.elementCountInMemory" />
					<jmesa:htmlColumn property="st.elementCountOnDisk" />
					<jmesa:htmlColumn property="st.hitCount" />
					<jmesa:htmlColumn property="st.missCount" />
					<jmesa:htmlColumn property="st.putCount" />
					<jmesa:htmlColumn sortable="false" title="Operation">
						<s:url var="r" action="admin/data/enableArea.action" namespace="/">
						</s:url>
						<input type="button" value="Enable" onclick="showModalDialog('${r}')" />
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