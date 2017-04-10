function createUserGroup(){
	$.ajax({
		url: "../user/createUserGroup",
		type:"post",
		dataType:"text",
		data: $("#createUserGroupForm").serialize(),
		success: function(response){
			alert("创建成功");
			location.reload();
		},
		error: function(){
			alert("获取数据失败");
		}
	});
}

function getRoletoAssign(userId, firmType) {
	$
			.ajax({
				url : "../user/getAllRoleAssignToUser?firmType=" + firmType,
				type : "get",
				dataType : "json",
				success : function(data) {
					$("#userIdInput").val(userId);
					$("#assignRoleDiv").empty();
					for ( var i in data) {
						var html = "<label class='checkbox'>"
								+ "<input type='checkbox' name='roleIds' value='"
								+ data[i].roleId + "'>" + data[i].roleName
								+ "</label>";
						$("#assignRoleDiv").append(html);
					}
				},
				error : function() {
					alert("获取数据失败");
				}
			});
}

function assignRoleToUser() {
	$.ajax({
		url : "../user/assignRoleToUser",
		type : "post",
		dataType : "text",
		data : $('#assignRoleToUserForm').serialize(),
		success : function(response) {
			alert(response);
			// location.reload();
		},
		error : function() {
			alert("添加失败");
		}
	});
}
function insertUser() {
	$.ajax({
		url : "../user/registerUser",
		type : "post",
		dataType : "text",
		data : $('#insertUserForm').serialize(),
		success : function(response) {
			alert(response);
			location.reload();
		},
		error : function() {
			alert("添加失败");
		}
	});
}

function updateUserInfo(){
	$.ajax({
		url : "../user/updateUserInfo",
		type:"post",
		dataType:"text",
		data:$("#updateUserForm").serialize(),
		success:function(response){
			alert("更新成功");
		},
		error: function(){
			alert("获取数据失败");
		}
	});
}
function getAllUserRoleDetail(userId) {
	debugger
	$.ajax({
		url : "../user/getUserInfoToUpdate?userId=" + userId,
		type:"get",
		dataType:"json",
		success: function(data){
			$("#userId").val(data.userId);
			$("#userNo").val(data.userNo);
			$("#userName").val(data.userName);
			$("#password").val(data.password);
		},
		error:function(){
			alert("获取数据失败");
		}
	});
}
function authAssignedRole() {
	$.ajax({
		url : "../user/assignAuthToRole",
		type : "post",
		dataType : "text",
		data : $('#authAssignForm').serialize(),
		success : function(response) {
			alert("分配成功");
			location.reload();
		},
		error : function() {
			alert("获取数据失败");
		}
	});
}
function getAllAuths(roleId, firmType) {
	$
			.ajax({
				url : "../user/getAllAuths",
				type : "get",
				dataType : "json",
				data : {
					roleId : roleId,
					firmType : firmType
				},
				success : function(response) {
					$("#roleIdAssign").val(roleId);
					$("#checkbox").empty();
					for (var i = 0; i < response.length; i++) {
						var html = "<label class='checkbox'><input type='checkbox' name='authIds' value='"
								+ response[i].authId
								+ "'>"
								+ response[i].authName
								+ "&nbsp;"
								+ response[i].authCode
								+ "&nbsp;"
								+ response[i].authDesc + "</label>";
						$("#checkbox").append(html);
					}
				},
				error : function() {
					alert("获取数据失败");
				}
			});
}

function delRole(roleId) {
	if (confirm("确认删除该角色，及该角色的权限对应关系？")) {
		$.ajax({
			url : "../user/deleteRole?roleId=" + roleId,
			type : "delete",
			dataType : "text",
			success : function(response) {
				alert(response);
				location.reload();
			},
			error : function() {
				alert("获取数据失败");
			}
		});
	}
}
function updateRole() {
	$.ajax({
		url : "../user/updateRole",
		type : "post",
		dataType : "text",
		data : $('#updateRoleForm').serialize(),
		success : function(response) {
			alert("更新成功");
			location.reload();
		},
		error : function() {
			alert("更新失败");
		}
	});
}
function getRoleById(roleId) {
	$.ajax({
		url : "../user/getRoleById?roleId=" + roleId,
		type : "get",
		dataType : "json",
		success : function(data) {
			$("#roleIdUpdate").val(roleId);
			$("#newRoleName").val(data.roleName);
			var type = data.firmType;
			var typeText = "";
			if (type == 0) {
				typeText = "系统管理员";
			} else if (type == 1) {
				typeText = "运营商";
			} else if (type == 2) {
				typeText = "厂商";
			}
			$("#type").text("角色类型:" + typeText);
		},
		error : function() {
			alert("获取数据失败");
		}
	});
}
function insertRole() {
	$.ajax({
		url : "../user/insertRole",
		type : "post",
		dataType : "text",
		data : $('#insertRoleForm').serialize(),
		success : function(response) {
			alert(response);
			location.reload();
		},
		error : function() {
			alert("添加失败");
		}
	});
}