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
		        .btn1{
		        width:15%; 
		        height: 40px; 
		        border: none; 
		        background-color: #36AAFD; 
		        color: white;
		        margin-left:10px
		        }
		        td{
		        font-size: 20px; 
		        font-family: small arial,sans-serif ;
		        }
		        th{
		        font-size: 20px; 
		        font-family: small arial,sans-serif ;
		        }
        </style>
	</head>
	<body style="background-color: #B8E5F8;background-image: url(../image/regist_bk.png);text-align: center">
	<div  class="border" style="background-color: #FFFDFD;margin: 0 auto;margin-top: 30px;border-radius: 10px;height: 96vh;width: 90%; ">
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
		<div class="m1" style="margin-top:30px">
    		<form name="form1dsccb" action="../" method="post" style="display:grid">
    			<table class="xz" cellspacing="30px">
    			   <tr>
    			   	<td><p>请选择班级</p></td>
    			   	<td style="display:flex">
    			   	  
                         	<select id="class" name="class"  class="selectpicker" data-live-search="true" style="height: 50px;">
    			   	   	<!--遍历session中所有班级-->
    			   	     	<c:forEach items="${sessionScope.studentclass }" var="c">
    				   <option value="${c}">${c}</option>
    				   </c:forEach>
                          </select>
    			   	</td>
    			   	<td><p>请选择试卷</p></td>
    			   	<td style="display:flex">
    			   		<!--遍历session中所有试卷-->
    			   		<select name="papername" id="paper" class="selectpicker" data-live-search="true" style="height:40px" style="height: 50px;">
    			   			<c:forEach items="${sessionScope.papername }" var="p">
    			   			<option value="${p}">${p }</option>
    			   			</c:forEach>
    			   		</select>
    			   	</td>
    			   	</table>
    			   	<div style="margin-top:20px">
    			   	<button class="btn1" id="b1" onclick="fun1()" type="button">查询</button>
    			    <button class="btn1" id="b2" onclick="fun2()" type="button">成绩分析</button>
    			    </div>
    			</form>
    		</div>
		</div>
		<div style="width: 100%;height: 2px;margin-top: 5vh;background-color: #eaeaea;">
		</div>
		<!-- 功能区 -->
               <div class="m2" >
    				<table class="cj" border="1px solid black" style="width:100%">
    					<th>学生名</th>
    					<th>试卷名</th>
    					<th>成绩</th>
    					<th>学生个人成绩</th>
    					<c:forEach items="${sessionScope.StudentGrade }" var="sg">
    					<tr>
    						<td>${sg.getName()}</td>
    						<td>${sg.getPapername()}</td>
    						<td>${sg.getscore()}</td>
    						<td>
    							<center>
    							<!--进入学生个人成绩页面，根据选中的学生用户名查询数据库
    							 链接值为servlet中老师对学生进行操作的文件名
    							-->
    							   <button type="button" class="btn btn-info btn-lg" onclick="show('${sg.getUserId()}','${sg.getPapername()}')">修改</button>
    							</center>
    						</td>    						
    					</tr>
    					</c:forEach>
    				</table>
    				
    		</div>
	</div>
	<div class="footer">
    		<div class="copyright">Copyright © 1996-2017. All Rights Reserved. 版权所有</div>
    	</div>
	<script language="javascript" src="../js/bootstrap.min.js">
	</script>
	<script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="../js/layer.js"></script>
	<script language="JavaScript">
			function fun1(){
				var myclass=document.getElementById("class");
				var index1=myclass.selectedIndex;
				var class1=myclass.options[index1].text;
				
				var mypaper=document.getElementById("paper");
				var index2=mypaper.selectedIndex;
				var paper1=mypaper.options[index2].text;
				window.location.href="/web_big_homework/ShowStudentGrade?class="+class1+"&papername="+paper1+"&type=1";//查询学生成绩 
			}
			function fun2(){
				document.form1.action="../ExportExcel";//柱状分析的servlet
			}
			function show(student_id,papername){
	   			var id=student_id
	   			layer.open({
	   			  type: 2 //Page层类型
	   			  ,area: ['500px', '600px']
	   			  ,title: '修改学生信息'
	   			  ,shade: 0.6 //遮罩透明度
	   			  ,maxmin: true //允许全屏最小化
	   			  ,anim: 1 //0-6的动画形式，-1不开启
	   			  ,content: '../showgrade?stu_id='+student_id+"&papername="+papername,
	   			cancel: function(index, layero){ 
	   	   	   	  if(confirm('确定要关闭么')){//只有当点击confirm框的确定时，该层才会关闭
	   	   	    	window.location.href='../ShowStudentGrade?type=1';
	   	   	   	    layer.close(index);
	   	   	   	  }
	   	   	   	  return false; 
	   	   	   	}
	   			});    
	   		};
		</script>
	</body>
</html>