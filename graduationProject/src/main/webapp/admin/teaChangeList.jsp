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
				<h1>教师管理</h1>
			</div>
			<div id="breadcrumb">
				<a href="teacherAction_home" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
				<a href="#" class="current">教师管理</a>
			</div>
			<div class="container-fluid">
				<div class="row-fluid">
						<div class="widget-box">
							<div class="widget-title">

							</div>
							<div class="widget-content nopadding">
								<table class="table table-bordered data-table">
									<thead>
									<tr>
										<th>工号</th>
										<th>姓名</th>
										<th></th>
										<th></th>
									</tr>
									</thead>
									<tbody>
									<c:forEach var="teacher" items="${teachertList}">
										<tr class="gradeX">
											<td>${teacher.teacher_no}</td>
											<td>${teacher.name}</td>
											<td><a href=" adminAction_teaDelete?teacher_id=${teacher.teacher_id}">［注销］</a></td>
											<td><a href=" adminAction_teaModify?teacher_id=${teacher.teacher_id}">［修改］</a></td>
										</tr>
									</c:forEach>
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
		
		
            
            <script src="../js/jquery.min.js"></script>
            <script src="../js/jquery.ui.custom.js"></script>
            <script src="../js/bootstrap.min.js"></script>
            <script src="../js/jquery.uniform.js"></script>
            <script src="../js/select2.min.js"></script>
            <script src="../js/jquery.dataTables.min.js"></script>
            <script src="../js/unicorn.js"></script>
            <script src="../js/unicorn.tables.js"></script>
	</body>
</html>
