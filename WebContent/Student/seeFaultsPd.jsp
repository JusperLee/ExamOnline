<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>查看错题选择题</title>
    	<style type="text/css">
    *{
	margin:0;
	padding:0;
}
a{
	text-decoration: none;
	color: black;
}
a:hover{
	color: lightblue;
}
.header{
		width:100%;
		height: 80px;
		/*height:20%;*/
		background-image: url('../images/logo.jpg');
		position:relative;
}
.header p{
		font-size: 30px;
		color: white;
		text-align: center;
		line-height: 80px;
}
#nave{
	/*border:1px solid red;*/
	height:50px;
	/*height: 10%;*/
	width:80%;
	margin: 0 auto;
	position: relative;
}
#nave .td0{
	width: 250px;
	/*border: 1px black solid;*/
	text-align: center;
	line-height: 50px;
}



#nave #tr1{
	text-align: center;
	line-height: 50px;
}
#nave .td1{
	width: 350px;
	/*border: 1px solid black;*/	
}

#nave .td2{
	width: 50px;
	text-align: right;
}
/*#nave .td2 button{
	width: 50px;
	background-color: deepskyblue;
}*/
#main{
	height: 800px;
	width: 70%;
	border: 1px solid cornflowerblue;
	margin: 0 auto;
	box-shadow: 0px 0px 8px cornflowerblue;
	position: relative;
}
#tab1{
	margin-top: 20px;
	margin-left: 20px;
	border-spacing: 10px;
	border: 1px solid gainsboro;
	width:850px;
	
}

.pd,.tk,.bc{
	height: 50px;
	/*border: 1px solid red;*/
	font-size: 20px;
	font-weight: 500;
}
#pd_title,.tk_title,.bc_title{
	/*border: 1px solid red;*/
	/*border: 1px solid red;*/
	font-size: 18px;
	height: 20px;
}
.pd_choose{
	width: 50px;
	/*border: 1px solid red;*/
	height: 20px;
	font-size: 16px;
}
.pd_con{
	/*border: 1px solid red;*/
	width: 820px;
}

#tab2{
	margin-top: 20px;
	margin-left: 20px;
	border-spacing: 10px;
	border: 1px solid gainsboro;
}
.tk_title,.bc_title{
	width: 880px;
}

#tab3{
	margin-top: 20px;
	margin-left: 20px;
	border-spacing: 10px;
	border: 1px solid gainsboro;
}
#footer{
	width:100%;
	height:50px;
	background-image: url('images/logo.jpg');

	
}
.copyright{
	line-height: 50px;
	text-align: center;
	font-size: 15px;
}
.top{
	width:54px;
	height:54px;
	position:fixed;
	right:0px;
	bottom:20px;
}
.fy{

    margin-top: -50px;
    margin-left: 350px;
	 
}
    </style>
    </head>
    <body>
		<table id="tab1">
			<tr>
				<td class="pd"colspan="2">三、判断题</td>
			</tr>
			<%int a=1;%>
			<c:forEach var = "pdt" items="${pdtlist}">
			<tr>
			
				<td colspan="2" id="pd_title">
					<%out.println(a++ +". ");%>${pdt.question}
				</td>
			</tr>
			
		
				
			<tr>
				<td class="pd_choose">
					<input type="radio" value="" name="pd1"/>&nbsp;&nbsp;&nbsp;yes
				</td>
			</tr>
			<tr>
				<td>
					<input type="radio" value="" name="pd1"/>&nbsp;&nbsp;&nbsp;no
				</td>
			</tr>
				<td colspan="2" style="text-align: right; color: red;">
					正确答案：${pdt.answer}
				</td>
			</tr>
			</c:forEach>
		</table>
 	</body>
</html>