<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="<c:url value='/resources/js/user.js'/>" type="text/javascript"></script>
<title>User Groups Details Page</title>
</head>
<body>
	<%@include file="../topmenu.jsp"%>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="<c:url value="/home"/>">主页</a></li>
					<li><a href="<c:url value="/user/getAllGroups"/>">用户组管理</a></li>
					<li class="active">用户组成员</li>
				</ul>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">管理员信息</div>
			<div class="panel-body">
				<table class="table" align="center">
					<tr>
						<th>Id</th>
						<th>用户编号</th>
						<th>用户名</th>
						<th>手机号</th>
						<th>邮件</th>
						<th>用户组</th>
						<th>状态</th>
						<th>公司</th>
						<th>操作时间</th>
					</tr>
					<c:forEach items="${groupUsers}" var="u">
						<tr>
							<td>${u.userId}</td>
							<td>${u.userNo}</td>
							<td>${u.userName}</td>
							<td>${u.mobilePhone}</td>
							<td>${u.email}</td>
							<td>${u.groupInfo.groupName}</td>
							<td>${u.status}</td>
							<td>${u.firmInfo.firmName}</td>
							<td>${u.operateDate}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>