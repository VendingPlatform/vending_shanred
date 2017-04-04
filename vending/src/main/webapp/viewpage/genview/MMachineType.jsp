<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>AllTypes Page</title>
</head>
<body>
	<%@include file="../topmenu.jsp"%>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="<c:url value="/home"/>">主页</a></li>
					<li class="active">类型列表</li>
				</ul>
			</div>
		</div>
		<div>
			<table class="table">
				<tr>
					<td>Id</td>
					<td>类型名</td>
					<td>公司Id</td>
					<td>操作者</td>
					<td>操作时间</td>
					<td>操作</td>
				</tr>
			
			<c:forEach items="${machineTypes}" var="type">
				<tr>
					<td>${type.tModelId }</td>
					<td>${type.tModelName }</td>
					<td>${type.firmId }</td>
					<td>${type.operateId }</td>
					<td>${type.operateDate }</td>
					<td>
						<a onclick="getTypeById(${type.tModelId })" class="btn default"
							data-toggle="modal" data-target="#updateMachineTypeModal"> 
							<span class="glyphicon glyphicon-edit" title="编辑"></span>
						</a>
					</td>
				</tr>
			</c:forEach>
			</table>
		</div>
	</div>
	<div class="modal fade" id="updateMachineTypeModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  		<div class="modal-dialog" role="document">
   			<div class="modal-content">
      			<div class="modal-header">
        			<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        			<h4 class="modal-title" id="myModalLabel">更新类型</h4>
      			</div>
      			<div class="modal-body" style="width: 80%; padding-left: 30px">
					<form method="post" id="updateMachineType" >
      					<input type="hidden" name="operateId" value="${user.userId}" />
      					<input type="hidden" name="tModelId" id="tId" >
      					<div class="form-group">
		        			<label for="tModelName">类型名称:</label>
		        			<input type="text" class="form-control" id="tModelName" name="tModelName" placeholder="输入类型名称" required="required">
		        		</div> 
      				</form>      				
      			</div>
    	  		<div class="modal-footer">
    	    		<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      	    		<button type="button" class="btn btn-primary"  onclick="updateMachineType()" data-dismiss="modal">更新</button>
     	 		</div>
   	 		</div>
 		 </div>
	</div> 
</body>
<script type="text/javascript">
function updateMachineType(){
	$.ajax({  
        url:"<c:url value='/manu/updateType'/>",
        type:"post",  
        dataType:"text",  
        data:$('#updateMachineType').serialize(),
        success:function(responseText){  
        	alert("更新成功");
        	location.reload();
        },  
        error:function(){  
            alert("更新失败");  
        }  
    });  
}

function getTypeById(tModelId){
	$.ajax({
		url:"<c:url value='/manu/getTypeById'/>?tModelId="+tModelId,
		type:"get",  
	    dataType:"json",  
		success:function(data){  
        	$("#tId").val(tModelId);
        	$("#tModelName").val(data);
        },  
        error:function(){  
            alert("数据错误");  
        }  
	});	
	
}
</script>
</html>