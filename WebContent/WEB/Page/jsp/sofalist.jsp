<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	int newpage = Integer.parseInt((String)request.getAttribute("page").toString());
	int count = Integer.parseInt((String)request.getAttribute("count").toString());
	int allpage = count%20==0?count/20:count/20+1;
	String region = (String)request.getAttribute("region");
	  //System.out.println(sofaPostList.toString());
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">

<title>发布沙发</title>
<link href="/CouchSurfing/WEB/Common/css/common.css" rel="stylesheet">
<link href="/CouchSurfing/WEB/Page/css/sofalist.css" rel="stylesheet">

<base href="<%=basePath%>" />
</head>
<body class="bodydiv">
	<div><jsp:include page="/WEB/Common/jsp/header.jsp" flush="true" /></div>
	<div class="hassofaguiding">
		<sapn class="biaoti">我有沙发&nbsp;</sapn>
		<sapn>帖数:</sapn>
		<sapn><%= count %></sapn>
		<br> <span class="red">发帖前请阅读以下内容：</span><br> <span
			class="red">本版仅限发表个人免费提供沙发的帖子，请勿发表与本版主题无关的帖子，谢谢合作。</span><br> <span
			class="red">1.禁止发布各类广告，包含外部连接、二维码、水印图片、私人QQ群等的帖子；</span><br> <span
			class="red">2.不得重复发帖；</span><br> <span class="red">3.如有收费沙发，欢迎举报。</span>
	</div>
	<div class="searchdiv">
		<div class="postbtn" onclick="fatiebtn()"></div>
		<span>选择省份</span> <select id="selectsheng">
			<option value="不限">不限</option>
			<option value="北京">北京市</option>
			<option value="浙江">浙江省</option>
			<option value="天津">天津市</option>
			<option value="安徽">安徽省</option>
			<option value="上海">上海市</option>
			<option value="福建">福建省</option>
			<option value="重庆">重庆市</option>
			<option value="江西">江西省</option>
			<option value="山东">山东省</option>
			<option value="河南">河南省</option>
			<option value="湖北">湖北省</option>
			<option value="湖南">湖南省</option>
			<option value="广东">广东省</option>
			<option value="海南">海南省</option>
			<option value="山西">山西省</option>
			<option value="青海">青海省</option>
			<option value="江苏">江苏省</option>
			<option value="辽宁">辽宁省</option>
			<option value="吉林">吉林省</option>
			<option value="台湾">台湾省</option>
			<option value="河北">河北省</option>
			<option value="贵州">贵州省</option>
			<option value="四川">四川省</option>
			<option value="云南">云南省</option>
			<option value="陕西">陕西省</option>
			<option value="甘肃">甘肃省</option>
			<option value="黑龙江">黑龙江省</option>
			<option value="香港">香港特别行政区</option>
			<option value="澳门">澳门特别行政区</option>
			<option value="广西">广西壮族自治区</option>
			<option value="宁夏">宁夏回族自治区</option>
			<option value="新疆">新疆维吾尔自治区</option>
			<option value="内蒙">内蒙古自治区</option>
			<option value="西藏">西藏自治区</option>
		</select> <input type="button" value="搜索"  height="33px" onclick="searchpost()">
	</div>
	<div class="allpostlist">




		<table class="posttable" border="0" cellpadding="3" cellspacing="0"
			width="100%">
			
			<c:choose>
			<c:when test="${sofaPostList== null || fn:length(sofaPostList) == 0}">
			<tr>
				<th style="text-align: center;">没有相关帖子信息！</th>
				
			</tr>
			
		    </c:when>
			<c:otherwise>
			<tr>
				<th width="50%" style="padding-left: 10%">主题</th>
				<th width="25%" style="text-align: center;">作者</th>
				<th width="25%" style="text-align: center;">时间</th>
			</tr>
			<c:forEach items="${sofaPostList}" var="SofaPost"  >
			<tr>
				<td width="50%" style="padding-left: 5%"><span
					style="color: #007CD5; margin-right: 10px;">[${SofaPost.postRegion}]</span><a
					href="SofaPostDetailAction.html?pid=${SofaPost.sofaPostId}" style="color: #444;">${SofaPost.postTheme}</a></td>
				<td width="25%" style="text-align: center;"><a>${SofaPost.nickName}</a></td>
				<td width="25%" style="text-align: center;">${SofaPost.postTime}</td>
			</tr>
			</c:forEach>
			</c:otherwise>
		    </c:choose>
		</table>
	</div>
	
	
	<c:if test="${fn:length(sofaPostList)!=0}">
	<div class="pagination ">
		<div class="xiayiye pb"  onclick="pageprev()" >下一页</div>
		<div class="tiaozhuang pb" onclick="pageinto()">跳转</div>
		<div class="yeshu center-vertical"
			style="width: 80px; justify-content: center;">
			<select style="width: 45px; height: 16.5px;" id="pageselect">
					<%for(int i=0;i<allpage;i++){ %>
					<option value="<%= i+1 %>"><%= i+1 %></option>
				<%} %>
			</select> 
			<!-- <input type="text" value="1" style="width: 30px; height: 11px;"> -->
			
			<span>/</span><span id="allpage"><%= allpage %></span><span>页</span>
		</div>
		<div class="shangyiye pb" onclick="pageback()">上一页</div>

		<div class="shouye pb" onclick="indexpage()">首页</div>



	</div>
	</c:if>
	
	<div><jsp:include page="/WEB/Common/jsp/footer.jsp" flush="true" /></div>
	<script src="TOOL/jquery.min.js"></script>
	<script src="WEB/Page/js/sofalist.js"></script>
	<script>
      $(function(){  
    	  
          $("#pageselect option[value='<%= newpage%>']").attr("selected",true);
    	  $("#selectsheng option[value='<%= region%>']").attr("selected",true);
      });
           
     </script>
</body>
</html>