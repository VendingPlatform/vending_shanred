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
			<form action="<c:url value="/machine/machineInfoUpdate"/>" method="post">
				<input type="hidden" name="mOperaterId" value=${machineOperater.mOperaterId }>
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
						<td>
							<input type="text" id="machineAssign" name="machineAssign" readonly="readonly" reuired value=${machineOperater.machineAssign }>
						</td>
					</tr>
					<tr>
						<td>售货机类型</td>
						<td>${machineOperater.tModelName }</td>
					</tr>
					<tr>
						<td>分配管理员</td>
						<td>
							<input type="text" name="userId" id="userId" onchange="assign(this.value)" value=${machineOperater.userId }>
						</td>
					</tr>
					<tr>
						<td>售货机地址</td>
						<td>
							<input type="text" name="machineAddress" value=${machineOperater.machineAddress }>
						</td>
					</tr>
					<tr>
						<td>售货机状态</td>
						<td>
							<select name="machineStatus" required>
								<c:if test="${machineOperater.machineStatus==0}">
									<option value="${machineOperater.machineStatus }" selected>不可用</option>
									<option value="1">可用</option>
								</c:if>
								<c:if test="${machineOperater.machineStatus==1}">
									<option value="${machineOperater.machineStatus }" selected>可用</option>
									<option value="0">不可用</option>
								</c:if>
							</select>
						</td>
					</tr>
					<tr>
						<td>售货机组</td>
						<td>
							<input type="text" name="groupId" value=${machineOperater.groupId }>
						</td>
					</tr>
					<tr>
						<td>运营商</td>
						<td>${machineOperater.operFirmId }</td>
					</tr>
				</table>
				<button class="btn btn-primary" value="submit">修改</button>
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