<div id="login-panel" class="popover">
	<div class="arrow"></div>
	<div class="inner">
		<form id="form-login" action="${pageContext.request.contextPath}/j_spring_security_check" method="post">
			<div class="row">
				<input type="text" placeholder="Username" name="j_username" value="${sessionScope['SPRING_SECURITY_LAST_USERNAME']}" />
			</div>
			<div class="row">
				<input type="password" placeholder="Password" name="j_password" />
			</div>
			<div class="button">
				<input type="submit" class="btn red" value="Login"/>
			</div>
		</form>
	</div>
</div>