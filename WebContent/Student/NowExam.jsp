<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link href="../image/考试.png" rel="shortcut icon" type="image/vnd.microsoft.icon">
	    <link href="../css/style.css" rel="stylesheet" type="text/css">
	
		<title>NowExam</title>
		<style type="text/css">
		          .content{
				width: 100%;
				height: 480px;
				/*border: 1px solid black;*/
				/*margin-top: 30px;*/
				/*background-color: gainsboro;*/
			}
			.main{
				width:100% ;
				height: 510px;
				/*background-color: white;*/
				margin: 0 auto;
			}
			.footer{
				width: 100%;
				height: 50px;
				/*border: 1px black  solid;*/
				
			}
			.copyright{
	           line-height: 50px;
	           text-align: center;
	           font-size: 15px;
			}
			.tt{
     		margin: 0 auto;
     		border-color: #B8E5F8;
     		width:100%;
     		font-size: 20px; 
     		font-family: small arial,sans-serif ;
     	}
      	#href{
      		text-decoration: none;
      	}
        </style>
	</head>
	<body style="background-color: #B8E5F8;background-image: url(../image/regist_bk.png);text-align: center">
	<div  class="border" style="background-color: #FFFDFD;margin: 0 auto;margin-top: 30px;border-radius: 10px;height: 1000px;width: 90%; ">
		<div style="height: 10vh;margin-bottom:10vh">
		<img src="../image/DIMTIM.png" height="300vh"/>
		</div>
		 <div style="align-self: center;width:60%;margin: 0 auto;margin-top:15vh">
		<font style="font-size: 24px; font-family: small arial,sans-serif">欢迎使用在线考试系统</font>&nbsp;&nbsp;&nbsp;&nbsp;
		<font style="font-size: 24px; font-family: small arial,sans-serif">学生：</font>
		<font style="font-size: 24px; font-family: small arial,sans-serif ;font-color: #36AAFD">${sessionScope.Student.name}</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button type="button" class="text-center" style="width:12%; height: 40px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 10px;" onclick="window.location.href='/web_big_homework/Logout'">登出</button>
		<button type="button" class="text-center" style="width:12%; height: 40px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 10px;margin-left:10px" onclick="window.location.href='/web_big_homework/Student/index.jsp'">回到首页</button>
		</div>
		
		<!-- 功能区 -->
		<div class="naver" style = "width:100%">
	 	<table class="t1" style = "width:100%;margin-top:5vh">
	 				<tr style=" height: 40px;">
	 				
	 					<td width="200px">
	 					<center><a href="BeforeExam.jsp" target="if"><button type="button" class="text-center" style="height: 40px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 10px;" >已经结束的考试</button></a>
	 					</center>
	 					</td>
	 					<td width="200px"><center><a href="NowExam.jsp" target="if"><button type="button" class="text-center" style=" height: 40px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 10px;" >正在进行的考试</button></a></center></td>
	 					<td width="200px"><center><a href="AfterExam.jsp" target="if"><button type="button" class="text-center" style="height: 40px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 10px;" >即将临近的考试</button></a></center></td>
	 				</tr>
	 			</table>
	 </div>
	 <div style="width: 100%;height: 2px;margin-top: 3vh;background-color: #eaeaea;">
		</div>
	<div class="content">
	 	<div class="main">
	 			<div>
	 			<table class="tt" border="1px solid" cellspacing="0">
	 				<tr  style="text-align:center">
	 					<th style="text-align:center">考试号</th>
	 					<th style="text-align:center">开始时间</th>
	 					<th style="text-align:center">结束时间</th>
	 					<th style="text-align:center">试卷名</th>
	 					<th style="text-align:center">操作</th>
	 				</tr>
	 				<!--获取将来考试信息的集合 -->
	 			
	 				<c:forEach items="${sessionScope.PaperNow}" var="pn">
	 				<tr style="text-align:center">
	 				  <td>${pn.id}</td>
	 				  <td>${pn.starttime}</td>
	 				  <td>${pn.endtime}</td>
	 				  <td>${pn.papername}</td>
	 				 <td><button type="button" style="width: 100%;background-color:#36AAFD"class="btn btn-info btn-sm" onclick="joinz('${pn.papername}')">加入考试</button>
	 				</td>
	 				</tr>
	 			    </c:forEach>
	 			</table>
	 		</div>
	 		</div>
	 	</div>
	 <div class="footer">
	 	<div class="copyright">Copyright © 2017-2018. All Rights Reserved. 版权所有李凯    豫ICP备18020526号-2</div>
	 </div>
	</div>
    
	</body>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
	<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
	<script language="javascript" src="../js/layer.js"></script>
	
	<script type="text/javascript">
 	function joinz(papername){
 		var name=papername;
	   		layer.confirm('是否要加入该考试？', {
	   	  btn: ['是','否'] //按钮
	   	}, function(){
	   	  window.location.href='../DoExam?papername='+name
	   	  layer.msg('加入成功', {icon: 1});
	      time: 3000;
	   	}, function(){
	   	window.location.href="/web_big_homework/showPaper"
	   	layer.msg('取消成功', {icon: 1});
	      time: 3000;
	   	});
	   		};
    </script>
</html>