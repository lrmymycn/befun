<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="/includes/admin/taglib.jsp"%>
<%@ include file="/includes/admin/cache.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><decorator:title default="Befun Administration Editor"/></title>
<%@ include file="/includes/admin/style.jsp"%>
<%@ include file="/includes/admin/profile/edit/style.jsp"%>
<%@ include file="/includes/admin/js.jsp"%>
<%@ include file="/includes/admin/profile/edit/js.jsp"%>
<s:head labelposition="left" locale="en_US"/>
<sx:head locale="en_US"/>
<style>
.tdLabel {
    text-align: left;
}
</style>
<decorator:head />
</head>
<body>
	<%@ include file="/includes/admin/header.jsp" %>
	<%@ include file="/includes/admin/profile/edit/header.jsp" %>
	<decorator:body />
	<%@ include file="/includes/admin/footer.jsp" %>
</body>
</html>