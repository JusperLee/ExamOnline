<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<title>教师批阅成绩</title>
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
                  .footer{
	              width:100%;
	              height:50px;
                  }
                  .copyright{
	              line-height: 50px;
	              text-align: center;
	              font-size: 15px;
                  }
                  th{
                  text-align: center;
                  }
                  td{
                  text-align:center;
                  }
        </style>
	</head>
	<body style="background-color: #B8E5F8;background-image: url(../image/regist_bk.png);text-align: center">
	<div  class="border" style="background-color: #FFFDFD;margin: 0 auto;margin-top: 30px;border-radius: 10px;height:95vh;width: 90%; ">
		<div style="height: 10vh;margin-bottom:10vh">
		<img src="../image/DIMTIM.png" height="300px"/>
		</div>
		 <div style="align-self: center;width:60%;margin: 0 auto;margin-top:120px">
		<font style="font-size: 24px; font-family: small arial,sans-serif">欢迎使用在线考试系统</font>&nbsp;&nbsp;&nbsp;&nbsp;
		<font style="font-size: 24px; font-family: small arial,sans-serif">教师：</font>
		<font style="font-size: 24px; font-family: small arial,sans-serif ;font-color: #36AAFD">${sessionScope.Teacher.name}</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button type="button" class="text-center" style="width:12%; height: 40px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 10px;" onclick="window.location.href='/web_big_homework/Logout'">登出</button>
		<button type="button" class="text-center" style="width:12%; height: 40px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 10px;margin-left:10px" onclick="window.location.href='/web_big_homework/teacher/index.jsp'">回到首页</button>
		
		
		
		<!-- 功能区 -->
		<div id="nave" style="margin-top: 15px">
		<table class="pagination">
			<tr id="tr0" >
				<td class="td0" >
					<font style="font-size: 24px; font-family: small arial,sans-serif">请选择试卷：</font>
				</td>
				<td class="td0">
			
					<a href="../cP" target="if">
					<button  class="function" type="button" >已批阅的试卷</button></a>
					<!--获取学生成绩的集合(list) -->
				
				</td>
				<td class="td0">
				<a href="../ucP" target="if">
					<button  class="function" type="button" style="">未批阅的试卷</button></a>
				</td>
			</tr>
		</table>
	</div>
	</div>
	<form name="form1" method="post" action="../ShowCorrectPaper" style="margin-top:15px">
    			<table  class="top" style="margin: 0 auto;width:50%">
    				<tr>
    			   	<td><font style="font-size: 24px; font-family: small arial,sans-serif">请选择班级</font></td>
    			   	<td>
                         	<select name="studentclass" id="cla"  style="width:100px; height: 40px">
    			   	   	<!--遍历session中所有班级-->
    			   	   	<c:forEach items="${sessionScope.student_class}" var="c1">
    				   <option value="${c1 }"  style="width:40px; height: 20px">${c1 }</option>
    		
    				   </c:forEach>
    			     </select>
    			   	</td>
    			   	<td>&nbsp;&nbsp;&nbsp;&nbsp;<font style="font-size: 24px; font-family: small arial,sans-serif">请选择试卷</font></td>
    			   	<td>
    			   		<!--遍历session中所有试卷-->
    			   		<select name="papername" id="paper"  style="width:100px; height: 40px">
    			   			<c:forEach items="${sessionScope.paper_name}" var="p">
    			   			<option value="${p}" >${p}</option>
    			   			</c:forEach>
    			   		</select>
    			   	</td>
    			   	<td>
    			   		<input type="submit" value="查询" id="sub" class="function" style="margin-left:20px;margin:0 auto"/> 
    			   		
    			   		
    			   	</td>
    			   </tr>
    			</table>
    			</form>
		<div style="width: 100%;height: 2px;margin-top: 5vh;background-color: #eaeaea;">
		</div>
		<div>
	 			<table class="tt" border="1px solid" style="width:95%;border-color: #36AAFD">
	 				<tr>
	 					<th><center><font style="font-size: 24px; font-family: small arial,sans-serif">学生名</font></center></th>
	 					<th><center><font style="font-size: 24px; font-family: small arial,sans-serif">学号</font></center></th>
	 					<th><font style="font-size: 24px; font-family: small arial,sans-serif">试卷名</font></th>
	 					<th><font style="font-size: 24px; font-family: small arial,sans-serif">试卷号</font></th>
	 					<th><font style="font-size: 24px; font-family: small arial,sans-serif">操作</font></th>
	 				</tr>
	 				<!--获取已批阅的集合 -->
	 				<c:forEach items="${sessionScope.listno }" var="ln">
	 				<tr>
	 				  <td><center><font style="font-size: 24px; font-family: small arial,sans-serif">${ln.name}</font></center></td>
	 				  <!--进入选中的已批阅试卷的页面，根据选中的试卷试卷名查询数据库
    					链接值为后台存储学生上传的答案的文件-->
    					<td><center><font style="font-size: 24px; font-family: small arial,sans-serif">${ln.getUserId()}</font></center></td>
    					<td><center><font style="font-size: 24px; font-family: small arial,sans-serif">${ln.papername}</font></center></td>
    					<td><center><font style="font-size: 24px; font-family: small arial,sans-serif">${ln.getPaperId()}</font></center></td>
    					<td><button type="button" class="text-center" style="width:100%; height: 30px; 
		border: none; background-color: #36AAFD; color: white" onclick="window.location.href='../CorrectPaper?papername=${ln.getPaperId()}&username=${ln.getUserId()}'">进入</button></td>				  	
	 				</tr>
	 				<input type="hidden" value="1" />
	 				</c:forEach>
	 			</table>
	 		</div>
	 <div class="footer" style="margin-top:34vh">
	 Copyright © 2017-2018. All Rights Reserved.  版权所有李凯    豫ICP备18020526号-2
	 </div>
	</div>
	<script language="javascript" src="../js/bootstrap.min.js">
	</script>
	</body>
</html>