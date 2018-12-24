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
    	<form action="../createpaperPdt" method="post">
		<table id="tab1">
			
			<tr >
				<td colspan="2" id="pd">五、判断题(请在以下选择题中选择3道)</td>
			</tr>
			<%int a=1;%>
			<c:forEach items="${sessionScope.pdtlist}" var="pd" >
			<tr>
				<td colspan="2" id="pdtitle">
					<input type="checkbox" name="pdt" id="" value="${pd.id}" />&nbsp;&nbsp;<%out.println(a++ +". ");%>.题目${pd.question}
				</td>
			</tr>
			<tr>
				<td class="pdchoose">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="" id="" value="" />yes
				</td>
			</tr>
			<tr>
				<td>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="" id="" value="" />no
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: right;">
					正确答案：${pd.answer}
				</td>
			</tr>
			</c:forEach>
		</table>
		<button type="submit" class="text-center" style="width:100px; height: 40px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 10px;">选定</button>
		</form>
 	</body>
</html>