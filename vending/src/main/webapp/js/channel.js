function insertChannelInfo(){
	$.ajax({
		url:"../channel/insertChannel",
		type:"post",
		dataType:"text",
		data:$("#insertChannelForm").serialize(),
		success: function(response){
			alert(response);
			location.reload();
		},
		error: function(){
			alert("获取数据失败");
		}
	});
}