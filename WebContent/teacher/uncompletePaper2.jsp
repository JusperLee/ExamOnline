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
                  border:1px solid;
                  border-color:#36AAFD;
                  font-size: 20px; 
                  font-family: small arial,sans-serif
                  }
                  td{
                  text-align:center;
                  border:1px solid;
                  border-color:#36AAFD;
                  font-size: 20px; 
                  font-family: small arial,sans-serif
                  }
                  input{
                  width:10%;
                  }
                  textarea{
                  width:50%;
                  height:18vh;
                  }
                  .btn1{
                  width:12%; 
                  height: 40px; 
		          border: none; 
		          background-color: #36AAFD; 
		          color: white;
		          margin-top: 10px;
                  }
                  p{
                  font-size: 18px; 
                  font-family: small arial,sans-serif
                  }
        </style>
	</head>
	<body style="background-color: #B8E5F8;background-image: url(../image/regist_bk.png);text-align: center">
	<div  class="border" style="background-color: #FFFDFD;margin: 0 auto;margin-top: 30px;border-radius: 10px;height:98vh;width: 90%; ">
		<div style="height: 10vh;margin-bottom:10vh">
		<img src="../image/DIMTIM.png" height="300px"/>
		</div>
		 <div style="align-self: center;width:100%;margin: 0 auto;margin-top:120px">
		<font style="font-size: 24px; font-family: small arial,sans-serif">欢迎使用在线考试系统</font>&nbsp;&nbsp;&nbsp;&nbsp;
		<font style="font-size: 24px; font-family: small arial,sans-serif">教师：</font>
		<font style="font-size: 24px; font-family: small arial,sans-serif ;font-color: #36AAFD">${sessionScope.Teacher.name}</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button type="button" class="text-center" style="width:12%; height: 40px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 10px;" onclick="window.location.href='/web_big_homework/Logout'">登出</button>
		<button type="button" class="text-center" style="width:12%; height: 40px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 10px;margin-left:10px" onclick="window.location.href='/web_big_homework/teacher/checkPaper.jsp'">回到批改</button>
		<!-- 功能区 -->
		<div style="width: 100%;height: 2px;margin-top: 5vh;background-color: #eaeaea;">
		</div>
		<div>
		        <!-- 学生信息 -->
		        <table style="width:100%;border:1px soild;">
		        <tr>
		        <th>学生学号</th>
		        <th>学生姓名</th>
		        <th>学生班级</th>
		        </tr>
		        <tr>
		        <td>${sessionScope.student.getId()}</td>
		        <td>${sessionScope.student.getName()}</td>
		        <td>${sessionScope.student.getStudentclass()}</td>
		        </tr>
		        </table>
		        
		        <div style="display:grid;margin-top:35px">
		        <form action="../Bct_jdt" method="post">
	 			<!-- 简答题 -->
	 			<c:set value="1" var="index"></c:set>
	 			<dd style="float: left;display: block; width: 100%;" index="${index}" id="${index}" name="${index}" >
				<div>
				<p>一、简答题（一共2道题）</p>
				<p>${index}、${sessionScope.stu_jdt_qu[0]}</p>
				<p class="aswer-p"><textarea class="aswer-textarea" name="${index}" value="${sessionScope.stu_jdt[0]}">${sessionScope.stu_jdt[0]}</textarea></p>
				<p>请输入分数：</p><input type="text" name="${index}"/>
				<c:set value="${index+1}" var="index"></c:set>
				</div>
				</dd>
				<dd style="float: left;display: none; width: 100%;" index="${index}" id="${index}" name="${index}">
				<div>
				<p>${index}、${sessionScope.stu_jdt_qu[1]}</p>
				<p class="aswer-p"><textarea class="aswer-textarea" name="${index}" value="${sessionScope.stu_jdt[1]}">${sessionScope.stu_jdt[1]}</textarea></p>
				<p>请输入分数：</p><input type="text"  name="${index}"/>
				<c:set value="${index+1}" var="index"></c:set>
				</div>
				</dd>
				
				
				<!-- 编程题 -->
				<dd style="float: left;display: none; width: 100%;" index="${index}" id="${index}" name="${index}">
				<div>
				<p>二、编程题（一共2道题）</p>
				<p>${index}、${sessionScope.stu_bct_qu[0]}</p>
				<p class="aswer-p"><textarea class="aswer-textarea" name="${index}" value="${sessionScope.stu_bct[0]}">${sessionScope.stu_bct[0]}</textarea></p>
				<p>请输入分数：</p><input type="text"  name="${index}"/>
				<c:set value="${index+1}" var="index"></c:set>
				</div>
				</dd>
				<dd style="float: left;display: none; width: 100%;" index="${index}" id="${index}" name="${index}">
				<div>
				<p>${index}、${sessionScope.stu_bct_qu[1]}</p>
				<p class="aswer-p"><textarea class="aswer-textarea" name="${index}" value="${sessionScope.stu_bct[1]}">${sessionScope.stu_bct[1]}</textarea></p>
				<p>请输入分数：</p><input type="text"  name="${index}"/>
				<c:set value="${index+1}" var="index"></c:set>
				</div>
				</dd>
				
				<div style="width:100%; height:20%; margin-top: 170px;">
				<button  class = "btn1" id="preSubject" type="button" >上一题</button>
				<button style="margin-left: 20px" class = "btn1" id="nextSubject" type="button">下一题</button>
			</div>
			<button  class = "btn1" type="submit" onclick="return confirm('确定提交吗?')">提交试卷</button>
			</form>
			</div>
				</div>
	 		</div>
	</div>
	<script src="js/jquery.js"></script>
	<script language="javascript" src="../js/bootstrap.min.js">
	</script>
	<script type="text/javascript">
    $(function(){
    	var cur=1;
    	function goo(cur,curg){
    		if(curg<1){
    			curg=1
    		}
    		if(curg>4){
    			curg=4
    		}
    		if(cur<1){
    			cur=1
    		}
    		if(cur>4){
    			cur=4
    		}
    		var curid=document.getElementById(cur.toString());
    		var curgid=document.getElementById(curg.toString());
    		 curid.style.display= "none";
    		 curgid.style.display = "block";
    		
    	}
    	$("#preSubject").click(
    			function (){
    				var curg=cur-1;
    				goo(cur,curg);
    				cur--;
    			}
    			);
    	$("#nextSubject").click(
    			function (){
    				var curg=cur+1;
    				goo(cur,curg);
    				cur++;
    			}
    			);
    });
    </script>
	</body>
</html>