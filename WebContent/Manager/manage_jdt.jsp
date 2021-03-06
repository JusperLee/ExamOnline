<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>简答题管理</title>
 	<link href="css/bootstrap.min.css" rel="stylesheet" />
 	<style type="text/css">
                 th{
                     text-align:center;
                 }
 	</style>
</head>
<body>
	<div style="text-align: center;">
		<table class="table table-striped table-hover table-condensed">
			<thead>
				<tr>
					<th>题目编号</th>
					<th>题目</th>
					<c:if test="${sessionScope.adminPower==3}">
						<th>操作</th>
					</c:if>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty sessionScope.JDT}">
						<c:forEach items="${sessionScope.JDT}" var="jdt">
							<tr>
								<td>${jdt.getId()}</td>
								<td>${jdt.question}</td>
								<td>
								<c:if test="${sessionScope.adminPower==3}">
									<div class="btn-group">
										<button type="button" class="btn btn-info btn-sm" onclick="xiugai('${jdt.getId()}')">修改</button>
										<button type="button" class="btn btn-danger btn-sm" onclick="delete_paper('${jdt.getId()}')">删除</button>
									</div>
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</c:when>
				</c:choose>
			</tbody>
		</table>
	</div>

	<!-- js引入 -->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="../js/layer.js"></script>
   	<script type="text/javascript">
   		function xiugai(paper_id){
   			var id=paper_id;
   			layer.open({
   			  type: 2 //Page层类型
   			  ,area: ['300px', '400px']
   			  ,title: '简答题'
   			  ,shade: 0.6 //遮罩透明度
   			  ,maxmin: true //允许全屏最小化
   			  ,anim: 1 //0-6的动画形式，-1不开启
   			  ,content: '../jdtedit?type=1&id='+id,
   			cancel: function(index, layero){ 
   	   	   	  if(confirm('确定要关闭么')){//只有当点击confirm框的确定时，该层才会关闭
   	   	    	window.location.href='../manage_Jdt';
   	   	   	    layer.close(index);
   	   	   	  }
   	   	   	  return false; 
   	   	   	}
   			});    
   		};
   	   		function delete_paper(paper_id){
   	   			var id=paper_id;
   	   		layer.confirm('是否要删除该试题？', {
   	   	  btn: ['删除','取消'] //按钮
   	   	}, function(){
   	   	  window.location.href='../jdtedit?type=2&id='+id;
   	   	  layer.msg('删除成功', {icon: 1});
   	      time: 3000;
   	   	}, function(){
   	   	window.location.href='../manage_Jdt';
   	   	layer.msg('取消删除', {icon: 1});
   	      time: 3000;
   	   	});
   	   		}
   	</script>
</body>
</html>