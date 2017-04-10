<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Select Machine Page</title>
</head>
<body>
	<%@include file="../topmenu.jsp"%>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="<c:url value="/home"/>">主页</a></li>
					<li class="active">售货机查询</li>
				</ul>
			</div>
		</div>
		<form class="form-inline" method="post" action="<c:url value="/machine/machineInfo"/>">
			<div class="form-group">
				<input type="text" class="form-control" name="machineInfo.machineName" placeholder="售货机铭牌号">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="machineInfo.machinePannel" placeholder="设备主板">
			</div>
			<div class="form-group">
				<select name="machineAssign" class="form-control">
					<option value="">---是否分配---</option>
					<option value="1">已分配</option>
					<option value="0">未分配</option>
				</select>
			</div>
			<div class="form-group">
				<select name="machineInfo.tModelId" class="form-control">
					<option value="">---售货机类型---</option>
					<c:forEach items="${allMachineTypes}" var="machineType">
						<option value="${machineType.tModelId}">${machineType.tModelName}</option>
					</c:forEach>
				</select>
			</div>
			<button type="submit" class="btn btn-default">
				<span class="glyphicon glyphicon-search"></span>
				查找
			</button>
		</form>
		<!-- 显示内容 -->
		<div>
			<table class="table">
				<tr>
					<th>铭牌号</th>
					<th>主板号</th>
					<th>是否分配</th>
					<th>售货机类型</th>
					<th>售货机地址</th>
					<th></th>
				</tr>
				<c:forEach items="${machineOperaterInfo}" var="machine">
					<tr>
						<td>${machine.machineInfo.machineName }</td>
						<td>${machine.machineInfo.machinePannel }</td>
						<td>${machine.machineAssign }</td>
						<td>${machine.machineInfo.machineType.tModelName }</td>
						<td>${machine.machineAddress }</td>
						<td>
							<a href="<c:url value="/machine/machineInfoDetail"/>?mOperaterId=${machine.mOperaterId}" class="btn default"> <span class="glyphicon glyphicon-info-sign" title="详情"></span>
							</a> <a href="<c:url value="/machine/machineInfoUpdateInfo"/>?mOperaterId=${machine.mOperaterId}" class="btn default"> <span class="glyphicon glyphicon-edit" title="编辑"></span>
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>