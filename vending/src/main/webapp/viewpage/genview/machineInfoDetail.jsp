<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
		<div>
			<table class="table" align="center">
				<tr>
					<th>列名</th>
					<th>信息</th>
				</tr>
				<tr>
					<td>铭牌号</td>
					<td>${machineOperater.machineName }</td>
				</tr>
				<tr>
					<td>主板号</td>
					<td>${machineOperater.machinePannel }</td>
				</tr>
				<tr>
					<td>是否分配</td>
					<td>${machineOperater.machineAssign }</td>
				</tr>
				<tr>
					<td>售货机类型</td>
					<td>${machineOperater.tModelName }</td>
				</tr>
				<tr>
					<td>管理员</td>
					<td>${machineOperater.userId}</td>
				</tr>
				<tr>
					<td>售货机地址</td>
					<td>${machineOperater.machineAddress }</td>
				</tr>
				<tr>
					<td>售货机状态</td>
					<td>${machineOperater.machineStatus}</td>
				</tr>
				<tr>
					<td>售货机组</td>
					<td>${machineOperater.groupId}</td>
				</tr>
				<tr>
					<td>运营商</td>
					<td>${machineOperater.operFirmId}</td>
				</tr>
				<tr>
					<td>操作者</td>
					<td>${machineOperater.operateId}</td>
				</tr>
				<tr>
					<td>操作时间</td>
					<td>${machineOperater.operateDate}</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>