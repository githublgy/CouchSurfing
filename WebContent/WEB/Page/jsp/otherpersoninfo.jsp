<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="com.couchsurfing.entity.User"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	User user = null;
	if(request.getAttribute("user")!=null){
		user =(User)request.getAttribute("user");
		
	}
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>他人信息</title>   
       <link href="/CouchSurfing/WEB/Common/css/common.css" rel="stylesheet">
        <link href="/CouchSurfing/WEB/Page/css/img_account.css" rel="stylesheet">
        <link href="/CouchSurfing/WEB/Page/css/jquery.Jcrop.min.css" rel="stylesheet">
        
       <link href="/CouchSurfing/WEB/Page/css/personal_info.css" rel="stylesheet">
      
        <base href="<%=basePath%>" />
    </head>
    <body class="bodydiv">
       <div><jsp:include page="/WEB/Common/jsp/header.jsp" flush="true" /></div>
       <div class="personcenter">
         	<div  class="pnav"  style="height:290px;">
         	<div  style="text-align: center;color: #444;margin-bottom: 10px;font-size: 13px;">头像</div>
         	<div class="imgdiv"><img  alt="" src="/CouchSurfing/WEB/Image/<%=  user.getUserHead() %>" width="100%" height="100%"> </div>
         		<div  style="text-align: center;color: #444;margin-bottom: 10px;font-size: 13px;"><%= user.getNickName()%></div>	
         			   
         
         				
         			
         		
         	
         	
         	</div>
         	<div  class="pcon" id="pcon1"  style="height:320px;">
         	    <div class="biaoti" id="biaoti">他的资料</div>
         		<div class="person_info">   
         	        <table class="person_info_table" >
						<tr>
							<td class="td1">昵称:<span id="userId" style="display:none"><%= user.getUserId()%></span></td>
							<td><input id="nickNamea" type="text" placeholder="请输入昵称" value="<%= user.getNickName()!=null?user.getNickName():"无" %>"></td>
						</tr>
						<tr>
							<td>性别:</td>
							
							<td><input type="text" name="sex" value="<%=user.getUserSex() %>"></td>
						</tr>
						<tr>
							<td>手机号(账号):</td>
							<td><input id="userNamea"  type="text" value="<%=   user.getUserName()!=null?user.getUserName():"无"%>"></td>
						</tr>
						<tr>
							<td>QQ:</td>
							<td><input  id="userQq" type="text" value="<%=   user.getUserQq()!=null&&!user.getUserQq().equals("")?user.getUserQq():"无"%>"></td>
						</tr>
						
						<tr>
							<td>邮箱:</td>
							<td><input  id="userEmail" type="text"  value="<%=   user.getUserEmail()!=null&&! user.getUserEmail().equals("")?user.getUserEmail():"无" %>"></td>
						</tr>
						<tr>
							<td>地区:</td>
							<td><input  type="text"  value="<%=   user.getUserRegion()!=null&&! user.getUserRegion().equals("")?user.getUserRegion():"无" %>"></td>
						</tr>
						<tr>
							<td valign="top">个性签名:</td>
							<td>
								<textarea  id="userSignature" rows="3" cols="25"  ><%= user.getUserSignature()!=null&&!user.getUserSignature().equals("")?user.getUserSignature():"无"%></textarea>
							
							
							</td>
						</tr>
					<tr>
						<td></td>
						
					</tr>
				</table>
         		
         		
         		 </div>
         	
         	
         	</div>
         	
         	
         	
         	
         	
         	<!-- 
         	<div  class="pcon" id="pcon4" style="display: none;">
         	    <div class="biaoti" id="biaoti">他的帖子</div>
         		<div class="person_info">   
         	       
         		
         		
         		 </div>
         	
         	
         	</div> -->
       
       </div>
       
       
       
        
    <div><jsp:include page="/WEB/Common/jsp/footer.jsp" flush="true" /></div>
        <script src="TOOL/jquery.min.js"></script>
      
        <script src="WEB/Page/js/otherpersonal_info.js"></script>
       
      
    </body>
</html>