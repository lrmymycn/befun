<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Import data from access</title>
</head>
<body>
	<center>
		<h1>basePath: ${pageContext.request.contextPath}</h1>
		<h1>
			<sec:authorize access="isAuthenticated()">
				currentUserName:
				<sec:authentication property="principal" var="authentication" />
				${authentication.username }<br />
			</sec:authorize>
			<sec:authorize access="isAnonymous()">
				<a href="<c:url value='/login.jsp' />">login</a>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<a href="<c:url value='/j_spring_security_logout' />">logout</a>
			</sec:authorize>
			<sec:authorize access="hasAnyRole('SUPER')">
				<a href="<c:url value='/admin/secCacheStatistic.action' />">Cache status</a>
			</sec:authorize>
			<sec:authorize access="hasAnyRole('SUPER','DATA_ADMIN')">
				<a href="<c:url value='/admin/impPage.action' />">Import From access</a>
			</sec:authorize>
			<sec:authorize access="hasAnyRole('SUPER','DATA_ADMIN')">
				<a href="<c:url value='/admin/data/demandProject.action' />">Manage Data</a>
			</sec:authorize>
		</h1>
	</center>
</body>
</html>