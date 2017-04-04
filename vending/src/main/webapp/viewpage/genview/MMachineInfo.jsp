<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String pathurl = request.getContextPath();
	String basePathurl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ pathurl + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<%@include file="../topmenu.jsp"%>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="<c:url value="/home"/>">主页</a></li>
					<li class="active">售货机列表</li>
				</ul>
			</div>
		</div>
		<a href="#" class="btn btn-primary"  data-toggle="modal" data-target="#addMachine"> 
			<span class="glyphicon glyphicon-plus"></span>添加售货机
			</a>
		<div>
			<table class="table">
				<tr>
					<th>售货机Id</th>
					<th>售货机名称</th>
					<th>售货机主板号</th>
					<th>厂商</th>
					<th>售货机价格</th>
					<th>售货机类型</th>
					<th>售货机状态</th>
					<th>运营商</th>
					<th>操作者</th>
					<th>操作日期</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${machineInfos}" var="m">
				<tr>
					<td>${m.machineId}</td>
					<td>${m.machineName}</td>
					<td>${m.machinePannel}</td>
					<td>${m.manuFirmInfo.firmName}</td>
					<td>${m.machinePrice}</td>
					<td>${m.tModelName}</td>
					<td><!--0:未售出，1：已售出，2：回收-->
						<c:if test="${m.manuMachineStatus==0}">未售出</c:if>
						<c:if test="${m.manuMachineStatus==1}">已售出</c:if>
						<c:if test="${m.manuMachineStatus==2}">回收</c:if>
					</td>
					<td>${m.operFirmInfo.firmName}</td>
					<td>${m.operateId}</td>
					<td>${m.operateDate}</td>
					<td>
						<a onclick="getMachineInfoById(${m.machineId})" class="btn default"
						data-toggle="modal" data-target="#updateMachineModal"> 
						<span class="glyphicon glyphicon-edit" title="编辑"></span>
						</a>
						<a onclick="document.getElementById('machineIdInput').value=${m.machineId};document.getElementById('manuFirmId').value=${m.manuFirmInfo.firmId}" class="btn default"
						data-toggle="modal" data-target="#assignMachine"> 
						<span class="glyphicon glyphicon-link" title="分配"></span>
						</a>
						<a onclick="delMachine(${m.machineId})" class="btn default"> 
						<span class="glyphicon glyphicon-trash" title="删除"></span>
						</a>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div class="modal fade" id="assignMachine" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  		<div class="modal-dialog" role="document">
   			<div class="modal-content">
      			<div class="modal-header">
        			<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        			<h4 class="modal-title" id="myModalLabel">分配售货机</h4>
      			</div>
      			<div class="modal-body" style="width: 80%; padding-left: 30px">
      				<form method="post" id="assignMachineForm" >
      				<input type="hidden" name="operateId" value="${user.userId}"/>
      				<input type="hidden" name="machineId" id="machineIdInput"/>
      				<input type="hidden" name="manuFirmInfo.firmId" id="manuFirmId">
      					<c:forEach items='${operMgrs}' var='f'>
      					<div class="radio">
  							<label>
  							 	 <input type="radio" name="operFirmInfo.firmId" value="${f.firmId }">${f.firmId }&nbsp;${f.firmName }&nbsp;${f.firmNo }
 						    </label>
						</div>
						</c:forEach>
		        	</form>
      			</div>
    	  		<div class="modal-footer">
    	    		<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      	    		<button type="button" class="btn btn-primary"  onclick="assignMachineInfo()" data-dismiss="modal">分配</button>
     	 		</div>
   	 		</div>
 		 </div>
	</div> 
	<div class="modal fade" id="addMachine" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  		<div class="modal-dialog" role="document">
   			<div class="modal-content">
      			<div class="modal-header">
        			<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        			<h4 class="modal-title" id="myModalLabel">添加售货机</h4>
      			</div>
      			<div class="modal-body" style="width: 80%; padding-left: 30px">
      				<form method="post" id="addMachineInfoForm" >
      					<input type="hidden" name="operateId" value="${user.userId}" />
      					<input type="hidden" name="manuMachineStatus" value="0" />
      					<input type="hidden" name="manuFirmId" value="${user.firmInfo.firmId }" />
      					
      					<div class="form-group">
		        			<label for="machineName">售货机名称:</label>
		        			<input type="text" class="form-control" name="machineName" placeholder="输入售货机名" required="required">
		        		</div>
		        		<div class="form-group">
		        			<label for="machinePannel">售货机主板号:</label>
		        			<input type="text" class="form-control" name="machinePannel" placeholder="输入售货机主板号" required="required">
		        		</div>
		        		<div class="form-group">
		        			<label for="machinePrice">售货机价格:</label>
		        			<input type="text" class="form-control" id="machinePrice" name="machinePrice" placeholder="输入售货机价格" required="required">
		        		</div> 
      					<div class="form-group">
		        		<label for='tModelName'>售货机类型:</label>
						<select name="tModelName" class="form-control">
						<option value="">---售货机类型---</option>
						<c:forEach items='${machineTypes}' var='t'>
							<option value='${t.tModelName}'>${t.tModelName}</option>
						</c:forEach>
						</select>
		        		</div>
		        	</form>
      			</div>
    	  		<div class="modal-footer">
    	    		<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      	    		<button type="button" class="btn btn-primary"  onclick="addMachineInfo()" data-dismiss="modal">保存</button>
     	 		</div>
   	 		</div>
 		 </div>
	</div>
	<div class="modal fade" id="updateMachineModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  		<div class="modal-dialog" role="document">
   			<div class="modal-content">
      			<div class="modal-header">
        			<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        			<h4 class="modal-title" id="myModalLabel">更新售货机信息</h4>
      			</div>
      			<div class="modal-body" style="width: 80%; padding-left: 30px">
      				<form method="post" id="updateMachineInfo" >
      					<input type="hidden" name="operateId" value="${user.userId}" />
      					<div id="form">
      					</div>
      					<div class="form-group">
		        		<label for='tModelName'>售货机类型:</label>
						<select name="tModelName" class="form-control">
						<option value="">---售货机类型---</option>
						<c:forEach items='${machineTypes}' var='t'>
							<option value='${t.tModelName}'>${t.tModelName}</option>
						</c:forEach>
						</select>
		        		</div>
		        	</form>
		        	
      			</div>
    	  		<div class="modal-footer">
    	    		<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      	    		<button type="button" class="btn btn-primary"  onclick="updateMachine()" data-dismiss="modal">保存</button>
     	 		</div>
   	 		</div>
 		 </div>
	</div>
