<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Import data from access</title>
</head>
<body>
	<center>
		<h1>上传Access文件，导入数据</h1>
		<s:form action="/admin/impAccess.action" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>选择文件:</td>
					<td><input type="file" name="file"></td>
				</tr>
				<tr>
					<td><input type="submit" value="上传"></td>
					<td><input type="reset"></td>
				</tr>
			</table>
		</s:form>
	</center>
</body>
</html>