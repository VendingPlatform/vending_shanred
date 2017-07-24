function createFirmInfo() {
	$.ajax({
		url : "../manager/createFirmInfo",
		type : "post",
		dataType : "text",
		data : $('#createFirmInfo').serialize(),
		success : function(response) {
			if (response == "true") {
				alert("添加成功");
			} else if (response == "false") {
				alert("编号重复，请重置");
			}
			location.reload();
		},
		error : function() {
			alert("添加失败");
		}
	});
}

function insertFirm() {
	$.ajax({
		url : "../manu/insertFirmToManu",
		type : "post",
		dataType : "text",
		data : $('#insertFirmForm').serialize(),
		success : function(responseText) {
			alert("添加成功" + responseText + "个");
			location.reload();
		},
		error : function() {
			alert("添加失败");
		}
	});
}
function updateFirmInfo() {
	$.ajax({
		url : "../manager/updateFirmInfo",
		type : "post",
		dataType : "text",
		data : $('#updateFirmInfo').serialize(),
		success : function(responseText) {
			alert("更新成功");
			location.reload();
		},
		error : function() {
			alert("更新失败");
		}
	});
}
function addGroup() {
	$.ajax({
		url : "../machine/machineGroupCreate",
		type : "post",
		dataType : "text",
		data : $('#addGroupForm').serialize(),
		success : function(responseText) {
			if (responseText == 1) {
				alert("添加成功");
			} else {
				alert("添加失败");
			}
			location.reload();
		},
		error : function() {
			alert("创建失败");
		}
	});
}

function addMachineToGroup(){
	$.ajax({  
        url:"../machine/addMachineToGroup",
        type:"post",  
        dataType:"text",  
        data:$('#addMachineToGroupForm').serialize(),
        success:function(responseText){  
        	alert("添加成功");
        	location.reload();
        },  
        error:function(){  
            alert("添加失败");  
        }  
    });  
}