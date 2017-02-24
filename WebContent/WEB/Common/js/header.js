$(document).ready(function(){
	
	
	
	$("#loginbtn").click(function(){
		
		var name = $("#name").val();
		var pwd = $("#pwd").val();
		
		if(name!=""&&pwd!=""){
			
			$.getJSON("./loginAction.html",
					{"username" : name,
				  "password":  pwd }
					, 
					function(json) {
						
						if(json.flag){
							 location.reload() 
						}else{
							
							alert("账户或密码错误！")
						}
					});
			
		}else{
			
			
			alert("请输入账户或密码！")
		}
		
		
		
		
		
		
		
		
		
		
		
	});
	

});

function closebutton(){
	$("#popup1").hide();
	$(".mask").hide();
	
};
function  popupwindows(){
	tanchukuang();
	$("#popup1").show();
	$(".mask").show();
	
}
function tanchukuang(){
	//获取页面的高度和宽度
	//var sWidth=document.body.scrollWidth+"px";
	var sHeight=document.body.scrollHeight+"px";
	//获取页面的可视区域高度和宽度
	var wHeight=document.documentElement.clientHeight;
	var wwidth=document.documentElement.clientWidth;
	//alert(wHeight);
	//alert(wwidth);
	$(".mask").css({"height":sHeight});
	
	$(".zhuce").css({"height":sHeight});
//	var height=(wHeight/2-160)+"px";
//	var width=(wwidth/2-155)+"px";
//	$(".login").css({"top":height,"left":width});
	//$(".mask").css({"height":"sHeight"});
}
function zhucebtn(){
	var passWord = $("#passWord").val();
	var nickName = $("#nickName").val();
	var userName = $("#userName").val();
	if(passWord==""||nickName==""||userName==""){
		alert("输入不能为空！");
		
	}else{
		
			
			$.post("./ZhuceUser.html",
					{
				nickName:nickName,
				userName:userName,
				userPassword:passWord
				     
				     
				     },
				     
					  function(data){
					    if(data.flag){
					    	alert("注册成功！");
					    	history.go(0);
					    }else{
					    	
					    	alert("用户已存在，注册失败！");
					    }
					     
					  },
					  "json");// 这里返回的类型有：json,html,xml,text
		
		
		
	}
	
}
