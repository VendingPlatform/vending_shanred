<%@page import="com.vending.platform.domain.MachineOperater"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="<c:url value='/resources/js/ware.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/js/channel.js'/>" type="text/javascript"></script>
<title>machineInfoUpdateInfo Info Page</title>
</head>
<body>
	<%@include file="../topmenu.jsp"%>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="<c:url value="/home"/>">主页</a></li>
					<li class="active">货道信息</li>
				</ul>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<a onclick="getWareToAssign(${user.firmInfo.firmId})" class="btn btn-primary" data-toggle="modal" data-target="#addChannelGroup">添加货道组</a>
			</div>
			<div class="panel-body">
				<table class="table" align="center">
					<tr>
						<th>货道组名</th>
						<th>商品名</th>
						<th>商品价格</th>
						<th>是否折扣</th>
						<th>操作人</th>
						<th>操作时间</th>
					</tr>
					<c:forEach items="${channelGroups}" var="g">
						<tr>
							<td>${g.channelGroupName}</td>
							<td>${g.wareInfo.wareName}</td>
							<td>${g.price}</td>
							<td>${g.isDiscount}</td>
							<td>${g.operateId}</td>
							<td>${g.operateDate}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	<div class="modal fade" id="addChannelGroup" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加货道组</h4>
				</div>
				<div class="modal-body" style="width: 80%; padding-left: 30px">
					<form class="form" id="addChannelGroupForm">
					<input type="hidden" name="firmId" value="${user.firmInfo.firmId}">
					<input type="hidden" name="operateId" value="${user.userId}">
						<div class="form-group">
							<label for="channelGroupName">货道组名:</label> 
							<input type="text" class="form-control" name="channelGroupName" placeholder="输入货道组名" required>
						</div>
						<div class="form-group">
							<label for="wareId">商品</label>
							<select name="wareId" class="form-control" id="wareIdInput">
							</select>
						</div>
						<div class="form-group">
							<label for="price">价格:</label> 
							<input type="text" class="form-control" name="price" placeholder="输入价格" required>
						</div>
						<div class="form-group">
							<label for="isDiscount">是否折扣:</label> 
							<select name="isDiscount"class="form-control">
								<option value="0">否</option>
								<option value="1">是</option>
							</select>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" onclick="addChannelGroup()"
						 data-dismiss="modal">保存</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>