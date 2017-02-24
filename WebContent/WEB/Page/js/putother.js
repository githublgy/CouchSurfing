var editor;
$(document).ready(function() {
	$(".currentlocation").html("发布帖子");
	
	
	KindEditor.ready(function(K) {
	    editor = K.create('#editor_id',{
	    	cssPath:'/CouchSurfing/TOOL/kindeditor-4.1.10/plugins/code/prettify.css',
	    	
	    	uploadJson:'/CouchSurfing/TOOL/kindeditor-4.1.10/jsp/upload_json.jsp',
	    	
	    	
	      });
	});
	
});
function getKindEditorhtml(){
	//editor.sync();
	var html=editor.html();
	//alert($("#postTheme").val()+$("#userId").html()+$("#postType").val());
	if(html==""){
		alert("请输入内容");
	}else{
		
		$.post("./PutOtherPostAction.html",
				{postTheme:$("#postTheme").val(),
			     userId:$("#userId").html(),
			     postContent:html,
			     postType:$("#postType").val(),
			     },
			     
				  function(data){
				    if(data.flag){
				    	alert("发表成功！");
				    	history.go(0);
				    }else{
				    	
				    	alert("发表失败！");
				    }
				     
				  },
				  "json");//这里返回的类型有：json,html,xml,text
				
	}
	
}