<%@page language="java" import="java.util.*" pageEncoding="UTF-8" deferredSyntaxAllowedAsLiteral="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html lang="zh-cn">
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <!-- IE兼容模式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- 国产360浏览器高速模式 -->
    <meta name="renderer" content="webkit">
    <!-- 响应式设计 -->  
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 每隔20秒刷新一下界面 --><%--  
    <meta http-equiv="refresh" content="20">
    --%>
    <title>运维平台-上报任务</title>
    <!-- 基础组件样式 -->
    <link rel="stylesheet" href="helpDeskUI/assets/css/bootstrap.css">
    <link rel="stylesheet" href="helpDeskUI/assets/css/layout.css">
    <!-- Add fancyBox main CSS files -->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>helpDeskUI/lib/fancyapps-fancyBox/source/jquery.fancybox.css?v=2.1.5" media="screen" />
    <!-- jQuery ui 组件样式 -->
    <link rel="stylesheet" href="helpDeskUI/assets/css/jquery-ui-flat.css">
    <!-- jQuery nprogress 进度条插件样式 -->
    <link rel="stylesheet" href="helpDeskUI/assets/css/nprogress.css">
    <!-- 图标字体样式 -->
    <link rel="stylesheet" href="helpDeskUI/assets/css/simple-line-icons.css">
    <link rel="stylesheet" href="helpDeskUI/assets/css/font-awesome.css">
    <link rel="stylesheet" href="helpDeskUI/assets/css/tasks-processing.css">
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
<div class="pages theme-heading-fixed-top theme-sidebar-fixed theme-footer-fixed">
<%--      
   <%@include file="top.jsp" %>
		<!-- /navbar-top -->
 		<%@include file="menu.jsp" %>  
 		--%>

    <div class="page-content">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <form action="selectTaskInfo!selectTaskInfo.action" method="post" class="form-table clearfix collapse" id="js-search-criteria">
                      <input type="hidden" name="statusCount" value="${requestScope.statusCount}" id="js-statuscount"/>
                      <input type="hidden" id="js_sign" name="sign" value="${requestScope.sign}" />
                        <div class="row margin-bottom-lg">
                            <div class="col-md-6">
                                <div class="row">
                                    <div class="col-md-4 text-right">
                                        <label class="margin-top-sm">
                                            系统平台：
                                        </label>
                                    </div>
                                    <div class="col-md-8">
                                        <select name="taskInfo.settlement" id="systemName1" class="form-control" >
                                     
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="row">
                                    <div class="col-md-4 text-right">
                                        <label class="margin-top-sm">
                                            问题类型：
                                        </label>
                                    </div>
                                    <div class="col-md-8 ">
                                        <select name="taskInfo.problemType" id="js-select-problemType" class="form-control" >

                                        </select>
                                    </div>
                                </div>
                            </div>
                            
                        </div>
          
                        <!-- /row one -->
                           
                        
                    <div class="row margin-bottom-lg">
                              <div class="col-md-6">
                                <div class="row">
                                    <div class="col-md-4 margin-top-sm text-right">
                                        <label>
                                            提交时间：
                                        </label>
                                    </div>
                                    <div class="col-md-8">
                                         <div class="row">
                                             <div class="col-md-6">
                                                <div class="input-inbox-icon input-inbox-icon-right">
                                                    <input type="text" class="form-control" id="js-submit-satr-date" name="taskInfo.submission_date" value="<fmt:formatDate value="${taskInfo.submission_date}" pattern="yyyy-MM-dd"/>"  placeholder="开始时间" readonly> 
                                                </div>
                                             </div>
                                             <div class="col-md-6">
                                                 <div class="input-inbox-icon input-inbox-icon-right">
                                                    <input type="text" class="form-control" id="js-submit-end-date" name="taskInfo.submission_date_time" value="<fmt:formatDate value="${taskInfo.submission_date_time}" pattern="yyyy-MM-dd"/>"  placeholder="结束时间" readonly>
                                                </div>
                                             </div>
                                         </div>
                                    </div>
                                </div>
                            </div>
                           <div class="col-md-6">
                                 <div class="row">
                                    <div class="col-md-4 margin-top-sm text-right">
                                        <label>
                                          创建人：
                                        </label>
                                    </div>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" name="taskInfo.submitter1" id="js-select-submitter1" value="${taskInfo.submitter1}">
                                    </div>
                                </div>   
                       </div>
                   </div>
                   <div class="row margin-bottom-lg">
                            <div class="col-md-6">
                                <div class="row">
                                    <div class="col-md-4 text-right">
                                        <label class="margin-top-sm">
                                           任务状态：
                                        </label>
                                    </div>
                                    <div class="col-md-8">
                                      	 <div>
	                                      	 <label class="checkbox-inline" style="width: 20%">
	  												<input type="checkbox" name="taskInfo.status"  value="1"  > 待提交
	  										</label>
	  										<label class="checkbox-inline">
	  												<input type="checkbox" name="taskInfo.status"   value="2" > 运维打回
	  										</label>
	  										<label class="checkbox-inline">
	  												<input type="checkbox" name="taskInfo.status"   value="3" > 已处理
	  										</label>
	  										<label class="checkbox-inline">
	  												<input type="checkbox" name="taskInfo.status"   value="4" > 关闭
	  										</label>
                                      	 </div>
                                      	 <div>
	                                      	 <label class="checkbox-inline" style="width: 20%">
	  												<input type="checkbox" name="taskInfo.status"  value="7" > 待处理
	  										</label>
	  										<label class="checkbox-inline">
	  												<input type="checkbox" name="taskInfo.status"  value="6" > 运营打回
	  										</label>
	  										<label class="checkbox-inline">
	  												<input type="checkbox" name="taskInfo.status"  value="5" > 处理中
	  										</label>
	  										<label class="checkbox-inline">
	  												<input type="checkbox"   id="checkAll"> 全选
	  										</label>
                                      	 </div>           											            											
										
  										
  										        		                        
                                    </div>
                                </div>
                            </div>
                         <div class="col-md-6">
                                 <div class="row">
                                    <div class="col-md-4 margin-top-sm text-right">
                                        <label>
                                            任务编号：
                                        </label>
                                    </div>
                                    <div class="col-md-8">
                                        <input type="text" class="form-control" name="taskInfo.taskId" id="js-select-taskId" value="${taskInfo.taskId}">
                                    </div>
                                </div>   
                       </div>
                      </div>

                        <!-- /row three -->
                        <div class="row margin-bottom-lg">
                            <div class="col-md-10 col-md-offset-2">
                                <button type="button" class="btn btn-info">
                                    <i class="icon-magnifier"></i>
                                  查询                      
                                </button>

                                <button type="button" class="btn btn-default">
                                    <i class="icon-refresh"></i>
                                    取消
                                </button>
                            </div>
                            
                        </div>
                    </form>
                </div>
            </div>
            <!-- /form search -->
            <div class="row">
                <div class="col-md-6">
                    <div class="panel panel-default">
                        <div class="panel-heading clearfix">
                            <h5 class="panel-title  pull-left padding-top-sm">
                                <i class="icon-grid"></i>
                                上报任务
                            </h5>
                            <div class="btn-group pull-right" role="group" aria-label="...">
                                <button type="button" class="btn btn-sm btn-success" style="margin-right: 5px;" data-toggle="collapse" href="#js-search-criteria" aria-expanded="true" aria-controls="js-search-criteria">
                                	<i class="icon-magic-wand"></i>高级查询
                                </button>
                                <button type="button" class="btn btn-sm btn-primary" style="margin-right: 5px;" id="js-add-btn">
                                    <i class="fa fa-plus"></i>新增
                                </button>
                                <button type="button" class="btn btn-sm btn-info" style="margin-right: 5px;"  id="js-submit-btn"  onclick="ReportingTasks.submitTaskInfo();">
                                     <i class="fa fa-check"></i>提交
								</button>
								<button type="button" class="btn btn-sm btn-danger" style="margin-right: 5px;" id="js-delete-btn"  onclick="ReportingTasks.deleteTaskInfo()">
									<i class="fa fa-minus"></i>删除
								</button>
								 <button type="button" class="btn btn-sm btn-warning" id="js-close-btn"    onclick="ReportingTasks.closeTaskInfo()">
                                    <i class="fa fa-close"></i>关闭                                                                                                                                                                       
                                </button>
                            </div>
                        </div>
                        <div class="panel-body">
                                <table class="table table-hover no-margin table-task-lists" style="margin-top:12px;margin-bottom:12px;">
                                    <thead  class="bg-info-lighter">
                                        <tr>
                                            <th>任务编号</th>
                                            <th  width="20%">系统平台</th>
                                            <th>级别</th>
                                            <th width="15%">问题类型</th>
                                            <th width="20%">处理时间</th>
                                            <th>状态</th>
                                            <th class="hide"></th>
                                            
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${requestScope.pageVO.recordList}" var="a">
                                       <tr id="${a.taskId}" >
                         					 <td>${a.taskId}</td> 
                         					 <td>${a.settlement}</td>                      						 
                       						 <td>${a.priority}</td>
                      					     <td>${a.problemType}</td>                       						
                        				     <td><fmt:formatDate value="${a.processTime}"
												pattern="yyyy-MM-dd HH:mm:ss" /></td>
                       				      	<td>
  
											<c:if test="${a.processState==1}">待提交</c:if>
											<c:if test="${a.processState==2}">运维打回</c:if>
											<c:if test="${a.processState==3}">已处理</c:if>							
											<c:if test="${a.processState==4}">关闭</c:if>
											
											<c:if test="${a.processState==5}">处理中</c:if>
									   		<c:if test="${a.processState==6}">运营打回</c:if>
									   		<c:if test="${a.processState==7}">待处理</c:if>
									       </td>
                                            <td class="hide"><input type="checkbox" name="checkbox" id="${a.taskId}"  class="js-checkbox"/></td>
                   			      </tr>
                   			     </c:forEach>
                                        
                                </tbody>
                              </table>
                            </div>

                                          
                            
                        <div class="panel-footer clearfix">
                            <ul class="pager no-margin pull-left">
                                <li class="">
                                 <c:choose>
                                 <c:when test="${requestScope.pageVO.currPage==1}">
                                     <a href="javascript:ReportingTasks.goPage(1);" aria-label="true">
                                        <i class="fa fa-angle-double-left"></i>
                                        上一页
                                    </a>
                                 </c:when>
                                 <c:otherwise>
                                     <a href="javascript:ReportingTasks.goPage(${requestScope.pageVO.currPage-1});" aria-label="true">
                                        <i class="fa fa-angle-double-left"></i>
                                       上一页                       
                                    </a>
                                 </c:otherwise>
                                </c:choose>
                                </li>
                                <li class="next">
                                  <c:choose>
                                    <c:when test="${requestScope.pageVO.currPage==requestScope.pageVO.pageTotal}">
                                      <a href="javascript:ReportingTasks.goPage(${requestScope.pageVO.pageTotal});"aria-label="true">
                                        下一页
                                        <i class="fa fa-angle-double-right"></i>
                                      </a>
                                    </c:when>
                                   <c:otherwise> 
                                     <a href="javascript:ReportingTasks.goPage(${requestScope.pageVO.currPage+1});" aria-label="true">
                                             下一页  
                                        <i class="fa fa-angle-double-right"></i>
                                                       
                                    </a>
                                 </c:otherwise>
                                </c:choose>    
                                </li>
                            </ul>
                            <div class="pagination-custom-result pull-right color-lightslategray">
                                <div class="pagination-total">
                                    共                     				
                                    <span class="total">${requestScope.pageVO.currPage}/${requestScope.pageVO.pageTotal}</span>
                                    页，
                                </div>
                                <div class="pagination-to">
                                    到第
                                    <input type="text" class="form-control" id="pageText">页</div>
                                <button class="btn btn-default pagination-custom-btn" type="button" onclick="ReportingTasks.goPage($('#pageText').val());">确定</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /col-md-6 -->
                <div class="col-md-6">
                    <div class="panel panel-default">
                        <div class="panel-heading clearfix">
                            <h5 class=" panel-title">
                                <i class="fa fa-edit"></i>
                                修改
                            </h5>
                        </div>
                        <!-- /panel-heading -->
                        <div class="panel-body no-padding-right">
                         <div class="task-info-scorll" style="padding-right: 15px;">
                          <form action ="" method="post" name="update-task-form" id="js-update-task-form">                              
                            <input type="hidden" id="js_id"  name="taskInfo.taskId"><%--
                                <div class="row margin-bottom">
                                    <div class="col-md-6">
                                        <div class="row">
                                            <div class="col-md-5 text-right">
                                                 <label class="margin-top-sm">任务标题：</label>
                                            </div>
                                            <div class="col-md-7">
                                                     <p class="form-control-static" id="js_taskInfo_taskTitle" >
                                                
                                                     </p>
                                              </div>
                                        </div>
                                    </div>           
                                </div>
                                --%><div class="row margin-bottom">
                                    <div class="col-md-6">
                                        <div class="row">
                                            <div class="col-md-5 text-right">
                                                 <label class="margin-top-sm">任务编号：</label>
                                            </div>
                                            <div class="col-md-7">
                                                     <p class="form-control-static" id="js_taskInfo_taskId" >
                                                
                                                     </p>
                                              </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="row">
                                            <div class="col-md-5 text-right">
                                                 <label class="margin-top-sm">优先级别：</label>
                                            </div>
                                               <div class="col-md-7">
                       
                                                    <select name="taskInfo.priority" id="js_taskInfo_priority" class="form-control">
														<option value="中" selected="selected">中</option>
														<option value="高">高</option>													
														<%--<option value="低">低</option>
													 --%></select>
                                                </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- /row star -->
                                <div class="row margin-bottom">
                                     <div class="col-md-6">
                                        <div class="row">
                                            <div class="col-md-5 text-right">
                                                 <label class="margin-top-sm">创建人：</label>
                                            </div>
                                              <div class="col-md-7">
                                                     <p class="form-control-static" id="js_taskInfo_submitter">
                                                      
                                                     </p>
                                              </div>
                                        </div>
                                    </div>
                            
                                    <div class="col-md-6">
                                        <div class="row">
                                            <div class="col-md-5 text-right">
                                                 <label class="margin-top-sm">问题类型：</label>
                                            </div>
                                            <div class="col-md-7">
                                                <select name="taskInfo.problemType" id="js-update-problemType"   class="form-control" > 
							
												</select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                 <!-- /row one -->
                                <%--
                                                                                                                          修改系统平台
                                
                                --%>
                                                                 
                               <div class="row margin-bottom">
                                   <div class="col-md-6">
                                        <div class="row">
                                            <div class="col-md-5 text-right">
                                                 <label class="margin-top-sm">处理人：</label>
                                            </div>
                                              <div class="col-md-7">
                                                     <p class="form-control-static" id="js_taskInfo_handleUser">
                                                      
                                                     </p>
                                              </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="row">
                                            <div class="col-md-5 text-right">
                                                 <label class="margin-top-sm">系统平台：</label>
                                            </div>
                                            <div class="col-md-7">
                                                <select name="taskInfo.settlement" id="systemName"  class="form-control" > 
								
							            	  </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                  <div class="row margin-bottom">
                                     <div class="col-md-6">
                                        <div class="row">
                                            <div class="col-md-5 text-right">
                                                 <label class="margin-top-sm">处理时间：</label>
                                            </div>
                                              <div class="col-md-7">
                                                     <p class="form-control-static" id="js_taskInfo_processTime">
                                                      
                                                     </p>
                                              </div>
                                        </div>
                                    </div>
             					 </div>
                               <!-- /row two -->
                                <div class="row margin-bottom">
                                     <div class="col-md-6">
                                        <div class="row">
                                            <div class="col-md-5 text-right">
                                                <label class="margin-bottom">问题描述：</label>
                                            </div>
                                        </div>
                                        
                                    </div>
                                    <div class="col-md-12" id="js_problemDescription">
                                                 <!-- <textarea name="problemDescription" id="" rows="5" class="margin-bottom form-control" ></textarea> -->
                                                <!-- <textarea name="taskInfo.problemDescription" id="js_taskInfo_problemDescription" rows="5" class="margin-bottom form-control" ></textarea>  -->
                                    </div>
                                    
                                </div>
                                <!-- /row three -->
                                 <div class="row" >
                                    <div class="col-md-12" >
                                        <label >图片详情：</label>
                                        <div class="row margin-bottom" id="js-img-gallery-new" >
                                            <div class="col-md-3">
                                                <div class="img-cover img-yunying">
                                                    <img src="helpDeskUI/assets/images/placeholder.png" class="img-rounded">
                                                    <div class="img-cover-content">
                                                        <div class="img-cover-footer">
                                                            <a href="#" title="预览图片" class="pull-left btn btn-default btn-sm fancybox fancybox.ajax">
                                                                <i class="fa fa-search"></i>
                                                            </a>
                                                            <a href="#" title="删除图片" class="pull-right btn btn-default btn-sm shanchu"   >
                                                                <i class=" fa fa-trash"></i>
                                                            </a>
                                                        </div>
                                                    </div>
                                                    <!-- img-cover-content -->
                                                </div>
                                                <!-- /img-cover -->
                                            </div>
                                            <div class="col-md-3">
                                                <div class="img-cover img-yunying">
                                                    <img src="helpDeskUI/assets/images/placeholder.png"  class="img-rounded">
                                                    <div class="img-cover-content">
                                                        <div class="img-cover-footer">
                                                            <a href="#" title="预览图片" class="pull-left btn btn-default btn-sm fancybox fancybox.ajax">
                                                                <i class="fa fa-search"></i>
                                                            </a>
                                                            <a href="#" title="删除图片"     class="pull-right btn btn-default btn-sm shanchu">
                                                                <i class=" fa fa-trash"></i>
                                                            </a>
                                                        </div>
                                                    </div>
                                                    <!-- img-cover-content -->
                                                </div>
                                                <!-- /img-cover -->
                                            </div>
                                            <div class="col-md-3">
                                                <div class="img-cover img-yunying">
                                                    <img src="helpDeskUI/assets/images/placeholder.png" class="img-rounded">
                                                    <div class="img-cover-content">
                                                        <div class="img-cover-footer">
                                                            <a href="#" title="预览图片" class="pull-left btn btn-default btn-sm fancybox fancybox.ajax">
                                                                <i class="fa fa-search"></i>
                                                            </a>
                                                            <a href="#" title="删除图片" class="pull-right btn btn-default btn-sm shanchu">
                                                                <i class=" fa fa-trash"></i>
                                                            </a>
                                                        </div>
                                                    </div>
                                                    <!-- img-cover-content -->
                                                </div>
                                                <!-- /img-cover -->
                                            </div>
                                            <div class="col-md-3">
                                                <div class="img-cover img-yunying">
                                                    <img src="helpDeskUI/assets/images/placeholder.png"  class="img-rounded">
                                                    <div class="img-cover-content">
                                                        <div class="img-cover-footer">
                                                            <a href="#" title="预览图片" class="pull-left btn btn-default btn-sm fancybox fancybox.ajax">
                                                                <i class="fa fa-search"></i>
                                                            </a>
                                                            <a href="#" title="删除图片" class="pull-right btn btn-default btn-sm shanchu">
                                                                <i class=" fa fa-trash"></i>
                                                            </a>
                                                        </div>
                                                    </div>
                                                    <!-- img-cover-content -->
                                                </div>
                                                <!-- /img-cover -->
                                            </div>
                                        </div>
                                       <!--   图片第二列-->
                                        <div class="row margin-bottom" id="js-img-gallery-yunwei" >
                                            <div class="col-md-3">
                                                <div class="img-cover img-yunwei">
                                                    <img src="helpDeskUI/assets/images/placeholder.png"  class="img-rounded">
                                                    <div class="img-cover-content">
                                                        <div class="img-cover-footer">
                                                            <a href="#" title="预览图片" class="pull-left btn btn-default btn-sm fancybox fancybox.ajax">
                                                                <i class="fa fa-search"></i>
                                                            </a>
                                                         
                                                        </div>
                                                    </div>
                                                    <!-- img-cover-content -->
                                                </div>
                                                <!-- /img-cover -->
                                            </div>
                                            <div class="col-md-3">
                                                <div class="img-cover img-yunwei">
                                                    <img src="helpDeskUI/assets/images/placeholder.png"  class="img-rounded">
                                                    <div class="img-cover-content">
                                                        <div class="img-cover-footer">
                                                            <a href="#" title="预览图片" class="pull-left btn btn-default btn-sm fancybox fancybox.ajax">
                                                                <i class="fa fa-search"></i>
                                                            </a>
                                                           
                                                        </div>
                                                    </div>
                                                    <!-- img-cover-content -->
                                                </div>
                                                <!-- /img-cover -->
                                            </div>
                                            <div class="col-md-3">
                                                <div class="img-cover img-yunwei">
                                                    <img src="helpDeskUI/assets/images/placeholder.png"  class="img-rounded">
                                                    <div class="img-cover-content">
                                                        <div class="img-cover-footer">
                                                            <a href="#" title="预览图片" class="pull-left btn btn-default btn-sm fancybox fancybox.ajax">
                                                                <i class="fa fa-search"></i>
                                                            </a>
                                                           
                                                        </div>
                                                    </div>
                                                    <!-- img-cover-content -->
                                                </div>
                                                <!-- /img-cover -->
                                            </div>
                                            <div class="col-md-3">
                                                <div class="img-cover img-yunwei">
                                                    <img src="helpDeskUI/assets/images/placeholder.png"  class="img-rounded">
                                                    <div class="img-cover-content">
                                                        <div class="img-cover-footer">
                                                            <a href="#" title="预览图片" class="pull-left btn btn-default btn-sm fancybox fancybox.ajax">
                                                                <i class="fa fa-search"></i>
                                                            </a>
                                                           
                                                        </div>
                                                    </div>
                                                    <!-- img-cover-content -->
                                                </div>
                                                <!-- /img-cover -->
                                            </div>
                                        </div>   
                                        
                                                                                                                                                                                                                                          
                                    </div>
                                </div>
                                
                                <!-- /row four --><%--
                                <div class="row">
                                     <div class="col-md-6">
                                        <div class="row">
                                            <div class="col-md-5 text-right">
                                                <label class="margin-bottom">图片详情：</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-12 " id="js-img-gallery">
                                        
                                    </div>
                                </div>
                               --%><!-- /row five -->
                                <div class="row">
                     
                                    <div class="col-md-12"  id="js-update-imgadd-div" >
                                       <%--
                                          <div class="form-inline">
	       			                     	<input type="file" class="margin-bottom-lg js-input-imgs form-control"  name="taskInfo.files">
	                            			<button type="button" class="btn btn-danger margin-bottom-lg form-control js-imageName-clear" onclick="ReportingTasks.clearAddress(this)">
	                            			<i class="fa fa-close"></i>
	                            			</button>	                           	  
                           	 			</div> 
                                       --%>
                                       <div class="margin-bottom form-inline inline-false" id="js-add-file">
                                           <input type="file" class="margin-bottom-lg js-input-imgs form-control" name="taskInfo.files" id="js-update-inputfile-first"  /><button type="button" class="btn btn-danger margin-bottom-lg form-control js-imageName-clear" style="margin-left: 3px" onclick="ReportingTasks.clearAddress(this)">
	                            			<i class="fa fa-close"></i>
	                            			</button>	
                                        </div>
                                        <%--                            
                                        <div class="margin-bottom" id="js-add-file">
                                           <input type="file" class="margin-bottom-lg js-update-imgs" name="taskInfo.files" id="js-update-inputfile-first">
                                  
                                        </div>
                                      --%>
                                    </div>
                                     <div class="col-md-6">
                                        <div class="row">
                                            <div class="col-md-5 text-right">
                                                <label class="margin-bottom">处理意见：</label>
                                            </div>
                                        </div>
                                     </div>
                                     
                                     <div class="col-md-12" id="js-handleSuggestion">
                                                                           
										 <!-- <textarea name="taskInfo.hangleSuggestion" id="js_taskInfo_handleSuggestion" rows="5" class="margin-bottom form-control" disabled="disabled"></textarea> -->
                                    
                                     	 <!-- <p class="form-control-static" id="js_taskInfo_handleSuggestion" >
                                                
                                          </p> -->
                                     
                                     </div>
                                </div>
                                
                                
                                   <%--                           
                              
                                      <div class="col-md-6">
                                        <div class="row">
                                            <div class="col-md-5 text-right">
                                                 <label class="margin-top-sm">任务编号：</label>
                                            </div>
                                            <div class="col-md-7">
                                                     <p class="form-control-static" id="js_taskInfo_taskId" >
                                                
                                                     </p>
                                              </div>
                                        </div>
                                    </div>
                            
                               --%>
                                
                                
                                
                                <!-- /row six -->
                                <div class="row">
                                    <div class="col-md-12 margin-bottom-lg">
                                        <button class="btn btn-info" type="button" id="js-update-btn"  onclick="ReportingTasks.updateTaskInfo();" >
                                            <i class="fa fa-save"></i>
                                           保存                                
                                        </button>
                                        <button class="btn btn-info" type="button" id="js-update-submit-btn"  onclick="ReportingTasks.updateSubmitTaskInfo();" >
                                            <i class="fa fa-check"></i>
                                           保存并提交                                
                                        </button><%--
                                         <button class="btn btn-info" type="button" id="js-update-back-btn"  onclick="ReportingTasks.backTaskInfo();" >
                                            <i class="fa fa-mail-forward"></i>
             	 打回                             
                                        </button>
                                           --%><%--
                                        <button class="btn btn-default"  type="button" id="js-update-cancel-btn" >
                                            <i class="icon-refresh"></i>
                                            取消
                                        </button>                                     
                                          --%>
                                    </div>
                                </div>
                                <!-- /row last -->
                                </form>
                                <table class="table no-margin table-hover">
                                    <thead>
                                        <tr>
                                            <th>
                                                <i class="fa fa-user"></i>
                                                操作人
                                            </th>
                                            <th>
                                                <i class="fa fa-calendar"></i>
                                               操作时间
                                            </th>
                                            <th>
                                                <i class="fa fa-sliders"></i>
                                               状态                                   
                                            </th>

                                        </tr>
                                    </thead>
                                    <tbody  id=js-taskInfo-processRecord>
   
                                    </tbody>
                                </table>
                                <!-- /table -->
                              </div>    
                        </div>
                    </div>
                
                <!-- /上报修改 -->
            </div>
          </div>  
        </div>
    </div>
    
      <div class="page-footer">
        <p class="copyright color-lightslategray">
            © 2015 Copyright <a href="http://www.gm-medicare.com/" target="_blank">GM-Medicare.com</a> All Rights Reserved 版权所有
        </p>
    </div>
    <!-- /page-footer -->
    
  </div>
   <!-- /pages -->
    

