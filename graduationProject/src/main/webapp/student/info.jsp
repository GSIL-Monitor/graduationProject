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
				<h1>个人信息管理</h1>

			</div>
			<div id="breadcrumb">
				<a href="studentAction_home" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
				<a href="#" class="current">个人信息管理</a>
			</div>
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="span12">
						<div class="widget-box">
							<div class="widget-title">
								<span class="icon">
									<i class="icon-align-justify"></i>									
								</span>
							</div>
							<div class="widget-content nopadding">
								<form class="form-horizontal" method="post" action="studentAction_update" name="basic_validate" id="basic_validate" novalidate="novalidate" />
                                    <div class="control-group">
                                        <label class="control-label">学号</label>
                                        <div class="controls">
                                            <input type="text" name="student.stuNo" id="stuNo" readonly="readonly" value="${student.stuNo}"/>
                                        </div>
                                    </div>
									<div class="control-group">
										<label class="control-label">姓名</label>
										<div class="controls">
											<input type="text" name="student.name" id="name" readonly="readonly" value="${student.name}"/>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">学院</label>
										<div class="controls">
											<input type="text" name="student.collegeName" id="collegeName" readonly="readonly"value="${student.collegeName}"/>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">专业</label>
										<div class="controls">
											<input type="text" name="student.majorName" id="majorName" readonly="readonly"value="${student.majorName}"/>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">年级</label>
										<div class="controls">
											<input type="text" name="student.grade" id="grade" readonly="readonly" value="${student.grade}"/>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">班级</label>
										<div class="controls">
											<input type="text" name="student.className" id="className" readonly="readonly" value="${student.className}"/>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">联系电话</label>
										<div class="controls">
											<input type="text" name="student.telNo" id="telNo" value="${student.telNo}"/>
										</div>
									</div>
                                    <div class="control-group">
                                        <label class="control-label">Email</label>
                                        <div class="controls">
                                            <input type="text" name="student.email" id="email"  value="${student.email}"/>
                                        </div>
                                    </div>
									<div class="control-group">
										<label class="control-label">QQ号码</label>
										<div class="controls">
											<input type="text" name="student.qqNo" id="qqNo" value="${student.qqNo}"/>
										</div>
									</div>
                                    <div class="form-actions">
                                        <input type="submit" value="保存" class="btn btn-primary" />
                                    </div>
                                </form>
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
