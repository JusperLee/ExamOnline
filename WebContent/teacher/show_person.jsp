<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>学生成绩查看</title>
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
					<form class="form-horizontal" id="studentAction" action="../studentupdata" method="post">
						<c:if test="${person_grade.getUserId() != null }">
							<div class="form-group">
								 <label for="studentId" class="col-sm-2 control-label">学生学号</label>
								 <div class="col-sm-5">                              
										<input class="form-control" id="studentName" name="studentName" type="text" value="${person_grade.getUserId()}" placeholder="学生姓名"   readonly="readonly" unselectable='on' onfocus='this.blur()'/>
							</div>
								 	<input type="hidden" value="1" name="isupdate" id="isupdate" class="form-control" />
							</div>
						</c:if>
						<div class="form-group">
							 <label for="classId" class="col-sm-2 control-label">学生姓名</label>
							<div class="col-sm-5">                              
										<input class="form-control" id="studentName" name="studentName" type="text" value="${person_grade.getName()}" placeholder="学生姓名"   readonly="readonly" unselectable='on' onfocus='this.blur()'/>
							</div>
						</div>
						<div class="form-group">
							 <label for="studentName" class="col-sm-2 control-label">试卷编号</label>
							<div class="col-sm-5">
								<input class="form-control" id="studentName" name="studentName" type="text" value="${person_grade.getPaperId()}" placeholder="试卷编号"  readonly="readonly" unselectable='on' onfocus='this.blur()'/>
							</div>
						</div>
						<div class="form-group">
							 <label for="studentName" class="col-sm-2 control-label">试卷名称</label>
							<div class="col-sm-5">
								<input class="form-control" id="studentName" name="student_tel" type="text" value="${person_grade.getPapername()}" placeholder="试卷名称"   readonly="readonly" unselectable='on' onfocus='this.blur()'/>
							</div>
						</div>
						<div class="form-group">
							 <label for="studentPwd" class="col-sm-2 control-label">选择题成绩</label>
							<div class="col-sm-5">
								<input class="form-control" id="studentPwd" name="studentPwd" type="text" value="${person_grade.getXztscore()}" placeholder="选择题成绩"    readonly="readonly" unselectable='on' onfocus='this.blur()'/>
							</div>
						</div>
						<div class="form-group">
							 <label for="studentPwd" class="col-sm-2 control-label">填空题成绩</label>
							<div class="col-sm-5">
								<input class="form-control" id="studentPwd" name="studentPwd" type="text" value="${person_grade.getTktscore()}" placeholder="填空题成绩"    readonly="readonly" unselectable='on' onfocus='this.blur()'/>
							</div>
						</div>
						<div class="form-group">
							 <label for="studentPwd" class="col-sm-2 control-label">判断题成绩</label>
							<div class="col-sm-5">
								<input class="form-control" id="studentPwd" name="studentPwd" type="text" value="${person_grade.getPdtscore()}" placeholder="判断题成绩"    readonly="readonly" unselectable='on' onfocus='this.blur()'/>
							</div>
						</div>
						<div class="form-group">
							 <label for="studentPwd" class="col-sm-2 control-label">简答题成绩</label>
							<div class="col-sm-5">
								<input class="form-control" id="studentPwd" name="studentPwd" type="text" value="${person_grade.getJdtscore()}" placeholder="简答题成绩"    readonly="readonly" unselectable='on' onfocus='this.blur()'/>
							</div>
						</div>
						<div class="form-group">
							 <label for="studentPwd" class="col-sm-2 control-label">编程题成绩</label>
							<div class="col-sm-5">
								<input class="form-control" id="studentPwd" name="studentPwd" type="text" value="${person_grade.getBctscore()}" placeholder="编程题成绩"    readonly="readonly" unselectable='on' onfocus='this.blur()'/>
							</div>
						</div>
						<div class="form-group">
							 <label for="studentPwd" class="col-sm-2 control-label">编程题成绩</label>
							<div class="col-sm-5">
								<input class="form-control" id="studentPwd" name="studentPwd" type="text" value="${person_grade.getBctscore()}" placeholder="编程题成绩"    readonly="readonly" unselectable='on' onfocus='this.blur()'/>
							</div>
						</div>
						<div class="form-group">
							 <label for="studentPwd" class="col-sm-2 control-label">总成绩</label>
							<div class="col-sm-5">
								<input class="form-control" id="studentPwd" name="studentPwd" type="text" value="${person_grade.getscore()}" placeholder="总题成绩"    readonly="readonly" unselectable='on' onfocus='this.blur()'/>
							</div>
						</div>
						<!-- <br /> -->
						<!-- <div class="form-group">
							<div class="col-sm-offset-2 col-sm-4">
								 <button id="sub" type="submit" class="btn btn-default btn-lg btn-block">
							 		提交
								 </button>
							</div>
						</div> -->
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