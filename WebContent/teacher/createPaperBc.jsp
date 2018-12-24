<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>出编程题</title>
        <link rel="stylesheet" type="text/css" href="css/createPaper.css"/>
    </head>
    <body>
    	<!--编程题-->
    	<form action="../createpaperBct" method="post">
		<table id="tab3">
			<tr>
				<td class="bc" >三、编程题(请在以下选择题中选择2道)</td>
			</tr>
			<%int a=1;%>
			<c:forEach items="${sessionScope.bctlist}" var="bc" >
			<tr>
				<td class="bctitle">
					<input type="checkbox" name="bct" id="" value="${bc.id}" />&nbsp;&nbsp;<%out.println(a++ +". ");%>.题目${bc.question}

				</td>
			</tr>
			</c:forEach>
		</table>
		<button type="submit" class="text-center" style="width:100px; height: 40px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 10px;">选定</button>
		</form>
 	</body>
</html>