<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//Dth HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dth">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="<c:url value='/resources/js/ware.js'/>" type="text/javascript"></script>
<title>出货</title>
</head>
<body>
	<%@include file="../topmenu.jsp"%>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="<c:url value="/home"/>">主页</a></li>
					<li class="active">添加出货信息</li>
				</ul>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">添加出库信息</div>
			<div class="panel-body">
				<form class="form-inline " id="selectWareForm">
					<div class="form-group">
						<label>营业员编号:</label>
						<!-- <input class="form-control" id="userNo" placeholder="营业员编号" />
						userIds -->
						<select class="form-control" id="userId">
							<option value="">----请选择用户----</option>
							<c:forEach items="${userIds}" var="u">
								<option value="${u.userId }">${u.userName}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label>出货编号:</label>
						<input class="form-control" id="shipNo" placeholder="输入出货编号">
					</div>
					<br />
					<br />
					<div class="form-group">
						<label>商品:</label>
						<select class="form-control" name="wareId" id="wareId">
							<option value="">----请选择商品----</option>
							<c:forEach items="${shipWares }" var="w">
								<option value="${w.wareId }">${w.wareName}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label>商品数量:</label>
						<input class="form-control" name="num" id="num" placeholder="输入数量">
					</div>
					<div class="form-group">
						<label>备注：</label>
						<input class="form-control" name="descr" id="descr" placeholder="添加备注">
					</div>
					<a class="btn btn-primary" onclick="selectWare('<%=basePath%>')">添加</a>
				</form>
				<form id="shipForm">
					<input type="hidden" name="userId" id="userIdHidden">
					<input type="hidden" name="shipNo" id="shipNoHidden">

					<table class="table" id="formTable">
						<tr class="table info">
							<th>商品编号</th>
							<th>商品名称</th>
							<th>商品数量</th>
							<th>单价</th>
							<th>备注</th>
							<th>操作</th>
						</tr>
					</table>
				</form>
				<a type="reset" class="btn btn-primary" onclick="location.reload();">取消</a> <a type="submit" class="btn btn-primary" onclick="addShipToUser('<%=basePath%>')">出货</a>
			</div>
		</div>
	</div>
</body>
</html>