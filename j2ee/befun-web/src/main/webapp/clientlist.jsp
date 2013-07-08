<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
    	<title>比房网</title>
        <jsp:include page="includes/head.jsp" />
    </head>
	<body>
		<div class="standard">
	        <header>
	        	<div class="inner">
	        		<jsp:include page="includes/search.jsp" />
	        	</div>
	        </header>
	        <div id="content" class="clientlist">		         	        	
				<h2>Client List</h2>
				<table class="list">
					<thead>
						<tr>
							<th width="80">First Name</th>
							<th width="80">Last Name</th>
							<th width="120">Preferred Name</th>
							<th width="170">Email</th>
							<th width="100">Mobile</th>
							<th>Tags</th>
							<th width="100">Action</th>
						</tr>
					</thead>
					<tbody data-bind="foreach: clients">
						<tr>
							<td data-bind="text: givenName"></td>
							<td data-bind="text: surname"></td>
							<td data-bind="text: preferredName"></td>
							<td data-bind="text: email"></td>
							<td data-bind="text: mobileNumber"></td>
							<td>Tags goes here</td>
							<td class="action"><a data-bind="attr: {href: 'client.jsp?id=' + id}">View</a> <a href="javascript:;" data-bind="click: $parent.removeClient">Delete</a></td>
						</tr>
					</tbody>
				</table>
         	</div>
         	<footer>
				&copy; 2012 Befun Property 
			</footer>
		</div>
		<jsp:include page="includes/script.jsp" />
        <script>
        	$(function(){
				ClientList.init();
			})
        </script>
	</body>
</html>
