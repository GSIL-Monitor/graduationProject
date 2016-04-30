<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>
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
                <li class="btn btn-inverse"><a title="" href="studentAction_info"><i class="icon icon-user"></i> <span class="text">个人信息</span></a></li>
				<li class="btn btn-inverse"><a title="" href="studentAction_change"><i class="icon icon-user"></i> <span class="text">密码修改</span></a></li>
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
			<a href="studentAction_home" class="visible-phone"><i class="icon icon-home"></i> 我的桌面</a>
			<ul>
				<li class="active"><a href="studentAction_home"><i class="icon icon-home"></i> <span>我的桌面</span></a></li>
				<li><a href="studentAction_choice"><i class="icon icon-th"></i> <span>学生选题</span></a></li>
				<li class="submenu">
					<a href="#"><i class="icon icon-th-list"></i> <span>撰写环节及任务</span> <span class="label">5</span></a>
					<ul>
						<li><a href="studentAction_begin">填写开题计划</a></li>
						<li><a href="studentAction_beginRead">查看开题计划</a></li>
						<li><a href="studentAction_mid">填写中期检查</a></li>
						<li><a href="studentAction_midRead">查看中期检查</a></li>
						<li><a href="studentAction_topFinal">论文终稿提交</a></li>
					</ul>
				</li>
				<li><a href="studentAction_message"><i class="icon icon-th-list"></i> <span>查看通知与下载</span></a></li>
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
				<a href="studentAction_home" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
				<a href="#" class="current">我的桌面</a>
			</div>
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="span12 center" style="text-align: center;">					
						<ul class="stat-boxes">
							<li>
								<div class="left peity_bar_good"><br/><br/><label>学生选择题目</label></div>
								<div class="right">
									<label>起:<fmt:formatDate value="${topicProcess.choiceBegin}" pattern="yyyy-MM-dd"/></label>
									<label>止:<fmt:formatDate value="${topicProcess.choiceEnd}" pattern="yyyy-MM-dd"/></label>
								</div>
							</li>
							<li>
								<div class="left peity_bar_good"><br/><br/><label>开题计划填写</label></div>
								<div class="right">
									<label>起:<fmt:formatDate value="${topicProcess.topicBegin}" pattern="yyyy-MM-dd"/></label>
									<label>止:<fmt:formatDate value="${topicProcess.topicEnd}" pattern="yyyy-MM-dd"/></label>
								</div>
							</li>
							<li>
								<div class="left peity_bar_good"><br/><br/><label>中期检查填写</label></div>
								<div class="right">
									<label>起:<fmt:formatDate value="${topicProcess.topicMidBegin}" pattern="yyyy-MM-dd"/></label>
									<label>止:<fmt:formatDate value="${topicProcess.topicMidEnd}" pattern="yyyy-MM-dd"/></label>
								</div>
							</li>
							<li>
								<div class="left peity_bar_good"><br/><br/><label>论文终稿提交</label></div>
								<div class="right">
									<label>起:<fmt:formatDate value="${topicProcess.topicFinalBegin}" pattern="yyyy-MM-dd"/></label>
									<label>止:<fmt:formatDate value="${topicProcess.topicFinalEnd}" pattern="yyyy-MM-dd"/></label>
								</div>
							</li>
						</ul>
					</div>
					<div class="span12">
						<div class="alert alert-info">
							欢迎进入 <strong> 毕业论文管理系统 </strong>. 请在规定时间内操作，以免造成不必要的麻烦!
							<a href="#" data-dismiss="alert" class="close">×</a>
						</div>
						<div class="widget-box">
							<div class="widget-content nopadding">
								<table class="table table-bordered table-striped">
									<thead>
										<tr>
											<th></th>
											<th>指导老师</th>
											<th>论文题目</th>
											<th>开题计划</th>
											<th>中期检查</th>
											<th>终稿提交</th>
											<th>成绩</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>我的毕业论文进度:</td>
											<td>${topic.tutorName}</td>
											<td>${topic.name}</td>
											<c:if test="${topicStatus.topicBegin!=2}">
												<td>暂无</td>
											</c:if>
											<c:if test="${topicStatus.topicBegin==2}">
												<td>${topicStatus.beginScore}</td>
											</c:if>
											<c:if test="${topicStatus.topicMid!=2}">
												<td>暂无</td>
											</c:if>
											<c:if test="${topicStatus.topicMid==2}">
												<td>${topicStatus.midScore}</td>
											</c:if><c:if test="${topicStatus.topicFinal!=2}">
												<td>暂无</td>
											</c:if>
											<c:if test="${topicStatus.topicFinal==2}">
												<td>${topicStatus.finalScore}</td>
											</c:if>
											<c:if test="${allScore==0}">
												<td>暂无</td>
											</c:if>
											<c:if test="${allScore!=0}">
												<td>${allScore}</td>
											</c:if>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<div class="row-fluid">
					<div id="footer" class="span12">
						2016 &copy; Graduation Thesis Management System. Brought to you by Wuhao
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
