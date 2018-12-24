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
	    <script src="../laydate/laydate.js"></script>
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
	    <script src="../laydate/laydate.js"></script>
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="css/bootstrap-select.css">
        <script src="js/bootstrap-select.js"></script>
		<title>出卷跳转页面</title>
		<% request.setCharacterEncoding("utf-8"); %>
		<script>
		laydate.render({
			  elem: '#startTime'
			  ,type: 'datetime'
			});
        </script>
        <script>
		laydate.render({
			  elem: '#endTime'
			  ,type: 'datetime'
			});
        </script>
        <script type="text/javascript">
        laydate.render({
        	  elem: '#time'
        	  ,type: 'time'
        	});
        </script>
		<style type="text/css">
		        .td2{
		        width:220px;
		        height: 30px;
		        }
		        .td1{
		        font-size: 20px; 
		        font-family: small arial,sans-serif ;
		        }
        </style>
	</head>
	<body style="background-color: #B8E5F8;background-image: url(../image/regist_bk.png);text-align: center">
	<div  class="border" style="background-color: #FFFDFD;margin: 0 auto;margin-top: 30px;border-radius: 10px;height: 90vh;width: 90%; ">
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
		</div>
		<div style="width: 100%;height: 2px;margin-top: 10vh;background-color: #eaeaea;">
		</div>
		<!-- 功能区 -->
		<div>
		<form action="../Create" method="post">
		<table style="margin:0 auto;margin-top:80px;">
    			<tr>
    				<td class="td1">请输入试卷名称:</td>
    				<td >
    					<input type="text" id="paperName" class="td2"name="paperName"/>
    				</td>
    			</tr>
    			<tr>
    				<td class="td1">请输入试卷类型:</td>
    				<td >
    					<input type="text" id="paperName" class="td2"name="paperName"/>
    				</td>
    			</tr>
    			<tr>
    				<td class="td1">请输入考试时间:</td>
    				<td >
    					<input type="time" id="time" class="td2"name="paperName"/>
    				</td>
    			</tr>
    			<tr style="margin-top:10px">
    				<td class="td1">请选择试卷开始时间：</td>
    				<td >
    					<input type="datetime" id="startTime"class="td2" name="startTime"/>
    				</td>
    			</tr>
    			<tr style="margin-top:10px">
    				<td class="td1">请选择试卷结束时间：</td>
    				<td >
    					<input type="datetime" id="endTime"class="td2" name="endTime"/>
    				</td>
    			</tr>
    			<tr style="margin-top:10px">
    				<td class="td1">请选择考试班级：</td>
    				<td >
                                  <select class="selectpicker" data-live-search="true" name="class">
                                  <c:forEach items="${sessionScope.Student}" var="stu" >
                                          <option value="${stu.studentclass}">${stu.studentclass}</option>
                                  </c:forEach>
                                  </select>
    				</td>
    			</tr>
    			<tr>
    				<td colspan="2" style="text-align: center;">
    					<button type="submit" class="text-center" style="width:40%; height: 50px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 30px;" >进入出卷界面</button>
    				</td>
    			</tr>
    			</table>
    			</form>
    			</div>
	</div>
	<script language="javascript" src="../js/bootstrap.min.js">
	</script>
	</body>
</html>
