<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=utf-8" %>
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
		<link rel="stylesheet" href="../css/uniform.css" />
		<link rel="stylesheet" href="../css/select2.css" />
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
				<h1>密码修改</h1>
			</div>
			<div id="breadcrumb">
				<a href="adminAction_home" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
				<a href="#" class="current">修改密码</a>
			</div>
			<div class="container-fluid">
					<div class="row-fluid">
						<div class="span12">
							<div class="widget-box">
								<div class="widget-title">
									<span class="icon">
										<i class="icon-align-justify"></i>									
									</span>
									<h5>密码修改</h5>
								</div>
								<div class="widget-content nopadding">
									<form class="form-horizontal" method="post" action="userAction_update" name="password_validate" id="password_validate" novalidate="novalidate" />
										<div class="control-group">
											<label class="control-label">旧密码</label>
											<div class="controls">
												<input type="password" name="password" id="password" />
											</div>
										</div>
										<div class="control-group">
											<label class="control-label">新密码</label>
											<div class="controls">
												<input type="password" name="pwd" id="pwd" maxlength="30"/>
											</div>
										</div>
										<div class="control-group">
											<label class="control-label">密码确认</label>
											<div class="controls">
												<input type="password" name="pwd2" id="pwd2" maxlength="30"/>
											</div>
										</div>
									    <div class="control-group">
											<div class="controls">${passError}</div>
										</div>
										<div class="form-actions">
											<input type="submit" value="修改" class="btn btn-primary" maxlength="30"/>
										</div>
									</form>
								</div>
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
		
		
            
            <script src="../js/jquery.min.js"></script>
            <script src="../js/jquery.ui.custom.js"></script>
            <script src="../js/bootstrap.min.js"></script>
            <script src="../js/jquery.uniform.js"></script>
            <script src="../js/select2.min.js"></script>
            <script src="../js/jquery.validate.js"></script>
            <script src="../js/unicorn.js"></script>
            <script src="../js/unicorn.form_validation.js"></script>
	</body>
</html>
