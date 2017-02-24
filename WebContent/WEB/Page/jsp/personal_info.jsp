<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="com.couchsurfing.entity.User"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	User user = null;
	if(session.getAttribute("user")!=null){
		user =(User)session.getAttribute("user");
		
	}
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>个人中心</title>   
       <link href="/CouchSurfing/WEB/Common/css/common.css" rel="stylesheet">
        <link href="/CouchSurfing/WEB/Page/css/img_account.css" rel="stylesheet">
        <link href="/CouchSurfing/WEB/Page/css/jquery.Jcrop.min.css" rel="stylesheet">
        
       <link href="/CouchSurfing/WEB/Page/css/personal_info.css" rel="stylesheet">
      
        <base href="<%=basePath%>" />
    </head>
    <body class="bodydiv">
       <div><jsp:include page="/WEB/Common/jsp/header.jsp" flush="true" /></div>
       <div class="personcenter">
         	<div  class="pnav">
         	<div class="imgdiv"><img  alt="" src="/CouchSurfing/WEB/Image/<%=  user.getUserHead() %>" width="100%" height="100%"> </div>
         			<ul  style="margin:0;padding: 0; ">
         			   
         				<li onclick="tiaozhuan(1)" id="li1"> &nbsp;<img alt="" src="/CouchSurfing/WEB/Page/image/info.png" >&nbsp;个人信息 </li>
         				<li onclick="tiaozhuan(2)" id="li2">&nbsp;<img alt="" src="/CouchSurfing/WEB/Page/image/ue.png">&nbsp;头像编辑   </li>
         				<li onclick="tiaozhuan(3)" id="li3"> &nbsp;<img alt="" src="/CouchSurfing/WEB/Page/image/pw.png">&nbsp;修改密码 </li>
         				<!-- <li onclick="tiaozhuan(4)" id="li4">&nbsp;<img alt="" src="/CouchSurfing/WEB/Page/image/post.png">&nbsp;我的帖子 </li> -->
         			
         			</ul>
         	
         	
         	</div>
         	<div  class="pcon" id="pcon1">
         	    <div class="biaoti" id="biaoti">个人信息编辑</div>
         		<div class="person_info">   
         	        <table class="person_info_table" >
						<tr>
							<td class="td1">昵称:<span id="userId" style="display:none"><%= user.getUserId()%></span></td>
							<td><input id="nickNamea" type="text" placeholder="请输入昵称" value="<%= user.getNickName()!=null?user.getNickName():"" %>"></td>
						</tr>
						<tr>
							<td>性别:</td>
							<% int i=0;
							if(user.getUserSex()!=null){
							  if(user.getUserSex().equals("男")){i=1;}else{i=2;}} %>
							<td><input type="radio" name="sex" <%= i==1?"checked='checked'":"" %>value="男">男<input type="radio" name="sex" <%= i==2?"checked='checked'":"" %> value="女">女</td>
						</tr>
						<tr>
							<td>手机号(账号):</td>
							<td><input id="userNamea"  type="text" value="<%=   user.getUserName()!=null?user.getUserName():""%>"></td>
						</tr>
						<tr>
							<td>QQ:</td>
							<td><input  id="userQq" type="text" value="<%=   user.getUserQq()!=null?user.getUserQq():""%>"></td>
						</tr>
						
						<tr>
							<td>邮箱:</td>
							<td><input  id="userEmail" type="text"  value="<%=   user.getUserEmail()!=null?user.getUserEmail():"" %>"></td>
						</tr>
						<tr>
							<td>地区:</td>
							<td><select  id="userRegion">
			<option value="选择地区">选择地区</option>
			<option value="北京市">北京市</option>
			<option value="浙江省">浙江省</option>
			<option value="天津市">天津市</option>
			<option value="安徽省">安徽省</option>
			<option value="上海市">上海市</option>
			<option value="福建省">福建省</option>
			<option value="重庆市">重庆市</option>
			<option value="江西省">江西省</option>
			<option value="山东省">山东省</option>
			<option value="河南省">河南省</option>
			<option value="湖北省">湖北省</option>
			<option value="湖南省">湖南省</option>
			<option value="广东省">广东省</option>
			<option value="海南省">海南省</option>
			<option value="山西省">山西省</option>
			<option value="青海省">青海省</option>
			<option value="江苏省">江苏省</option>
			<option value="辽宁省">辽宁省</option>
			<option value="吉林省">吉林省</option>
			<option value="台湾省">台湾省</option>
			<option value="河北省">河北省</option>
			<option value="贵州省">贵州省</option>
			<option value="四川省">四川省</option>
			<option value="云南省">云南省</option>
			<option value="陕西省">陕西省</option>
			<option value="甘肃省">甘肃省</option>
			<option value="黑龙江省">黑龙江省</option>
			<option value="香港特别行政区">香港特别行政区</option>
			<option value="澳门特别行政区">澳门特别行政区</option>
			<option value="广西壮族自治区">广西壮族自治区</option>
			<option value="宁夏回族自治区">宁夏回族自治区</option>
			<option value="新疆维吾尔自治区">新疆维吾尔自治区</option>
			<option value="内蒙古自治区">内蒙古自治区</option>
			<option value="西藏自治区">西藏自治区</option>
		</select></td>
						</tr>
						<tr>
							<td valign="top">个性签名:</td>
							<td>
								<textarea  id="userSignature" rows="3" cols="25" placeholder="(不超过30个字)" ><%= user.getUserSignature()!=null?user.getUserSignature():""%></textarea>
							
							
							</td>
						</tr>
					<tr>
						<td></td>
						<td>
							<div class="savebtn" onclick="saveuserbtn()">修改</div>
						</td>
					</tr>
				</table>
         		
         		
         		 </div>
         	
         	
         	</div>
         	
         	
         	<div  class="pcon" id="pcon2" style="display: none;">
         	    <div class="biaoti" id="biaoti">头像编辑</div>
         		<div class="person_info" style="height:500px;">
								<div class="head_detail_content">
					<form name="headForm" method="post"
						action="CropAction.html"
						enctype="multipart/form-data">
						<div class="headMain">
							<div class="preview_pane">
								<p>设置您的头像：</p>
								<p class="preview_background">
									<img src="/CouchSurfing/WEB/Page/image/icon.jpg" id="target" class="mainImage" />
								</p>
								<p>仅支持GIF、JPG、PNG图片</p>
							</div>
							<div class="source_pane">
								<p>头像预览（大小：200 * 200）</p>
								<div class="img-preview">
									<div class="img-contbox">
										<img src="/CouchSurfing/WEB/Page/image/icon.jpg" id="litte_pre" class="jcrop-preview"
											alt="Preview">
									</div>
								</div>
								<div>
									<a href="javascript:void(0);" class="file">上传照片 <input
										type="file" name="image" id="imgOne" accept=".png,.jpg,.gif"
										onChange="preImg(this.id);">
									</a>
								</div>
							</div>
						</div>
						<input type="hidden" id="userId" name="userId" value="<%= user.getUserId()%> "/> 
						<input type="hidden" id="x1" name="x1" /> <input type="hidden"
							id="y1" name="y1" /> <input type="hidden" id="x2" name="x2" />
						<input type="hidden" id="y2" name="y2" /> <input type="hidden"
							id="w" name="w" /> <input type="hidden" id="h" name="h" /> <input
							type="hidden" id="ratio" name="ratio" /> <img
							style="display: none" src="/CouchSurfing/WEB/Page/image/icon.jpg" id="org_file"
							name="org_file" />
						<div class="text-center" style="margin-top: 100px">
							<input type="button" id="btnHeadSave"
								class="save_button save_left" onclick="checkImage()"
								value="保   存" />
						</div>
					</form>
				</div>
				

			     </div>
         	
         	
         	</div>
         	
         	<div  class="pcon" id="pcon3" style="display: none;">
         	
         	    <div class="biaoti" id="biaoti">修改密码</div>
         		<div class="person_info">  
         		<table class="person_info_table" > 
         	     
						
						<tr>
							<td>新密码:</td>
							<td><input id="pw" type="password"></td>
						</tr>
						<tr>
							<td>确认密码:</td>
							<td><input id="repw" type="password"></td>
						</tr>
					<tr>
						<td></td>
						<td>
							<div class="savebtn" id="savebtn3" onclick="saveuserPassword()">修改</div>
						</td>
					</tr>
         		</table>
         		
         		 </div>
         	
         	
         	</div>
         	
         	<!-- <div  class="pcon" id="pcon4" style="display: none;">
         	    <div class="biaoti" id="biaoti">我的帖子</div>
         		<div class="person_info">   
         	       
         		
         		
         		 </div>
         	
         	
         	</div> -->
       
       </div>
       
       
       
        
    <div><jsp:include page="/WEB/Common/jsp/footer.jsp" flush="true" /></div>
        <script src="TOOL/jquery.min.js"></script>
         <script src="WEB/Page/js/jquery.Jcrop.min.js"></script>
        <script src="WEB/Page/js/personal_info.js"></script>
        <script type="text/javascript">
        var jcrop_api, boundx, boundy, $preview, $pcnt, pimg;
        var xsize, ysize;
        $(document).ready(function (e) {
            $preview = $('.img-preview');
            $pcnt = $('.img-preview .img-contbox');
            $pimg = $('.img-preview .img-contbox img');
            xsize = $pcnt.width();
            ysize = $pcnt.height();
        });
    </script>
        <script>
      $(function(){  var value = "<%= user.getUserRegion()!=null?user.getUserRegion():"选择地区"%>";
          $("#userRegion option[value='"+value+"']").attr("selected",true);
      });
           
     </script>
    </body>
</html>