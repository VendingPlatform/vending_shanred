/**
 * 
 */
function getAssignToUsers(mOperaterId) {
	$.ajax({
		url : "../machine/getAssignToUsers",
		type : "get",
		dataType : "json",
		success : function(data) {
			$("#mOperaterId").val(mOperaterId);
			$("#selectUserToAssign").empty();
			for ( var i in data) {
				var html = "<div class='radio'> <label>"
						+ "<input type='radio' name='userId' value='"
						+ data[i].userId + "' checked>" + data[i].userName
						+ "&nbsp;" + data[i].userNo + "</label></div>";
				$("#selectUserToAssign").append(html);
			}
		},
		error : function() {
			alert("获取数据失败");
		}
	});
}
function assignMachineToUser(){
	$.ajax({
		url:"../machine/assignMachineToUser",
		type:"post",
		data:$("#assignMachineToUserForm").serialize(),
		dataType:"text",
		success : function(response){
			alert(response);
		},
		error : function(){
			alert("获取数据失败");
		}
	});
}

function removeMachine(mOperaterId) {
	if (confirm("确认移除该售货机?")) {
		$.ajax({
			url : "../machine/removeMachineOperater?mOperaterId=" + mOperaterId,
			type : "post",
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