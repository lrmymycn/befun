<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result</title>
<script src="<c:url value="/js/befun-window.js"/>"></script>
</head>
<body>
	<center>
		<h1>
			<s:actionerror />
		</h1>
		<h1>
			<s:actionmessage />
		</h1>
	</center>
</body>
</html>