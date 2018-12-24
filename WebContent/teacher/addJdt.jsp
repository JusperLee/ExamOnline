<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>添加编程题</title>
        <style type="text/css">
        	#div1{
        		width: 840px;
        		height: 550px;
        		border: gainsboro 1px solid;
        	}
        	#tab1{
        		margin-left: 20px;
        		margin-top: 20px;
        		margin-right: 20px;
        		/*border: 1px black solid;*/
        		width: 800px;
        		height: 500px;
        	}
        	#tab1 td{
        		width: 100%;
        		height: 20px;
        		font-size:20px;
        		font-family:small arial,sans-serif
        	}
        	#tab1 .bcchoose{
        		margin-left: 20px;
        		/*width: 120px;*/
        		text-align: center;
        		/*border: 1px red solid;*/
        		font-size:20px;
        		font-family:small arial,sans-serif
        	}
        	#bctitle,#key{
        		width: 750px;
        		/*border: 1px red solid;*/
        		height: 50px;
        		border-color:#36aafd94
        	}
        </style>
    </head>
    <body>
    	<div id="div1" style="width:100%">
    		<form action="../InsertQuestion?questiontype=jdt" method="post" enctype="multipart/form-data">
    		<table id="tab1" style="margin:0 auto;width:50%">
    			<tr>
    				<td colspan="2" style="text-align: center;">简答题</td>
    			</tr>
    			<tr>
    				<td class="bcchoose">题目</td>
    				<td >
    					<input type="text" value="" name="question" id="bctitle" placeholder="请输入题目"/>	
    				</td>
    			</tr>
    			<tr>
    				<td class="tkchoose" >知识点</td>
    				<td >
    					<input type="text"  name="questionpoint" id="bctitle" placeholder="请输入题目"/>	
    				</td>
    			</tr>
    			<tr>
    				<td class="bcchoose">答案</td>
    				<td><input type="text" value=""placeholder="请输入答案" id="key"/></td>
    			</tr>
    			<tr>
    				<td ></td>
    				<td  style="text-align: right;">
    					<input type="submit" value="提交" style="border: none;width: 150px;height: 50px;background-color: #36AAFD;"/>
    				</td>
    			</tr>	
    		</form>
    		</table>
    	</div>
 	</body>
</html>