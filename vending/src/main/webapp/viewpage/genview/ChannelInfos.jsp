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
				<form  class="form-inline"> 
					<input type="text" class="form-control" name="machineName" placeholder="输入售货机铭牌号">
					<input type="text" class="form-control" name="channelNo" placeholder="货道编号">
					<input type="text" class="form-control" name="wareName" placeholder="商品编号">
					<input type="hidden" value="${user.firmInfo.firmId }">
					<button type="submit" class="btn btn-primary">查找</button>
				</form>
			</div>
			<div class="panel-body">
				<table class="table" align="center">
				<tr>
					<th>售货机铭牌号</th>
					<th>货道编号</th>
					<th>商品名称</th>
					<th>是否特价</th>
					<th>当前量</th>
					<th>加货量</th>
					<th>额定量</th>
				</tr>
				<c:forEach items="${allChannelWareInfos }" var="c">
					<tr>
						<td>${c.channelInfo.machineInfo.machineName}</td>
						<td>${c.channelInfo.channelNo}</td>
						<td>
							<c:if test="${c.wareInfo!=null}">
							${c.wareInfo.wareName}
							</c:if>
						</td>
						<td>${c.isDiscount }</td>
						<td>${c.channelInfo.stockNumNow}</td>
						<td>${c.channelInfo.stockNumAdd}</td>
						<td>${c.channelInfo.stockNum}</td>
					</tr>
				</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>