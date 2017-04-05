<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Authority Info Page</title>
</head>
<body>
<body>
	<%@include file="../topmenu.jsp"%>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="<c:url value="/home"/>">主页</a></li>
					<li class="active">权限管理</li>
				</ul>
			</div>
		</div>
		<!-- <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#createAuthModal">
  			创建权限
		</button> -->
		<table class="table">
			<tr>
				<th>Id</th>
				<th>权限名称</th>
				<th>权限编码</th>
				<th>权限描述</th>
				<th>操作者</th>
				<th>操作时间</th>
			</tr>
			<c:forEach items="${authorityInfos}" var="auth">
				<tr>
					<td>${auth.authId}</td>
					<td>${auth.authName}</td>
					<td>${auth.authCode}</td>
					<td>${auth.authDesc }</td>
					<td>${auth.operateId}</td>
					<td>${auth.operateDate}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<!-- Modal -->
	<%-- <div class="modal fade" id="createAuthModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">创建权限</h4>
	      </div>
	      <div class="modal-body"  style="width: 80%; padding-left: 30px">
	        <form class="form-horizontal" id="createAuthModal" method="post">
				<input type="hidden" name="operateId" value="${user.userId}" />
					<div class="form-group">
						<label for="authName">权限名称:</label>
						<input type="text" class="form-control" name="authName" required placeholder="权限名称">
					</div>
					<div class="form-group">
						<label for="authCode">权限名称:</label>
						<input type="text" class="form-control" name="authCode" required placeholder="权限编号">
					</div>
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary" data-dismiss="modal">保存</button>
	      </div>
	    </div>
	  </div>
	</div> --%>
</body>
</html>