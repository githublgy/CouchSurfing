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
        <title>个人中心</title>   
       <link href="/CouchSurfing/WEB/Common/css/common.css" rel="stylesheet">
       <link href="/CouchSurfing/WEB/Page/css/personalcenter.css" rel="stylesheet">
      
        <base href="<%=basePath%>" />
    </head>
    <body class="bodydiv">
       <div><jsp:include page="/WEB/Common/jsp/header.jsp" flush="true" /></div>
        
    <div><jsp:include page="/WEB/Common/jsp/footer.jsp" flush="true" /></div>
        <script src="TOOL/jquery.min.js"></script>
        <script src="WEB/Page/js/personalcenter.js"></script>
    </body>
</html>