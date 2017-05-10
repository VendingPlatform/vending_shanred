

function addChannelWare(){
	$.ajax({
		url:'../channel/addChannelWare',
		type:"post",
		dataType:"text",
		data:$("#channelWareForm").serialize(),
		success: function(res){
			alert("添加成功");
		},
		error: function(){
			alert("获取数据失败");
		}
	});
}

function getChannelInfoToUpdate(channenId){
	$.ajax({
		url:"../channel/getChannelInfoAndChannelWareInfo",
		type:"get",
		dataType:"json",
		success :function(data){

		},
		error: function(){
			alert("获取数据失败");
		}

	});
}


function addChannelGroup(basePath){
	$.ajax({
		url : basePath+"channel/addChannelGroup",
		type : "post",
		dataType : "text",
		data : $("#addChannelGroupForm").serialize(),
		success : function(res){
			alert("添加货道组成功");
			location.reload();
		},
		error: function(){
			alert("获取数据失败");
		}
	});
}

function getAllMachienChannelsNotAssign(basePath,firmId,channelGroupId){
	$.ajax({
		url: basePath+"channel/getAllMachinesNotAssign/"+firmId,
		type:"get",
		dataType:"json",
		success: function(data){
			$("#channelGroupId").val(channelGroupId);
			$("#channelsNotAssign").empty();
			var html = "";
			for (i in data){
				data[i];
				html = "<label class='checkbox'><input type='checkbox' name='channelId' value='"+data[i].channelId+"'>"
				+data[i].channelNo+"&nbsp;"+data[i].machineInfo.machineName+"&nbsp;"+data[i].machineInfo.machinePannel+"&nbsp;</label>";
				$("#channelsNotAssign").append(html);
			}
		},
		error: function(){
			alert("获取数据失败");
		}
	});
}
function addChannelsToGroup(basePath){
	$.ajax({
		url:basePath+"channel/addChannelsToGroup",
		type:"post",
		dataType:"text",
		data:$("#addChannelsToGroupForm").serialize(),
		success: function(res){
			alert("添加成功");
			location.reload();
		},
		error: function(){
		alert("获取数据失败");	
		}
	});
}