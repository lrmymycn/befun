<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Import data from access</title>
</head>
<body>
	<center>
		<h1>
			base: ${pageContext.request.contextPath}
		</h1>
		<h1>
			<s:url value="/" />
		</h1>
		<h1>
			currentUserName:
			<s:label name="currentUserName" />
		</h1>
		<sec:authentication property="principal" var="authentication" />
		<sec:authorize ifAllGranted="ROLE_USER">可以访问</sec:authorize>
		用户名：${authentication.username }<br />
	</center>
</body>
</html>