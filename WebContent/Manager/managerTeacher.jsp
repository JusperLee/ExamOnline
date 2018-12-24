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
		 <div style="align-self: center;width:100%;margin: 0 auto;margin-top:15vh">
		<font style="font-size: 24px; font-family: small arial,sans-serif">欢迎使用在线考试系统</font>&nbsp;&nbsp;&nbsp;&nbsp;
		<font style="font-size: 24px; font-family: small arial,sans-serif">管理员：</font>
		<font style="font-size: 24px; font-family: small arial,sans-serif ;font-color: #36AAFD">${sessionScope.Manager.name}</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button type="button" class="text-center" style="width:12%; height: 40px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 10px;" onclick="window.location.href='/web_big_homework/Logout'">登出</button>
		<button type="button" class="text-center" style="width:12%; height: 40px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 10px;margin-left:10px" onclick="window.location.href='/web_big_homework/Manager/index.jsp'">回到首页</button>
		<button type="button" class="text-center" style="width:12%; height: 40px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 10px;margin-left:10px" onclick="add()">添加老师</button>
		</div>
		<div style="width: 100%;height: 2px;margin-top: 10vh;background-color: #eaeaea;">
		</div>
	<div style="text-align: center;">
		<table class="table table-striped table-hover table-condensed">
			<thead>
				<tr>
					<th>教师工号</th>
					<th>教师姓名</th>
					<th>登录密码</th>
					<th>教师电话</th>
					<th>教师授权码</th>
					<c:if test="${sessionScope.adminPower == 3}">
						<th>操作</th>
					</c:if>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty sessionScope.TeacherInfo}">
						<c:forEach items="${sessionScope.TeacherInfo}" var="teacher">
							<tr>
								<td>${teacher.getId()}</td>
								<td>${teacher.name}</td>
								<td>
									<span id="hidePwd">******</span>
									<span id="showPwd" style="display: none">${teacher.pwd}</span>
									<button type="button" class="btn btn-info btn-xs viewPwd">查看</button>
								</td>
								<td>${teacher.telephone}</td>
								<td>${teacher.auth}</td>
								<td>
									<div class="btn-group">
										<button type="button" class="btn btn-info btn-sm" onclick="xiugai('${teacher.getId()}')">修改</button>
										<button type="button" class="btn btn-danger btn-sm" onclick="delete_student('${teacher.getId()}')">删除</button>
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
		<%-- <c:if test="${pageTotal > 1 }">
			<div>
				<ul class="pagination">
					<li><a href="students?startPage=1">首页</a></li>
					<c:if test="${pageNow-1 > 0 }">
						<li><a href="students?startPage=${pageNow-1 }">上一页</a></li>
					</c:if>
					<c:forEach begin="${pageNow }" end="${pageNow+4 }" var="subPage">
						<c:if test="${subPage-5 > 0 }">
							<li><a href="students?startPage=${subPage-5 }">${subPage-5 }</a></li>
						</c:if>
					</c:forEach>
					<c:forEach begin="${pageNow }" end="${pageNow+5 }" step="1" var="pageNo">
						<c:if test="${pageNo <= pageTotal }">
							<c:if test="${pageNow == pageNo }">
								<li class="active"><a href="students?startPage=${pageNo }">${pageNo }</a></li>
							</c:if>
							<c:if test="${pageNow != pageNo }">
								<li><a href="students?startPage=${pageNo }" class="pageLink">${pageNo }</a></li>
							</c:if>
						</c:if>
					</c:forEach>
					<c:if test="${pageNow+1 <= pageTotal }">
						<li><a href="students?startPage=${pageNow+1 }">下一页</a></li>
					</c:if>
					<li><a href="students?startPage=${pageTotal }">尾页</a></li>
					<li>
						<a>${pageNow }/${pageTotal }</a>
					</li>
					<li>
						<div style="width:-1%; height:100%;float:right;">
							<form action="students" id="scannerPageForm">
								<input id="scannerPage" type="text" name="startPage" style="width: 40px; height: 30px; border: 1px solid gray; border-radius: 4px;" />
								<input class="btn btn-default goPage" type="submit" value="Go" style="margin-left: -4px; height: 30px;" />
							</form>
						</div>
					</li>
				</ul>
			</div>
		</c:if> --%>
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
   			  ,title: '修改老师信息'
   			  ,shade: 0.6 //遮罩透明度
   			  ,maxmin: true //允许全屏最小化
   			  ,anim: 1 //0-6的动画形式，-1不开启
   			  ,content: '../teacheredit?type=3&id='+id,
   			cancel: function(index, layero){ 
   	   	   	  if(confirm('确定要关闭么')){//只有当点击confirm框的确定时，该层才会关闭
   	   	    	window.location.href='../Managerteacher';
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
   	   			  ,title: '添加教师信息'
   	   			  ,shade: 0.6 //遮罩透明度
   	   			  ,maxmin: true //允许全屏最小化
   	   			  ,anim: 1 //0-6的动画形式，-1不开启
   	   			  ,content: 'teacherAdd.jsp',
   	   		cancel: function(index, layero){ 
   	   	  if(confirm('确定要关闭么')){//只有当点击confirm框的确定时，该层才会关闭
   	    	window.location.href='../Managerteacher';
   	   	    layer.close(index);
   	   	  }
   	   	  return false;
   	   	}});    
   		}
   	   		function delete_student(id){
   	   		layer.confirm('是否要删除该老师？', {
   	   	  btn: ['删除','取消'] //按钮
   	   	}, function(){
   	   	  window.location.href='../teacherdelete?type=3&id='+id
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