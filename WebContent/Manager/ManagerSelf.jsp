<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("utf-8"); %>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>管理员个人信息</title>
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
					<form class="form-horizontal" id="managerAction" action="../managerupdata" method="post">
					<div class="form-group">
								 <label for="managerId" class="col-sm-2 control-label">${manager_success}</label>
							</div>
						<c:if test="${Manager1.getId() != null }">
							<div class="form-group">
								 <label for="managerId" class="col-sm-2 control-label">管理员工号</label>
								 <div class="col-sm-5">                              
										<input class="form-control" id="" name="managerid" type="text" value="${Manager1.getId()}" placeholder="教师工号   readonly="readonly" unselectable='on' onfocus='this.blur()'/>
							</div>
								 	<input type="hidden" value="1" name="isupdate" id="isupdate" class="form-control" />
							</div>
						</c:if>
						<div class="form-group">
							 <label for="classId" class="col-sm-2 control-label">管理员姓名</label>
							<div class="col-sm-5">                              
										<input class="form-control" id="" name="managerName" type="text" value="${Manager1.name}" placeholder="教师姓名" />
							</div>
						</div>
						<div class="form-group">
							 <label for="managerName" class="col-sm-2 control-label">管理员电话</label>
							<div class="col-sm-5">
								<input class="form-control" id="" name="managertel" type="text" value="${Manager1.telephone}" placeholder="教师电话" />
							</div>
						</div>
						<div class="form-group">
							 <label for="managerName" class="col-sm-2 control-label">账号密码</label>
							<div class="col-sm-5">
								<input class="form-control" id="" name="managerpwd" type="password" value="${Manager1.pwd}" placeholder="账号密码"/>
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