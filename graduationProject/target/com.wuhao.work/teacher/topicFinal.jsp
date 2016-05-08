<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=utf-8" %>
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
        <link rel="stylesheet" href="../css/colorpicker.css" />
        <link rel="stylesheet" href="../css/datepicker.css" />
		<link rel="stylesheet" href="../css/uniform.css" />
		<link rel="stylesheet" href="../css/select2.css" />
		<link rel="stylesheet" href="../css/unicorn.main.css" />
		<link rel="stylesheet" href="../css/unicorn.grey.css" class="skin-color" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
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
				<h1>论文终稿提交</h1>
			</div>
			<div id="breadcrumb">
				<a href="studentAction_home" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
				<a href="#" class="current">论文终稿提交</a>
			</div>
			<div class="row-fluid">
				<div class="span12">
					<div class="widget-box">
						<div class="widget-title">
							<span class="icon">
								<i class="icon-align-justify"></i>
							</span>
							<h5>论文终稿提交</h5>
						</div>
						<div class="widget-content nopadding">
							<form action="topicAction_finalSave" method="get" class="form-horizontal" >
								<input type="hidden" name="topic_id" value="${topicFinalInfo.topic_id}">
								<div class="control-group">
									<label class="control-label">word格式论文:</label>
									<div class="controls">
										<c:if test="${topicFinalInfo.isSaveWord==1}">
											<a href="messageAction_download?docName=${topicFinalInfo.wordName}"><label>下载word版论文</label></a>
										</c:if>
										<c:if test="${topicFinalInfo.isSaveWord==0}">
											<label>未提交</label>
										</c:if>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">pdf   格式论文:</label>
									<div class="controls">
										<c:if test="${topicFinalInfo.isSavePdf==1}">
											<a href="messageAction_download?docName=${topicFinalInfo.pdfName}"><label>下载pdf版论文</label></a>
										</c:if>
										<c:if test="${topicFinalInfo.isSavePdf==0}">
											<label>未提交</label>
										</c:if>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">老师意见:</label>
									<div class="controls">
										<textarea name="teacher_info" cols="40" rows="5"></textarea>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">分数(百分制):</label>
									<div class="controls">
										<input type="number" name="sorce" />
									</div>
								</div>

								<div class="control-group">
									<label class="control-label">是否通过:</label>
									<div class="controls">
										<label><input type="radio" name="is_pass" value="0" checked="checked"/> 否</label>
										<label><input type="radio" name="is_pass" value="1"/> 是</label>
									</div>
								</div>
								<div class="form-actions">
									<input type="submit" value="提交" class="btn btn-primary" maxlength="30"/>
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
            <script src="../js/bootstrap-colorpicker.js"></script>
            <script src="../js/bootstrap-datepicker.js"></script>
            <script src="../js/jquery.uniform.js"></script>
            <script src="../js/select2.min.js"></script>
            <script src="../js/unicorn.js"></script>
            <script src="../js/unicorn.form_common.js"></script>
	</body>
</html>
