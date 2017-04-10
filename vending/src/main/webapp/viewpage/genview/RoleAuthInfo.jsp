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
<title>Role Auth Info Page</title>
</head>
<body>
	<%@include file="../topmenu.jsp"%>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="<c:url value="/home"/>">主页</a></li>
					<li><a href="<c:url value="/user/getAllRoles"/>">角色管理</a></li>
					<li class="active">角色对应的权限信息</li>
				</ul>
			</div>
		</div>
		<table class="table">
			<tr>
				<th>权限Id</th>
				<th>权限编码</th>
				<th>权限名称</th>
				<th>权限描述</th>
				
			</tr>
			<c:forEach items="${roleAuthInfos}" var="ra">
				<tr>
					<td>${ra.authorityInfo.authId }</td>
					<td>${ra.authorityInfo.authCode }</td>
					<td>${ra.authorityInfo.authName }</td>
					<td>${ra.authorityInfo.authDesc }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>