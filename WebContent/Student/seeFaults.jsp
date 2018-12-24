<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<title>查看错题</title>
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
	              height: 46vh;
	              width: 100%;
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
	              margin-top: 0px;
                  }
        </style>
	</head>
	<body style="background-color: #B8E5F8;background-image: url(../image/regist_bk.png);text-align: center">
	<div  class="border" style="background-color: #FFFDFD;margin: 0 auto;margin-top: 30px;border-radius: 10px;height: 95vh;width: 90%; ">
		<div style="height: 10vh;margin-bottom:10vh">
		<img src="../image/DIMTIM.png" height="300vh"/>
		</div>
		 <div style="align-self: center;margin: 0 auto;margin-top:15vh">
		<font style="font-size: 24px; font-family: small arial,sans-serif">欢迎使用在线考试系统</font>&nbsp;&nbsp;&nbsp;&nbsp;
		<font style="font-size: 24px; font-family: small arial,sans-serif">学生：</font>
		<font style="font-size: 24px; font-family: small arial,sans-serif ;font-color: #36AAFD">${sessionScope.Student.name}</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button type="button" class="text-center" style="width:12%; height: 40px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 10px;" onclick="window.location.href='/web_big_homework/Logout'">登出</button>
		<button type="button" class="text-center" style="width:12%; height: 40px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 10px;margin-left:10px" onclick="window.location.href='/web_big_homework/Student/index.jsp'">回到首页</button>
		
			<!--nave开始-->
	<div id="nave">
		<table class="pagination">
			<tr id="tr0" >
				<td class="td0" >
					<font style="font-size: 24px; font-family: small arial,sans-serif">请选择查看题型：</font>
				</td>
				<td class="td0">
			
					<a href="seeFaultsXz.jsp?xztlist" target="if">
					<button  class="function" type="button" >选择题</button></a>
					<!--获取学生成绩的集合(list) -->
				
				</td>
				<td class="td0">
				<a href="seeFaultsTk.jsp?tktlist" target="if">
					<button  class="function" type="button" style="">填空题</button></a>
				</td>
				<td class="td0">
				<a href="seeFaultsPd.jsp?pdtlist" target="if">
					<button  class="function" type="button" style="" 
		 target="if">判断题</button></a>
				</td>
				<td class="td0">
				<a href="seeFaultsJd.jsp?jdtlist" target="if">
					<button  class="function" type="button" style="" 
		 target="if">简答题</button></a>
				</td>
				<td class="td0">
				<a href="seeFaultsBc.jsp?bctlist" target="if">
					<button  class="function" type="button" style="" 
		 target="if">编程题</button></a>
				</td>
			</tr>
		</table>
	</div>
	<!--nave结束-->
		<div style="width: 100%;height: 2px;background-color: #eaeaea;">
		</div>
		<div id="main">
		<iframe src="seeFaultsXz.jsp" width="100%" height="100%" frameborder="0" scrolling="yes" name="if"></iframe>
	</div>
	<div id="footer">
        <div class="copyright">Copyright © 2017-2018. All Rights Reserved. 版权所有李凯    豫ICP备18020526号-2</div>
    </div>
   </div>
	<script language="javascript" src="../js/bootstrap.min.js">
	</script>
	</body>
</html>