</body>
<script type="text/javascript">
function assignMachineInfo(){
	$.ajax({
		url:"<c:url value='/manu/assignMachine'/>",
		type:"post",
		dataType:"text",
		data:$('#assignMachineForm').serialize(),
		success:function(response){  
        	alert(response);
        	location.reload();
        },  
        error:function(){  
            alert("分配失败");  
        }  
	});	
}

function delMachine(machineId){
	$.ajax({
		url:"<c:url value='/manu/deleteMachineInfo'/>?machineId="+machineId,
		type:"delete",
		dataType:"text",
		success:function(response){ 
			if(response=="true"){
				alert("删除成功");
			}else{
				alert("删除失败");
			}
        	location.reload();
        },  
        error:function(){  
            alert("删除失败");  
        }  
	});	
}
function addMachineInfo(){
	$.ajax({
		url:"<c:url value='/manu/addMachine'/>",
		type:"post",
		dataType:"text",
		data:$('#addMachineInfoForm').serialize(),
		success:function(responseText){  
        	alert('添加成功');
        	location.reload();
        },  
        error:function(){  
            alert("添加失败");  
        }  
	});	
}

function updateMachine(){
	$.ajax({  
        url:"<c:url value='/manu/updateMachine'/>",
        type:"post",  
        dataType:"text",  
        data:$('#updateMachineInfo').serialize(),
        success:function(responseText){  
        	alert(responseText);
        	location.reload();
        },  
        error:function(){  
            alert("更新失败");  
        }  
    });  
}
function getMachineInfoById(machineId){
	$.ajax({  
        url:"<c:url value='/manu/getMachineInfoById'/>?machineId="+machineId,
        type:"get",  
        dataType:"json",  
        success:function(data){  
        	var manuMachineStatus= data.manuMachineStatus===0? "未出售" :(data.manuMachineStatus===1 ? "已出售": "已回收");
        	var operFirmId = data.operFirmInfo== undefined ? '' : data.operFirmInfo.firmName;
        	var manuFirmId = data.manuFirmInfo == undefined ? '' : data.manuFirmInfo.firmName;
        	var price = data.machinePrice == undefined ? '' : data.machinePrice;
        	var html = "<input type='hidden' name='machineId' value='"+data.machineId+"' />"+
        				"<div class='form-group'>"+
        				"<label for='machineName'>售货机名称:</label>"+
        				"<input type='text' class='form-control' name='machineName' value="+data.machineName+" placeholder='售货机名称'>"+
        				"</div>"+
        				"<div class='form-group'>"+
							"<label for='machinePannel'>售货机主板号:</label>"+
							"<input type='text' class='form-control' name='machinePannel' value="+data.machinePannel+" placeholder='售货机主板号'>"+
						"</div>"+
						"<div class='form-group'>"+
							"<label for='manFirmId'>厂商:</label>"+
							manuFirmId
						+"</div>"+
						"<div class='form-group'>"+
							"<label for='machinePrice'>售货机价格:</label>"+
							"<input type='text' class='form-control' name='machinePrice' value='"+price+"'  placeholder='售货机价格'>"+
						"</div>"+
						"<div class='form-group'>"+
							"<label for='manuMachineStatus'>售货机状态:</label>"+
							manuMachineStatus
							+"<input type='hidden' name='manuMachineStatus' value='"+data.manuMachineStatus+"' />"
						+"</div>"+
						"<div class='form-group'>"+
							"<label for='operFirmId'>运营商:</label>"+	
							operFirmId
						+"</div>";
			$("#form").empty();
        	$("#form").append(html);
        },  
        error:function(){  
            alert("获取失败");  
        }  
    });  
}
</script>
</html>