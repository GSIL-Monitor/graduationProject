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

	<div id="style-switcher">
		<i class="icon-arrow-left icon-white"></i>
		<span>Style:</span>
		<a href="#grey" style="background-color: #555555;border-color: #aaaaaa;"></a>
		<a href="#blue" style="background-color: #2D2F57;"></a>
		<a href="#red" style="background-color: #673232;"></a>
	</div>

		<div id="content">
			<div id="content-header">
				<h1>论文详情</h1>
			</div>
			<div id="breadcrumb">
				<a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
				<a href="#" class="current">论文详情</a>
			</div>
			<div class="container-fluid">
				<div class="row-fluid">
						<div class="widget-box">
							<div class="widget-title">

							</div>
							<div class="widget-content nopadding">
								<table class="table table-bordered data-table">
									<tbody>
									<tr class="gradeX">
										<td>论文题目:</td>
										<td colspan="3">Internet Explorer 4.0</td>
									</tr>
									<tr class="gradeC">
										<td>指导教师姓名:</td>
										<td>郭龙江</td>
										<td>添加人:</td>
										<td>郭龙江</td>
									</tr>
									<tr class="gradeA">
										<td>题目对应专业:</td>
										<td>计算机科学与技术(计算机应用)</td>
										<td>添加时间:</td>
										<td>2015年11月20日</td>
									</tr>
									<tr class="gradeA">
										<td>题目类别:</td>
										<td>论文</td>
									 	<td>修改人:</td>
									 	<td>B:科学研究类</td>
									</tr>
									<tr class="gradeX">
										<td>题目性质:</td>
										<td>B:科学研究类</td>
										<td>修改时间:</td>
										<td>2015年11月20日</td>
									</tr>
									<tr class="gradeX">
										<td>是否实验类:</td>
										<td>否</td>
										<td>是否导师在研项目:</td>
										<td>否</td>
									</tr>
									<tr class="gradeX">
										<td>是否应用类:</td>
										<td>否</td>
										<td>题目申报状态:</td>
										<td>题目通过审核，已可选</td>
									</tr>
									<tr class="gradeX">
										<td>题目说明:</td>
										<td colspan="3">没有说明</td>
									</tr>
									<tr class="gradeX">
										<td>备注:</td>
										<td colspan="3">没有说明</td>
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
