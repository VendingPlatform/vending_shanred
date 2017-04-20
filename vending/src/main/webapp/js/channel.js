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


function addChannelGroup(){
	$.ajax({
		url : "../../channel/addChannelGroup",
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
