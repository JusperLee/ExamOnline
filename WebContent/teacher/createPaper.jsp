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
		<title>教师出卷</title>
		<style type="text/css">
		          #main{
	height: 800px;
	width: 100%;
	border: 1px solid cornflowerblue;
	margin: 0 auto;
	box-shadow: 0px 0px 8px cornflowerblue;
	
}
#footer{
	width:100%;
	height:50px;
	background-image: url('../image/top.jpg');
	position:relative;
	
}
        </style>
	</head>
	<body style="background-color: #B8E5F8;background-image: url(../image/regist_bk.png);text-align: center">
	<div  class="border" style="background-color: #FFFDFD;margin: 0 auto;margin-top: 30px;border-radius: 10px;height: 1300px;width: 90%; ">
		<div style="height: 10vh;margin-bottom:10vh">
		<img src="../image/DIMTIM.png" height="300vh"/>
		</div>
		 <div style="align-self: center;width:60%;margin: 0 auto;margin-top:15vh">
		<font style="font-size: 24px; font-family: small arial,sans-serif">欢迎使用在线考试系统</font>&nbsp;&nbsp;&nbsp;&nbsp;
		<font style="font-size: 24px; font-family: small arial,sans-serif">教师：</font>
		<font style="font-size: 24px; font-family: small arial,sans-serif ;font-color: #36AAFD">${sessionScope.Teacher.name}</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button type="button" class="text-center" style="width:12%; height: 40px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 10px;" onclick="window.location.href='/web_big_homework/Logout'">登出</button>
		<button type="button" class="text-center" style="width:12%; height: 40px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 10px;margin-left:10px" onclick="window.location.href='/web_big_homework/teacher/index.jsp'">回到首页</button>
		<div id="nave">
		<table style="margin:0 auto;width:70%;margin-top:40px">
			<tr id="tr1">
				<!--这里需要添加js事件-->
				<td class="td1">
					<a href="createPaperXz.jsp" target="if"><button type="button" class="text-center" style="width:100px; height: 40px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 10px;">选择题</button></a>
				</td>
				<td class="td1">
					<a href="createPaperTk.jsp" target="if"><button type="button" class="text-center" style="width:100px; height: 40px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 10px;">填空题</button></a>
				</td>
				<td class="td1">
					<a href="createPaperBc.jsp" target="if"><button type="button" class="text-center" style="width:100px; height: 40px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 10px;">编程题</button></a>
				</td>
				<td class="td1">
					<a href="createPaperPd.jsp" target="if"><button type="button" class="text-center" style="width:100px; height: 40px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 10px;">判断题</button></a>
				</td>
				<td class="td1">
					<a href="createPaperJd.jsp" target="if"><button type="button" class="text-center" style="width:100px; height: 40px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 10px;">简答题</button></a>
				</td>
			</tr>
		</table>
	</div>
		</div>
		<div style="width: 100%;height: 2px;margin-top: 5vh;background-color: #eaeaea;">
		</div>
		<!-- 功能区 -->
		<div id="main">
		<form action="../Designtest" method="post" style="height:790px">
		<iframe src="createPaperXz.jsp" width="800px" height="100%"
			frameborder="0" scrolling="yes" name="if"></iframe>
		<!--确认出卷-->
		<table id="tab4">
			<tr>
				<td style="width: 770px; text-align: center;"></td>
				<td style="width: 100px; text-align: center;">
					<button type="submit" class="text-center" style="width:100px; height: 40px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 10px;">确认出卷</button>
				</td>
			</tr>
		</table>
		</form>
	</div>
	<div id="footer">
        <div class="copyright">Copyright © 2017-2018. All Rights Reserved.  版权所有李凯    豫ICP备18020526号-2</div>
    </div>
	</div>
	<script language="javascript" src="../js/bootstrap.min.js">
	</script>
	</body>
</html>
