<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>沙发客</title>
<!-- Bootstrap -->

<!--你自己的样式文件 -->
<link href="/CouchSurfing/WEB/Common/css/common.css" rel="stylesheet">
<link href="/CouchSurfing/WEB/Page/css/index.css" rel="stylesheet">

<base href="<%=basePath%>" />
</head>
<body class="bodydiv">
	<div><jsp:include page="/WEB/Common/jsp/header.jsp" flush="true" /></div>
	<div class="banner" id="b04">
		<ul>
			<li><img src="/CouchSurfing/WEB/Page/image/1.jpg" alt="" width="100%"
				height="100%"></li>

			<li><img src="/CouchSurfing/WEB/Page/image/002.jpg" alt="" width="100%"
				height="100%"></li>
			<li><img src="/CouchSurfing/WEB/Page/image/003.jpg" alt="" width="100%"
				height="100%"></li>

		</ul>
		<a href="javascript:void(0);" class="unslider-arrow04 prev"><img
			class="arrow" id="al" src="/CouchSurfing/WEB/Page/image/arrowl.png" alt="prev"
			height="35"></a> <a href="javascript:void(0);"
			class="unslider-arrow04 next"><img class="arrow" id="ar"
			src="/CouchSurfing/WEB/Page/image/arrowr.png" alt="next" width="20" height="37"></a>
	</div>
	<div style="margin:3px 0; "><span style="color:rgb(0,102,0);font-weight: 700;float: left; ">[公告]:</span>
	<marquee onMouseOut="this.start()" onMouseOver="this.stop()" behavior="alternate" align="left"  width="93.5%" direction="right"
	 >
	   <span><a href="OtherPostDetailAction.html?pid=56" style="color:#444;">加入“沙发客!”志愿版主招募中……</a></span>
	  <!--  <span><a>加入“9k沙发客!”志愿版主招募中……</a></span>
	   <span><a>加入“9k沙发客!”志愿版主招募中……</a></span>
	   <span><a>加入“9k沙发客!”志愿版主招募中……</a></span>
	   <span><a>加入“9k沙发客!”志愿版主招募中……</a></span> -->
	</marquee></div>
	<div class="content">
		<div class="ctdiv">
			<div class="cttitle">
				<span style="float:left;display:block;">我们提供免费沙发</span>
				<span style="float:right;display:block;"><a  style="color:white;"href="getSofaPostAction.html">更多...</a></span>
			</div>
			<div class="ctbody">
				<ul>
					<c:forEach items="${sofaPostList}" var="sofaPost" end="9">
					<li style="white-space: nowrap;overflow:hidden; text-overflow: ellipsis; list-style-position: inside;">
					<a style="color:#444 " href="SofaPostDetailAction.html?pid=${sofaPost.sofaPostId}">{${ sofaPost.postRegion}}${ sofaPost.postTheme}</a></li>
					</c:forEach>

				</ul>
			</div>

		</div>
		<div class="ctdiv" style="margin: 0 1.5%">

			<div class="cttitle">
				<span style="float:left;display:block;">最新帖子</span>
				<span style="float:right;display:block;">
				</span>
			</div>
			<div class="ctbody">
				<ul>
					
					<c:forEach items="${newmanPostlist}" var="sofaPost" end="1">
					<li style="white-space: nowrap;overflow:hidden; text-overflow: ellipsis; list-style-position: inside;"><a style="color:#444 " href="OtherPostDetailAction.html?pid=${sofaPost.otherPostId}">${ sofaPost.postTheme}</a></li>
					</c:forEach>
					<c:forEach items="${tripPostlist}" var="sofaPost" end="1">
					<li style="white-space: nowrap;overflow:hidden; text-overflow: ellipsis; list-style-position: inside;"><a  style="color:#444 " href="OtherPostDetailAction.html?pid=${sofaPost.otherPostId}">${ sofaPost.postTheme}</a></li>
					</c:forEach>
					<c:forEach items="${xianyanPostlist}" var="sofaPost" end="1">
					<li style="white-space: nowrap;overflow:hidden; text-overflow: ellipsis; list-style-position: inside;"><a style="color:#444 " href="OtherPostDetailAction.html?pid=${sofaPost.otherPostId}">${ sofaPost.postTheme}</a></li>
					</c:forEach>
					<c:forEach items="${sofaPostList}" var="sofaPost" end="3">
					<li style="white-space: nowrap;overflow:hidden; text-overflow: ellipsis; list-style-position: inside;"><a style="color:#444 " href="SofaPostDetailAction.html?pid=${sofaPost.sofaPostId}">{${ sofaPost.postRegion}}${ sofaPost.postTheme}</a></li>
					</c:forEach>

				</ul>
			</div>

		</div>
		<div class="ctdiv">
			<div class="cttitle">
				<span style="float:left;display:block;">我们在写：</span>
				<span style="float:right;display:block;">
				<a style="color:white;"href="OtherPostAction.html?type=1">更多...</a></span>
			</div>
			<div class="ctbody">
				<ul>
					<c:forEach items="${tripPostlist}" var="sofaPost" end="9">
					<li style="white-space: nowrap;overflow:hidden; text-overflow: ellipsis; list-style-position: inside;"><a style="color:#444 " href="OtherPostDetailAction.html?pid=${sofaPost.otherPostId}">${ sofaPost.postTheme}</a></li>
					</c:forEach>

				</ul>
			</div>

		</div>
		<!--  -->
	</div>
	<div class="content" style="margin-top: 16px;">

		
		<div class="ctdiv">

			<div class="cttitle">
				<span style="float:left;display:block;">闲言碎语</span>
				<span style="float:right;display:block;">
				<a style="color:white;"href="OtherPostAction.html?type=3">更多...</a></span>
			</div>
			<div class="ctbody">
				<ul>
				<c:forEach items="${xianyanPostlist}" var="sofaPost" end="9">
					<li style="white-space: nowrap;overflow:hidden; text-overflow: ellipsis; list-style-position: inside;" ><a style="color:#444 " href="OtherPostDetailAction.html?pid=${sofaPost.otherPostId}">${ sofaPost.postTheme}</a></li>
					</c:forEach>


				</ul>
			</div>

		</div>
		<div class="ctdiv" style="margin: 0 1.5%">

			<div class="cttitle">
				<span style="float:left;display:block;">新人报道</span>
				<span style="float:right;display:block;">
				<a style="color:white;"href="OtherPostAction.html?type=2">更多...</a></span>
			</div>
			<div class="ctbody">
				<ul style="">
					<c:forEach items="${newmanPostlist}" var="sofaPost" end="9">
					<li style="white-space: nowrap;overflow:hidden; text-overflow: ellipsis; list-style-position: inside;"><a style="color:#444 " href="OtherPostDetailAction.html?pid=${sofaPost.otherPostId}">${ sofaPost.postTheme}</a></li>
					</c:forEach>

				</ul>
			</div>

		</div>
		<div class="ctdiv">

			<div class="cttitle">
				<span style="float:left;display:block;">最新美图</span>
				<span style="float:right;display:block;">
				</span>
			</div>
			<div class="ctbody2">
				<div class="meitu" id="b05">
					<ul>
						<li><a href="OtherPostDetailAction.html?pid=53"><img src="/CouchSurfing/Image/image/20161210/20161210213903_113.jpg" alt="" width="100%"
							height="100%"></a></li>

						<li><a href="OtherPostDetailAction.html?pid=51"><img src="/CouchSurfing/Image/image/20161210/20161210212500_810.jpg" alt="" width="100%"
							height="100%"></a></li>
						<li><a href="OtherPostDetailAction.html?pid=54"><img src="/CouchSurfing/Image/image/20161210/20161210215502_94.jpg" alt="" width="100%"
							height="100%"></a></li>
							<li><a href="OtherPostDetailAction.html?pid=55"><img src="/CouchSurfing/Image/image/20161210/20161210215742_780.jpg" alt="" width="100%"
							height="100%"></a></li>
						

					</ul>
					
					
				</div>

			</div>

		</div>

	</div>
		<div class="allpost">
		  <div class="posthead"> 我是沙发客！</div>
			<div class="postbody">
				<div class="post1">
						<div class="pic" style="background: url('WEB/Page/image/hasshafa.png') no-repeat;background-size:100% 100%; ">
							
						 </div>
						<div class="con " >
							<span class="jiachu"><a href="getSofaPostAction.html" style="color:rgb(255,153,0);font-size: 14px">我有沙发</a></span><br>
							<span class="jiachu">帖数:</span><span>${sofaPostcount}</span><br>
							<span class="jiachu">最后发表:</span><span>${sofaPostList[0].postTime}</span>
						</div>
				</div>
				<div class="post1">
						<div class="pic" style="background: url('WEB/Page/image/trip.png') no-repeat;background-size:100% 100%; ">
							
						 </div>
						<div class="con " >
							<span class="jiachu"><a href="OtherPostAction.html?type=1" style="color:rgb(255,153,0);font-size: 14px">旅行日志</a></span><br>
							<span class="jiachu">帖数:</span><span>${tripcount}</span><br>
							<span class="jiachu">最后发表:</span><span>${tripPostlist[0].postTime}</span>
						</div>
				</div>
				<div class="post1">
						<div class="pic" style="background: url('WEB/Page/image/newperson.png') no-repeat;background-size:100% 100%; ">
							
						 </div>
						<div class="con " >
							<span class="jiachu"><a href="OtherPostAction.html?type=2" style="color:rgb(255,153,0);font-size: 14px">新人报道</a></span><br>
							<span class="jiachu">帖数:</span><span>${newmancount}</span><br>
							<span class="jiachu">最后发表:</span><span>${newmanPostlist[0].postTime}</span>
						</div>
				</div>
				<div class="post1">
						<div class="pic" style="background: url('WEB/Page/image/speak.png') no-repeat;background-size:100% 100%; ">
							
						 </div>
						<div class="con " >
							<span class="jiachu"><a href="OtherPostAction.html?type=3" style="color:rgb(255,153,0);font-size: 15px">闲言碎语</a></span><br>
							<span class="jiachu">帖数:</span><span>${xianyancount}</span><br>
							<span class="jiachu">最后发表:</span><span>${xianyanPostlist[0].postTime}</span>
						</div>
				</div>
				
			 </div>
		</div>
		<div><jsp:include page="/WEB/Common/jsp/footer.jsp" flush="true" /></div>
	<script src="TOOL/jquery.min.js"></script>
	<script src="TOOL/unslider.min.js"></script>
	<script src="WEB/Page/js/index.js"></script>
</body>
</html>