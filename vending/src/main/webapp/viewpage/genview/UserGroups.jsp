<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="<c:url value='/resources/js/user.js'/>" type="text/javascript"></script>
<title>User Groups Page</title>
</head>
<body>
	<%@include file="../topmenu.jsp"%>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="<c:url value="/home"/>">主页</a></li>
					<li class="active">用户组管理</li>
				</ul>
			</div>
		</div>
		<c:if test="${flag==1}">
			<a  class="btn btn-primary" data-toggle="modal" data-target="#createGroup">创建用户组</a>
		</c:if>
		<table class="table">
			<tr>
				<th>Id</th>
				<th>组名</th>
				<th>描述</th>
				<th>操作时间</th>
			</tr>
			<c:forEach items="${userGroupInfos }" var="g">
				<tr>
					<td>${g.groupId }</td>
					<td>${g.groupName }</td>
					<td>${g.groupDesc }</td>
					<td>${g.operateDate }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<div class="modal fade" id="createGroup" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">创建用户组</h4>
				</div>
				<div class="modal-body" style="width: 80%; padding-left: 30px">
					<form class="form" id="createUserGroupForm">
						<input type="hidden" name="groupType" value="1"/>
						<div class="form-group">
							<label for="groupName">组名:</label> 
							<input type="text" class="form-control" name="groupName" placeholder="输入组名" required/>
						</div>
						<div class="form-group">
							<label for="groupDesc">描述:</label> 
							<input type="text" class="form-control" name="groupDesc" placeholder="输入描述" required/>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary"
						onclick="createUserGroup()" data-dismiss="modal">保存</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>