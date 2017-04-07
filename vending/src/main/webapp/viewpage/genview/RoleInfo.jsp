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
		<!-- firmType==0系统管理员才有的权限 -->
		<c:if test="${user.firmInfo.firmType==0 }">
			<a type="button" class="btn btn-primary" data-toggle="modal"
				data-target="#insertRole">添加角色</a>
		</c:if>
		<table class="table">
			<tr>
				<th>Id</th>
				<th>角色名称</th>
				<th>角色类型</th>
				<th>操作时间</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${allRoleInfos}" var="role">
				<tr>
					<td>${role.roleId }</td>
					<td>${role.roleName }</td>
					<td>
						<c:if test="${role.firmType==0}">
						系统管理员
						</c:if>
						<c:if test="${role.firmType==1}">
						运营商
						</c:if>
						<c:if test="${role.firmType==2}">
						厂商
						</c:if>
					</td>
					<td>${role.operateDate }</td>
					<td><a href="<c:url value="/user/getRoleAuthInfo"/>?roleId=${role.roleId }" class="btn default">
							<span class="glyphicon glyphicon-info-sign" title="详情"></span> 
						</a> 
						<a class="btn default" onclick="getRoleById(${role.roleId })" data-toggle="modal" data-target="#getRole"> 
							<span class="glyphicon glyphicon-edit" title="编辑"></span>
						</a> 
						<a  href="<c:url value="/user/insertRoleAuthInfo"/>?roleId=${role.roleId }" class="btn default">
							<span class="glyphicon glyphicon-plus" title="添加权限"></span> 
						</a> 
						<a onclick="delRole(${role.roleId })" class="btn default">
							<span class="glyphicon glyphicon-trash" title="删除角色"></span> 
						</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div class="modal fade" id="insertRole" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加角色</h4>
				</div>
				<div class="modal-body" style="width: 80%; padding-left: 30px">
					<form class="form" id="insertRoleForm">
						<div class="form-group">
							<label for="roleName">角色名称:</label> <input type="text"
								class="form-control" name="roleName" placeholder="输入角色名称"
								required="required">
						</div>
						<label for="firmType">角色类型:</label>
						<select name="firmType" class="form-control" required>
							<option value="0" id="sys">系统管理员</option>
							<option value="1" id="ope">运营商</option>
							<option value="2" id="manu">厂商</option>
						</select>

					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary"
						onclick="insertRole()" data-dismiss="modal">保存</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="getRole" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">编辑角色</h4>
				</div>
				<div class="modal-body" style="width: 80%; padding-left: 30px">
					<form class="form" id="updateRoleForm">
					<input type="hidden" name="roleId" id="roleIdUpdate">
						<div class="form-group">
							<label for="roleName">角色名称:</label> 
							<input type="text" class="form-control" name="roleName" id="newRoleName" placeholder="输入角色名称" required="required">
						</div>
						<label for="firmType" id="type">角色类型:</label> 
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary"
						onclick="updateRole()" data-dismiss="modal">保存</button>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
function delRole(roleId){
	if(confirm("确认删除该角色，及该角色的权限对应关系？")){
		$.ajax({
			url : "<c:url value='/user/deleteRole'/>?roleId="+roleId,
			type: "delete",
			dataType:"text",
			success:function(response){
				alert("删除成功");
	        	location.reload();
	        },  
	        error:function(){  
	            alert("获取数据失败");  
	        }  
		});
	}
}
function updateRole(){
	$.ajax({
		url : "<c:url value='/user/updateRole'/>",
		type: "post",
		dataType:"text",
		data: $('#updateRoleForm').serialize(),
		success:function(response){
			alert("更新成功");
        	location.reload();
        },  
        error:function(){  
            alert("更新失败");  
        }  
	});
}
function getRoleById(roleId){
	$.ajax({
		url : "<c:url value='/user/getRoleById'/>?roleId="+roleId,
		type: "get",
		dataType:"json",
		success:function(data){
			$("#roleIdUpdate").val(roleId);
			$("#newRoleName").val(data.roleName);
			var type=data.firmType;
			var typeText="";
			if(type==0){
				typeText="系统管理员";
			}else if(type==1){
				typeText="运营商";
			}else if(type==2){
				typeText="厂商";
			}
			$("#type").text("角色类型:"+typeText);
        },  
        error:function(){  
            alert("获取数据失败");  
        }  
	});
}
function insertRole(){
	$.ajax({
		url : "<c:url value='/user/insertRole'/>",
		type: "post",
		dataType:"text",
		data: $('#insertRoleForm').serialize(),
		success:function(response){
			alert(response);
        	location.reload();
        },  
        error:function(){  
            alert("添加失败");  
        }  
	});
}
</script>
</html>