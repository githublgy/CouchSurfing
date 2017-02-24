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
	int type = Integer.parseInt((String)request.getAttribute("type").toString());
	int allpage = count%20==0?count/20:count/20+1;
String title = "",content="";
if(type==1){title="旅行日志";content="欢迎大家发布旅途中的奇闻，旅途中的感想，旅途中的一切一切。";};
if(type==2){title="新人报道";content="啦啦啦啦啦啦，欢迎新人报道咯";};
if(type==3){title="闲言碎语";content="碎碎碎碎碎碎碎碎碎碎！这里就是一个大杂烩，大家说什么都可以。";};



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
		<sapn class="biaoti"><%= title %> &nbsp;</sapn>
		<sapn>帖数:</sapn>
		<sapn class="red"><%= count %></sapn><sapn id="otherposttype" style="display:none"><%= type %></sapn>
		 <br> <span ><%= content %></span><br>
		 <span >帖子内容禁止发布含外部链接、有关广告、暴力、低俗色彩或敏感类话题。如有发现，一律封号不解释。</span>
		<!-- <br> <span class="red">发帖前请阅读以下内容：</span> <span
			class="red">本版仅限发表个人免费提供沙发的帖子，请勿发表与本版主题无关的帖子，谢谢合作。</span><br> <span
			class="red">1.禁止发布各类广告，包含外部连接、二维码、水印图片、私人QQ群等的帖子；</span><br> <span
			class="red">2.不得重复发帖；</span><br> <span class="red">3.如有收费沙发，欢迎举报。</span> -->
			
	</div>
	<div class="searchdiv">
		<div class="postbtn" onclick="fatiebtn()"></div>
		<div class="fhlb" onclick="javascript:history.go(-1)">返回</div>
	</div>
	<div class="allpostlist">




		<table class="posttable" border="0" cellpadding="3" cellspacing="0"
			width="100%">
			
			<c:choose>
			<c:when test="${otherPostlist== null || fn:length(otherPostlist) == 0}">
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
			<c:forEach items="${otherPostlist}" var="OtherPost"  >
			<tr>
				<td width="50%" style="padding-left: 5%"><span
					style="color: #007CD5; margin-right: 10px;">[<%= title %>]</span><a
					href="OtherPostDetailAction.html?pid=${OtherPost.otherPostId}" style="color: #444;">${OtherPost.postTheme}</a></td>
				<td width="25%" style="text-align: center;"><a>${OtherPost.nickName}</a></td>
				<td width="25%" style="text-align: center;">${OtherPost.postTime}</td>
			</tr>
			</c:forEach>
			</c:otherwise>
		    </c:choose>
		</table>
	</div>
	
	
	<c:if test="${fn:length(otherPostlist)!=0}">
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
	<script src="WEB/Page/js/otherpostlist.js"></script>
	<script>
      $(function(){  
    	  
          $("#pageselect option[value='<%= newpage%>']").attr("selected",true);
    	 
      });
           
     </script>
</body>
</html>