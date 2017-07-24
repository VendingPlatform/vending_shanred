<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="<c:url value='/resources/js/ware.js'/>" type="text/javascript"></script>
<title>用户信息</title>
</head>
<body>
	<%@include file="../topmenu.jsp"%>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="<c:url value="/home"/>">主页</a></li>
					<li class="active">商品信息</li>
				</ul>
			</div>
		</div>
		<a onclick="clearWareInput()" class="btn btn-primary" data-toggle="modal" data-target="#insertWare">添加商品</a>
				<table class="table">
					<tr>
						<th>商品Id</th>
						<th>商品编号</th>
						<th>商品名</th>
						<th>商品规格</th>
						<th>商品单位</th>
						<th>商品进价</th>
						<th>最高价</th>
						<th>最低价</th>
						<th>商品描述</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${allWareInfos}" var="w">
						<tr>
							<td>${w.wareId}</td>
							<td>${w.wareCode}</td>
							<td>${w.wareName}</td>
							<td>${w.wareNorm}</td>
							<td>${w.wareUnit}</td>
							<td>${w.wareBasePrice}</td>
							<td>${w.wareMaxPrice}</td>
							<td>${w.wareMinPrice}</td>
							<td>${w.wareDesc}</td>
							<td>
								<a onClick="getWareToUpdate(${w.wareId})" data-toggle="modal" data-target="#insertWare">
									<span class="glyphicon glyphicon-edit" title="编辑"> </span>
								</a>
								<!-- <a onclick="#">
									<span class="glyphicon glyphicon-trash" title="移除"> </span>
								</a> -->
							</td>
						</tr>
					</c:forEach>
				</table>
		</div>
		<div class="modal fade" id="insertWare" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="waretitle"></h4>
				</div>
				<div class="modal-body" style="width: 80%; padding-left: 30px">
					<form class="form" id="insertWareForm">
						<div class="form-group">
							<label for="wareCode">商品编码:</label> 
							<input type="text" 
								class="form-control" name="wareCode" id="wareCode" placeholder="输入编码" required>
						</div>
						<div class="form-group">
							<label for="wareName">商品名称:</label> 
							<input type="text" 
								class="form-control" name="wareName" id="wareName" placeholder="输入商品名称" required>
						</div>
						<div class="form-group">
							<label for="wareNorm">商品规格:</label> 
							<input type="text" 
								class="form-control" name="wareNorm" id="wareNorm" placeholder="输入商品规格" >
						</div>
						<div class="form-group">
							<label for="wareUnit">商品单位:</label> 
							<input type="text" 
								class="form-control" name="wareUnit" id="wareUnit" placeholder="输入商品单位" >
						</div>
						<div class="form-group">
							<label for="wareBasePrice">商品进价(元/瓶):</label> 
							<input type="text" 
								class="form-control" name="wareBasePrice" id="wareBasePrice" placeholder="输入商品进价" >
						</div>
						<div class="form-group">
							<label for="firmId">公司:</label> 
							<input type="text" 
								class="form-control" name="firmId" placeholder="输入公司" value="${user.firmInfo.firmId }" readonly>
						</div>
						<div class="form-group">
							<label for="wareDesc">商品描述:</label> 
							<textarea class="form-control" name="wareDesc" id="wareDesc" placeholder="输入商品描述"></textarea> 
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="subBtn" onclick="insertWareInfo()" data-dismiss="modal">保存</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>