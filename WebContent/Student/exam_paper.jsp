<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="renderer" content="webkit">
		<meta charset="utf-8" />
		<link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link href="image/考试.png" rel="shortcut icon" type="image/vnd.microsoft.icon">
	    <link href="css/style.css" rel="stylesheet" type="text/css">
		<title>学生主页</title>
		<style type="text/css">
		        p{
		        font-size: 20px; 
		        font-family: small arial,sans-serif ;
		        text-align: -webkit-left;
		        }
		        .color{
		        background-color: #36aafd78
		        }
		        .btn1{
		        width:100px; 
		        height: 40px; 
		        border: none; 
		        background-color: #36AAFD; 
		        color: white;
		        margin-top: 10px;
		        }
		        .btn1:hover{
		        width:100px; 
		        height: 40px; 
		        border: none; 
		        background-color: #36aafd73; 
		        color: white;
		        margin-top: 10px;
		        }
				label{
				font-size:30px;
				color: #a7abb1;
				}
				div.timeBar > span{
				font-size: 30px;
				color: #a7abb1;
				}
        </style>
	</head>
	<body style="background-color: #B8E5F8;background-image: url(image/regist_bk.png);text-align: center">
	<div  class="border" style="background-color: #FFFDFD;margin: 0 auto;margin-top: 30px;border-radius: 10px;height: 90vh;width: 90%; ">
		<div style="height: 10vh;margin-bottom:10vh">
		<img src="image/DIMTIM.png" height="300vh"/>
		</div>
		 <div style="align-self: center;width:60%;margin: 0 auto;margin-top:15vh">
		<font style="font-size: 24px; font-family: small arial,sans-serif">欢迎使用在线考试系统</font>&nbsp;&nbsp;&nbsp;&nbsp;
		<font style="font-size: 24px; font-family: small arial,sans-serif">学生：</font>
		<font style="font-size: 24px; font-family: small arial,sans-serif ;font-color: #36AAFD">${sessionScope.Student.name}</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button type="button" class="text-center" style="width:12%; height: 40px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 10px;" onclick="window.location.href='/web_big_homework/Logout'">登出</button>
		<button type="button" class="text-center" style="width:12%; height: 40px; 
		border: none; background-color: #36AAFD; color: white;margin-top: 10px;margin-left:10px" onclick="window.location.href='/web_big_homework/Student/index.jsp'">回到首页</button>
		</div>
		<div style="width: 100%;height: 2px;margin-top: 10vh;background-color: #eaeaea;">
		</div>
		<!-- 功能区 -->
		<div class="container" style="margin-top: 20px;">
		<!-- 试题 -->
		<form action="submit_Paper?paperid=${sessionScope.ps.id}&student_name=${Student.name}" method="post" style="width: 100%" id="form1">
		<div style="width: 60%; height: 100%; float: left;">
		<c:set value="1" var="index"></c:set>
			<div style="width: 100%; height: 80%;">
			<dd style="float: left;display: block; width: 100%;" index="${index}" id="${index}">
				<div>
				<p>一、选择题（一共10道题）</p>
				<p>${index}、 ${sessionScope.ps.xzt1qu}</p>
				<p class="aswer-p"><input type="radio" name="${index}" value="A"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt1opA}</span></p>
				<p class="aswer-p"><input type="radio" name="${index}" value="B"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt1opB}</span></p>
				<p class="aswer-p"><input type="radio" name="${index}" value="C"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt1opC}</span></p>
				<p class="aswer-p"><input type="radio" name="${index}" value="D"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt1opD}</span></p>
				<c:set value="${index+1}" var="index"></c:set>
				</div>
			</dd>
			<dd style="float: left;display: none; width: 100%;" index="${index}" id="${index}">
				<div>
				<p>${index}、 ${sessionScope.ps.xzt2qu}</p>
				<p class="aswer-p"><input type="radio" name="${index}" value="A"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt2opA}</span></p>
				<p class="aswer-p"><input type="radio" name="${index}" value="B"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt2opB}</span></p>
				<p class="aswer-p"><input type="radio" name="${index}" value="C"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt2opC}</span></p>
				<p class="aswer-p"><input type="radio" name="${index}" value="D"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt2opD}</span></p>
				<c:set value="${index+1}" var="index"></c:set>
				</div>
			</dd>
			<dd style="float: left;display: none; width: 100%;" index="${index}" id="${index}">
				<div>
				<p>${index}、${sessionScope.ps.xzt3qu}</p>
				<p class="aswer-p"><input type="radio" name="${index}" value="A"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt3opA}</span></p>
				<p class="aswer-p"><input type="radio" name="${index}" value="B"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt3opB}</span></p>
				<p class="aswer-p"><input type="radio" name="${index}" value="C"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt3opC}</span></p>
				<p class="aswer-p"><input type="radio" name="${index}" value="D"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt3opD}</span></p>
				<c:set value="${index+1}" var="index"></c:set>
				</div>
			</dd>
			<dd style="float: left;display: none; width: 100%;" index="${index}" id="${index}">
				<div>
				<p>${index}、${sessionScope.ps.xzt4qu}</p>
				<p class="aswer-p"><input type="radio" name="${index}" value="A"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt4opA}</span></p>
				<p class="aswer-p"><input type="radio" name="${index}" value="B"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt4opB}</span></p>
				<p class="aswer-p"><input type="radio" name="${index}" value="C"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt4opC}</span></p>
				<p class="aswer-p"><input type="radio" name="${index}" value="D"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt4opD}</span></p>
				<c:set value="${index+1}" var="index"></c:set>
				</div>
			</dd>
			<dd style="float: left;display: none; width: 100%;" index="${index}" id="${index}">
				<div>
				<p>${index}、${sessionScope.ps.xzt5qu}</p>
				<p class="aswer-p"><input type="radio" name="${index}" value="A"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt5opA}</span></p>
				<p class="aswer-p"><input type="radio" name="${index}" value="B"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt5opB}</span></p>
				<p class="aswer-p"><input type="radio" name="${index}" value="C"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt5opC}</span></p>
				<p class="aswer-p"><input type="radio" name="${index}" value="D"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt5opD}</span></p>
				<c:set value="${index+1}" var="index"></c:set>
				</div>
			</dd>
			<dd style="float: left;display: none; width: 100%;" index="${index}" id="${index}">
				<div>
				<p>${index}、${sessionScope.ps.xzt6qu}</p>
				<p class="aswer-p"><input type="radio" name="${index}" value="A"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt6opA}</span></p>
				<p class="aswer-p"><input type="radio" name="${index}" value="B"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt6opB}</span></p>
				<p class="aswer-p"><input type="radio" name="${index}" value="C"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt6opC}</span></p>
				<p class="aswer-p"><input type="radio" name="${index}" value="D"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt6opD}</span></p>
				<c:set value="${index+1}" var="index"></c:set>
				</div>
			</dd>
			<dd style="float: left;display: none; width: 100%;" index="${index}" id="${index}">
				<div>
				<p>${index}、${sessionScope.ps.xzt7qu}</p>
				<p class="aswer-p"><input type="radio" name="${index}" value="A"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt7opA}</span></p>
				<p class="aswer-p"><input type="radio" name="${index}" value="B"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt7opB}</span></p>
				<p class="aswer-p"><input type="radio" name="${index}" value="C"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt7opC}</span></p>
				<p class="aswer-p"><input type="radio" name="${index}" value="D"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt7opD}</span></p>
				<c:set value="${index+1}" var="index"></c:set>
				</div>
			</dd>
			<dd style="float: left;display: none; width: 100%;" index="${index}" id="${index}">
				<div>
				<p>${index}、${sessionScope.ps.xzt8qu}</p>
				<p class="aswer-p"><input type="radio" name="${index}" value="A"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt8opA}</span></p>
				<p class="aswer-p"><input type="radio" name="${index}" value="B"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt8opB}</span></p>
				<p class="aswer-p"><input type="radio" name="${index}" value="C"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt8opC}</span></p>
				<p class="aswer-p"><input type="radio" name="${index}" value="D"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt8opD}</span></p>
				<c:set value="${index+1}" var="index"></c:set>
				</div>
			</dd>
			<dd style="float: left;display: none; width: 100%;" index="${index}" id="${index}">
				<div>
				<p>${index}、${sessionScope.ps.xzt9qu}</p>
				<p class="aswer-p"><input type="radio" name="${index}" value="A"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt9opA}</span></p>
				<p class="aswer-p"><input type="radio" name="${index}" value="B"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt9opB}</span></p>
				<p class="aswer-p"><input type="radio" name="${index}" value="C"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt9opC}</span></p>
				<p class="aswer-p"><input type="radio" name="${index}" value="D"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt9opD}</span></p>
				<c:set value="${index+1}" var="index"></c:set>
				</div>
			</dd>
			<dd style="float: left;display: none; width: 100%;" index="${index}" id="${index}">
				<div>
				<p>${index}、${sessionScope.ps.xzt10qu}</p>
				<p class="aswer-p"><input type="radio" name="${index}" value="A"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt10opA}</span></p>
				<p class="aswer-p"><input type="radio" name="${index}" value="B"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt10opB}</span></p>
				<p class="aswer-p"><input type="radio" name="${index}" value="C"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt10opC}</span></p>
				<p class="aswer-p"><input type="radio" name="${index}" value="D"/>&nbsp;<span class="subjectOption">${sessionScope.ps.xzt10opD}</span></p>
				<c:set value="${index+1}" var="index"></c:set>
				</div>
			</dd>
			<!-- 填空题 -->
			<dd style="float: left;display: none; width: 100%;" index="${index}" id="${index}">
				<div>
				<p>二、填空题（一共5道题）</p>
				<p>${index}、${sessionScope.ps.tkt1qu}</p>
				<p class="aswer-p"><input type="text" name="${index}" value="" placeholder="请填入答案"  aria-required="true"/></p>
				<c:set value="${index+1}" var="index"></c:set>
				</div>
			</dd>
			<dd style="float: left;display: none; width: 100%;" index="${index}" id="${index}">
				<div>
				<p>${index}、${sessionScope.ps.tkt2qu}</p>
				<p class="aswer-p"><input type="text" name="${index}" value="" placeholder="请填入答案"  aria-required="true"/></p>
				<c:set value="${index+1}" var="index"></c:set>
				</div>
			</dd>
			<dd style="float: left;display: none; width: 100%;" index="${index}" id="${index}">
				<div>
				<p>${index}、${sessionScope.ps.tkt3qu}</p>
				<p class="aswer-p"><input type="text" name="${index}" value="" placeholder="请填入答案"  aria-required="true"/></p>
				<c:set value="${index+1}" var="index"></c:set>
				</div>
			</dd>
			<dd style="float: left;display: none; width: 100%;" index="${index}" id="${index}">
				<div>
				<p>${index}、${sessionScope.ps.tkt4qu}</p>
				<p class="aswer-p"><input type="text" name="${index}" value="" placeholder="请填入答案"  aria-required="true"/></p>
				<c:set value="${index+1}" var="index"></c:set>
				</div>
			</dd>
			<dd style="float: left;display: none; width: 100%;" index="${index}" id="${index}">
				<div>
				<p>${index}、${sessionScope.ps.tkt5qu}</p>
				<p class="aswer-p"><input type="text" name="${index}" value="" placeholder="请填入答案"  aria-required="true"/></p>
				<c:set value="${index+1}" var="index"></c:set>
				</div>
			</dd>
			<!-- 判断题 -->
			<dd style="float: left;display: none; width: 100%;" index="${index}" id="${index}">
				<div>
				<p>三、判断题（一共3道题）</p> 
				<p>${index}、${sessionScope.ps.pdt1qu}</p>
				<p class="aswer-p"><input type="radio" name="${index}" value="yes"/>&nbsp;<span class="subjectOption">Yes</span></p>
				<p class="aswer-p"><input type="radio" name="${index}" value="no"/>&nbsp;<span class="subjectOption">No</span></p>
				<c:set value="${index+1}" var="index"></c:set>
				</div>
			</dd>
			<dd style="float: left;display: none; width: 100%;" index="${index}" id="${index}">
				<div>
				<p>${index}、${sessionScope.ps.pdt2qu}</p>
				<p class="aswer-p"><input type="radio" name="${index}" value="yes"/>&nbsp;<span class="subjectOption">Yes</span></p>
				<p class="aswer-p"><input type="radio" name="${index}" value="no"/>&nbsp;<span class="subjectOption">No</span></p>
				<c:set value="${index+1}" var="index"></c:set>
				</div>
			</dd>
			<dd style="float: left;display: none; width: 100%;" index="${index}" id="${index}">
				<div>
				<p>${index}、${sessionScope.ps.pdt3qu}</p>
				<p class="aswer-p"><input type="radio" name="${index}" value="yes"/>&nbsp;<span class="subjectOption">Yes</span></p>
				<p class="aswer-p"><input type="radio" name="${index}" value="no"/>&nbsp;<span class="subjectOption">No</span></p>
				<c:set value="${index+1}" var="index"></c:set>
				</div>
			</dd>
			
			<!-- 简答题 -->
			<dd style="float: left;display: none; width: 100%;" index="${index}" id="${index}">
				<div>
				<p>四、简答题（一共2道题）</p>
				<p>${index}、${sessionScope.ps.jdt1qu}</p>
				<p class="aswer-p"><textarea class="aswer-textarea" name="${index}" style="width:100%;height:100px;"></textarea></p>
				<c:set value="${index+1}" var="index"></c:set>
				</div>
			</dd>
			<dd style="float: left;display: none; width: 100%;" index="${index}" id="${index}">
				<div>
				<p>${index}、${sessionScope.ps.jdt2qu}</p>
				<p class="aswer-p"><textarea class="aswer-textarea" name="${index}" style="width:100%;height:100px;"></textarea></p>
				<c:set value="${index+1}" var="index"></c:set>
				</div>
			</dd>
			
			<!-- 编程题 -->
			<dd style="float: left;display: none; width: 100%;" index="${index}" id="${index}">
				<div>
				<p>五、编程题（一共2道题）</p>
				<p>${index}、${sessionScope.ps.bct1qu}</p>
				<p class="aswer-p"><textarea class="aswer-textarea" name="${index}" style="width:100%;height:100px;" ></textarea></p>
				<c:set value="${index+1}" var="index"></c:set>
				</div>
			</dd>
			<dd style="float: left;display: none; width: 100%;" index="${index}" id="${index}"> 
				<div>
				<p>${index}、${sessionScope.ps.bct2qu}</p>
				<p class="aswer-p"><textarea class="aswer-textarea" name="${index}" style="width:100%;height:100px;" ></textarea></p>
				<c:set value="${index+1}" var="index"></c:set>
				</div>
			</dd>
			
			
			</div>
			<div style="width:100%; height:20%; margin-top: 170px;">
				<button  class = "btn1" id="preSubject" type="button" >上一题</button>
				<button style="margin-left: 20px" class = "btn1" id="nextSubject" type="button">下一题</button>
			</div>
		</div>
		
		<!-- 答题卡 -->
		<span id="beginTime" style="display: none;">${sessionScope.ps.starttime}</span>
		<span id="examTime" style="display: none;">${sessionScope.ps.endtime}</span>
		<input name="stu_name" style="display: none" value="${sessionScope.Student.name}" />
		<input name="stu_number" style="display: none" value="${sessionScope.Student.getId()}" />
		<input name="stu_class" style="display: none" value="${sessionScope.Student.studentclass}" />
		<input name="paper_id" style="display: none" value="${sessionScope.ps.id}" />
		<div>
		<button style="display:none" type="button" class="" onclick="automatic"></button>
		<button  class = "btn1" type="submit" onclick="return confirm('确定提交吗?')">提交试卷</button>
		<br><div style="margin-top:60px"><font style="font-weight: 25;font-size: 25px;">剩余时间</font></div>
		<div class="container timeBar ys1" data="${sessionScope.time}" ></div>
		</div>
		</form>
	</div>

	
	</div>
	<script language="javascript" src="js/bootstrap.min.js">
	</script>
	<!-- js引入 -->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="./Student/js/countdown.js"></script> 
    <script type="text/javascript">
    $(function(){
    	var cur=1;
    	function goo(cur,curg){
    		if(curg<1){
    			curg=1
    		}
    		if(curg>22){
    			curg=22
    		}
    		if(cur<1){
    			cur=1
    		}
    		if(cur>22){
    			cur=22
    		}
    		var curid=document.getElementById(cur.toString());
    		var curgid=document.getElementById(curg.toString());
    		 curid.style.display= "none";
    		 curgid.style.display = "block";
    		
    	}
    	$("#preSubject").click(
    			function (){
    				var curg=cur-1;
    				goo(cur,curg);
    				cur--;
    			}
    			);
    	$("#nextSubject").click(
    			function (){
    				var curg=cur+1;
    				goo(cur,curg);
    				cur++;
    			}
    			);
    });
    
    $(function(){
		$(".timeBar").each(function () {
			$(this).countdownsync({
				dayTag: "",
				hourTag: "<label class='tt hh dib vam'>00</label><span>时</span>",
				minTag: "<label class='tt mm dib vam'>00</label><span>分</span>",
				secTag: "<label class='tt ss dib vam'>00</label><span>秒</span>",
				dayClass: ".dd",
				hourClass: ".hh",
				minClass: ".mm",
				secClass: ".ss",
				isDefault: false,
				showTemp:1

			}, function () {
				document.getElementById('form1').submit();
			});
		});
	});
    
    </script>
	</body>
</html>
