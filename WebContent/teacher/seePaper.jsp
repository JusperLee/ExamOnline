<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="renderer" content="webkit">
		<meta charset="utf-8" />
		<link rel="stylesheet" href="../css/font-awesome.min.css">
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link href="../image/考试.png" rel="shortcut icon" type="image/vnd.microsoft.icon">
	    <link href="../css/style.css" rel="stylesheet" type="text/css">
	    <link href="https://fonts.googleapis.com/css?family=Anton" rel="stylesheet">
		<title>查看试卷</title>
		<style type="text/css">
		          .function{
		          margin-right: 30px;
		          width:120px; 
		          height: 40px; 
		          border: none; 
		          background-color: #36AAFD; 
		          color: white;
		          margin-top: 10px;
		          }
		          .function:hover{
		          margin-right: 30px;
		          width:120px; 
		          height: 40px; 
		          border: none; 
		          background-color: #36aafd91; 
		          color: white;
		          margin-top: 10px;
		          }
		          #main{
	              height: 2000px;
	              width: 70%;
                  border: 1px solid cornflowerblue;
	              margin: 0 auto;
	              box-shadow: 0px 0px 8px cornflowerblue;
	              position: relative;
                  }
                  #footer{
	              width:100%;
	              height:50px;
	              background-image: url('images/logo.jpg');
                  }
                  .copyright{
	              line-height: 50px;
	              text-align: center;
	              font-size: 15px;
                  }
                  
        </style>
	</head>
	<body style="background-color: #B8E5F8;background-image: url(../image/regist_bk.png);text-align: center">
	<div  class="border" style="background-color: #FFFDFD;margin: 0 auto;margin-top: 30px;border-radius: 10px;height:1350px;width: 90%; ">
		<div style="height: 10vh;margin-bottom:10vh">
		<img src="../image/DIMTIM.png" height="300vh"/>
		</div>
		 <div style="align-self: center;width:60%;margin: 0 auto;margin-top:10vh">
		<font style="font-size: 24px; font-family: small arial,sans-serif">欢迎使用在线考试系统</font>&nbsp;&nbsp;&nbsp;&nbsp;
		<font style="font-size: 24px; font-family: small arial,sans-serif">教师：</font>
		<font style="font-size: 24px; font-family: small arial,sans-serif ;font-color: #36AAFD">${sessionScope.Teacher.name}</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button type="button" class="text-center" style="width:12%; height: 40px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 10px;" onclick="window.location.href='/web_big_homework/Logout'">登出</button>
		<button type="button" class="text-center" style="width:12%; height: 40px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 10px;margin-left:10px" onclick="window.location.href='/web_big_homework/teacher/index.jsp'">回到首页</button>
		
		
		<!-- 功能区 -->
		<div id="nave" style="margin-top: 10vh">
		<table class="pagination">
			<tr id="tr0" >
				<td class="td0" >
					<font style="font-size: 24px; font-family: small arial,sans-serif">请选择查看试题：</font>
				</td>
				<td class="td0">
			
					<a href="getCplus.jsp" target="if">
					<button  class="function" type="button" >C++</button></a>
					<!--获取学生成绩的集合(list) -->
				
				</td>
				<td class="td0">
				<a href="getJava.jsp" target="if">
					<button  class="function" type="button" style="">Java</button></a>
				</td>
				<td class="td0">
				<a href="getAllPaper.jsp" target="if">
					<button  class="function" type="button" style="" 
		 target="if">所有试卷</button></a>
				</td>
			</tr>
		</table>
	</div>
	</div>
		<div style="width: 100%;height: 2px;margin-top: 5vh;background-color: #eaeaea;">
		</div>
		<div id="right">
	 		<iframe src="getCplus.jsp" width="100%" height="720px"  frameborder="0" scrolling="yes" name="if"></iframe>
	 	</div>
	 <div class="footer">
	 Copyright © 2017-2018. All Rights Reserved.  版权所有李凯    豫ICP备18020526号-2
	 </div>
	</div>
	<script language="javascript" src="../js/bootstrap.min.js">
	</script>
	</body>
</html>
