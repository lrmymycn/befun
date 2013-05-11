<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <jsp:include page="includes/head.jsp" />
    </head>
	<body class="standard">
		<header style="position:absolute;">
        	<div class="inner">
        		<div class="top">
					<a href="/"><h1 class="logo">BeFun Property</h1></a>
					<div class="menu">
						<ul>
							<li><a href="#">Join us</a></li>
							<li class="more"><a href="javascript:;">More<i class="arrow-down-grap"></i></a>
								<ul>
									<li><a href="#">About us</a></li>
									<li><a href="#">Contact us</a></li>
								</ul>
							</li>
							<li class="phone"><i class="phone"></i> 02-1234-5678</li>
						</ul>
					</div>
				</div>
        	</div>
        </header>
        <img src="/img/login.jpg" width="100%" alt="" class="bg-login"/>
		<div id="login">
			<form action="${pageContext.request.contextPath}/j_spring_security_check" method="post">
				<div class="row">
					<input type="text" placeholder="Username" name="j_username" value="${sessionScope['SPRING_SECURITY_LAST_USERNAME']}" />
				</div>
				<div class="row">
					<input type="password" placeholder="Password" name="j_password" />
				</div>
				<div>
					<input class="btn-submit" name="submit" value="Login" type="submit"/>
				</div>
			</form>
		</div>
		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
		<script>window.jQuery || document.write('<script src="/js/vendor/jquery-1.8.3.min.js"><\/script>')</script>
		<script>
			$(function(){
				$('img.bg-login').height($(window).height());
			})
			
			$(window).change(function(){
				$('img.bg-login').height($(window).height());
			});
		</script>
		<script>
            var _gaq=[['_setAccount','UA-40663296-1'],['_trackPageview']];
            (function(d,t){var g=d.createElement(t),s=d.getElementsByTagName(t)[0];
            g.src=('https:'==location.protocol?'//ssl':'//www')+'.google-analytics.com/ga.js';
            s.parentNode.insertBefore(g,s)}(document,'script'));
        </script>
	</body>
</html>