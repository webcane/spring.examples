<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>s3mvc example</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	
	<s:url value="/resources/css/app.css" var="appCss" />
	<s:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
	
	<link href="${bootstrapCss}" rel="stylesheet" />
	<link href="${appCss}" rel="stylesheet" />
</head>
<body>

	<!-- Navigation -->
	<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
		<div class="container">
		
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">S3MVC</a>
			</div>
			
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav navbar-left">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="${pageContext.request.contextPath}/hello">Hello</a></li>
				</ul>
			</div>
					
		</div>
	</nav>

	
	<header class="page" id="home">
		<div class="container">
			<div class="content cover text-center">
			
				<div class="row">
					<div class="col-lg-12">
						<h1 class="brand-heading">${message}</h1>
					</div>
				</div>
			</div>				
		</div>
	</header>
	
	<footer>
		<div class="container">
		
			<div class="row">
				<div class="col-lg-12">
					<p  class="copyright">
						<span class="text-muted">Все права защищены. &copy; Cane Brothers. 2016</span>
					</p>
				</div>
			</div>
			
		</div>
	</footer>
	
	<s:url value="/resources/js/app.js" var="appJs" />
	<s:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />
 
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
	<script src="${appJs}"></script>
	<script src="${bootstrapJs}"></script>
	
</body>
</html>