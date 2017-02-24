<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>footer</title>
<!-- Bootstrap -->

<!--你自己的样式文件 -->
<link href="WEB/Common/css/footer.css" rel="stylesheet">
<!-- 以下两个插件用于在IE8以及以下版本浏览器支持HTML5元素和媒体查询，如果不需要用可以移除 -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
<base href="<%=basePath%>" />
</head>
<body >  	
	<div class="tubiao">
		<div class="tupic">
		<a href="http://www.12377.cn/"> <img alt="" src="WEB/Common/image/f1.png" width="100%" height="100%"></a>
	    </div>
	    <div class="tupic">
		<a href="http://www.cyberpolice.cn/wfjb/"> <img alt="" src="WEB/Common/image/f2.png" width="100%" height="100%"></a>
	
	    </div>
	    <div class="tupic">
	
	<a href="http://www.wenming.cn/"> <img alt="" src="WEB/Common/image/f3.png" width="100%" height="100%"></a>
	    </div>
	    
	    <div class="tupic">
	<a href="http://webscan.360.cn/"> <img alt="" src="WEB/Common/image/f4.png" width="100%" height="100%"></a>
	
	    </div>
	
	 </div>
	<div class="banquan"> 
		<p>信息产业部备案： 浙ICP备123456789号-1    </p>
		<p>版权所有：沙发客网 Powered by lgy! X2.5 Copyright© 2009-2013  All Right Reserved </p>
	</div>
	

	
</body>
</html>