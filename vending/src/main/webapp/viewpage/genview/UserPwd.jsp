<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>change pwd</title>
</head>
<body>
	<%@include file="../topmenu.jsp"%>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="<c:url value="/home"/>">主页</a></li>
					<li class="active">修改密码</li>
				</ul>
			</div>
		</div>
		<form  action="<c:url value="/user/changepwdexecute"/>" method="post" style="width:180px">
			<input type="hidden" name="userId" value="${user.userId }">
			<div class="form-group">
				<label for="name">用户名:</label>
				<input type="text" class="form-control" id="name" name="userName" value="${user.userName }" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="pwd">密码:</label>
				<input type="password" class="form-control" id="pwd" name="password" value="${user.password}" required placeholder="输入密码">
			</div>
			<button type="submit" class="btn btn-primary">提交</button>
		</form>
	</div>
</body>
</html>