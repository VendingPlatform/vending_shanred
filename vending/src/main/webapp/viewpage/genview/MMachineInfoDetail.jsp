<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="<c:url value='/resources/js/manu.js'/>" type="text/javascript"></script>
</head>
<body>
	<%@include file="../topmenu.jsp"%>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="<c:url value="/home"/>">主页</a></li>
					<li><a href="<c:url value="/manu/getAllMachines"/>">售货机列表</a></li>
					<li class="active">售货机列表</li>
				</ul>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">售货机信息</div>
			<div class="panel-body">
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
					</tr>
					<tr>
						<td>${machineInfo.machineId}</td>
						<td>${machineInfo.machineName}</td>
						<td>${machineInfo.machinePannel}</td>
						<td>${machineInfo.manuFirmInfo.firmName}</td>
						<td>${machineInfo.machinePrice}</td>
						<td>${machineInfo.machineType.tModelName}</td>
						<td>
							<!--0:未售出，1：已售出，2：回收-->
							<c:if test="${machineInfo.manuMachineStatus==0}">未售出</c:if>
							<c:if test="${machineInfo.manuMachineStatus==1}">已售出</c:if>
							<c:if test="${machineInfo.manuMachineStatus==2}">回收</c:if>
						</td>
						<td>${machineInfo.operFirmInfo.firmName}</td>
						<td>${machineInfo.operateId}</td>
						<td>${machineInfo.operateDate}</td>
					</tr>
				</table>
			</div>
		</div>

		<div class="panel panel-default">
			<div class="panel-heading">
				<a class="btn btn-default" data-toggle="modal" data-target="#insertChannel">添加货道</a>
			</div>
			<div class="panel-body">
				<table class="table">
					<tr>
						<th>ID</th>
						<th>编号</th>
						<th>容量</th>
						<th>操作者</th>
						<th>操作日期</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${machineChannelInfos}" var="ch">
						<tr>
							<td>${ch.channelId}</td>
							<td>${ch.channelNo}</td>
							<td>${ch.stockNum }</td>
							<td>${ch.operateId}</td>
							<td>${ch.operateDate }</td>
							<td><a onclick="deleteChan(${ch.channelId})"><span class="glyphicon glyphicon-trash" title="删除货道"></span></a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>

	<div class="modal fade" id="insertChannel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加货道信息</h4>
				</div>
				<div class="modal-body" style="width: 500px">
					<form class="form" id="addChannelForm">
						<div class="form-group">
							<label for="channelNo">货道编号:</label>
							<input type="text" class="form-control" name="channelNo" placeholder="输入货道编号">
						</div>
						<div class="form-group">
							<label for="stockNum">货道库存:</label>
							<input type="text" class="form-control" name="stockNum">
						</div>
						<input type="hidden" name="stockNumNow" value="0">
						<input type="hidden" name="stockNumAdd" value="0">
						<input type="hidden" name="operateId" value="${user.userId }">
						<div class="form-group">
							<label for="stockNumAdd">售货机名:</label>
							<input type="text" class="form-control" value="${machineInfo.machineName }" readonly>
						</div>
						<input type="hidden" name="machineId" value="${machineInfo.machineId }">
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" onclick="addChannelInfo()" class="btn btn-primary" data-dismiss="modal">提交</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>