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
					<li><a href="<c:url value="/machine/machineInfo"/>">售货机查询列表</a></li>
					<li class="active">更新售货机信息</li>
				</ul>
			</div>
		</div>
		<!-- 显示内容 -->
		<div>
			<form class="form-inline" action="<c:url value="/machine/machineInfoUpdate"/>" method="post">
				<input type="hidden" name="mOperaterId" value="${machineOperater.mOperaterId }">
				<table class="table" align="center">
					<tr>
						<th>列名</th>
						<th>信息</th>
					</tr>
					<tr>
						<td>铭牌号</td>
						<td>${machineOperater.machineInfo.machineName }</td>
					</tr>
					<tr>
						<td>主板号</td>
						<td>${machineOperater.machineInfo.machinePannel }</td>
					</tr>
					<tr>
						<td>是否分配</td>
						<td>
						<div class="form-group">
							<input type="text" id="machineAssign" class="form-control" 
							name="machineAssign" readonly="readonly" reuired value="${machineOperater.machineAssign }">
						</div>
						</td>
					</tr>
					<tr>
						<td>售货机类型</td>
						<td>${machineOperater.machineInfo.machineType.tModelName }</td>
					</tr>
					<tr>
						<td>分配管理员</td>
						<td>
						<div class="form-group">
							<input type="text" name="userId" class="form-control"  placeholder="分配管理员" id="userId" onchange="assign(this.value)" value="${machineOperater.userId }">
						</div>
						</td>
					</tr>
					<tr>
						<td>售货机地址</td>
						<td>
						<div class="form-group">
							<textarea rows="5" cols="30" name="machineAddress" class="form-control"  placeholder="售货机地址" value="${machineOperater.machineAddress }"></textarea> 
						</div>
						</td>
					</tr>
					<tr>
						<td>运营商</td>
						<td>${machineOperater.operFirmId }</td>
					</tr>
				</table>
				<button class="btn btn-primary" value="submit">提交</button>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		function assign(x) {
			if (x != null && x != "") {
				document.getElementById("machineAssign").value = 1;
			} else {
				document.getElementById("machineAssign").value = 0;
			}
		}
	</script>
</body>
</html>