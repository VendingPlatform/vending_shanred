<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Role Info Page</title>
</head>
<body>
<body>
	<%@include file="../topmenu.jsp"%>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="<c:url value="/home"/>">主页</a></li>
					<li class="active">角色管理</li>
				</ul>
			</div>
		</div>
		<table class="table">
			<tr>
				<th>Id</th>
				<th>角色名称</th>
				<th>角色状态</th>
				<th>公司Id</th>
				<th>操作者</th>
				<th>操作时间</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${allRoleInfos}" var="role">
				<tr>
					<td>${role.roleId }</td>
					<td>${role.roleName }</td>
					<td>${role.status }</td>
					<td>${role.firmId }</td>
					<td>${role.operateId }</td>
					<td>${role.operateDate }</td>
					<td>
						<a href="<c:url value="/user/getRoleAuthInfo"/>?roleId=${role.roleId }" class="btn default"> 
						<span class="glyphicon glyphicon-edit" title="编辑"></span>
						</a>
						<a href="<c:url value="/user/insertRoleAuthInfo"/>?roleId=${role.roleId }" class="btn default"> 
						<span class="glyphicon glyphicon-add" title="添加权限"></span>
						</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>