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
		<title>学生成绩查询</title>
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
	              height: 95vh;
	              width: 100%;
                  border: 1px solid cornflowerblue;
	              margin: 0 auto;
	              box-shadow: 0px 0px 8px cornflowerblue;
	              position: relative;
	              margin-top:10px;
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
                  tr{
                  font-size: 18px; 
                  font-family: small arial,sans-serif ;
                  
                  }
                  th{
                  text-align:center
                  }
                  td{
                  text-align:center
                  }
                  #b1{
                  width:100%; 
                  height: 40px; 
		          border: none; 
		          background-color: #36AAFD; 
		          color: white;
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
		
		<div style="width: 100%;height: 2px;background-color: #eaeaea;margin-top:10px">
		</div>
		<div id="main">
		<form>
			<table class="t1" border="1px solid " cellspacing="0"  style="width:100%">
				<!--<thead>考试成绩</thead>-->
				<tr>
					<th >学生班级</th>
					<th >学生名</th>
					<th >试卷名</th>
					<th >选择题成绩</th>
					<th >填空题成绩</th>
					<th >判断题成绩</th>
					<th >简答题成绩</th>
					<th >编程题成绩</th>
					<th >总成绩</th>
					<th>分析</th>
					<th>导出成绩</th>
					<th ></th>
					
					
				</tr>
				<!-- 获取学生成绩的集合(list) -->
				<c:forEach var="user" items="${sessionScope.mygradelist }">
				<tr>		
				<td><center>${sessionScope.Student.studentclass }</center></td>
				<td><center>${sessionScope.Student.name}</center></td>
				<td><center>${user.papername }</center></td>
				<td><center>${user.xztscore }</center></td>
				<td><center>${user.tktscore }</center></td>
				<td><center>${user.pdtscore }</center></td>
				<td><center>${user.jdtscore }</center></td>
				<td><center>${user.bctscore }</center></td>
				<td><center>${user.score}</center></td>
				<td><center><button id="b1">成绩分析</button></center></td>
				<td><center><button id="b1">导出成绩</button></center></td>
				</tr>
				</c:forEach>
			</table>
			</form>
			
	</div>
	<div id="footer">
        <div class="copyright">Copyright © 2017-2018. All Rights Reserved. 版权所有李凯    豫ICP备18020526号-2</div>
    </div>
   </div>
   <script language="JavaScript">
		</script>
	<script language="javascript" src="../js/bootstrap.min.js">
	</script>
	</body>
</html>
