$(document).ready(function() {
	$(".currentlocation").html("个人中心");
	
	
	
});
function tiaozhuan(a){
	switch (a) {
	case 1:
		$("#pcon1").show();
		$("#pcon2").hide();
		$("#pcon3").hide();
		$("#pcon4").hide();
		

		break;
	case 2:
		$("#pcon1").hide();
		$("#pcon2").show();
		$("#pcon3").hide();
		$("#pcon4").hide();
		break;
	case 3:
		$("#pcon1").hide();
		$("#pcon2").hide();
		$("#pcon3").show();
		$("#pcon4").hide();
		break;
	case 4:
		$("#pcon1").hide();
		$("#pcon2").hide();
		$("#pcon3").hide();
		$("#pcon4").show();
		break;

	default:
		break;
	}
	
	
}

function  saveuserPassword(){
	var pw = $("#pw").val();
	var repw = $("#repw").val();
	if(pw==""||repw==""){
		alert("输入不能为空！");
		
	}else{
		if(pw!=repw){
			alert("两次密码不一样！");
			
		}else{
			
			$.post("./ModfiyUserPw.html",
					{
				     userId:$("#userId").html(),
				    
				   
				     userPassword:pw
				     
				     },
				     
					  function(data){
					    if(data.flag){
					    	alert("修改成功！");
					    	history.go(0);
					    }else{
					    	
					    	alert("修改失败！");
					    }
					     
					  },
					  "json");// 这里返回的类型有：json,html,xml,text
		}
		
		
	}
	
	
}
function saveuserbtn(){
		
//	var sex = $("input:radio:checked").val();
	//alert($("#userId").html()+$("#userRegion").val()+$("#userSignature").val()+$("#nickNamea").val());
	if($("#userNamea").val()!=""&&$("#nickNamea").val()!=""){ 
		
	$.post("./SaveUserAction.html",
			{
		     userId:$("#userId").html(),
		     nickName:$("#nickNamea").val(),
		     userName:$("#userNamea").val(),
		     userQq:$("#userQq").val(),
		     userEmail:$("#userEmail").val(),
		     userRegion:$("#userRegion").val(),
		     userSignature:$("#userSignature").val(),
		   
		     userSex:$("input:radio:checked").val()
		     
		     },
		     
			  function(data){
			    if(data.flag){
			    	alert("修改成功！");
			    	history.go(0);
			    }else{
			    	
			    	alert("修改失败！");
			    }
			     
			  },
			  "json");// 这里返回的类型有：json,html,xml,text
	}else{
		alert("账号和昵称不能为空！");
		
	}
	
	
}
//设置图片上传校验
function checkImage() {
	if ($("#imgOne").val() == "") {
		alert("请先选择上传照片");
	} else {
		document.forms["headForm"].submit();
	}
}



/* =================== 头像、计划图片上传通用JS =================== */
/**
 * 将本地图片 显示到浏览器上
 */
function preImg(sourceId) {

	if(!isNormalPic())
		return;
	//每次利用空间显示数据时初始化jcrop控件
	if(typeof(jcrop_api) != "undefined") {
		jcrop_api.destroy();
		$("#target").removeAttr("style");
	}
	//获得图片的保存路径
	var url = getFileUrl(sourceId);
	//显示经过等比缩放后的大图
	$("#target").attr("src",url);
	//显示用户默认框选等比缩放预览图
	$("#litte_pre").attr("src",url);
	//保存没有缩放后的图片
	$('#org_file').attr("src",url);
	//裁剪空间初始化
	init_Jcrop();
}


//初始化Jcrop控件
function init_Jcrop() {

	$('#target').Jcrop({
		onChange: updatePreview,
		onSelect: updatePreview,
		aspectRatio: xsize / ysize,
		allowSelect:false
	}, function () {
		var bounds = this.getBounds();
		boundx = bounds[0];
		boundy = bounds[1];
		jcrop_api = this;
		jcrop_api.animateTo([0, 0, 200, 200]);
		//
		$('#ratio').val($('#org_file').width() / boundx);
	});
}


//获得图片的保存路径
function getFileUrl(sourceId) {
	var url;
	if (navigator.userAgent.indexOf("MSIE")>=1) { // IE
		url = document.getElementById(sourceId).value;
	} else if(navigator.userAgent.indexOf("Firefox")>0) { // Firefox
		url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0));
	} else if(navigator.userAgent.indexOf("Chrome")>0) { // Chrome
		url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0));
	}

	return url;
}



//更新小预览图
function updatePreview(c){

	if (parseInt(c.w) > 0) {
		var rx = xsize / c.w;
		var ry = ysize / c.h;

		$pimg.css({
			width: Math.round(rx * boundx) + 'px',
			height: Math.round(ry * boundy) + 'px',
			marginLeft: '-' + Math.round(rx * c.x) + 'px',
			marginTop: '-' + Math.round(ry * c.y) + 'px'
		});

		$('#x1').val(c.x);
		$('#y1').val(c.y);
		$('#x2').val(c.x2);
		$('#y2').val(c.y2);
		$('#w').val(c.w);
		$('#h').val(c.h);
	}
};



//验证文件类型与文件大小
function isNormalPic(){

	var fileName = document.getElementById("imgOne").value;

	if(fileName.trim() == "")
		return false;

	var fileSize = document.getElementById('imgOne').files[0].size;

	var str = fileName.substring(fileName.lastIndexOf("\\")+1);
	var end = str.substring(str.indexOf(".")+1);
	if(fileName !=null && (end.toLowerCase() != "png" && end.toLowerCase() != "jpg" && end.toLowerCase() != "gif")){
		alert("头像目前只支持(PNG、GIF、JPG)");
		return false;
	}

	if(fileSize > 2 * 1024 * 1024) {
		alert("上传文件不能超过(2Mb)");
		return false;
	}
	return true;
}







