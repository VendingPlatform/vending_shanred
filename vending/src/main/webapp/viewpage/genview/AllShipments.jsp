<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//Dth HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dth">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>出货</title>
</head>
<body>
	<%@include file="../topmenu.jsp"%>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="<c:url value="/home"/>">主页</a></li>
					<li class="active">出货列表</li>
				</ul>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">库存信息</div>
			<div class="panel-body">
				<table class="table">
					<tr>
						<th>营业员组</th>
						<th>营业员编号</th>
						<th>营业员</th>
						<th>商品名称</th>
						<th>数量</th>
						<th>单价</th>
						<th>订单号</th>
						<th>类型</th>
						<th>是否结清</th>
						<th>更新时间</th>
					</tr>
					<c:forEach items="${allShipments}" var="s">
						<tr>
							<td>${s.userInfo.groupInfo.groupName}</td>
							<td>${s.userInfo.userNo }</td>
							<td>${s.userInfo.userName }</td>
							<td>${s.wareInfo.wareName}</td>
							<td>${s.num }</td>
							<td>${s.wareInfo.wareBasePrice }</td>
							<td>${s.descr}</td>
							<td>
								<c:if test="${s.type==0 }">出库</c:if>
								<c:if test="${s.type==1 }">调拨</c:if>
							</td>
							<td>
								<c:if test="${s.isSend==0 }">未结清</c:if>
								<c:if test="${s.isSend==1 }">已结清</c:if>
							</td>
							<td>${s.operateDate }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>