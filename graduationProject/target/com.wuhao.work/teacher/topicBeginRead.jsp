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
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script type="text/javascript" charset="utf-8" src="../ueditor.config.js"></script>
		<script type="text/javascript" charset="utf-8" src="../ueditor.all.min.js"> </script>
		<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
		<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
		<script type="text/javascript" charset="utf-8" src="../lang/zh-cn/zh-cn.js"></script>
	</head>
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
				<h1>查看开题计划</h1>
			</div>
			<div id="breadcrumb">
				<a href="studentAction_home" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
				<a href="#" class="tip-bottom">论文管理</a>
				<a href="#" class="current">查看开题计划</a>
			</div>
			<div class="container-fluid">
				<!-- 加载编辑器的容器 -->
				<script id="container" name="content" type="text/plain">
					${report.beginReport}
				</script>
				<div class="control-group">
					<label class="control-label">老师意见: ${topicThirdSug.begin_sug}</label>
				</div>
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
		editor.setDisabled();
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
