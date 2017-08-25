<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="<c:url value='/resources/js/saas.js'/>" type="text/javascript"></script>
<title>SaaS Rent Page</title>
</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="<%=basePath%>viewpage/login.jsp">主页</a></li>
					<li class="active">欢迎进入平台租用页面</li>
				</ul>
			</div>
		</div>
		<%-- <form action="<c:url value="/saas/createNewSaasRent"/>" method="post" class="form-horizontal"> --%>
		<div class="form-horizontal">
			<div class="form-group">
				<label for="firmType" class="col-sm-2 control-label">租户类型:</label>
				<div class="col-sm-10" style="width: 240px">
					<select name="firmType" id="firmType" class="form-control" onchange="calculateMoney('<%=basePath%>')">
						<option value="">--请选择--</option>
						<option value="1">运营商</option>
						<option value="2">厂商</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="firmName" class="col-sm-2 control-label">租户名称：</label>
				<div class="col-sm-10" style="width: 240px">
					<input type="text" class="form-control" name="firmName" id="firmName" value="" onchange="validateSaas(this.value,null,'<%=basePath%>')" required autofocus>
				</div>
			</div>
			<div class="form-group">
				<label for="firmNo" class="col-sm-2 control-label">租户编号：</label>
				<div class="col-sm-10" style="width: 240px">
					<input type="text" class="form-control" name="firmNo" id="firmCode" value="" onchange="validateSaas(null, this.value,'<%=basePath%>')" required autofocus>
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">管理员密码:</label>
				<div class="col-sm-10" style="width: 240px">
					<input type="password" class="form-control" id="password" name="password" required placeholder="输入密码" autofocus>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">租用台数：</label>
				<div class="col-sm-10" style="width: 240px">
					<input class="form-control" name="machineNum" id="machineNum" type="number" step="1" min="1" max="1000" onchange="calculateMoney('<%=basePath%>')" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">租用时间</label>
				<div class="col-sm-10">
					<input type="text" name="rentTime" id="rentTime" onchange="calculateMoney()" hidden>
					<div class="btn-group">
						<button type="button" class="btn btn-default" id="0" onclick="getValue(this.id,'<%=basePath%>')">试用一个月</button>
						<button type="button" class="btn btn-default" id="1" onclick="getValue(this.id,'<%=basePath%>')">1个月</button>
						<button type="button" class="btn btn-default" id="2" onclick="getValue(this.id,'<%=basePath%>')">2个月</button>
						<button type="button" class="btn btn-default" id="3" onclick="getValue(this.id,'<%=basePath%>')">3个月</button>
						<button type="button" class="btn btn-default" id="4" onclick="getValue(this.id,'<%=basePath%>')">4个月</button>
						<button type="button" class="btn btn-default" id="5" onclick="getValue(this.id,'<%=basePath%>')">5个月</button>
						<button type="button" class="btn btn-default" id="6" onclick="getValue(this.id,'<%=basePath%>')">6个月</button>
						<button type="button" class="btn btn-default" id="7" onclick="getValue(this.id,'<%=basePath%>')">7个月</button>
						<button type="button" class="btn btn-default" id="8" onclick="getValue(this.id,'<%=basePath%>')">8个月</button>
						<button type="button" class="btn btn-default" id="9" onclick="getValue(this.id,'<%=basePath%>')">9个月</button>
						<button type="button" class="btn btn-default" id="10" onclick="getValue(this.id,'<%=basePath%>')">10个月</button>
						<button type="button" class="btn btn-default" id="11" onclick="getValue(this.id,'<%=basePath%>')">11个月</button>
						<button type="button" class="btn btn-default" id="12" onclick="getValue(this.id,'<%=basePath%>')">1年</button>
						<button type="button" class="btn btn-default" id="24" onclick="getValue(this.id,'<%=basePath%>')">2年</button>
						<button type="button" class="btn btn-default" id="36" onclick="getValue(this.id,'<%=basePath%>')">3年</button>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">当前费用：</label>
				<div class="col-sm-10" style="width: 240px">
					<input type="text" name="sumPrice" class="form-control" id="sumPrice" readonly>
				</div>
			</div>
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-primary" onclick="submitRent('<%=basePath%>')">提交</button>
				<button type="reset" class="btn btn-default">取消</button>
			</div>
		</div>
		</form>
	</div>
</body>
</html>