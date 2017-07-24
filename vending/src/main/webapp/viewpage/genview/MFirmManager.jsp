<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="<c:url value='/resources/js/firmGroup.js'/>" type="text/javascript"></script>
<title>OperFirm Page</title>
</head>
<body>
	<%@include file="../topmenu.jsp"%>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="<c:url value="/home"/>">主页</a></li>
					<li class="active">厂商管理的运营商列表</li>
				</ul>
			</div>
		</div>
		<a type="button" class="btn btn-primary" data-toggle="modal" data-target="#insertFirm">添加商家</a>
		<div>
			<table class="table">
				<tr>
					<th>Id</th>
					<th>运营商编号</th>
					<th>运营商Id</th>
					<th>运营商名称</th>
					<th>厂商Id</th>
					<th>厂商名称</th>
					<th>操作者</th>
					<th>操作时间</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${operMgrs}" var="operFirm">
					<tr>
						<td>${operFirm.operMgrId}</td>
						<td>${operFirm.operFirm.firmNo}</td>
						<td>${operFirm.operFirm.firmId}</td>
						<td>${operFirm.operFirm.firmName}</td>
						<td>${operFirm.manuFirm.firmId}</td>
						<td>${operFirm.manuFirm.firmName}</td>
						<td>${operFirm.operateId}</td>
						<td>${operFirm.operateDate}</td>
						<td>
						<a href= "<c:url value="/manu/removeFirmToManu"/>?operMgrId=${operFirm.operMgrId}" class="btn default">
								<span class="glyphicon glyphicon-remove-sign" title="移除"></span>
							</a> 
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div class="modal fade" id="insertFirm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  		<div class="modal-dialog" role="document">
   			<div class="modal-content">
      			<div class="modal-header">
        			<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        			<h4 class="modal-title" id="myModalLabel">商家列表</h4>
      			</div>
      			<div class="modal-body" style="width: 80%; padding-left: 30px">
      			<form  method="post" id="insertFirmForm" >
		        	<c:forEach items="${firmInfosNotInManus}" var="firm">
		        		<label class="checkbox">
		        		  <input type="checkbox" name="firmIds" value="${firm.firmId}">
		        			&nbsp;<span>${firm.firmNo}</span>
   	      					&nbsp;<span>${firm.firmName}</span>
   	     			 		&nbsp;<span>${firm.firmDesc}</span>
   	      					&nbsp;<span><c:if test="${firm.firmStatus==1}">可用</c:if></span>
		        		</label>
		        	</c:forEach>
		        	</form>
      			</div>
    	  		<div class="modal-footer">
    	    		<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      	    		<button type="button" class="btn btn-primary"  onclick="insertFirm()" data-dismiss="modal"  >保存</button>
     	 		</div>
   	 		</div>
 		 </div>
	</div>
</body>
</html>