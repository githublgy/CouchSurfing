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

<title>发布沙发</title>
<link href="/CouchSurfing/WEB/Common/css/common.css" rel="stylesheet">
<link href="/CouchSurfing/WEB/Page/css/putsofa.css" rel="stylesheet">

<base href="<%=basePath%>" />
</head>
<body class="bodydiv">
	<div><jsp:include page="/WEB/Common/jsp/header.jsp" flush="true" /></div>
	<div class="fusft">
		<div class="fusft1">发布帖子<span style="display:none;" id="userId"> ${sessionScope.user.userId}</span></div>

	</div>
	<div class="sflxhzt">
		<span>&nbsp;选择帖子类型</span> <select id="postType">
			
			<option value="1">旅行日志</option>
			<option value="2">新人报道</option>
			<option value="3">闲言碎语</option>
			
		</select> <span>主题</span> <input type="text"  id="postTheme"style="width: 250px;"
			placeholder="请输入帖子主题(最多八十字)">
	</div>
	<textarea id="editor_id" style="width:100%;min-height:280px;"></textarea>
	<div class="fbtz" style="padding: 5px 10px;" onclick="getKindEditorhtml()">
				<img alt="" src="WEB/Page/image/fbtz.png" style="cursor: pointer;">
	 </div>



	<div><jsp:include page="/WEB/Common/jsp/footer.jsp" flush="true" /></div>
	<script src="TOOL/jquery.min.js"></script>
	<script src="WEB/Page/js/putother.js"></script>
	<script charset="utf-8" src="TOOL/kindeditor-4.1.10/kindeditor-min.js"></script>
	<script charset="utf-8" src="TOOL/kindeditor-4.1.10/lang/zh_CN.js"></script>
</body>
</html>