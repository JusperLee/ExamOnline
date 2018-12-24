<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<% request.setCharacterEncoding("UTF-8"); %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>教师信息编辑</title>
 	<link href="css/bootstrap.min.css" rel="stylesheet" />
 	<link href="css/bootstrap-select.min.css" rel="stylesheet" />
 	<style type="text/css">
 		.dropdown-toggle {
 			height: 30px;
 		}
 	</style>
</head>
<body>
	<div>
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<form class="form-horizontal" id="teacherAction" action="../teacherAdd" method="post">
						<div class="form-group">
								 <label for="teacherId" class="col-sm-2 control-label" name="message_success">${sessionScope.message_success}</label>
							</div>
							<div class="form-group">
								 <label for="teacherId" class="col-sm-2 control-label">教师工号</label>
								 <div class="col-sm-3">
								 	<input class="form-control" id="teacherId" name="teacherId" type="text" value=""  aria-required="true" placeholder="教师工号"/>
								 </div>
								 	<input type="hidden" value="1" name="isupdate" id="isupdate" class="form-control" />
							</div>
						<div class="form-group">
							 <label for="classId" class="col-sm-2 control-label">教师授权码</label>
							<div class="col-sm-5">
								<input class="form-control" id="teacherName" name="teacherAuth" type="text"  placeholder="教师授权码"  aria-required="true"/>
							</div>
						</div>
						<div class="form-group">
							 <label for="teacherName" class="col-sm-2 control-label">教师姓名</label>
							<div class="col-sm-5">
								<input class="form-control" id="teacherName" name="teacherName" type="text"  placeholder="教师姓名"  aria-required="true"/>
							</div>
						</div>
						<div class="form-group">
							 <label for="teacherName" class="col-sm-2 control-label">教师手机号</label>
							<div class="col-sm-5">
								<input class="form-control" id="teacherName" name="teacher_tel" type="text" placeholder=教师手机号"  aria-required="true"/>
							</div>
						</div>
						<div class="form-group">
							 <label for="teacherPwd" class="col-sm-2 control-label">登录密码</label>
							<div class="col-sm-5">
								<input class="form-control" id="teacherPwd" name="teacherPwd" type="password" placeholder="登录密码"  aria-required="true"/>
							</div>
						</div>
						<br />
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-4">
								 <button id="sub" type="submit" class="btn btn-default btn-lg btn-block">
							 		提交
								 </button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>


	<!-- js引入 -->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/bootstrap-select.min.js"></script>
    <script type="text/javascript">
    	$('.selectpicker').selectpicker({
    	    style: 'btn-default',
    	    size: 8
    	});
    </script>
</body>
</html>