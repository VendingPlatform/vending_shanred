/**
 * 获取处理中任务量
 */
var time="";
function getProcessingTaskSum(){
	$.ajax({
		url:"getProcessingTaskSum!getProcessingTaskSum.action",
		data:'',
		dataType:'text',
		type:'post',
		cache:false,
		success:function(data){
			$('#processCount').html(data);
		},
		
	});
}
//setTimeout('getProcessingTaskSum()',0);
//var timer = setInterval(function(){
//	getProcessingTaskSum();
//},30000);


