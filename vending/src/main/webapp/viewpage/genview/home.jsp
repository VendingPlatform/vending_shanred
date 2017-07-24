<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>首页</title>
</head>
<body>
	<%@include file="../topmenu.jsp"%>
	<div class="container">
		<div class="page-header">
			<h1>主页</h1>
		</div>
		<%-- <div class="row-fluid">
			<div class="span12">
				<div class="carousel slide" id="carousel-660274">
					<ol class="carousel-indicators">
						<li class="active" data-slide-to="0"
							data-target="#carousel-660274"></li>
						<li data-slide-to="1" data-target="#carousel-660274"></li>
						<li data-slide-to="2" data-target="#carousel-660274"></li>
					</ol>
					<div class="carousel-inner">
						<div class="item active" >
							<img alt="" src="<c:url value='/resources/imgs/pic1.jpg'/>" style="height:529px; width：900px" />
						</div>
						<div class="item">
							<img alt="" src="<c:url value='/resources/imgs/pic2.jpg'/>" style="height:529px; width：900px"/>
						</div>
						<div class="item">
							<img alt="" src="<c:url value='/resources/imgs/pic2.jpg'/>" style="height:529px; width：900px"/>
						</div>
					</div>
				</div>
				<a data-slide="prev" href="#carousel-660274"
					class="left carousel-control"></a> <a data-slide="next"
					href="#carousel-660274" class="right carousel-control">›</a>
			</div>
		</div> --%>
	</div>
</body>
</html>