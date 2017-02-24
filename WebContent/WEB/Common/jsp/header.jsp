<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.couchsurfing.entity.User"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
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
<title>head</title>

<link href="/CouchSurfing/WEB/Common/css/common.css" rel="stylesheet">
<link href="/CouchSurfing/WEB/Common/css/header.css" rel="stylesheet">

<base href="<%=basePath%>" />
</head>
<body>
	<div class="header">
		<div class="headerh">
			<div class="logo">
				<img alt="" src="WEB/Common/image/logo.png" width="180px"
					height="70px">
			</div>
       <% if(user==null){%>
			<div class="myform">
				<div class="na">
					<label>账号&nbsp;</label><input type="text" id="name"
						placeholder="请输入您的账号" style="width: 150px; height: 20px;">

					<span  class="zhuce" style="cursor: pointer;" onclick="popupwindows()">立即注册</span>
				</div>
				<div class="na">
					<label>密码&nbsp;</label><input type="password" id="pwd"
						placeholder="请输入您的密码" style="width: 150px; height: 20px;">
					<input type="button" value="登&nbsp;&nbsp;录" id="loginbtn">
				</div>
			</div>
			 <% }else if(user!=null){%>
			<div class="loginsuccess" >
				<div class="userhead">
					<img alt="#" src="WEB/Image/<%= user.getUserHead()!=null? user.getUserHead(): "userpic.gif" %> " width="100%" height="100%">
				
				</div>
				<div class="usermess">
					<span><a href="PersonAction.html" style="color: #444;"><%= user.getNickName()!=null?user.getNickName() :user.getUserName()%></a></span><br>
					<span><a href="ExitAction.html" style="color: #444;">退出</a></span>
				</div>
			
			</div>
			<%} %>

		</div>

		<div class="headerb">
			<ul class="navli">
				<li ><a href="IndexAction.html"style="border-left:1px solid transparent;color: white;">首页</a></li>
				
				<li><a href="getSofaPostAction.html" style="color: white;">搜沙发</a></li>
				<li><a style="color: white;"  href="OtherPostAction.html?type=1">旅行日志</a></li>
				<li><a style="color: white;" href="OtherPostAction.html?type=2">新人报道</a></li>
				<li><a style="color: white;" href="OtherPostAction.html?type=3">闲言碎语</a></li>
				<li><a href="PersonAction.html" style="color: white;">个人中心</a></li>
			</ul>
		</div>
		<div class="headerf">
			<span>当前位置></span>
			<span class=" currentlocation">首页</span>
		</div>
	</div>
	
	<div class="mask" style="display: none;" onclick="closebutton()"></div>
		<div class="popup" id="popup1" style="display: none;">
			<div class="close" onclick="closebutton()">×</div>
			<div class="popupcon">
				<div class="title">用户注册</div>
				<div class="inputwc">
					<span class="stylefront">账号</span> <input class="inputstyle"
						id="userName" type="text" placeholder="请输入账号(手机号)"
						value="" maxlength="11"
						onkeyup="value=value.replace(/[^\w\.\/]/ig,'')" />
					<!--	onkeyup="value=value.replace(/[^\d]/g,'') "
   									onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"-->
				</div>
				<div class="inputwc">
					<span class="stylefront">昵称</span> <input class="inputstyle"
						id="nickName" type="text" placeholder="请输入昵称"
						value="" maxlength="16"
						 />
				</div>
				<div class="inputwc">
					<span class="stylefront">密码</span> <input class="inputstyle"
						id="passWord" type="password" placeholder="请输入密码"
						value="" maxlength="16"
						onkeyup="value=value.replace(/[^\w\.\/]/ig,'')" />
				</div>

				<div class="addbutton" onclick="zhucebtn()">
					<span class="">注册</span>
				</div>
			</div>

		</div>
		<script src="TOOL/jquery.min.js"></script>
<script src="WEB/Common/js/header.js"></script>
</body>
</html>