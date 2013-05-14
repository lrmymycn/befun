<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit ProjectMedia ID:${view.id},LN:${view.projectName},${view.media.smallUrl }</title>
</head>
<body>
	<s:form action="saveProjectMedia.action" method="post">
		<s:hidden name="view.id"></s:hidden>
		<s:label name="view.id" label="ID"></s:label>
		<s:textfield name="view.projectId" label="projectId"></s:textfield>
		<s:label name="view.projectName" label="projectName"></s:label>
		<s:textfield name="view.media.id" label="mediaId"></s:textfield>
		<s:label name="view.media.smallUrl" label="mediaSmallUrl"></s:label>
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