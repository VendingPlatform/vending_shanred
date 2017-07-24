<%@page import="com.vending.platform.domain.AuthorityInfo"%>
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
<title>用户信息</title>
</head>
<body>
	<%@include file="../topmenu.jsp"%>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="<c:url value="/home"/>">主页</a></li>
					<li class="active">用户管理</li>
				</ul>
			</div>
		</div>
		<!-- 只有管理员可以添加用户 -->
		<c:if test="${flag==0||flag==1 }">
			<a href="<c:url value='/user/insertUser'/>" class="btn btn-primary" data-toggle="modal" data-target="#insertUser">添加管理员</a>
		</c:if>
		<table class="table">
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
				<th>操作</th>
			</tr>
			<c:forEach items="${userInfos}" var="u">
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
					<td>
						<a href="<c:url value='/user/userRoleInfo'/>?userId=${u.userId}" class="btn default"> <span class="glyphicon glyphicon-info-sign" title="详情"></span>
						</a> <a href="<c:url value='#'/>?userId=${u.userId}" class="btn default"> <span onclick="getAllUserRoleDetail(${u.userId})" data-toggle="modal" data-target="#updateUserInfo" class="glyphicon glyphicon-edit" title="编辑"></span>
						</a> <a onclick="getRoletoAssign(${u.userId},${u.firmInfo.firmType})" class="btn default" data-toggle="modal" data-target="#assignRoleToUser"> <span class="glyphicon glyphicon-plus" title="角色管理"></span>
						</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="modal fade" id="updateUserInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">用户更新</h4>
				</div>
				<div class="modal-body" style="width: 80%; padding-left: 30px">
					<form class="form" id="updateUserForm">
						<input type="hidden" name="operateId" value="${user.userId }">
						<input type="hidden" name="userId" id="userId">
						<div class="form-group">
							<label for="userNo">用户编号:</label>
							<input type="text" class="form-control" name="userNo" id="userNo" readonly>
						</div>
						<div class="form-group">
							<label for="userName">用户名:</label>
							<input type="text" id="userName" class="form-control" name="userName" readonly>
						</div>
						<div class="form-group">
							<label for="password">密码:</label>
							<input type="password" id="password" class="form-control" name="password" placeholder="输入密码" required>
						</div>
						<c:if test="${groupInfosToAsssign!=null}">
							<div class="form-group">
								<label for="groupId">分组:</label>
								<select name="groupId" class="form-control">
									<option value="">---管理员分组---</option>
									<c:forEach items="${groupInfosToAsssign}" var="g">
										<option value="${g.groupId }">${g.groupName }</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label for="groupManager">是否为小组管理员:</label>
								<select name="groupManager" class="form-control">
									<option value="1">是</option>
									<option value="0" selected>否</option>
								</select>
							</div>
						</c:if>
						<div class="form-group">
							<label for="status">状态:</label>
							<select name="status" class="form-control">
								<option value="1">可用</option>
								<option value="0">禁用</option>
							</select>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" onclick="updateUserInfo()" data-dismiss="modal">保存</button>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="assignRoleToUser" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">角色分配</h4>
				</div>
				<div class="modal-body" style="width: 80%; padding-left: 30px">
					<form class="form" id="assignRoleToUserForm">
						<input type="hidden" name="operateId" value="${user.userId }">
						<input type="hidden" name="userId" id="userIdInput">
						<div id="assignRoleDiv"></div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" onclick="assignRoleToUser()" data-dismiss="modal">保存</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="insertUser" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">注册管理员</h4>
				</div>
				<div class="modal-body" style="width: 80%; padding-left: 30px">
					<form class="form" id="insertUserForm">
						<input type="hidden" name="operateId" value="${user.userId }">
						<div class="form-group">
							<label for="userNo">用户编号:</label>
							<input type="text" class="form-control" name="userNo" placeholder="输入编号" required>
						</div>
						<div class="form-group">
							<label for="userName">用户名:</label>
							<input type="text" class="form-control" name="userName" placeholder="输入用户名" required>
						</div>
						<div class="form-group">
							<label for="password">密码:</label>
							<input type="password" class="form-control" name="password" placeholder="输入密码" required>
						</div>
						<div class="form-group">
							<label for="mobilePhone">电话:</label>
							<input type="text" class="form-control" name="mobilePhone" placeholder="输入电话号码">
						</div>
						<div class="form-group">
							<label for="email">邮箱:</label>
							<input type="text" class="form-control" name="email" placeholder="输入邮箱">
						</div>
						<c:if test="${groupInfosToAsssign!=null }">
							<div class="form-group">
								<label for="groupId">分组:</label>
								<select name="groupId" class="form-control">
									<option value="">---管理员分组---</option>
									<c:forEach items="${groupInfosToAsssign}" var="g">
										<option value="${g.groupId }">${g.groupName }</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label for="groupManager">是否为小组管理员:</label>
								<select name="groupManager" class="form-control">
									<option value="1">是</option>
									<option value="0" selected>否</option>
								</select>
							</div>
						</c:if>
						<div class="form-group">
							<label for="status">状态:</label>
							<select name="status" class="form-control">
								<option value="1">可用</option>
								<option value="0">禁用</option>
							</select>
						</div>
						<div>
							<c:if test="${firmInfosToAssign!=null }">
								<label for="firmId">公司:</label>
								<select name="firmId" class="form-control">
									<c:forEach items="${firmInfosToAssign }" var="f">
										<option value="${f.firmId }">${f.firmName }&nbsp;${f.firmNo}</option>
									</c:forEach>
								</select>
							</c:if>
							<c:if test="${firmInfosToAssign==null }">
								<input type="hidden" name="firmId" value="${user.firmInfo.firmId }">
							</c:if>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" onclick="insertUser()" data-dismiss="modal">保存</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>