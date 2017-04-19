function addChannelWare(){
	$.ajax({
		url:'../channel/addChannelWare',
		type:"post",
		dataType:"text",
		data:$("#channelWareForm").serialize(),
		success: function(res){
			alert("");
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

