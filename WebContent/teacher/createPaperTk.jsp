<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>出填空题</title>
        <link rel="stylesheet" type="text/css" href="css/createPaper.css"/>
    </head>
    <body>
    	<!--填空题-->
    	<form action="../createpaperTkt" method="post">
		<table id="tab2">
			<tr>
				<td class="tk">二、填空题(请在以下填空题中选择5道)</td>
			</tr>
			<%int a=1;%>
			<c:forEach items="${sessionScope.tktlist}" var="tk" >
			<tr>
				<td class="tktitle">
					<input type="checkbox" name="tkt" id="" value="${tk.id}" />&nbsp;&nbsp;<%out.println(a++ +". ");%>.题目${tk.question}
				</td>
			</tr>
			<tr>
				
				<td class="tkcon">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;答案:${tk.answer}
				</td>
			</tr>
		 </c:forEach>
		</table>
		<button type="submit" class="text-center" style="width:100px; height: 40px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 10px;">选定</button>
		</form>
 	</body>
</html>