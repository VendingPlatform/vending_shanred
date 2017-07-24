/**
 * 获取上报任务量
 */
var timer =null,showWindow=false,windowName=null;
var w=screen.availWidth,h=screen.availHeight,htmlWidth=200,htmlHeight=100;
var topV=h-htmlHeight-58,leftV=w-htmlWidth;
//判断是否需要弹窗提示信息
var reportMsgFlag=$('#js-authorityCode').val().indexOf('001')!=-1,
processingMsgFlag=$('#js-authorityCode').val().indexOf('010')!=-1;

function getReportRaskSum(){
	$.ajax({
		url:"getReportTaskSum!getReportTaskSum.action",
		data:'',
		type:'post',
		cache:false,
		dataType:'text',
		success:function(data){
			if(-10000==data){
				location.href=location.href=$('#basePath').val();
			}else if(-100==data){
				clearInterval(timer);
			}else if(-1==data){
				clearInterval(timer);
				window.location.href=$('#basePath').val()+"loginU!loginU.action";
			}else if(-2==data){
				clearInterval(timer);
			}else{
				if( data > 0 ){
					$('#add_status_count').html(data);
					if(showWindow&&reportMsgFlag)
						windowName=window.open($('#basePath').val()+"helpDeskUI/htmlView/msg.html","msgWindow",
								"height="+htmlHeight+", width="+htmlWidth+",top="+topV+",left="+leftV+", " +
								"toolbar =no, menubar=no, scrollbars=no, resizable=no," +
								" alwaysRaised=yes, location=0, status=no,directories=no");
				}else{
					$('#add_status_count').html(0);
				}
			}
		},
		error:function(){
			if(data !== '')
			 clearInterval(timer);
		}
	});
	//值班信息刷新
	$.ajax({
		url:"getRefresh!getRefresh.action",
		data:'',
		type:'post',
		cache:false,
		dataType:'json',
		success:function(datas){
			if(datas!=100){
				$('#jsw-subfield').html(datas.subfield);
				$('#jsw-directWatchPerson').html(datas.directWatchPerson);
				$('#jsw-auxiliaryWatchPerson').html(datas.auxiliaryWatchPerson);
				$('#jsw-phone').html(datas.phone);
				$('#jsw-startTime').html(datas.startTime);
				$('#jsw-endTime').html(datas.endTime);
			}else{
				if(null!=timer)
					 clearInterval(timer);
				
				window.location.href=$('#basePath').val()+"loginU!loginU.action";
			}
		},
		error:function(){
			if(null!=timer)
			 clearInterval(timer);
		}
	});
	
	$.ajax({
		url:"getProcessingTaskSum!getProcessingTaskSum.action",
		data:'',
		dataType:'text',
		type:'post',
		cache:false,
		success:function(data){
			if(data>0){
				if(showWindow&&processingMsgFlag){
					windowName=window.open($('#basePath').val()+"helpDeskUI/htmlView/msg.html","msgWindow",
							"height="+htmlHeight+", width="+htmlWidth+",top="+topV+",left="+leftV+", " +
							"toolbar =no, menubar=no, scrollbars=no, resizable=no," +
							" alwaysRaised=yes, location=0, status=no,directories=no");
				}
					
			}else{
				data=0;
			}
			$('#processCount').html(data);
		},
	});
}
getReportRaskSum();
clearInterval(timer);
timer= setInterval(function(){
	showWindow=true;
	getReportRaskSum();
},30000);
