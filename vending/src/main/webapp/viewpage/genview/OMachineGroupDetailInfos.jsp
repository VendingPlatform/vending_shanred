<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>OMachineGroupDetailInfos</title>
</head>
<body>
	<%@include file="../topmenu.jsp"%>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="<c:url value="/home"/>">主页</a></li>
					<li><a href="<c:url value="/machine/machineGroup"/>">售货机分组</a></li>
					<li class="active">售货机分组详情</li>
				</ul>
			</div>
		</div>
		<div>
		<a href="#" class="btn btn-primary"  data-toggle="modal" data-target="#addMachineToGroup" > 
			<span class="glyphicon glyphicon-plus"></span>添加售货机
		</a>
			<table class="table">
				<tr>
					<th>铭牌号</th>
					<th>主板号</th>
					<th>是否分配</th>
					<th>售货机类型</th>
					<th>售货机地址</th>
					<th>售货机可用</th>
					<th>售货机组</th>
					<th>所属公司</th>
					<th></th>
				</tr>
				<c:forEach items="${machineGroupDetialInfos}" var="machine">
					<tr>
						<td>${machine.machineName }</td>
						<td>${machine.machinePannel }</td>
						<td>${machine.machineAssign }</td>
						<td>${machine.tModelName }</td>
						<td>${machine.machineAddress }</td>
						<td>${machine.machineStatus}</td>
						<td>${machine.groupInfo.groupName}</td>
						<td>${machine.operFirmId}</td>
						<td>
							<a href= "<c:url value="/machine/machineInfoDetail"/>?mOperaterId=${machine.mOperaterId}" class="btn default">
								<span class="glyphicon glyphicon-info-sign" title="详情"></span>
							</a> 
							<a href= "<c:url value="/machine/machineInfoRemoveGroup"/>?mOperaterId=${machine.mOperaterId}&groupId=${machine.groupInfo.groupId}" class="btn default">
								<span class="glyphicon glyphicon-remove-sign" title="移除"></span>
							</a> 
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="modal fade" id="addMachineToGroup" tabindex="-1" role="dialog" aria-labelledby="ModelAdd">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="ModelAdd">添加售货机</h4>
		      </div>
		      <div class="modal-body" style="width:500px">
		        	<form  method="post" id="addMachineToGroupForm" >
		        	<input type="hidden" value="${groupId}" name="groupId">
		        	<c:forEach items="${machineNotIntoGroup}" var="m">
		        		<label class="checkbox-inline">
		        		  <input type="checkbox" name="mOperaterId" value="${m.mOperaterId}">${m.machineName}
		        		</label>
		        	</c:forEach>
		        	</form>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		        <button type="button" class="btn btn-primary" onclick="addMachineToGroup()" data-dismiss="modal">提交</button>
		      </div>
		    </div>
		  </div>
		</div>
	</div>
<script type="text/javascript">
	function addMachineToGroup(){
		$.ajax({  
            url:"<c:url value='/machine/addMachineToGroup'/>",
            type:"post",  
            dataType:"text",  
            data:$('#addMachineToGroupForm').serialize(),
            success:function(responseText){  
            	alert("添加成功");
            	location.reload();
            },  
            error:function(){  
                alert("添加失败");  
            }  
        });  
	}
</script>
</body>
</html>