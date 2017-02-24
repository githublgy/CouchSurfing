var editor;
$(document).ready(function() {
	$(".currentlocation").html("帖子详情");
	
	
	KindEditor.ready(function(K) {
	    editor = K.create('#editor_id',{
	    	cssPath:'/CouchSurfing/TOOL/kindeditor-4.1.10/plugins/code/prettify.css',
	    	resizeType:0,
	    	uploadJson:'/CouchSurfing/TOOL/kindeditor-4.1.10/jsp/upload_json.jsp',
	    	items : [
	                    'fontname','fontsize', '|','forecolor', 'hilitecolor','bold', 'italic','underline',
	                    'removeformat','|', 'justifyleft','justifycenter', 'justifyright','insertorderedlist',
	                    'insertunorderedlist','|', 'emoticons','link','media','|','image']  
	    	
	      });
	});
	
});
function fatiebtn(){
	location.href="WEB/Page/jsp/putOther.jsp";
	
	
}
function getKindEditorhtml(){
	//editor.sync();
	var html=editor.html();
	//alert(html);
	if(html==""){
		alert("请输入内容");
	}else{
		
		$.post("./OtherPostReplayAction.html",
				{postId:$("#otherPostId").html(),
			     userId:$("#userId").html(),
			     replayContent:html
			     },
			     
				  function(data){
				    if(data.flag){
				    	alert("回复成功！");
				    	history.go(0);
				    }else{
				    	
				    	alert("回复失败！");
				    }
				     
				  },
				  "json");//这里返回的类型有：json,html,xml,text
				
		
		
	}
	
	
	
	
}
//下一页
function pageprev(){
	var otherPostId = $("#otherPostId").html();
	var page = $("#pageselect").val();
	var allpage = $("#allpage").html();
//	alert(page);
	if(page==allpage){
		alert("已经最后一页");
		
	}else{
		location.href="OtherPostDetailAction.html?page="+(++page)+"&pid="+parseInt(otherPostId);
	 
	}
}
//上一页
function pageback(){
	var otherPostId = $("#otherPostId").html();
	var page = $("#pageselect").val();
     if(page==1){
		
		alert("已经第一页");
		
	}else{
		location.href="OtherPostDetailAction.html?page="+(--page)+"&pid="+parseInt(otherPostId);
		
	}
}
//首页
function indexpage(){
	var otherPostId = $("#otherPostId").html();
	
	var page = $("#pageselect").val();
    if(page==1){
		
		alert("已经是首页");
		
	}else{
	   location.href="OtherPostDetailAction.html?page=1"+"&pid="+parseInt(otherPostId);
	}
	
}
//跳转
function pageinto(){
	var otherPostId = $("#otherPostId").text();
	
	var page = $("#pageselect").val();
	location.href="OtherPostDetailAction.html?page="+page+"&pid="+parseInt(otherPostId);
}