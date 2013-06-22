<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <jsp:include page="includes/head.jsp" />
    </head>
	<body>
		<div class="standard">
	        <header>
	        	<div class="inner">
	        		<jsp:include page="includes/search.jsp" />
	        	</div>
	        </header>
	        <div id="content" class="project clearfix">		
	        	<div id="left">
	        		<div class="tile">
						<h2>Project Name</h2>	
						
					</div>
				</div>
				<div id="right">
					<div class="contactus widget">
						<h3>联系我们</h3>
						<form action="" method="post">
							<div class="row clearfix">
								<div class="input">
									<input type="text" name="name" value="" class="required" placeholder="姓名"/>
								</div>
							</div>
							<div class="row clearfix">
								<div class="input">
									<input type="email" name="email" value="" class="required" placeholder="Email"/>
								</div>
							</div>
							<div class="row clearfix">
								<div class="input">
									<input type="text" name="mobile" value="" placeholder="手机"/>
								</div>
							</div>
							<div class="row clearfix">
								<div class="input">
									<textarea placeholder="例如：关于这个项目，我想了解更多。"></textarea>
								</div>
							</div>
							<div class="buttons">
								<input type="submit" class="btn red" value="提交"></a>
							</div>
						</form>
					</div>
				</div>
         	</div>
         	<footer>
				&copy; 2012 Befun Property 
			</footer>
		</div>
		<jsp:include page="includes/script.jsp" />
        <script>
        	$(function(){

			})
        </script>
	</body>
</html>
