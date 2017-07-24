<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="navbar page-heading navbar-static-top">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle collapsed"
			data-toggle="collapse" data-target="#navbar" aria-expanded="false"
			aria-controls="navbar">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
	</div>
	<!-- /navbar-header -->

	<div id="navbar" class="navbar-collapse collapse">
		<!-- <ul class="nav navbar-nav">
			<li class="notification"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown" role="button" aria-haspopup="true"
				aria-expanded="false"> <i class="icon-bell"></i> <span
					class="badge badge-sm bg-badger">2</span> </a></li>
			<li class="notification"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown" role="button" aria-haspopup="true"
				aria-expanded="false"> <i class="icon-envelope fa-fw"></i> <span
					class="badge badge-sm bg-success">9</span> </a></li>
		</ul> -->
		<ul class="nav navbar-nav navbar-right">
			<!-- <li><a href="helpDeskUI/view/index.jsp"> <i class="fa fa-area-chart"></i>首页 </a></li> -->
			<li><a href="#"> <i class="icon-user"></i> ${sessionScope.userInfo.userName }-${sessionScope.userInfo.roleName } </a></li>
			<li><a href="#" target="_self"> <i class="icon-lock-open"></i> 修改密码 </a></li>
			<li><a href="loginU!loginU.action"> <i class="icon-logout"></i> 退出平台 </a></li>
		</ul>
		<!-- /navbar-right -->
	</div>
</div>
<!-- /navbar-top -->
