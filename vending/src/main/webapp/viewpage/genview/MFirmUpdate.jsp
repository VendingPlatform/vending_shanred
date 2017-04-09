<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Firm Info Page</title>
</head>
<body>
	<%@include file="../topmenu.jsp"%>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="<c:url value="/home"/>">主页</a></li>
					<li><a href="<c:url value="/manager/getAllFirms"/>">商家列表</a></li>
					<li class="active">商家信息</li>
				</ul>
			</div>
		</div>
		<div>
			<form class="form-inline" id="updateFirmInfo" method="post" action="<c:url value="/manager/updateFirmInfo"/>">
				<input type="hidden" name="firmId" value="${firmInfo.firmId }" />
				<input type="hidden" name="operateId" value="${user.userId }" />
				<table class="table">
					<tr>
						<td>商家编号</td>
						<td>
							<div class="form-group">
								<input type="text" class="form-control" name="firmNo" value="${firmInfo.firmNo}" placeholder="商家编号" readonly>
							</div>
						</td>
					</tr>
					<tr>
						<td>商家名称</td>
						<td>
							<div class="form-group">
								<input type="text" class="form-control" name="firmName" value="${firmInfo.firmName}" placeholder="商家名称" >
							</div>
						</td>
					</tr>
					<tr>
						<td>商家描述</td>
						<td>
							<div class="form-group">
								<input type="text" class="form-control" name="firmDesc" value="${firmInfo.firmDesc}" placeholder="商家描述">
							</div>
						</td>
					</tr>
					<tr>
						<td>商家类型</td>
						<td>
							<select name="firmType" required>
								<c:if test="${firmInfo.firmType==1}">
									<option value="${firmInfo.firmType}" selected>运营商</option>
									<option value="0">厂商</option>
								</c:if>
								<c:if test="${firmInfo.firmType==2}">
									<option value="${firmInfo.firmType}" selected>厂商</option>
									<option value="1">运营商</option>
								</c:if>
							</select>
						</td>
					</tr>
					<tr>
						<td>商家状态</td>
						<td>
							<select name="firmStatus" required>
								<c:if test="${firmInfo.firmStatus==0}">
									<option value="${firmInfo.firmStatus }" selected>不可用</option>
									<option value="1">可用</option>
								</c:if>
								<c:if test="${firmInfo.firmStatus==1}">
									<option value="${firmInfo.firmStatus }" selected>可用</option>
									<option value="0">不可用</option>
								</c:if>
							</select>
						</td>
					</tr>
					<tr>
						<td>操作者</td>
						<td>${firmInfo.operateId}</td>
					</tr>
					<tr>
						<td>操作时间</td>
						<td>${firmInfo.operateDate }</td>
					</tr>
				</table>
				<button class="btn btn-primary" value="submit" onclick="updateFirmInfo()">提交</button>
			</form>
		</div>
	</div>
</body>
<script type="text/javascript">
	function updateFirmInfo() {
		$.ajax({
			url : "<c:url value='/manager/updateFirmInfo'/>",
			type : "post",
			dataType : "text",
			data : $('#updateFirmInfo').serialize(),
			success : function(responseText) {
				alert("更新成功");
				location.reload();
			},
			error : function() {
				alert("更新失败");
			}
		});
	}
</script>
</html>