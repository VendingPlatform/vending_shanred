<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="<c:url value='/resources/js/firmGroup.js'/>" type="text/javascript"></script>
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
		<div class="form-group">
			<button class="btn btn-primary" data-toggle="modal" data-target="#createFirmInfoModal">注册商家</button>
		</div>
		<div id="search">
			<form class="form-inline" method="post" action="<c:url value="/manager/getAllFirms"/>">
				<div class="form-group">
					<input type="text" class="form-control" name="firmNo" placeholder="商家编号">
				</div>
				<div class="form-group">
					<input type="text" class="form-control" name="firmName" placeholder="商家名称">
				</div>
				<input type="hidden" name="firmType" value="1">
				<!-- <div class="form-group">
					<select name="firmType" class="form-control">
						<option value="">---商家类型---</option>
						<option value="1">运营商</option>
						<option value="2">厂商</option>
					</select>
				</div> -->
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
						<td>
							<c:if test="${firm.firmType==1}">运营商</c:if>
							<c:if test="${firm.firmType==2}">厂商</c:if>
						</td>
						<td>
							<c:if test="${firm.firmStatus==1}">可用</c:if>
							<c:if test="${firm.firmStatus==0}">不可用</c:if>
						</td>
						<td>${firm.operateId}</td>
						<td>${firm.operateDate}</td>
						<td>
							<a href="<c:url value="/manager/getFirmInfo"/>?firmId=${firm.firmId}" class="btn default"> <span class="glyphicon glyphicon-edit" title="编辑"></span>
							</a>
							<a href="<c:url value="/manager/deleteFirmInfo"/>?firmId=${firm.firmId}" class="btn default"> <span class="glyphicon glyphicon-trash" title="删除"></span>
							</a>
						</td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="createFirmInfoModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加商家</h4>
				</div>
				<div class="modal-body" style="width: 80%; padding-left: 30px">
					<form class="form-horizontal" id="createFirmInfo" method="post">
						<input type="hidden" name="operateId" value="${user.userId}" />
						<div class="form-group">
							<label for="firmNo">商家编号:</label>
							<input type="text" class="form-control" name="firmNo" required placeholder="商家编号">
						</div>

						<div class="form-group">
							<label for="firmName">商家名称:</label>
							<input type="text" class="form-control" name="firmName" required placeholder="商家名称">
						</div>

						<div class="form-group">
							<label for="firmDesc">商家描述:</label>
							<input type="text" class="form-control" name="firmDesc" placeholder="商家描述">
						</div>
						<input type="hidden" name="firmType" value="1">
						<div class="form-group">
							<label for="firmDesc">商家状态:</label>
							<select name="firmStatus" required>
								<option value="1" selected>可用</option>
								<option value="0">不可用</option>
							</select>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="createBtn" data-dismiss="modal" onclick="createFirmInfo()">提交</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>