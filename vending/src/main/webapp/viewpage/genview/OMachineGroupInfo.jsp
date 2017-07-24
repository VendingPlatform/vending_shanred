<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Machine Group Info</title>
</head>
<body>
	<%@include file="../topmenu.jsp"%>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="<c:url value="/home"/>">主页</a></li>
					<li><a href="<c:url value="/machine/machineGroup"/>">售货机分组</a></li>
					<li class="active">更新分组信息</li>
				</ul>
			</div>
			<div>
			<form action="<c:url value='/machine/machineGroupUpdate'/>" class="form-inline" method="post">
			<input type="hidden" name="groupId" value="${groupInfo.groupId}">
				<table class="table">
					<tr>
						<td>组名</td>
						<td>
							<div class="form-group">
								<input type="text" class="form-control" name="groupName" placeholder="组名" value="${groupInfo.groupName}" required="required">
							</div>
						</td>
					</tr>
					<tr>
						<td>描述</td>
						<td>
							<div class="form-group">
								<textarea class="form-control" name="groupDesc" >${groupInfo.groupDesc}</textarea>
							</div>
						</td>
					</tr>
				</table>
				<button type="submit" class="btn btn-primary">提交</button>
			</form>
			</div>
		</div>
	</div>
</body>
</html>