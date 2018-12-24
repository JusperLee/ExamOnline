var countdown=60; 
function settime(obj) {
	var tel_text = document.getElementById('tel_num2')
	if(tel_text!="" || tel_text!=null){
		if (countdown == 0) { 
	        obj.removeAttribute("disabled");    
	        obj.value="免费获取验证码"; 
	        countdown = 60; 
	        
	        return;
	    } else { 
	        obj.setAttribute("disabled", true); 
	        obj.value="重新发送(" + countdown + ")"; 
	        countdown--; 
	    }
	    if(countdown==59){
	    	var number=rand(1000,9999);
	    	var tel=document.getElementById("tel_num2").value;
	    	$.ajax({
	    	    type: "POST",
	    	    url: "/web_big_homework/Send?number="+number+"&tel="+tel,
	    	    success:function(data){  
	    	        //TODO
	    	    } 
	    	})
	    }
	setTimeout(function() { 
	    settime(obj) }
	    ,1000) 
	}
}
function rand(min,max) {
    return Math.floor(Math.random()*(max-min))+min;
}
/*var btn=document.getElementById("btn");
btn.onclick=function(){
    var randnum=rand(1000,9999);
    document.getElementById("num").innerHTML=randnum;
}！*/