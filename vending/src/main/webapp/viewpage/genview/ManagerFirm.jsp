<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Firm Manager Page</title>
</head>
<body>
	<%@include file="../topmenu.jsp"%>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="<c:url value="/home"/>">主页</a></li>
					<li class="active">商家列表</li>
				</ul>
			</div>
		</div>
		<div id="search">
			<form class="form-inline" method="post" action="<c:url value="/manager/getAllFirms"/>">
				<div class="form-group">
					<input type="text" class="form-control" name="firmNo" placeholder="商家编号">
				</div>
				<div class="form-group">
					<input type="text" class="form-control" name="firmName" placeholder="商家名称">
				</div>
				<div class="form-group">
					<select name="firmType" class="form-control">
						<option value="">---商家类型---</option>
						<option value="1">运营商</option>
						<option value="0">厂商</option>
					</select>
				</div>
				<div class="form-group">
					<select name="firmStatus" class="form-control">
						<option value="">---是否可用---</option>
						<option value="1">是</option>
						<option value="0">否</option>
					</select>
				</div>
				<button type="submit" class="btn btn-default">
					<span class="glyphicon glyphicon-search"></span>
					查找
				</button>
			</form>
		</div>
		<div>
			<table class="table">
				<tr>
					<th>Id</th>
					<th>商家编号</th>
					<th>商家名称</th>
					<th>商家描述</th>
					<th>商家类型</th>
					<th>商家状态</th>
					<th>操作者</th>
					<th>操作时间</th>
					<th></th>
				</tr>
				<c:forEach items="${allFirmInfos}" var="firm">
					<tr>
						<td>${firm.firmId}</td>
						<td>${firm.firmNo}</td>
						<td>${firm.firmName}</td>
						<td>${firm.firmDesc}</td>
						<td>${firm.firmType}</td>
						<td>${firm.firmStatus}</td>
						<td>${firm.operateId}</td>
						<td>${firm.operateDate}</td>
						<td>
							<a href="<c:url value="/manager/firmUpdate"/>?firmId=${firm.firmId}" class="btn default"> 
							<span class="glyphicon glyphicon-edit" title="编辑"></span>
							</a>
						</td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</div>
</body>
</html>