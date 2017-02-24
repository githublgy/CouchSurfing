$(document).ready(function() {
	$(".currentlocation").html("发布沙发帖子");
	
	
	
});
function xuanzhong(a){
	var str = ["①","②", "③","④","⑤","⑥","⑦"];
	var length = a.length;
	var s="";
	var j=0;
	for(var i=0;i<length;i++){
		if(a.eq(i).is(':checked')){
			s=s+str[j]+a.eq(i).val();
			j++;
		}
	}
	
	return s;
	
	
}
function putpost(){
	var sofaarea = $("#sofaarea").val();
	var postTheme = $("#postTheme").val();
	var postAddress = $("#postAddress").val();
	var postType = $("#postType").val();
	var postHasTime = $("#postHasTime").val();
	var postRenshu = $("#postRenshu").val();
	var postSex = $("#postSex").val();
	var postAge = $("#postAge").val();
	var postdays = $("#postdays").val();
	
	var PostGoods = xuanzhong($(".PostGoods"));
	
	
	var PostRemark = $("#PostRemark").val();
	
	
	var PostContact = $("#PostContact").val();
	

	//alert(sofaarea+postTheme+postAddress+postType+PostGoods+postHasTime+postSex+postRenshu+postAge+postdays+PostRemark+PostContact);
	
	if(postTheme==""&&postAddress==""&&PostGoods==""&&PostContact==""){
		alert("请检查帖子信息是否输入完整！");
	}else{
		
		$.post("./PutSofaPost.html",
				{sofaarea:sofaarea,
			     userId:$("#userId").html(),
			     postTheme:postTheme,
			     postAddress:postAddress,
			     postType:postType,
			     postHasTime:postHasTime,
			     postRenshu:postRenshu,
			     postSex:postSex,
			     postAge:postAge,
			     postdays:postdays,
			     PostGoods:PostGoods,
			     PostRemark:PostRemark,
			     PostContact:PostContact
			    
			     },
			     
				  function(data){
				    if(data.flag){
				    	alert("发帖成功！");
				    	history.go(0);
				    }else{
				    	
				    	alert("发帖失败！");
				    }
				     
				  },
				  "json");
		
	}
	
	
	
}