<div id="js-add-dialog">
	   <form action ="" method="post" name="add-task-form" id="js-new-task-form">
			<!-- <hidden name="taskId"><hidden> -->
	        <div class="row margin-bottom-lg">
	            <div class="col-md-6">
	                <div class="row">
	                    <div class="col-md-4 text-right">
	                        <label class="margin-top-sm">
	                          系统平台：
	                        </label>
	                    </div>
	                    <div class="col-md-8">
	                        <select name="taskInfo.settlement" id="systemName2" class="form-control">
	                          
	                        </select>
	                    </div>
	                </div>
	            </div>
	        
	                                
	            <div class="col-md-6">
	                <div class="row">
	                    <div class="col-md-4 text-right">
	                        <label class="margin-top-sm">
	                            问题类型：
	                        </label>
	                    </div>
	                    <div class="col-md-8">
	                        <select name="taskInfo.problemType" id="js-add-problemType" class="form-control">
	                        </select>
	                    </div>
	                </div>
	            </div>
	        </div>
	        
	       
	        <!-- /row one -->
	        <div class="row margin-bottom-lg">
	            <div class="col-md-6">
	                <div class="row">
	                    <div class="col-md-4 text-right">
	                        <label class="margin-top-sm">
	                            优先级别：
	                        </label>
	                    </div>
	                    <div class="col-md-8">
	                        <select name="taskInfo.priority" id="js-add-priority" class="form-control">	                         
								<option value="中" selected="selected">中</option>
								<option value="高">高</option>								
								<%--<option value="低">低</option>
	                        --%></select>
	                    </div>
	                </div>
	            </div><%--
	            
	                                            
	            <div class="col-md-6">
	                <div class="row">
	                    <div class="col-md-4 text-right">
	                        <label class="margin-top-sm">
	                            任务标题：
	                        </label>
	                    </div>
	                    <div class="col-md-8">
	                        <input type="text"  id="js-add-taskTitle"  class="form-control" name="taskInfo.taskTitle"/>
	                    </div>
	                </div>
	            </div>
	        --%></div>
	        
	        
	       <div class="row">
	            <div class="col-md-6">
	                <div class="row">
	                    <div class="col-md-4 text-right">
	                        <label class="margin-top-sm">
	                            问题描述：
	                        </label>
	                    </div>
	                 </div>
	             </div>
	                    <div class="col-md-12 ">
	                        <textarea cols="5" class="margin-bottom form-control" id="js-add-problemDescription" name="taskInfo.problemDescription"></textarea>
	                    </div>
	               
	        </div>
	
	        <!-- /row three -->
	        <div class="row ">
	            <div class="col-md-12">
	                <div class="row">
	                    <div class="col-md-2 text-right">
	                        <label class="margin-top-sm">
	                            增加附件：
	                        </label>
	                    </div>
	                    <div class="col-md-10">	                        
	                        <div class="margin-bottom" id="js-select-file">
	                            <div class="form-inline">
	                            	<input type="file" class="margin-bottom-lg js-input-imgs form-control"  name="taskInfo.files" /><button type="button" class="btn btn-danger margin-bottom-lg form-control js-imageName-clear"  style="margin-left: 3px;" onclick="ReportingTasks.clearAddress(this)">
	                            		<i class="fa fa-close"></i>
	                            	</button>	                           	  
                           	 	</div> 	                          
	                           
	                            <%--	                            
	                            <input type="file" class="margin-bottom-lg js-input-imgs"  name="taskInfo.files">
	                            --%>
	                            <button type="button" class="btn btn-default margin-right-sm tianjia">
	                                <i class="fa fa-plus"></i>
	                                添加
	                            </button>
	                            <span class="color-info">
	                                <i class="fa fa-file-photo-o fa-fw"></i>
	                                点击增加，相应增加1个图片上传，最多可添加4个图片上传。
	                            </span>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	        <!-- /row four -->
	    </form>
	</div>
	
