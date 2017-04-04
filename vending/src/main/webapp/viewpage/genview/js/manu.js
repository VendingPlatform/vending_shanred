function getMachineInfoById(machineId){
	debugger
	$.ajax({  
        url:"<c:url value='/manu/getMachineInfoById'/>?machineId="+machineId,
        type:"get",  
        dataType:"json",  
        success:function(data){  
        	var manuMachineStatus= data.manuMachineStatus===0? "未出售" :(data.manuMachineStatus===1 ? "已出售": "已回收");
        	$("#updateMachineInfo").empty();
        	var html = "<div class='form-group'>"+
        				"<label for='machineName'>售货机名称:</label>"+
        				"<input type='text' class='form-control' name='machineName' value="+data.machineName+" placeholder='售货机名称'>"+
        				"</div>"+
        				"<div class='form-group'>"+
							"<label for='machinePannel'>售货机主板号:</label>"+
							"<input type='text' class='form-control' name='machinePannel' value="+data.machinePannel+" placeholder='售货机主板号'>"+
						"</div>"+
						"<div class='form-group'>"+
							"<label for='manFirmId'>厂商:</label>"+
							data.manuFirmInfo.firmName
						+"</div>"+
						"<div class='form-group'>"+
							"<label for='machinePrice'>售货机价格:</label>"+
							"<input type='text' class='form-control' name='machinePrice' value="+data.machinePrice+" required placeholder='售货机价格'>"+
						"</div>"+
						"<div class='form-group'>"+
							"<label for='tModelName'>售货机类型：</label>"+
							"<input type='text' class='form-control' name='tModelName' required placeholder='售货机类型'>"+
						"</div>"+
						"<div class='form-group'>"+
							"<label for='manuMachineStatus'>售货机状态:</label>"+
							manuMachineStatus
						+"</div>"+
						"<div class='form-group'>"+
							"<label for='operFirmId'>运营商:</label>"+
							data.operFirmInfo.firmName+
						"</div>";
        	
        	$("#updateMachineInfo").append(html);
        },  
        error:function(){  
            alert("获取失败");  
        }  
    });  
}