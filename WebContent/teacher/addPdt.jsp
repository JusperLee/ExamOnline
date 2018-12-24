<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>添加填空题</title>
        <style type="text/css">
        	#div1{
        		width: 840px;
        		height: 550px;
        		border: gainsboro 1px solid;
        		border-color:#36AAFD
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
        	}
        	#tab1 .xzchoose{
        		margin-left: 20px;
        		/*width: 120px;*/
        		text-align: center;
        		font-size:20px;
        		font-family:small arial,sans-serif
        		/*border: 1px red solid;*/
        	}
        	#xztitle,.xzcon,#key{
        		width: 750px;
        		/*border: 1px red solid;*/
        		height: 50px;
        		border-color:#36aafd94
        	}
        </style>
    </head>
    <body>
    	<div id="div1" style="width:100%">
    		<form action="../InsertQuestion?questiontype=pdt" method="post">
    		<table id="tab1" style="margin:0 auto;width:50%">
    			<tr>
    				<td colspan="2" style="text-align: center; font-size:20px;font-family:small arial,sans-serif">填空题</td>
    			</tr>
    			<tr>
    				<td class="xzchoose" >知识点</td>
    				<td >
    					<input type="text"  name="questionpoint" id="xztitle" placeholder="请输入题目"/>	
    				</td>
    			</tr>
    			<tr>
    				<td class="xzchoose" >题目</td>
    				<td >
    					<input type="text"  name="question" id="xztitle" placeholder="请输入题目"/>	
    				</td>
    			</tr>
    			<tr>
    				<td class="xzchoose">答案</td>
    				<td><input type="text" name="answer" placeholder="请输入答案" id="key"/></td>
    			</tr>
    			<tr>
    				<td ></td>
    				<td  style="text-align: right;">
    					<input type="submit" value="提交" style="border: none;width: 150px;height: 50px;background-color: #36AAFD;"/>
    				</td>
    			</tr>	
    		
    		</table>
    		</form>
    	</div>
 	</body>
</html>