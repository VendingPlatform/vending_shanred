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
    <base href="<%=basePath%>">
    <!-- IE兼容模式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- 国产360浏览器高速模式 -->
    <meta name="renderer" content="webkit">
    <!-- 响应式设计 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>运维平台-登陆</title>
    <!-- 基础组件样式 -->
    <link rel="stylesheet" href="<%=basePath%>/helpDeskUI/assets/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/helpDeskUI/assets/css/layout.css">
    <link rel="stylesheet" href="<%=basePath%>/helpDeskUI/assets/css/login.css">
    <!-- jQuery ui 组件样式 -->
    <link rel="stylesheet" href="<%=basePath%>/helpDeskUI/assets/css/jquery-ui-flat.css">
    <!-- 图标字体样式 -->
    <link rel="stylesheet" href="<%=basePath%>/helpDeskUI/assets/css/simple-line-icons.css">
    <link rel="stylesheet" href="<%=basePath%>/helpDeskUI/assets/css/font-awesome.css">
    <link rel="stylesheet" href="<%=basePath%>/helpDeskUI/assets/css/security-code.css">
    <!-- 
        1. html5shiv 用于 IE8 支持 HTML5 标签 
        2. respond.min.js 用于 IE8 的响应式设计兼容脚本。该脚本不支持本地直接打开方式，请在服务器下使用。
    -->
    <!--[if lt IE 9]>
   
	<script src="<%=basePath%>helpDeskUI/assets/js/lib/html5shiv.min.js"></script>	
	<script src="<%=basePath%>helpDeskUI/assets/js/lib/respond.min.js"></script>
    
    <![endif]-->
</head>
<body onload="createCode();">
	<div class="panel panel-flat panel-login clearfix" >
                <h1 class="login-title bg-info">
                    <i class="fa fa-area-chart fa-lg"></i>
                    运维平台
                </h1>
                 <form action="<%=basePath%>main!main.action" class="login-form" id="loginfor" method="post">
                    <div class="form-group form-group-header text-center">
                        <span>
                            <i class="fa fa-cog "></i>
                            登录您的账户
                        </span>
                   </div>
                    <div class="form-group color-badger">
                        <!-- <i class="fa fa-bell-o"></i> --> 
                        <span id="pak"><%-- ${sessionScope.message} --%></span>
                    </div> 
                   <div class="form-group ">
                        <input type="text" class="form-control"  id="userNO" name="userInfo.userNo" placeholder="请输入账户名"> 
                        <i class="form-contorl-icon icon-user"></i> 
                   </div>
                    <div class="form-group">
                        <input type="password" class="form-control" id="passwd" name="userInfo.password" placeholder="请输入密码" onKeyDown="setTab();"> 
                        <i class="form-contorl-icon icon-lock"></i>
                    </div>
                    <div class="form-group">
						<div class="code-left col-md-5 code-right">
							<input type="text" class="form-control" placeholder="请输入验证码" id="input1">
							<i class="form-contorl-icon icon-key"></i>
						</div>
						<div class="col-md-3 code-right">
						     <font color='red' size='5' class="code-img" onselectstart="return   false">
                            	<span  id="checkCode" onselectstart="return   false"></span>
                            </font>
							<!-- <img src="assets/images/security-code.png" alt="" class="code-img"> -->
						</div>
						<div class="col-md-4 code-right">
							<button type="button" class="btn btn-default btn-xs code-btn" id="again">看不清，换一张</button>
						</div>
					</div>
                    <button type="button" class="btn btn-info btn-block" onclick="goMain();" onKeyDown="setTab();"id="loginIndex"> <i class="fa fa-send"></i>
                        登录 
                    </button>
                </form>
        </div>
	

        
        <!-- /page-content -->
            <p class="copyright text-center color-lightslategray">
                © 2015 Copyright
                <a href="http://www.gm-medicare.com/" target="_blank">GM-Medicare.com</a>
                All Rights Reserved 版权所有
            </p>

    
    <!-- jQuery -->
    <script src="<%=basePath%>/helpDeskUI/assets/js/lib/jquery.js"></script>
    <!-- jQuery UI -->
    <script src="<%=basePath%>/helpDeskUI/assets/js/lib/jquery-ui.min.js"></script>
    <!-- jQuery twitter bootstrap -->
    <script src="<%=basePath%>/helpDeskUI/assets/js/lib/bootstrap.min.js"></script>
    <script src="<%=basePath%>/helpDeskUI/lib/jquery.placeholder.min.js"></script>
    <!-- 基础脚本库 -->
    <script src="<%=basePath%>/helpDeskUI/assets/js/base/app.js"></script>
    <script src="<%=basePath%>/helpDeskUI/lib/md5/md5.min.js"></script>
    <script src="<%=basePath%>/helpDeskUI/assets/js/pages/login.js"></script>
    <script type="text/javascript">
      
   </script>
</body>
<%-- <%session.removeAttribute("message"); %> --%>
<!--[if lt IE 10]>
		<script>
			$(function (){
				var ie9Placeholder = function (window, $, undefined) {
					if( !$().placeholder ) { return false; }
					$('input').placeholder();
					$('textarea').placeholder();
				}(window, jQuery);
			});
		</script>
	<![endif]-->
</html>
