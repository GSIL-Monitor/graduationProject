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
        <link rel="stylesheet" href="../css/colorpicker.css" />
        <link rel="stylesheet" href="../css/datepicker.css" />
		<link rel="stylesheet" href="../css/uniform.css" />
		<link rel="stylesheet" href="../css/select2.css" />
		<link rel="stylesheet" href="../css/unicorn.main.css" />
		<link rel="stylesheet" href="../css/unicorn.grey.css" class="skin-color" />
		<script type="text/javascript" charset="utf-8" src="../ueditor.config.js"></script>
		<script type="text/javascript" charset="utf-8" src="../ueditor.all.min.js"> </script>
		<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
		<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
		<script type="text/javascript" charset="utf-8" src="../lang/zh-cn/zh-cn.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	</head>
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
				<h1>创建系统消息</h1>
			</div>
			<div id="breadcrumb">
				<a href="adminAction_home" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
				<a href="#" class="tip-bottom">消息管理</a>
				<a href="#" class="current">创建系统消息</a>
			</div>
			<div class="container-fluid">
				<form action="adminAction_msgCreate" method="post" class="form-horizontal" name="basic_validate" id="basic_validate" novalidate="novalidate" enctype="multipart/form-data">
					<!-- 加载编辑器的容器 -->
					<div class="control-group">
						<label class="control-label">标题</label>
						<div class="controls">
							<input type="text" name="message.title" id="title"/>
						</div>
					</div>
					<script id="container" name="message.content" type="text/plain">
					这里写你的初始化内容
					</script>
					<div class="control-group">
						<label class="control-label">类目</label>
						<div class="controls">
							<select name="message.type">
								<option value="通知与公告">通知与公告</option>
								<option value="其他">其他</option>
							</select>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">附件</label>
						<div class="controls">
							<input type="file" name="upload" id="upload"/>
						</div>
					</div>
					<div class="form-actions">
						<input type="submit" value="提交" class="btn btn-primary" />
					</div>

				</form>

				<div class="row-fluid">
					<div id="footer" class="span12">
						2016 &copy; Graduation Thesis Management System. Brought to you by Wuhao
					</div>
				</div>
			</div>
		</div>
	<!-- 配置文件 -->
	<script type="text/javascript" src="../ueditor.config.js"></script>
	<!-- 编辑器源码文件 -->
	<script type="text/javascript" src="../ueditor.all.js"></script>
	<!-- 实例化编辑器 -->
	<script type="text/javascript">
		var editor = UE.getEditor('container');
	</script>
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
