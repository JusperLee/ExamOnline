function validate() {
    var pwd1 = document.getElementById("password").value;
    var pwd2 = document.getElementById("password1").value;
    if(pwd1 == pwd2) {
        document.getElementById("tishi").innerHTML="<font color='green'>输入正确</font>";
        document.getElementById("submit").disabled = false;
    }
    else {
      document.getElementById("tishi").innerHTML="<font color='red'>两次密码不相同</font>";
      document.getElementById("submit").disabled = true;
    }
}

function check_tel(){
	var tel_num = document.getElementById("tel_num2").value;
	var myreg = /^1[2|3|4|5|6|7|8|9]\d{9}$/;
    if (tel_num == '') {
		document.getElementById("tel_tishi").innerHTML="<font color='red'>手机号码不能为空！</font>";
    } else if (tel_num.length != 11) {
        document.getElementById("tel_tishi").innerHTML="<font color='red'>请输入11位手机号码！</font>";
    } else if (!myreg.test(tel_num)) {
        //console.log("请输入有效的手机号码！");
        document.getElementById("tel_tishi").innerHTML="<font color='red'>请输入有效的手机号码！</font>";
    } else {
        document.getElementById("tel_tishi").innerHTML="<font color='green'>输入正确！</font>";
    }
}