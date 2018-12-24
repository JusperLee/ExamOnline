<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<% request.setCharacterEncoding("utf-8"); %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>试卷信息编辑</title>
 	<link href="css/bootstrap.min.css" rel="stylesheet" />
 	<link href="css/bootstrap-select.min.css" rel="stylesheet" />
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.bundle.min.js"></script>
 	<script src="js/bootstrap-select.js"></script>
 	 <script src="../laydate/laydate.js"></script>
 	<style type="text/css">
 		.dropdown-toggle {
 			height: 30px;
 		}
 	</style>
 	<script>
		laydate.render({
			  elem: '#startTime'
			  ,type: 'datetime'
			});
		laydate.render({
			  elem: '#endTime'
			  ,type: 'datetime'
			});
        laydate.render({
        	  elem: '#Time1'
        	  ,type: 'time'
        	});
        </script>
</head>
<body>
	<div>
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<form class="form-horizontal" id="studentAction" action="../paperupdate" method="post">
						<c:if test="${paper_person.getId() != null }">
						<div class="form-group">
								 <label for="studentId" class="col-sm-2 control-label">${sessionScope.msg1}</label>
							</div>
							<div class="form-group">
								 <label for="studentId" class="col-sm-2 control-label">试卷编号</label>
								 <div class="col-sm-5">
								 	<input class="form-control" id="studentId" name="paperid" type="text" value="${paper_person.getId()}" readonly="readonly" unselectable='on' onfocus='this.blur()' />
								 </div>
							</div>
						</c:if>
						<div class="form-group">
							 <label for="classId" class="col-sm-2 control-label">试卷名称</label>
								 <div class="col-sm-5">
								 	<input class="form-control" id="studentId" name="papername" type="text" value="${paper_person.getPapername()}" placeholder="试卷名称"/>
								 </div>
						</div>
						<div class="form-group">
							 <label for="studentName" class="col-sm-2 control-label">试卷开始时间</label>
							<div class="col-sm-5">
								<input class="form-control" id="startTime" name="paperstart" type="datetime" value="${paper_person.starttime }" placeholder="试卷开始时间" />
							</div>
						</div>
						<div class="form-group">
							 <label for="studentName" class="col-sm-2 control-label">试卷结束时间</label>
							<div class="col-sm-5">
								<input class="form-control" id="endTime" name="paperend" type="datetime" value="${paper_person.endtime }" placeholder="试卷结束时间" />
							</div>
						</div>
						<div class="form-group">
							 <label for="studentPwd" class="col-sm-2 control-label">试卷考试时间</label>
							<div class="col-sm-5">
								<input class="form-control" id="Time1" name="papertime" type="time" value="${paper_person.time }" placeholder="试卷考试时间" />
							</div>
						</div>
						<div class="form-group">
							 <label for="studentPwd" class="col-sm-2 control-label">试卷适用班级</label>
							<div class="col-sm-5">
								<input class="form-control" id="studentPwd" name="paperclass" type="text" value="${paper_person.getClass1() }" placeholder="试卷适用班级" />
							</div>
						</div>
						<div class="form-group">
							 <label for="studentPwd" class="col-sm-2 control-label">试卷知识点</label>
							<div class="col-sm-5">
								<input class="form-control" id="studentPwd" name="paperpoint" type="text" value="${paper_person.getpaperPoint() }" placeholder="试卷知识点" />
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