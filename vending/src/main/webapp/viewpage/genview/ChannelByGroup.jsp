<%@page import="com.vending.platform.domain.MachineOperater"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
					<li><a href="<c:url value="/channel/getAllChannelGroups/${user.firmInfo.firmId}"/>">货道组信息</a></li>
					<li class="active">货道信息</li>
				</ul>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">货道列表</div>
			<div class="panel-body">
				<table class="table">
					<tr>
						<th>货道编号</th>
						<th>售货机铭牌号</th>
						<th>售货机主板号</th>
						<th>商品名</th>
						<th>商品编号</th>
						<th>商品价格</th>
						<th>是否折扣</th>
						<th>当前库存量</th>
						<th>加货量</th>
						<th>额定存货量</th>
					</tr>
					<c:forEach items="${channelsByGroupId}" var="s">
						<tr>
							<td>${s.channelInfo.channelNo}</td>
							<td>${s.channelInfo.machineInfo.machineName}</td>
							<td>${s.channelInfo.machineInfo.machinePannel}</td>
							<td>${s.wareInfo.wareName}</td>
							<td>${s.wareInfo.wareCode}</td>
							<td>${s.price}</td>
							<td>
								<c:if test="${s.isDiscount==1}">是</c:if>
								<c:if test="${s.isDiscount==0}">否</c:if>
							</td>
							<td>${s.channelInfo.stockNumNow}</td>
							<td>${s.channelInfo.stockNumAdd}</td>
							<td>${s.channelInfo.stockNum}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>