<input id="js-select-systemNameBack" type="hidden" value="${taskInfo.settlement}"><%--查询时回显系统平台--%>
<input id="js-select-problemTypeBack" type="hidden" value="${taskInfo.problemType}"><%--查询时回显问题类型--%>
<input id="js-select-statusBack" type="hidden" value="${requestScope.str}"><%--查询时回显处理状态--%>
<input id="js-select-taskIdBack" type="hidden" value="${taskInfo.taskId}"><%--查询时回显任务编号--%>
<input id="js-select-submitter1Back" type="hidden" value="${taskInfo.submitter1}"><%--查询时回显创建人--%>
<!-- jQuery -->
<script src="<%=basePath%>helpDeskUI/assets/js/lib/jquery.js"></script>
<!-- jQuery UI -->
<script src="<%=basePath%>helpDeskUI/assets/js/lib/jquery-ui.min.js"></script>
<script src="<%=basePath%>helpDeskUI/assets/js/lib/datepicker-zh-CN.js"></script>
<!-- jQuery twitter bootstrap -->
<script src="<%=basePath%>helpDeskUI/assets/js/lib/bootstrap.min.js"></script>
<!-- jQuery 进度条 nprogress -->
<script src="<%=basePath%>helpDeskUI/assets/js/lib/nprogress.js"></script>
<!-- jQuery slimscroll -->
<script src="<%=basePath%>helpDeskUI/assets/js/lib/jquery.slimscroll.js"></script>
<!--ajaxSubmit -->
<script src="<%=basePath%>helpDeskUI/assets/js/lib/jquery.form.js"></script>
<!-- Add fancyBox main JS files -->
<script type="text/javascript" src="helpDeskUI/lib/fancyapps-fancyBox/source/jquery.fancybox.pack.js?v=2.1.5"></script>
<!-- 默认显示 -->
<script src="<%=basePath%>/helpDeskUI/assets/js/lib/jquery.placeholder.min.js"></script>
<!-- 基础脚本库 -->
<script src="<%=basePath%>helpDeskUI/assets/js/base/app.js"></script>
<script src="<%=basePath%>helpDeskUI/assets/js/pages/reporting-tasks.js"></script>
<!-- 定时刷新菜单中任务量 -->
<%-- <script type="text/javascript" src="helpDeskUI/customJs/menu.timer.js"></script> --%>
<script>
    $(function (){
        'use strict';
        App.stopDefaultEvent();
        App.sidebarScroll();
        App.pageLoadBar();            
        ReportingTasks.init();                   
        ReportingTasks.addFileInputAdd('#js-select-file');
        ReportingTasks.addDialog();
        ReportingTasks.checkAll();      
        ReportingTasks.backStatus(); 
        ReportingTasks.chooseFisTr();
        $('#js_taskInfo_processState').val($('#js-select-statusBack').val());
        $('#systemName1').val($('#js-select-systemNameBack').val());
        $('#js-select-problemType').val($('#js-select-problemTypeBack').val());
        $('#js-select-taskId').val($('#js-select-taskIdBack').val());
        $('#js-select-submitter1').val($('#js-select-submitter1Back').val());
        $('.fancybox').fancybox();
    }); 
</script>
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
<%
  session.removeAttribute("statusCount");

  %>
  
  
</body>
</html>