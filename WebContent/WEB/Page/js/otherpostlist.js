$(document).ready(function() {
	
	$(".currentlocation").html("帖子");
	
	
	
});
function fatiebtn(){
	location.href="WEB/Page/jsp/putOther.jsp";
	
	
}
//下一页
function pageprev(){
	var type = $("#otherposttype").html();
	var page = $("#pageselect").val();
	var allpage = $("#allpage").html();
//	alert(page);
	if(page==allpage){
		alert("已经最后一页");
		
	}else{
		location.href="OtherPostAction.html?page="+(++page)+"&type="+type;
	 
	}
}
//上一页
function pageback(){
	var type = $("#otherposttype").html();
	var page = $("#pageselect").val();
     if(page==1){
		
		alert("已经第一页");
		
	}else{
		location.href="OtherPostAction.html?page="+(--page)+"&type="+type;
		
	}
}
//首页
function indexpage(){
	var type = $("#otherposttype").html();
	var page = $("#pageselect").val();
    if(page==1){
		
		alert("已经是首页");
		
	}else{
	   location.href="OtherPostAction.html?page=1"+"&type="+type;
	}
	
}
//跳转
function pageinto(){
	
	var type = $("#otherposttype").html();
	var page = $("#pageselect").val();
	location.href="OtherPostAction.html?page="+page+"&type="+type;;
}