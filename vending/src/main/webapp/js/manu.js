var script = document.createElement('script');
script.src = "https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js";
document.head.appendChild(script);

function assignMachineInfo() {
	$.ajax({
		url : "../manu/assignMachine",
		type : "post",
		dataType : "text",
		data : $('#assignMachineForm').serialize(),
		success : function(response) {
			alert(response);
			location.reload();
		},
		error : function() {
			alert("分配失败");
		}
	});
}

function delMachine(machineId) {
	$.ajax({
		url : "../manu/deleteMachineInfo?machineId=" + machineId,
		type : "delete",
		dataType : "text",
		success : function(response) {
			if (response == "true") {
				alert("删除成功");
			} else {
				alert("删除失败");
			}
			location.reload();
		},
		error : function() {
			alert("删除失败");
		}
	});
}
function addMachineInfo() {
	$.ajax({
		url : "../manu/addMachine",
		type : "post",
		dataType : "text",
		data : $('#addMachineInfoForm').serialize(),
		success : function(responseText) {
			alert('添加成功');
			location.reload();
		},
		error : function() {
			alert("添加失败");
		}
	});
}

function updateMachine() {
	$.ajax({
		url : "../manu/updateMachine",
		type : "post",
		dataType : "text",
		data : $('#updateMachineInfo').serialize(),
		success : function(responseText) {
			alert(responseText);
			location.reload();
		},
		error : function() {
			alert("更新失败");
		}
	});
}

function getMachineInfoById(machineId) {
	debugger
	$
			.ajax({
				url : "../manu/getMachineInfoById?machineId=" + machineId,
				type : "get",
				dataType : "json",
				success : function(data) {
					var manuMachineStatus = data.manuMachineStatus === 0 ? "未出售"
							: (data.manuMachineStatus === 1 ? "已出售" : "已回收");
					var operFirmId = data.operFirmInfo == undefined ? ''
							: data.operFirmInfo.firmName;
					var manuFirmId = data.manuFirmInfo == undefined ? ''
							: data.manuFirmInfo.firmName;
					var price = data.machinePrice == undefined ? ''
							: data.machinePrice;
					var html = "<input type='hidden' name='machineId' value='"
							+ data.machineId
							+ "' />"
							+ "<div class='form-group'>"
							+ "<label for='machineName'>售货机名称:</label>"
							+ "<input type='text' class='form-control' name='machineName' value="
							+ data.machineName
							+ " placeholder='售货机名称'>"
							+ "</div>"
							+ "<div class='form-group'>"
							+ "<label for='machinePannel'>售货机主板号:</label>"
							+ "<input type='text' class='form-control' name='machinePannel' value="
							+ data.machinePannel
							+ " placeholder='售货机主板号'>"
							+ "</div>"
							+ "<div class='form-group'>"
							+ "<label for='manFirmId'>厂商:</label>"
							+ manuFirmId
							+ "</div>"
							+ "<div class='form-group'>"
							+ "<label for='machinePrice'>售货机价格:</label>"
							+ "<input type='text' class='form-control' name='machinePrice' value='"
							+ price
							+ "'  placeholder='售货机价格'>"
							+ "</div>"
							+ "<div class='form-group'>"
							+ "<label for='manuMachineStatus'>售货机状态:</label>"
							+ manuMachineStatus
							+ "<input type='hidden' name='manuMachineStatus' value='"
							+ data.manuMachineStatus + "' />" + "</div>"
							+ "<div class='form-group'>"
							+ "<label for='operFirmId'>运营商:</label>"
							+ operFirmId + "</div>";
					$("#form").empty();
					$("#form").append(html);
				},
				error : function() {
					alert("获取失败");
				}
			});
}

function updateMachineType() {
	$.ajax({
		url : "../manu/updateType",
		type : "post",
		dataType : "text",
		data : $('#updateMachineType').serialize(),
		success : function(responseText) {
			alert("更新成功");
			location.reload();
		},
		error : function() {
			alert("更新失败");
		}
	});
}

function getTypeById(tModelId) {
	$.ajax({
		url : "../manu/getTypeById?tModelId=" + tModelId,
		type : "get",
		dataType : "json",
		success : function(data) {
			$("#tId").val(tModelId);
			$("#tModelName").val(data);
		},
		error : function() {
			alert("数据错误");
		}
	});
}

function addChannelInfo(){
	$.ajax({
		url : "../manu/addChannelInfo",
		type : "post",
		dataType : "text",
		data : $("#addChannelForm").serialize(),
		success : function(res) {
			alert(res);
			location.reload();
		},
		error : function() {
			alert("获取数据失败");
		}
	});
}

function deleteChan(channelId) {
	if (confirm("确定删除该货道，及货道信息？")) {
		$.ajax({
			url : "../manu/deleteChannel?channelId=" + channelId,
			type : "get",
			dataType : "text",
			success : function(res) {
				alert("删除成功");
				location.reload();
			},
			error : function() {
				alert("获取数据失败");
			}
		});
	}
}
