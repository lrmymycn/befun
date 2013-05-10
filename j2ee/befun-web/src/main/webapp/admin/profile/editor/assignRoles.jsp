<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Assign roles:${model.id},Name:${model.username}</title>
<sx:head/>
</head>
<body>
	<s:form action="assignRoles.action" method="post">
		<s:hidden name="id"></s:hidden>
		<s:label name="model.id" label="ID"></s:label>
		<s:label name="model.username" label="username"></s:label>
		<s:optiontransferselect
		    label="Roles"
		    labelposition="top"
		    name="roleIds"
		    leftTitle="Roles"
		    rightTitle="Current Roles"
		    list="allRoles"
		    listKey="id"
		    listValue="name"
		    multiple="true"
		    headerKey="headerKey"
		    doubleList="currentRoles"
		    doubleName="rightSideCartoonCharacters"
		    doubleHeaderKey="doubleHeaderKey"
		    doubleMultiple="true"
		    doubleListKey="id"
		    doubleListValue="name"
		    allowAddAllToLeft="true"
		    allowAddAllToRight="true"
		    allowAddToLeft="true"
		    allowAddToRight="true"
		    allowSelectAll="true"
		    allowUpDownOnLeft="false"
		    allowUpDownOnRight="false"
		/>
		<tr>
			<td colspan="2"><div align="right">
					<s:if test="editable">
						<input type="submit" value="Submit" />
						<input type="reset" value="Reset" />
					</s:if>
					<input type="button" value="Close" onclick="closeCurrentWindow();" />
				</div></td>
		</tr>
	</s:form>
</body>
</html>