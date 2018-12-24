<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>学生信息管理</title>
 	<link href="css/bootstrap.min.css" rel="stylesheet" />
 	<style type="text/css">
                 th{
                     text-align:center;
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
		<font style="font-size: 24px; font-family: small arial,sans-serif">管理员：</font>
		<font style="font-size: 24px; font-family: small arial,sans-serif ;font-color: #36AAFD">${sessionScope.Manager.name}</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button type="button" class="text-center" style="width:12%; height: 40px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 10px;" onclick="window.location.href='/web_big_homework/Logout'">登出</button>
		<button type="button" class="text-center" style="width:12%; height: 40px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 10px;margin-left:10px" onclick="window.location.href='/web_big_homework/Manager/index.jsp'">回到首页</button>
		<button type="button" class="text-center" style="width:12%; height: 40px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 10px;margin-left:10px" onclick="add()">添加学生</button>
		</div>
		<div style="width: 100%;height: 2px;margin-top: 10vh;background-color: #eaeaea;">
		</div>
	<div style="text-align: center;">
		<table class="table table-striped table-hover table-condensed">
			<thead>
				<tr>
					<th>学生学号</th>
					<th>学生姓名</th>
					<th>登录密码</th>
					<th>学生电话</th>
					<th>就读班级</th>
					<c:if test="${sessionScope.adminPower == 2 || sessionScope.adminPower==3}">
						<th>操作</th>
					</c:if>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty sessionScope.Student}">
						<c:forEach items="${sessionScope.Student}" var="student">
							<tr>
								<td>${student.getId()}</td>
								<td>${student.name}</td>
								<td>
									<span id="hidePwd">******</span>
									<span id="showPwd" style="display: none">${student.pwd}</span>
									<button type="button" class="btn btn-info btn-xs viewPwd">查看</button>
								</td>
								<td>${student.telephone}</td>
								<td>${student.studentclass}</td>
								<td>
									<div class="btn-group">
										<button type="button" class="btn btn-info btn-sm" onclick="xiugai('${student.getId()}')">修改</button>
										<button type="button" class="btn btn-danger btn-sm" onclick="delete_student('${student.getId()}')">删除</button>
									</div>
								</td>
							</tr>
						</c:forEach>
					</c:when>
				</c:choose>
			</tbody>
		</table>
		<form action="student" method="post">
			<input type="hidden" value="DELETE" name="_method" />
		</form>
	</div>
</div>

	<!-- js引入 -->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="../js/layer.js"></script>
   	<script type="text/javascript">
   		$(function() {
   			$(".viewPwd").click(function() {
   				var pwd0 = $(this).siblings("#hidePwd").text();
   				if (pwd0.indexOf("*") != -1) {
   					var pwd = $(this).siblings("#showPwd").text();
   					$(this).siblings("#hidePwd").text(pwd);
   					return;
   				} else {
   					$(this).siblings("#hidePwd").text("******");
   				}
   			});
   		})
   		function xiugai(student_id){
   			var id=student_id
   			layer.open({
   			  type: 2 //Page层类型
   			  ,area: ['500px', '600px']
   			  ,title: '修改学生信息'
   			  ,shade: 0.6 //遮罩透明度
   			  ,maxmin: true //允许全屏最小化
   			  ,anim: 1 //0-6的动画形式，-1不开启
   			  ,content: '../studentedit?type=3&id='+id,
   			cancel: function(index, layero){ 
   	   	   	  if(confirm('确定要关闭么')){//只有当点击confirm框的确定时，该层才会关闭
   	   	    	window.location.href='../ShowUserInfo?type=3';
   	   	   	    layer.close(index);
   	   	   	  }
   	   	   	  return false; 
   	   	   	}
   			});    
   		};
   	   		function add(){
   	   			layer.open({
   	   			  type: 2 //Page层类型
   	   			  ,area: ['500px', '600px']
   	   			  ,title: '添加学生信息'
   	   			  ,shade: 0.6 //遮罩透明度
   	   			  ,maxmin: true //允许全屏最小化
   	   			  ,anim: 1 //0-6的动画形式，-1不开启
   	   			  ,content: 'studentAdd.jsp',
   	   		cancel: function(index, layero){ 
   	   	  if(confirm('确定要关闭么')){//只有当点击confirm框的确定时，该层才会关闭
   	    	window.location.href='../ShowUserInfo?type=3';
   	   	    layer.close(index);
   	   	  }
   	   	  return false;
   	   	}});    
   		}
   	   		function delete_student(id){
   	   		layer.confirm('是否要删除该学生？', {
   	   	  btn: ['删除','取消'] //按钮
   	   	}, function(){
   	   	  window.location.href='../studentdelete?type=3&id='+id
   	   	  layer.msg('删除成功', {icon: 1});
   	      time: 3000;
   	   	}, function(){
   	   	layer.msg('取消删除', {icon: 1});
   	      time: 3000;
   	   	});
   	   		}
   	</script>
</body>
</html>