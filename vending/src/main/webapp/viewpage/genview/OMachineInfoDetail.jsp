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
<script src="<c:url value='/resources/js/channel.js'/>"
	type="text/javascript"></script>
<title>MachineOperater Info Page</title>
</head>
<body>
	<%@include file="../topmenu.jsp"%>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="<c:url value="/home"/>">主页</a></li>
					<li><a href="<c:url value="/machine/machineInfo"/>">售货机查询列表</a></li>
					<li class="active">售货机信息</li>
				</ul>
			</div>
		</div>
		<!-- 显示内容 -->
		<div class="panel panel-default">
			<div class="panel-heading">售货机信息</div>
			<div class="panel-body">
				<table class="table" align="center">
					<tr>
						<th>铭牌号</th>
						<th>主板号</th>
						<th>是否分配</th>
						<th>售货机类型</th>
						<th>管理员</th>
						<th>售货机地址</th>
						<th>售货机组</th>
						<th>运营商</th>
						<th>操作者</th>
						<th>操作时间</th>
					</tr>
					<tr>
						<td>${machineOperater.machineInfo.machineName }</td>
						<td>${machineOperater.machineInfo.machinePannel }</td>
						<td>${machineOperater.machineAssign }</td>
						<td>${machineOperater.machineInfo.machineType.tModelName }</td>
						<td>${machineOperater.userId}</td>
						<td>${machineOperater.machineAddress }</td>
						<td>${machineOperater.groupInfo.groupName}</td>
						<td>${machineOperater.operFirmId}</td>
						<td>${machineOperater.operateId}</td>
						<td>${machineOperater.operateDate}</td>
					</tr>
				</table>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<a href="#" data-toggle="modal" data-target="#insertChannel"> <span
					class="btn btn-default">添加货道信息</span>
				</a>
			</div>
			<div class="panel-body">
				<table class="table">
					<tr>
						<th>货道编号</th>
						<th>商品编号</th>
						<th>商品名</th>
						<th>商品进价</th>
						<th>商品价格</th>
						<th>是否折扣</th>
						<th>存货量</th>
						<th>现存量</th>
						<th>新增量</th>
						<th>货到组</th>
						<th>售货机名</th>
						<th>售货机主板号</th>
					</tr>
					<c:forEach items="${channelWareByMachine}" var="ch">
						<tr>
							<td>${ch.channelInfo.channelNo}</td>
							<td>${ch.wareInfo.wareCode}</td>
							<td>${ch.wareInfo.wareName}</td>
							<td>${ch.wareInfo.wareBasePrice}</td>
							<td>${ch.price}</td>
							<td>${ch.isDiscount}</td>
							<td>${ch.channelInfo.stockNum}</td>
							<td>${ch.channelInfo.stockNumNow}</td>
							<td>${ch.channelInfo.stockNumAdd}</td>
							<td>${ch.channelInfo.channelGroupId}</td>
							<td>${ch.channelInfo.machineOperater.machineInfo.machineName}</td>
							<td>${ch.channelInfo.machineOperater.machineInfo.machinePannel}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>


	<div class="modal fade" id="insertChannel" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加货道信息</h4>
				</div>
				<div class="modal-body" style="width: 500px">
					<form class="form" id="insertChannelForm">
						<div class="form-group">
							<label for="channelNo">货道编号:</label> <input type="text"
								class="form-control" name="channelNo" placeholder="输入货道编号">
						</div>
						<div class="form-group">
							<label for="wareId">商品:</label> <input type="text"
								class="form-control" name="wareId">
						</div>
						<div class="form-group">
							<label for="price">商品售价:</label> <input type="text"
								class="form-control" name="price" placeholder="输入价格">
						</div>
						<div class="form-group">
							<label for="isDiscount">是否折扣:</label> <input type="text"
								class="form-control" name="isDiscount">
						</div>
						<div class="form-group">
							<label for="stockNum">货道容量:</label> <input type="text"
								class="form-control" name="stockNum">
						</div>
						<div class="form-group">
							<label for="stockNumNow">货道库存:</label> <input type="text"
								class="form-control" name="stockNumNow">
						</div>
						<div class="form-group">
							<label for="stockNumAdd">货道增量:</label> <input type="text"
								class="form-control" name="stockNumAdd">
						</div>
						<div class="form-group">
							<label for="stockNumAdd">售货机名:</label> <input type="text"
								class="form-control"
								value="${machineOperater.machineInfo.machineName }" readonly>
						</div>
						<input type="hidden" name="mOperaterId"
							value="${machineOperater.mOperaterId }">
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" onclick="insertChannelInfo()"
						class="btn btn-primary" data-dismiss="modal">提交</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>