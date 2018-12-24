<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.io.IOException,java.util.*,java.sql.*"%>
<%!
    String url = "login.jsp";   //设置跳转的地址
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta http-equiv=refresh content=5;url=<%=url %>> 
 <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
<title>注册成功</title>
<style>
	#d1{
		margin-top:200px;
	}
	#p1{
		font-size:36px;
		margin-top:100px;
	}
	#p2{
		font_size:16px;
		color:red;
	}
	#h1{
		color: #1E90FF; 
	}
	#h2{
		color: #1E90FF;
	}
	#jump{
		color:red;
	}
</style>
<body style="background-color: #B8E5F8">
	<div align="center" id="d1" style="background: url(./image/regist_bk.png) no-repeat center 0; height: 900px">
		<h1 id="p1">注册成功</h1>
		<h4 id="p2">温馨提示：请牢记您的账号和密码，避免丢失造成不必要的麻烦！</h4>
		<h3 id="h1">请使用您的账号登陆系统</h2>
		<h3 id="h2"><span id=jump>5</span> 秒钟后页面将自动返回登录页面...</h2>
		<h3><a href="javascript:void(0);" onclick="jumpToIndex()">点击此处立即跳转至首页</a></h2>
	</div>
	<script>
           function countDown(secs){
                       jump.innerText=secs;
                       if(--secs>0)
                                setTimeout("countDown("+secs+" )",1000);
             } 
           countDown(5); 
			function jumpToIndex(){
				window.location.href='<%=url %>';
			} 
      </script>
</body>
</html> 