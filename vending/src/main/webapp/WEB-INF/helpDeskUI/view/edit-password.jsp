<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <!-- IE兼容模式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- 国产360浏览器高速模式 -->
    <meta name="renderer" content="webkit">
    <!-- 响应式设计 -->  
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>运维平台-修改密码</title>
    <!-- 基础组件样式 -->
    <link rel="stylesheet" href="<%=basePath%>/helpDeskUI/assets/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/helpDeskUI/assets/css/layout.css">
    <!-- jQuery ui 组件样式 -->
    <link rel="stylesheet" href="<%=basePath%>/helpDeskUI/assets/css/jquery-ui-flat.css">
    <!-- jQuery nprogress 进度条插件样式 -->
    <link rel="stylesheet" href="<%=basePath%>/helpDeskUI/assets/css/nprogress.css">
    <!-- 图标字体样式 -->
    <link rel="stylesheet" href="<%=basePath%>/helpDeskUI/assets/css/simple-line-icons.css">
    <link rel="stylesheet" href="<%=basePath%>/helpDeskUI/assets/css/font-awesome.css">
    <!-- 
        1. html5shiv 用于 IE8 支持 HTML5 标签 
        2. respond.min.js 用于 IE8 的响应式设计兼容脚本。该脚本不支持本地直接打开方式，请在服务器下使用。
    -->
    <!--[if lt IE 9]>
     
	<script src="<%=basePath%>helpDeskUI/assets/js/lib/html5shiv.min.js"></script>	
	<script src="<%=basePath%>helpDeskUI/assets/js/lib/respond.min.js"></script>
    
    <![endif]-->
</head>
<body>
<div class="pages theme-heading-fixed theme-sidebar-fixed theme-footer-fixed">
<!-- <div class="pages theme-heading-static-top theme-sidebar-default"> -->
     <%@include file="top.jsp" %>
		<!-- /navbar-top -->
<%-- 		<%@include file="menu.jsp" %> --%>
		<!-- /page-sidebar -->
    <div class="page-content">
        <div class="page-breadcrumb">
                <span class="fa-stack fa-lg">
                    <i class="fa fa-circle fa-stack-2x"></i>
                    <i class="fa fa-flag fa-stack-1x fa-inverse"></i>
                </span>
                <h1>修改密码</h1>
               <!--  <ol class="breadcrumb pull-right">
                    <li class="description color-lightslategray">
                        您现在的位置：
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-home"></i>
                            首页
                        </a>
                    </li>
                    <li>
                        <a href="#">系统设置</a>
                    </li>
                    <li class="active">修改密码</li>
                </ol> -->
        </div>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading clearfix">
                            <h5 class="panel-title">
                                <i class="fa fa-unlock"></i>
                                修改密码
                            </h5>
                        </div>
                        <!-- /panel-heading -->
                        <div class="panel-body">
                            <form action="updatePassWd!updatePassWd.action" class="form-horizontal margin-bottom-lg"  method="post" id="updatepasswdss">
                                <div class="form-group">
                                    <label class="control-label col-md-2">
                                        原始密码：
                                    </label>
                                    <div class="col-md-5">
                                        <input type="password" class="form-control" id="passwd" name="userInfo.password">
                                    </div>
                                    <!-- <div class="col-md-5 margin-top-sm color-success">
                                        <i class="fa fa-check"></i>
                                        已通过。
                                    </div> -->
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-2">
                                        新密码：
                                    </label>
                                    <div class="col-md-5">
                                        <input type="password" class="form-control" id="newpasswd" name="userInfo.newpasswd" >
                                    </div>
                                   <!--  <div class="col-md-5 margin-top-sm color-badger">
                                        <i class="fa fa-close"></i>
                                        新密码不能为空。
                                    </div> -->
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-2">
                                        确认新密码：
                                    </label>
                                    <div class="col-md-5">
                                        <input type="password" class="form-control"id="checkoutPasswd" onKeyDown="setTab();">
                                    </div>
                                    <!-- <div class="col-md-5 margin-top-sm color-badger">
                                        <i class="fa fa-close"></i>
                                        确认密码与新密码不一致。
                                    </div> -->
                                </div>
                                <div class="form-group no-margin-bottom">
                                    <div class="col-sm-offset-2 col-sm-10">
                                        <button type="button" class="btn btn-info" id="js-tester">
                                            <i class="fa fa-send"></i>
                                            保存修改
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <!-- /panel-default -->
                </div>
                <!-- /col-md-12  -->
            </div>
            <!-- /row -->
        </div>   
        <!-- /container-fluid  -->
    </div>
    <div class="page-footer">
        <p class="copyright color-lightslategray">
            © 2015 Copyright <a href="http://www.gm-medicare.com/" target="_blank">GM-Medicare.com</a> All Rights Reserved 版权所有
        </p>
        
    </div>
    <!-- /page-footer -->
</div>
<!-- /pages -->
<!-- jQuery -->
<script src="<%=basePath%>/helpDeskUI/assets/js/lib/jquery.js"></script>
<!-- jQuery UI -->
<script src="<%=basePath%>/helpDeskUI/assets/js/lib/jquery-ui.min.js"></script>
<!-- jQuery twitter bootstrap -->
<script src="<%=basePath%>/helpDeskUI/assets/js/lib/bootstrap.min.js"></script>
<!-- jQuery 进度条 nprogress -->
<script src="<%=basePath%>/helpDeskUI/assets/js/lib/nprogress.js"></script>
<!-- jQuery slimscroll -->
<script src="<%=basePath%>/helpDeskUI/assets/js/lib/jquery.slimscroll.js"></script>

<!-- 基础脚本库 -->
<script src="<%=basePath%>/helpDeskUI/assets/js/base/app.js"></script>
<script src="<%=basePath%>/helpDeskUI/lib/md5/md5.min.js"></script>
<script src="<%=basePath%>/helpDeskUI/assets/js/pages/edit-password.js"></script>
<%-- <script src="<%=basePath%>/helpDeskUI/assets/js/pages/change-password.js"></script> --%>
<script>
    
		
</script>
</body>
</html>