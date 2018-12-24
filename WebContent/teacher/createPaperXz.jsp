<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>出选择题</title>
        <link rel="stylesheet" type="text/css" href="css/createPaper.css"/>
    </head>
    <body>
    	<!--选择题-->
    	<form action="../createpaperXzt" method="post">
		<table id="tab1">
			
			<tr >
				<td colspan="2" id="xz">一、选择题(请在以下选择题中选择10道)</td>
			</tr>
			<%int a=1;%>
			<c:forEach items="${sessionScope.xztlist}" var="xz" >
			<tr>
				<td colspan="2" id="xztitle">
					<input type="checkbox" name="xzt" id="" value="${xz.id}" />&nbsp;&nbsp;<%out.println(a++ +". ");%>.题目${xz.question}
				</td>
			</tr>
			<tr>
				<td class="xzchoose">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A
				</td>
				<td class="xzcon">
					${xz.optionA}
				</td>
			</tr>
			<tr>
				<td>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;B
				</td>
				<td>${xz.optionB}</td>
			</tr>
			<tr>
				<td>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;C
				</td>
				<td>${xz.optionC}</td>
			</tr>
			<tr>
				<td>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;D
				</td>
				<td>${xz.optionD}</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: right;">
					正确答案：${xz.answer}
				</td>
			</tr>
			</c:forEach>
		</table>
		<button type="submit" class="text-center" style="width:100px; height: 40px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 10px;">选定</button>
		</form>
 	</body>
</html>