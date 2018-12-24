<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("utf-8"); %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>编程题编辑</title>
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
					<form class="form-horizontal" id="studentAction" action="../bctedit?type=3" method="post">
						<c:if test="${bct_person.getId() != null }">
						<div class="form-group">
								 <label for="studentId" class="col-sm-2 control-label">${sessionScope.jdt_edit}</label>
							</div>
							<div class="form-group">
								 <label for="studentId" class="col-sm-2 control-label">编程题编号</label>
								 <div class="col-sm-3">
								 	<input class="form-control" id="studentId" name="id" type="text" value="${bct_person.getId()}" readonly="readonly" unselectable='on' onfocus='this.blur()' />
								 </div>
								 	<input type="hidden" value="1" name="isupdate" id="isupdate" class="form-control" />
							</div>
						</c:if>
						<div class="form-group">
							 <label for="classId" class="col-sm-2 control-label">题目</label>
							<div class="col-sm-5">
							<input class="form-control" id="studentName" name="question" type="text" value="${bct_person.question }" placeholder="题目" />
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