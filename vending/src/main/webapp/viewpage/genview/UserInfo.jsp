<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>用户信息</title>
</head>
<body>
	<%@include file="../topmenu.jsp"%>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="<c:url value="/home"/>">主页</a></li>
					<li class="active">用户信息</li>
				</ul>
			</div>
		</div>
		<table class="table table-hover">
			<tr>
				<td>Id</td>
				<td>${user.userId}</td>
			</tr>
			<tr>
				<td>用户编号</td>
				<td>${user.userNo}</td>
			</tr>
			<tr>
				<td>用户名</td>
				<td>${user.userName}</td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td>${user.email}</td>
			</tr>
			<tr>
				<td>分组</td>
				<td>${user.groupInfo.groupName}</td>
			</tr>
			<tr>
				<td>公司类型</td>
				<td>${user.firmType}</td>
			</tr>
			<tr>
				<td>状态</td>
				<td>${user.status}</td>
			</tr>
		</table>
	</div>
</body>
</html>