<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>题目管理</title>
 	<link href="css/bootstrap.min.css" rel="stylesheet" />
 	<style type="text/css">
                 th{
                     text-align:center;
                 }
                 .function{
		          margin-right: 30px;
		          width:150px; 
		          height: 50px; 
		          border: none; 
		          background-color: #36AAFD; 
		          color: white;
		          margin-top: 10px;
		          margin-top:0 auto;
		          }
		          .function:hover{
		          margin-right: 30px;
		          width:150px; 
		          height: 50px; 
		          border: none; 
		          background-color: #36aafd91; 
		          color: white;
		          margin-top: 10px;
		          margin-top:0 auto;
		          }
 	</style>
</head>
<body style="background-color: #B8E5F8;background-image: url(../image/regist_bk.png);text-align: center">
	<div  class="border" style="background-color: #FFFDFD;margin: 0 auto;margin-top: 30px;border-radius: 10px;height: 95vh;width: 90%; ">
		<div style="height: 10vh;margin-bottom:10vh">
		<img src="../image/DIMTIM.png" height="300vh"/>
		</div>
		 <div style="align-self: center;width:60%;margin: 0 auto;margin-top:15vh">
		<font style="font-size: 24px; font-family: small arial,sans-serif">欢迎使用在线考试系统</font>&nbsp;&nbsp;&nbsp;&nbsp;
		<font style="font-size: 24px; font-family: small arial,sans-serif">管理员：</font>
		<font style="font-size: 24px; font-family: small arial,sans-serif ;font-color: #36AAFD">${sessionScope.Manager.name}</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button type="button" class="text-center" style="width:12%; height: 40px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 10px;" onclick="window.location.href='/web_big_homework/Logout'">登出</button>
		<button type="button" class="text-center" style="width:12%; height: 40px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 10px;margin-left:10px" onclick="window.location.href='/web_big_homework/Manager/index.jsp'">回到首页</button>
		</div>
		<div style="margin-top:30px">
		<a href="../manage_xzt"target="if"><button  class="function" type="button" style="">
		<font style="font-size: 20px; font-family: small arial,sans-serif">管理选择题</font></button></a>
		<a href="../manage_tkt"target="if"><button  class="function" type="button" style="">
		<font style="font-size: 20px; font-family: small arial,sans-serif">管理填空题</font></button></a>
		<a href="../manage_pdt"target="if"><button  class="function" type="button" style="">
		<font style="font-size: 20px; font-family: small arial,sans-serif">管理判断题</font></button></a>
		<a href="../manage_jdt"target="if"><button  class="function" type="button" style="">
		<font style="font-size: 20px; font-family: small arial,sans-serif">管理简答题</font></button></a>
		<a href="../manage_bct"target="if"><button  class="function" type="button" style="">
		<font style="font-size: 20px; font-family: small arial,sans-serif">管理编程题</font></button></a>
		</div>
		<div style="width: 100%;height: 2px;margin-top: 5vh;background-color: #eaeaea;">
		</div>
	    <div style="margin-top:15px">
	    <iframe src="../manage_xzt" width="99%" height="400vh"  frameborder="0" scrolling="yes" name="if"></iframe>
       </div>
</div>

	<!-- js引入 -->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="../js/layer.js"></script>
</body>
</html>