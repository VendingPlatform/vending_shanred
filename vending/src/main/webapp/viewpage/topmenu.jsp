<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
	int flag = 0;
    List<String> auths = (List<String>)session.getAttribute("userAuthCodes");
    if(auths.contains("000")){
        flag=0;
    }
    else if (auths.contains("001") || auths.contains("002")) {
	    //管理员
	    flag=1;
	}else{
	    //普通
	    flag=2;
	}
	session.setAttribute("flag", flag);
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
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> 
					<c:if test="${user.firmInfo.firmType!=0 }">
					用户管理 
					</c:if>
					<c:if test="${user.firmInfo.firmType==0 }">
					权限管理
					</c:if>
						
					
					<span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
						<!-- 用户管理只有系统管理员和运营商管理员，厂商管理员可以访问 -->
						<c:if test="${flag==0||flag==1}">
							<li><a href="<c:url value="/user/getAllUsers"/>">用户管理</a></li>
						</c:if>
							<c:if test="${user.firmInfo.firmType==0 }">
								<li><a href="<c:url value="/user/getAllAuthoritys"/>">权限管理</a></li>
							</c:if>
								<li><a href="<c:url value="/user/getAllRoles"/>">角色管理</a></li>
							<c:if test="${user.firmInfo.firmType==1 }">
								<li><a href="<c:url value="/user/getAllGroups"/>">用户组管理</a></li>
							</c:if>
						</ul>
					</li>
					<!-- firmType==2厂商管理员才有的权限 -->
					<c:if test="${user.firmInfo.firmType==2 }">
						<li><a href="<c:url value="/manager/getAllFirms"/>">商家管理</a></li>
					</c:if>
					<!-- firmType==1运营商才有的权限 -->
					<c:if test="${user.firmInfo.firmType==1 }">
						<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> 售货机管理 <span class="caret"></span>
						</a>
							<ul class="dropdown-menu">
								<li><a href="<c:url value="/machine/machineInfo"/>">售货机管理</a></li>
								<li><a href="<c:url value="/machine/machineGroup"/>">分组管理</a></li>
								<li><a href="#">货道组管理</a></li>
								<li><a href="#">货道管理</a></li>
							</ul></li>
						<c:if test="${flag==0||flag==1}">
						<li><a href="<c:url value="/ware/getAllWareInfos"/>">商品管理</a></li>
						</c:if>
						<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> 库存管理 <span class="caret"></span>
						</a>
							<ul class="dropdown-menu">
								<li><a href="#">库存查询</a></li>
								<li><a href="#">仓库出货</a></li>
								<li><a href="#">出库信息查询</a></li>
							</ul></li>
						<li><a href="#">订单管理</a></li>
						<li><a href="#">财务管理</a></li>
					</c:if>
					<c:if test="${user.firmInfo.firmType==2 }">
						<!-- 厂商才有的权限 -->
						<li><a href="<c:url value="/manu/getAllOperateFirms"/>">运营商管理</a></li>
						<li><a href="<c:url value="/manu/getAllMachines"/>">售货机管理</a></li>
						<li><a href="<c:url value="/manu/getAllTypes"/>">类型管理</a></li>
					</c:if>
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