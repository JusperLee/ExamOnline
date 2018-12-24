<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>    
<!DOCTYPE html>
<html>
<%  request.setCharacterEncoding("utf-8"); %>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="renderer" content="webkit">
    <link rel="stylesheet" href="./css/font-awesome.min.css">
    <link rel="stylesheet" href="./css/bootstrap.min.css">
	<title>找回密码 - 更智能的在线考试系统</title>
	<link href="./image/考试.png" rel="shortcut icon" type="image/vnd.microsoft.icon">
	<link href="./css/style.css" rel="stylesheet" type="text/css">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
</head>
<body class="site" style="background-color: #B8E5F8">
<%
     Cookie[] cs = request.getCookies();
     String UserId = "";
     String password = "";
     if (cs.length!=0){
    	 for(int i =0 ;i<cs.length;i++){
    		 Cookie c =cs[i];
    		 if("UserId".equals(c.getName())){
    			 UserId = c.getValue();
    		 }
    		 if("password".equals(c.getName())){
    			 password = c.getValue();
    		 }
    	 }
     }
     
%>
<div class="main-container" style="background: url(./image/regist_bk.png) no-repeat center 0">
    <div class="container" style="width: fit-content;">
        <div class="row">
            <div class="col-xs-12 rm-pd-lr con-box">
                <div id="system-message-container">
	</div>

            </div>
        </div>
<div class="row">
<div class="col-xs-12">
    <div class="row">
        <div class="col-xs-12 text-center" style="margin: 30px 0;">
            
        </div>
    </div>

    <div class="row">
        <div class="col-xs-12">
            <div class="form-warpper" style="width:580px">
                <div id="form-box" class="border" style="height: 790px">
                    <div class="col-xs-offset-1 title-align" style="
    margin-left: 0px;" align="center">
                        <h3><img src="./image/name.png"></img></h3>
                    </div>
                    <hr>
                    <form id="signup-form" class="row col-xs-11 col-xs-pull-1 col-xs-push-1" action="/web_big_homework/Find" method="post">
                        <fieldset>
                            <div class="form-group">
                                <span id="find_tishi">${message1}</span><br>
                                <label>学号/工号</label>
                                <div style="position: relative">
                                    <i class="fas fa-envelope icon fa-lg" style="line-height: 100%;"></i>
                                    <input id="id" name="id" type="text" class="form-control border" placeholder="请输入您的学号/工号" autocomplete="off" required="" aria-required="true" autofocus="" value="">
                                </div>
                            </div>
						
							<div class="form-group">
                                <label>手机号</label>
                                <div style="position: relative">
                                    <i class="fas fa-mobile icon fa-lg" style="line-height: 100%;"></i>
                                    <input id="tel_num2" name="tel_num2" type="text" class="form-control border" placeholder="请输入正确手机号" maxlength="99" autocomplete="off" required="" aria-required="true" onkeyup="check_tel()">
									<span id="tel_tishi"></span>
                                </div>
                            </div>
							<div class="form-group">
                                <label>验证码</label>
                                <div style="position: relative;display: inline-flex;width: 100%;">
                                    <i class="fas fa-thumbs-up icon fa-lg" style="line-height: 100%;"></i>
                                    <input id="yan" name="yan" type="text" class="form-control border" placeholder="请输入收到的验证码" maxlength="99" autocomplete="off" required="" aria-required="true" style="width:60%">
									<input type="button" class="text-center" style="width:40%; height: 45px; border: none; background-color: #36AAFD; color: white;" id="getid" onclick="settime(this)" value="获取验证码">
                                </div>
                            <div class="form-group">
                                <label>密码</label>
                                <div style="position: relative">
                                    <i class="fas fa-unlock icon fa-lg" style="line-height: 100%;"></i>
                                    <input id="password1" name="password1" type="password" class="form-control border" placeholder="请输入密码" maxlength="99" autocomplete="off" required="" aria-required="true" aria-autocomplete="list"  >
                                </div>
                            </div>
                              <div class="form-group">
                                <label>确认密码</label>
                                <div style="position: relative">
                                    <i class="fas fa-unlock icon fa-lg" style="line-height: 100%;"></i>
                                    <input id="password2" name="password2" type="password" class="form-control border" placeholder="请输入密码" maxlength="99" autocomplete="off" required="" aria-required="true" aria-autocomplete="list"  onkeyup="validate()">
                                   <span id="tishi"></span>
                                </div>
                            </div>
                            <button id="submit" type="submit" class="text-center" style="width:100%; height: 40px; border: none; background-color: #36AAFD; color: white;margin-top: 20px;">
                                修改密码                            </button>
							&nbsp;&nbsp;&nbsp;&nbsp;
                            <p class="text-center" style="color: #8C8C8C; margin-top: 20px">没有帐户？ <a href="/web_big_homework/register_teacher.jsp">老师注册</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="/web_big_homework/regist_student.jsp">学生注册</a>
                            </p>

                            <input type="hidden" name="plan" value="free">

                            <input type="hidden" name="8524d5f1cef31448fe08562098186f13" value="1"></fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <p class="col-xs-12 col-sm-12 text-center copyright" style="font-color: black">版权所有 ©2018 李凯 保留所有权利 豫ICP备18020526号-2</p>
    </div>
</div>
        </div>
    </div>
</div>
<script language="javascript" src="./js/bootstrap.min.js"></script>
<script language="javascript" src="./js/check.js"></script>
<script language="javascript" src="./js/yan.js"></script>
<script language="javascript">
function validate() {
	              var pwd1 = document.getElementById("password1").value;
	              var pwd2 = document.getElementById("password2").value;
			<!-- 对比两次输入的密码 -->
	              if(pwd1 == pwd2) {
	                  document.getElementById("tishi").innerHTML="<font color='green'>两次密码相同</font>";
	                  document.getElementById("submit").disabled = false;
	              }
	              else {
	                  document.getElementById("tishi").innerHTML="<font color='red'>两次密码不相同</font>";
	                document.getElementById("submit").disabled = true;
	              }
	          }
</script>
</body>
</html>