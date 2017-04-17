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