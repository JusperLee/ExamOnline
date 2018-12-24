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
		<title>学生主页</title>
		<style type="text/css">
		          .function{
                  width:7%; 
                  height: 15vh; 
                  border: none; 
                  margin-top: 20px;
                  border-radius: 9px;
                  background:url(../image/查看成绩.png) round
                  }
                  .function_right1{
                  width:7%; 
                  height: 15vh; 
                  border: none; 
                  margin-top: 20px;
                  margin-right: 5%;
                  border-radius: 9px;
                  background:url(../image/我的错题.png) round
                  }
                  .function_right2{
                  width:7%; 
                  height: 15vh; 
                  border: none; 
                  margin-top: 20px;
                  margin-right: 5%;
                  border-radius: 9px;
                  background:url(../image/查看考试.png) round
                  }
                  .function_left1{
                  width:7%; 
                  height: 15vh; 
                  border: none; 
                  margin-top: 20px;
                  margin-left: 5%;
                  border-radius: 9px;
                  background:url(../image/自我检测.png) round
                  }
                  .function_left2{
                  width:7%; 
                  height: 15vh; 
                  border: none; 
                  margin-top: 20px;
                  margin-left: 5%;
                  border-radius: 9px;
                  background:url(../image/个人中心.png) round
                  }
                  .function_right1:hover{
                  width:7%; 
                  height: 15vh; 
                  border: none; 
                  margin-top: 20px;
                  margin-right: 5%;
                  background:url(../image/我的错题hui.png) round
                  }
                   .function_right2:hover{
                  width:7%; 
                  height: 15vh; 
                  border: none; 
                  margin-top: 20px;
                  margin-right: 5%;
                  background:url(../image/查看考试hui.png) round
                  }
                   .function:hover{
                  width:7%; 
                  height: 15vh; 
                  border: none; 
                  margin-top: 20px;
                  background:url(../image/查看成绩hui.png) round
                  }
                   .function_left1:hover{
                  width:7%; 
                  height: 15vh; 
                  border: none; 
                  margin-top: 20px;
                  margin-left: 5%;
                  background:url(../image/自我检测hui.png) round
                  }
                   .function_left2:hover{
                  width:7%; 
                  height: 15vh; 
                  border: none; 
                  margin-top: 20px;
                  margin-left: 5%;
                  background:url(../image/个人中心hui.png) round
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
		<font style="font-size: 24px; font-family: small arial,sans-serif">学生：</font>
		<font style="font-size: 24px; font-family: small arial,sans-serif ;font-color: #36AAFD">${sessionScope.Student.name}</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button type="button" class="text-center" style="width:12%; height: 40px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 10px;" onclick="window.location.href='/web_big_homework/Logout'">登出</button>
		
		</div>
		<div style="width: 100%;height: 2px;margin-top: 10vh;background-color: #eaeaea;">
		</div>
		<!-- 功能区 -->
		<div style=" margin-top: 10vh;">
		<button class ="function_right1 " style=""  onclick="window.location.href='/web_big_homework/MistakeCollect'"></button>
		<button class ="function_right2 " style=""  onclick="window.location.href='/web_big_homework/showPaper'"></button>
		<button class ="function " style=""  onclick="window.location.href='/web_big_homework/ShowMygrade'"></button>
		<button class ="function_left1 " style=""  onclick="window.location.href='selfTest0.jsp'"></button>
		<button class ="function_left2 " style=""  onclick="show('${sessionScope.Student.getId()}')"></button>
		</div>
	</div>
	  <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="../js/layer.js"></script>
	<script language="javascript" src="../js/bootstrap.min.js">
	</script>
	<script>
	function show(student_id){
		var id=student_id;
		layer.open({
		  type: 2 //Page层类型
		  ,area: ['500px', '600px']
		  ,title: '查看个人信息'
		  ,shade: 0.6 //遮罩透明度
		  ,maxmin: true //允许全屏最小化
		  ,anim: 1 //0-6的动画形式，-1不开启
		  ,content: '../studentedit?type=1&id='+id,
		cancel: function(index, layero){ 
   	   	  if(confirm('确定要关闭么')){//只有当点击confirm框的确定时，该层才会关闭
   	    	window.location.href='index.jsp';
   	   	    layer.close(index);
   	   	  }
   	   	  return false; 
   	   	}
		});    
	};
	</script>
	</body>
</html>
