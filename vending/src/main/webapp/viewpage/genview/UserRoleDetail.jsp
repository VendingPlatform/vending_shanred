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
<title>用户信息</title>
</head>
<body>
	<%@include file="../topmenu.jsp"%>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="<c:url value="/home"/>">主页</a></li>
					<li><a href="<c:url value="/user/getAllUsers"/>">用户管理</a></li>
					<li class="active">用户详细信息</li>
				</ul>
			</div>
		</div>
		<table class="table">
			<tr>
				<th>名称</th>
				<th>内容</th>
			</tr>
			<tr>
				<td>用户编码</td>
				<td>${userInfoDetail.userNo}</td>
			</tr>
			<tr>
				<td>用户名</td>
				<td>${userInfoDetail.userName}</td>
			</tr>
			<tr>
				<td>用户组</td>
				<td>${userInfoDetail.groupInfo.groupName}</td>
			</tr>
			<tr>
				<td>用户公司</td>
				<td>${userInfoDetail.firmInfo.firmName}</td>
			</tr>

			<tr>
				<td>角色名称</td>
				<td><c:forEach items="${userRoleInfo}" var="u">${u.roleInfo.roleName}&nbsp;
					</c:forEach></td>
			</tr>
		</table>
	</div>
</body>
</html>