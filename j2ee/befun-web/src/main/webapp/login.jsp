<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="charset" content="UTF-8">
<title>Login</title>
</head>

<body>
	<div id="container">
		<div id="header">
			<h1></h1>
		</div>
		<div id="content">
			<h1>用户登陆</h1>
			${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}
			<form action="${pageContext.request.contextPath}/j_spring_security_check" method="post">
				用户： <input type="text" name="j_username" value="${sessionScope['SPRING_SECURITY_LAST_USERNAME']}" /> 密码：
				<input type="password" name="j_password" /> 两周之内不必登陆<input type="checkbox"
					name="_spring_security_remember_me" /> <input type="submit" value="登陆" /> <input type="reset"
					value="重置" />
			</form>
		</div>
		<div id="list"></div>
		<div id="footer">Copyright befun.com</div>
	</div>
</body>
</html>