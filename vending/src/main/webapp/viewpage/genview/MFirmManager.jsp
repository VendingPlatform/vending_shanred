<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>OperFirm Page</title>
</head>
<body>
	<%@include file="../topmenu.jsp"%>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="<c:url value="/home"/>">主页</a></li>
					<li class="active">厂商管理的运营商列表</li>
				</ul>
			</div>
		</div>
		<div>
			<table class="table">
				<tr>
					<th>Id</th>
					<th>运营商编号</th>
					<th>运营商Id</th>
					<th>运营商名称</th>
					<th>厂商Id</th>
					<th>厂商名称</th>
					<th>操作者</th>
					<th>操作时间</th>
				</tr>
				<c:forEach items="${operMgrs}" var="operFirm">
					<tr>
						<td>${operFirm.operMgrId}</td>
						<td>${operFirm.firmNo}</td>
						<td>${operFirm.firmId}</td>
						<td>${operFirm.firmName}</td>
						<td>${operFirm.manuId}</td>
						<td>${operFirm.manuName}</td>
						<td>${operFirm.operateId}</td>
						<td>${operFirm.operateDate}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>