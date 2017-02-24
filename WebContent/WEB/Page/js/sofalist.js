$(document).ready(function() {
	
	$(".currentlocation").html("我有沙发");
	
	//getallpost(1);
	
});
function searchpost(){
	var selectsheng = $("#selectsheng").val();

	location.href="getSofaPostAction.html?page=1&region="+selectsheng;
}
function fatiebtn(){
	location.href="WEB/Page/jsp/putsofa.jsp";
	
	
}
//下一页
function pageprev(){
	var selectsheng = $("#selectsheng").val();
	var page = $("#pageselect").val();
	var allpage = $("#allpage").html();
//	alert(page);
	if(page==allpage){
		alert("已经最后一页");
		
	}else{
		location.href="getSofaPostAction.html?page="+(++page)+"&region="+selectsheng;
	 
	}
}
//上一页
function pageback(){
	var selectsheng = $("#selectsheng").val();
	var page = $("#pageselect").val();
     if(page==1){
		
		alert("已经第一页");
		
	}else{
		location.href="getSofaPostAction.html?page="+(--page)+"&region="+selectsheng;
		
	}
}
//首页
function indexpage(){
	var selectsheng = $("#selectsheng").val();
	var page = $("#pageselect").val();
    if(page==1){
		
		alert("已经是首页");
		
	}else{
	   location.href="getSofaPostAction.html?page=1"+"&region="+selectsheng;
	}
	
}
//跳转
function pageinto(){
	var selectsheng = $("#selectsheng").val();
	var page = $("#pageselect").val();
	location.href="getSofaPostAction.html?page="+page+"&region="+selectsheng;;
}

//function getallpost(page){
//	$.getJSON("./getSofaPostAction.html",
//			{"page" : page
//			    }
//			, 
//			function(json) {
//				$(".posttable").remove();
//				$(".pagination").remove();
//				if(json.sofaPostList.length!=0){
//					$(".allpostlist").append("<table class='posttable' border='0' cellpadding='3' cellspacing='0' width='100%'>" +
//							"<tr><th width=\"60%\" style=\"padding-left: 70px;\">主题</th><th width=\"20%\">作者</th><th width=\"20%\">时间</th></tr>");
//					for(var i=0;i<json.sofaPostList.length;i++){		
//							
//							"<tr><td width=\"60%\" style=\"padding-left: 20px;\"><span style=\"color: #007CD5; margin-right: 10px;\">" +
//							+"</span>" +
//							json.user.userId+"</td><td>" +
//							json.user.userName+"</td><td ><a href='userServlet.jhtml?un=" +
//									json.user.userId+"&methodName=getUserByUserName'    style='color:#11449E'>查看</a></td></tr>"
//							);
//					}
//					
//					
//					
//				}else{
//					
//				   $("#userlist").append("<table class='commontable' border='0' cellpadding='3' cellspacing='0' width='100%'>" +
//									"<tr><th>用户不存在</th></tr>");
//				}
//			});
//	
//	
//	
//	
//}