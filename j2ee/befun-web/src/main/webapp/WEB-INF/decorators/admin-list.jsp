<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ include file="/includes/admin/taglib.jsp"%>
<%@ include file="/includes/admin/cache.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><decorator:title default="Befun Administration List view"/></title>
<%@ include file="/includes/admin/style.jsp"%>
<%@ include file="/includes/admin/list/style.jsp"%>
<%@ include file="/includes/admin/js.jsp"%>
<%@ include file="/includes/admin/list/js.jsp"%>
<decorator:head />
</head>
<body>
	<%@ include file="/includes/admin/header.jsp" %>
	<%@ include file="/includes/admin/list/header.jsp" %>
	<decorator:body />
	<%@ include file="/includes/admin/footer.jsp" %>
</body>
</html>