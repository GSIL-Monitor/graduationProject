<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=utf-8" %>
<html lang="en">
    <head>
        <title>毕业论文管理系统</title>
		<meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
        <link rel="stylesheet" href="css/unicorn.login.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
    <body>
        <div id="logo">
            <img src="img/logo.png" alt="" />
        </div>
        <div id="loginbox">            
            <form id="loginform" class="form-vertical" action="userAction_login"  method="post" onsubmit = "return checkUser();" />
				<p>欢迎登录毕业论文管理系统</p>
                <div class="control-group">
                    <div class="controls">
                        <div class="input-prepend">
                            <span class="add-on"><i class="icon-user"></i></span><input type="text" placeholder="Username" name="username" id="username"/>
                        </div>
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <div class="input-prepend">
                            <span class="add-on"><i class="icon-lock"></i></span><input type="password" placeholder="Password" name="password" id="password"/>
                        </div>
                    </div>
                </div>
                <label><font color="red">${loginError}</font></label>
                <div class="form-actions">
                    <span class="pull-left"><a href="#" class="flip-link" id="to-recover">密码丢失？</a></span>
                    <span class="pull-right"><input type="submit" class="btn btn-inverse" value="登录" /></span>
                </div>
            </form>
            <form id="recoverform" action="userAction_recover" class="form-vertical" method="post" onsubmit="return recoverUser();"/>
            <p>请输入您的用户名和邮箱</p>
                <div class="control-group">
                    <div class="controls">
                        <div class="input-prepend">
                            <span class="add-on"><i class="icon-user"></i></span><input type="text" placeholder="Username" name="username" id="recoverUser"/>
                        </div>
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <div class="input-prepend">
                            <span class="add-on"><i class="icon-envelope"></i></span><input type="text" placeholder="E-mail address" name="email" id="email"/>
                        </div>
                    </div>
                </div>
                <div class="form-actions">
                    <span class="pull-left"><a href="#" class="flip-link" id="to-login">&lt; 登录</a></span>
                    <span class="pull-right"><input type="submit" class="btn btn-inverse" value="找回" /></span>
                </div>
            </form>
        </div>
        <script>
            function recoverUser(){
                alert("密码已发送到您账号的邮箱中，请注意查收");
                return true;
            }
            function checkUser() {
                var username = document.getElementById("username").value;
                var password = document.getElementById("password").value;
                if(username == ""  ){
                    alert("用户名不能为空");
                    return false;
                }
                if(password == ""  ){
                    alert("密码不能为空");
                    return false;
                }else{
                    return true;
                }
            }
        </script>
        <script src="js/jquery.min.js"></script>  
        <script src="js/unicorn.login.js"></script> 
    </body>
</html>
