<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
				<li class="btn btn-inverse"><a title="" href="teacherAction_info"><i class="icon icon-user"></i> <span class="text">个人信息</span></a></li>
				<li class="btn btn-inverse"><a title="" href="teacherAction_change"><i class="icon icon-user"></i> <span class="text">密码修改</span></a></li>
				<li class="btn btn-inverse dropdown" id="menu-messages"><a href="#" data-toggle="dropdown" data-target="#menu-messages" class="dropdown-toggle"><i class="icon icon-envelope"></i> <span class="text">邮箱</span><b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a class="sAdd" title="" href="#">发送信息</a></li>
						<li><a class="sInbox" title="" href="#">收件箱</a></li>
						<li><a class="sOutbox" title="" href="#">已发出信息</a></li>
					</ul>
				</li>
				<li class="btn btn-inverse"><a title="" href="userAction_logout"><i class="icon icon-share-alt"></i> <span class="text">退出登录</span></a></li>
			</ul>
		</div>
            
		<div id="sidebar">
			<a href="#" class="visible-phone"><i class="icon icon-home"></i> 我的桌面</a>
			<ul>
				<li class="active"><a href="teacherAction_home"><i class="icon icon-home"></i> <span>我的桌面</span></a></li>
				<li class="submenu">
					<a href="#"><i class="icon icon-th-list"></i> <span>论文管理</span> <span class="label">3</span></a>
					<ul>
						<li><a href="teacherAction_add">论文录入</a></li>
						<li><a href="teacherAction_updateTopic">论文修改</a></li>
						<li><a href="teacherAction_studentTopic">给学生选题</a></li>
					</ul>
				</li>
				<li class="submenu">
					<a href="#"><i class="icon icon-file"></i> <span>论文过程管理</span> <span class="label">6</span></a>
					<ul>
						<li><a href="teacherAction_process">学生进度查看</a></li>
						<li><a href="teacherAction_begin">审核学生开题计划</a></li>
						<li><a href="teacherAction_beginRead">查看学生开题计划</a></li>
						<li><a href="teacherAction_mid">审核学生中期计划</a></li>
						<li><a href="teacherAction_midRead">查看学生中期计划</a></li>
						<li><a href="teacherAction_topFinal">审核学生终稿</a></li>
					</ul>
				</li>
				<li>
					<a href="teacherAction_message"><i class="icon icon-signal"></i> <span>查看通知与下载</span></a>
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
							<div class="widget-title"><span class="icon"><i class="icon-signal"></i></span><h5>Site Statistics</h5><div class="buttons"><a href="teacherAction_home" class="btn btn-mini"><i class="icon-refresh"></i> Update stats</a></div></div>
							<div class="widget-content">
								<div class="row-fluid">
								<div class="span4">
									<ul class="site-stats">
										<li><i class="icon-tag"></i> <strong>${sumBean.topicCount}</strong> <small>创建论文</small></li>
										<li><i class="icon-tag"></i> <strong>${sumBean.topicPendingCount}</strong> <small>待审核</small></li>
										<li class="divider"></li>
										<li><i class="icon-tag"></i> <strong>${sumBean.studentCount}</strong> <small>已被学生选中</small></li>
										<li><i class="icon-tag"></i> <strong>${sumBean.teacherCount}</strong> <small>学生已通过</small></li>
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
