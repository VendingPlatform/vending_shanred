<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!doctype html>
<div class="page-sidebar">
	<div class="sidebar-inner">
		<a class="sidebar-brand bg-info" href="helpDeskUI/view/index.jsp"
			title="跳转到首页"> <i class="fa fa-area-chart fa-2x"></i> <span
			class="brand-title">运维平台</span>
		</a>
		<c:if
			test="${fn:contains(sessionScope.userInfo.authorityCode ,'001') || fn:contains(sessionScope.userInfo.authorityCode ,'010')}">
			<h4 class="sidebar-title">任务中心</h4>

			<ul class="nav sidebar-nav">
				<c:if
					test="${fn:contains(sessionScope.userInfo.authorityCode ,'001')}">
					<li><a
						href="selectTaskInfo!selectTaskInfo.action?taskInfo.Status=1&taskInfo.Status=2&taskInfo.Status=3">
							<i class="icon-rocket"></i> 上报任务 <span
							class="badge badge-sm bg-badger pull-right" id="add_status_count">${statusCount}</span>
					</a></li>
				</c:if>
				<c:if
					test="${fn:contains(sessionScope.userInfo.authorityCode ,'010')}">
					<li><a
						href="dispose!dispose.action?taskInfo.status=5&taskInfo.status=6&taskInfo.status=7">
							<i class="icon-note"></i> 任务处理 <span
							class="badge badge-sm bg-info pull-right" id="processCount">${processCount}</span>
					</a></li>
				</c:if>
			</ul>
		</c:if>
		<c:if
			test="${fn:contains(sessionScope.userInfo.authorityCode ,'020') || fn:contains(sessionScope.userInfo.authorityCode ,'030')}">
			<h4 class="sidebar-title">权限管理</h4>
		</c:if>
		<ul class="nav sidebar-nav">
			<c:if
				test="${fn:contains(sessionScope.userInfo.authorityCode ,'020')}">
				<li><a
					href="#"
					target="_self"> <i class="icon-users "></i> 用户管理
				</a></li>
			</c:if>
			<c:if
				test="${fn:contains(sessionScope.userInfo.authorityCode ,'030')}">
				<li><a
					href="#"
					target="_self"> <i class="icon-settings "></i> 角色管理
				</a></li>
			</c:if>
		</ul>
		<c:if
			test="${fn:contains(sessionScope.userInfo.authorityCode ,'040')}">
			<h4 class="sidebar-title">值班管理</h4>
			<ul class="nav sidebar-nav">
				<li><a
					href="#"
					target="_self"> <i class="icon-user"></i> 值班安排
				</a></li>
			</ul>
		</c:if>
		<c:if test="${fn:contains(sessionScope.userInfo.
 ,'10000' )}">
			<h4 class="sidebar-title">数据分析</h4>
			<ul class="nav sidebar-nav">
				<li><a href="#"> <i class="icon-magnifier"></i> 报表查询
				</a></li>
				<li><a href="#"> <i class="icon-pie-chart"></i> 数据分析
				</a></li>
			</ul>
		</c:if>
		<h4 class="sidebar-title sidebar-bordered">值班信息</h4>
		<ul class="sidebar-user-nav">
			<li><i class="color-info icon-directions margin-right-sm"></i> <span
				id="jsw-subfield">${sessionScope.sc.subfield }</span></li>
			<li><i class="color-info icon-directions margin-right-sm"></i> <span
				id="jsw-directWatchPerson">主：${sessionScope.sc.directWatchPerson }</span>&nbsp;
				&nbsp;<span id="jsw-auxiliaryWatchPerson">辅：
					${sessionScope.sc.auxiliaryWatchPerson }</span></li>
			<li><i class="color-info icon-call-end margin-right-sm"></i> <span
				id="jsw-phone">${sessionScope.sc.phone }</span></li>
			<li><a href="mailto:${sessionScope.sc.email}"> <i
					class="color-info icon-envelope-letter margin-right-sm"></i>
					邮件联系值班人员
			</a></li>
			<li><i class="color-info fa fa-calendar margin-right-sm"></i> <span
				id="jsw-startTime">${sessionScope.sc.startTime }</span>到<span
				id="jsw-endTime">${sessionScope.sc.endTime }</span></li>

		</ul>
		<!-- /sidebar-user-nav -->
	</div>
	<!-- /page-sidebar-inner -->
</div>
<input type="hidden" id="basePath" value="<%=basePath%>" />
<input type="hidden" id="js-authorityCode"
	value="${sessionScope.userInfo.authorityCode}" />
<!-- jQuery -->

<script src="helpDeskUI/assets/js/lib/jquery.js"></script>
<!-- 定时刷新菜单中任务量 -->
<script type="text/javascript" src="helpDeskUI/customJs/menu.timer.js"></script>




