<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
	<head>
		<title>毕业论文管理系统</title>
		<meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="../css/bootstrap.min.css" />
		<link rel="stylesheet" href="../css/bootstrap-responsive.min.css" />
		<link rel="stylesheet" href="../css/fullcalendar.css" />
		<link rel="stylesheet" href="../css/unicorn.main.css" />
		<link rel="stylesheet" href="../css/unicorn.grey.css" class="skin-color" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
	<body>
		<div id="header">
			<h1><a href="./dashboard.html">我的桌面</a></h1>
		</div>
		<div id="user-nav" class="navbar navbar-inverse">
			<ul class="nav btn-group">
				<li class="btn btn-inverse"><a title="" href="adminAction_change"><i class="icon icon-user"></i> <span class="text">密码修改</span></a></li>
				<li class="btn btn-inverse"><a title="" href="userAction_logout"><i class="icon icon-share-alt"></i> <span class="text">退出登录</span></a></li>
			</ul>
		</div>
            
		<div id="sidebar">
			<a href="adminAction_home" class="visible-phone"><i class="icon icon-home"></i>我的桌面</a>
			<ul>
				<li class="active"><a href="adminAction_home"><i class="icon icon-home"></i> <span>我的桌面</span></a></li>
				<li class="submenu">
					<a href="#"><i class="icon icon-th-list"></i> <span>基本配置管理</span> <span class="label">2</span></a>
					<ul>
						<li><a href="adminAction_studentPer">学生权限控制</a></li>
						<li><a href="adminAction_teacherPer">教师权限控制</a></li>
					</ul>
				</li>
				<li class="submenu">
					<a href="#"><i class="icon icon-file"></i> <span>用户管理</span> <span class="label">4</span></a>
					<ul>
						<li><a href="adminAction_stuCreate">创建学生账户</a></li>
						<li><a href="adminAction_stuUpdate">修改学生账户</a></li>
						<li><a href="adminAction_teaCreate">创建老师账户</a></li>
						<li><a href="adminAction_teaUpdate">修改老师账户</a></li>
					</ul>
				</li>
				<li>
					<a href="adminAction_check"><i class="icon icon-signal"></i> <span>论文审核</span></a>
				</li>
				<li class="submenu">
					<a href="#"><i class="icon icon-file"></i> <span>通知管理</span> <span class="label">2</span></a>
					<ul>
						<li><a href="adminAction_messageCreate">创建通知</a></li>
						<li><a href="adminAction_msgList">删除通知</a></li>
					</ul>
				</li>
			</ul>
		
		</div>
		
		<div id="style-switcher">
			<i class="icon-arrow-left icon-white"></i>
			<span>Style:</span>
			<a href="#grey" style="background-color: #555555;border-color: #aaaaaa;"></a>
			<a href="#blue" style="background-color: #2D2F57;"></a>
			<a href="#red" style="background-color: #673232;"></a>
		</div>
		
		<div id="content">
			<div id="content-header">
				<h1>我的桌面</h1>
			</div>
			<div id="breadcrumb">
				<a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
				<a href="#" class="current">我的桌面</a>
			</div>
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="span12 center" style="text-align: center;">
						<ul class="stat-boxes">
							<li>
								<div class="left peity_bar_good"><br/><br/><label>提交论文题目</label></div>
								<div class="right">
									<label>起:<fmt:formatDate value="${topicCheckProcess.topicCommitBegin}" pattern="yyyy-MM-dd"/></label>
									<label>止:<fmt:formatDate value="${topicCheckProcess.topicCommitEnd}" pattern="yyyy-MM-dd"/></label>
								</div>
							</li>
							<li>
								<div class="left peity_bar_good"><br/><br/><label>为学生选题</label></div>
								<div class="right">
									<label>起:<fmt:formatDate value="${topicCheckProcess.choiceBegin}" pattern="yyyy-MM-dd"/></label>
									<label>止:<fmt:formatDate value="${topicCheckProcess.choiceEnd}" pattern="yyyy-MM-dd"/></label>
								</div>
							</li>
							<li>
								<div class="left peity_bar_good"><br/><br/><label>开题报告审核</label></div>
								<div class="right">
									<label>起:<fmt:formatDate value="${topicCheckProcess.topicBegin}" pattern="yyyy-MM-dd"/></label>
									<label>止:<fmt:formatDate value="${topicCheckProcess.topicEnd}" pattern="yyyy-MM-dd"/></label>
								</div>
							</li>
							<li>
								<div class="left peity_bar_good"><br/><br/><label>中期报告审核</label></div>
								<div class="right">
									<label>起:<fmt:formatDate value="${topicCheckProcess.topicMidBegin}" pattern="yyyy-MM-dd"/></label>
									<label>止:<fmt:formatDate value="${topicCheckProcess.topicMidEnd}" pattern="yyyy-MM-dd"/></label>
								</div>
							</li>
							<li>
								<div class="left peity_bar_good"><br/><br/><label>终期论文审核</label></div>
								<div class="right">
									<label>起:<fmt:formatDate value="${topicCheckProcess.topicFinalBegin}" pattern="yyyy-MM-dd"/></label>
									<label>止:<fmt:formatDate value="${topicCheckProcess.topicFinalEnd}" pattern="yyyy-MM-dd"/></label>
								</div>
							</li>
						</ul>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span12">
						<div class="alert alert-info">
							欢迎进入 <strong> 毕业论文管理系统 </strong>. 请在规定时间内操作，以免造成不必要的麻烦!
							<a href="#" data-dismiss="alert" class="close">×</a>
						</div>
						<div class="widget-box">
							<div class="widget-title"><span class="icon"><i class="icon-signal"></i></span><h5>Site Statistics</h5><div class="buttons"><a href="adminAction_home" class="btn btn-mini"><i class="icon-refresh"></i> Update stats</a></div></div>
							<div class="widget-content">
								<div class="row-fluid">
								<div class="span4">
									<ul class="site-stats">
										<li><i class="icon-user"></i> <strong>${sumBean.studentCount}</strong> <small>学生总数</small></li>
										<li><i class="icon-user"></i> <strong>${sumBean.teacherCount}</strong> <small>教师总数</small></li>
										<li class="divider"></li>
										<li><i class="icon-tag"></i> <strong>${sumBean.topicCount}</strong> <small>论文总数</small></li>
										<li><i class="icon-tag"></i> <strong>${sumBean.topicPendingCount}</strong> <small>论文待审核总数</small></li>
									</ul>
								</div>
								</div>							
							</div>
						</div>					
					</div>
				</div>
				<div class="row-fluid">
					<div class="span12">
						<div class="widget-box widget-calendar">
							<div class="widget-title"><span class="icon"><i class="icon-calendar"></i></span><h5>Calendar</h5></div>
							<div class="widget-content nopadding">
								<div class="calendar"></div>
							</div>
						</div>
					</div>
				</div>
				<div class="row-fluid">
					<div id="footer" class="span12">
						2016 &copy; Unicorn Admin. Brought to you by Wuhao</a>
					</div>
				</div>
			</div>
		</div>
		

            <script src="../js/excanvas.min.js"></script>
            <script src="../js/jquery.min.js"></script>
            <script src="../js/jquery.ui.custom.js"></script>
            <script src="../js/bootstrap.min.js"></script>
            <script src="../js/jquery.flot.min.js"></script>
            <script src="../js/jquery.flot.resize.min.js"></script>
            <script src="../js/jquery.peity.min.js"></script>
            <script src="../js/fullcalendar.min.js"></script>
            <script src="../js/unicorn.js"></script>
            <script src="../js/unicorn.dashboard.js"></script>
	</body>
</html>
