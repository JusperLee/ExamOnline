<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>所有试卷的试卷名</title>
        <style type="text/css">
        .main{
	margin: 0 auto;
}
.t{
	margin: 0 auto;
	margin-top: 30px;
	border-color: #36AAFD;
}
.t a{
	text-decoration: none;
}
        </style>
    </head>
    <body>
    	<div class="main" style="width:100%">
    		<table class="t" border="1px solid" cellspacing="0"  style="width:100%">
    	  	<tr style="text-align:center;">
    	  		<th><font style=" font-family:small arial,sans-serif;font-size:20px;">试卷名</font></th>
    	  		<th><font style=" font-family:small arial,sans-serif;font-size:20px;">开始时间</font></th>
    	  		<th><font style=" font-family:small arial,sans-serif;font-size:20px;">结束时间</font></th>
    	  		<th><font style=" font-family:small arial,sans-serif;font-size:20px;">考试班级</font></th>
    	  	</tr>
    	  	<!--从ShowAllPaper中获取java试卷名-->
    	  	<c:forEach items="${sessionScope.all}" var="all">
    	  	<tr  style="text-align:center;">
    	  		<td><font style="font-family:small arial,sans-serif;font-size:23px">${all.papername}</font></td>
    	  		<td><font style="font-family:small arial,sans-serif;font-size:23px">${all.starttime}</font></td>
    	  		<td><font style="font-family:small arial,sans-serif;font-size:23px">${all.endtime}</font></td>
    	  		<td><font style="font-family:small arial,sans-serif;font-size:23px">${all.class1}</font></td>
    	  	</tr>
    	  	</c:forEach>
    	  </table>
    	  </div>
 	</body>
</html>