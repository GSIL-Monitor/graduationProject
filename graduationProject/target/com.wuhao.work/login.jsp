<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0034)http://my.hlju.edu.cn/login.portal -->
<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<meta name="robots" content="all">
<meta name="description" content="">
<meta name="keywords" content="">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7">
    <link href="./css/validation.css" rel="stylesheet" type="text/css">
    <link href="./css/style.css" rel="stylesheet" type="text/css">
<title>毕业论文管理系统登陆</title>
</head>
<body>
<div class="wallpaper">
  <div class="login-main">
  	<div class="header"><i class="tc-img"><img src="./css/tc.png" width="73" height="93"></i><i class="logo"><img src="./css/logo1.png" width="441" height="74"></i></div>
    <div class="login-area">
    	<div class="login-left"><img src="./css/login-img.jpg" width="694" height="392"></div>
        <div class="login-right">


        	<div class="form-area fw">
            	<h1>用户登录</h1>
                <div class="form">
                    <form id="loginForm" name="loginForm" method="post" action="userAction_login">
                    <p id="loginMsg" class="err-msg ipt2"></p>

                	<p><span>用户名：</span>
                	  <input type="text" name="user.username" id="username" class="ipt required min-length-1 validation-failed" title=""></p>

                    <p><span>密&nbsp; 码：</span>
                      <input type="password" name="user.password" id="password" class="ipt required min-length-1"></p>
                        
                    <p class="mt10"><span></span>&nbsp;&nbsp;
                        <input type="submit" name="btn" value="登录" tabindex="4" style="border-width:0;width:80px;height:29px;
			                   cursor:pointer;margin-left:-20px;">

                        <input tabindex="5" type="reset" value="重置" style="border-width:0;width:80px;height:29px;
                               cursor:pointer; margin-left:4px;">
                    </p>
                    </form>
                </div>

                <div class="form-content">
                	<p>说明：  <a href="http://my.hlju.edu.cn/getBackPassword.portal" target="_blank"><font class="f-blue">【密码找回】</font></a></p>
                    <p>1、教师用户名为WebOffice账号或职工号，如职工号有问题请咨询人事处;</p>
                    <p>2、学生用户名为学生学号;</p>
                    <p>3、用户初始密码为：<span class="f-red">本人身份证号后六位(字母大写)</span>，如"20054X";</p>
                </div>
            </div>

        </div>
    </div>
  </div>
</div>
</form>


<script type="text/javascript">
    var Login = {
        forwardUrl:'',
        loginURL:'userPasswordValidate.portal',
        nameField:'Login.Token1',
        pwdField:'Login.Token2',
        gotoUrl:'http://my.hlju.edu.cn/loginSuccess.portal',
        gotoFailUrl:'http://my.hlju.edu.cn/loginFailure.portal',
        hideCaptcha:true
    };
</script>
<script type="text/javascript" src="./css/portal-login.js"></script>
</body></html>