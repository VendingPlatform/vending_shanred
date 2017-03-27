<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!-- 运营商菜单及标题栏 -->
<body>
	<nav class="navbar navbar-inverse" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">售货机管理平台</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="<c:url value="/home"/>">主页</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> 用户管理 <span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a href="<%=basePath%>viewpage/genview/UserManager.jsp">用户管理</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="<c:url value="/user/getAllAuthority"/>">权限管理</a></li>
							<li><a href="#">角色管理</a></li>
							<li><a href="#">用户组管理</a></li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> 售货机管理 <span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a href="<c:url value="/machine/machineHome"/>">售货机管理</a></li>
							<li><a href="<c:url value="/machine/machineGroup"/>">分组管理</a></li>
							<li><a href="#">货道管理</a>
							<li role="separator" class="divider"></li>
							<li><a href="#">货道组管理</a></li>
							<li><a href="#">货道管理</a></li>
						</ul></li>
					<li><a href="#">商品管理</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> 库存管理 <span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a href="#">库存查询</a></li>
							<li><a href="#">仓库出货</a></li>
							<li><a href="#">出库信息查询</a></li>
						</ul></li>
					<li><a href="#">订单管理</a></li>
					<li><a href="#">财务管理</a></li>
					<li><a href="<c:url value="/firm/getAllOperateFirms"/>">运营商管理</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="<c:url value="/user/userInfo"/>"><span class="glyphicon glyphicon-user"></span> ${user.userName}</a></li>
					<c:if test="${user!=null}">
						<li><a href="<%=basePath%>viewpage/genview/UserPwd.jsp">修改密码</a></li>
						<li><a href="<c:url value="/user/logout"/>">退出平台</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>