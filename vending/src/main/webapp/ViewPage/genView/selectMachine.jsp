<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<div class="container">
		<form class="form-inline">
			<div class="form-group">
				<input type="text" class="form-control" id="" placeholder="售货机铭牌号">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" id="" placeholder="设备主板">
			</div>
			<div class="form-group">
				<select class="form-control">
					<option>---是否分配---</option>
					<option>已分配</option>
					<option>未分配</option>
				</select>
			</div>
			<div class="form-group">
				<select class="form-control">
					<option>---售货机类型---</option>
					<option>类型1</option>
					<option>类型2</option>
				</select>
			</div>
			<button type="submit" class="btn btn-default">
				<span class="glyphicon glyphicon-search"></span>
				Search
			</button>
		</form>
	</div>
</body>
</html>