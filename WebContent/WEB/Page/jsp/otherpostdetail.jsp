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
	int count = Integer.parseInt((String)request.getAttribute("replycount").toString());
	int allpage = count%5==0?count/5:count/5+1;
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">

<title>帖子详情</title>
<link href="/CouchSurfing/WEB/Common/css/common.css" rel="stylesheet">
<link href="/CouchSurfing/WEB/Page/css/postdetail.css" rel="stylesheet">
<link rel="stylesheet" href="/CouchSurfing/TOOL/kindeditor-4.1.10/themes/default/default.css" />
<base href="<%=basePath%>" />
</head>
<body class="bodydiv">
	<div><jsp:include page="/WEB/Common/jsp/header.jsp" flush="true" /></div>
	
	<div class="fatiehfh">
		<div class="postbtn"  onclick="fatiebtn()"></div>
		<div class="fhlb" onclick="javascript:history.go(-1)">返回</div>
	</div>
	<table class="tiezitou" width="100%" border="0" cellspacing="0">
		<tr>
			<td width="20%" class="bg"> 回复:<span class="red">${replycount}</span></td>
			<td   width="80%" class="td2style"  ><span style="margin-left: 20px;"> [<c:if test="${otherPost.postType eq 4}">公告</c:if><c:if test="${otherPost.postType eq 1}">旅行日志</c:if><c:if test="${otherPost.postType eq 2}">新人报道</c:if><c:if test="${otherPost.postType eq 3}">闲言碎语</c:if>] ${otherPost.postTheme}</span><span style="display:none;" id="otherPostId"> ${otherPost.otherPostId}</span><span style="display:none;" id="userId"> ${sessionScope.user.userId}</span></td>
		</tr>
	
	</table>
	<table class="tiezicon" width="100%" cellspacing="0">
		<tr >
			<td width="20%" class="bg tdul" ><span >${otherPost.nickName}</span> </td>
			<td  width="80%" class="td2 tdul" ><span style="margin-left: 20px;"> 贴子发表于 ${otherPost.postTime}</span> </td>
		</tr>
		<tr>
			<td width="20%" valign="top" class="bg">


				<div class="tdpic">
					<img src="WEB/Image/${otherPost.userhead}" width="100%" height="100%">
				</div>
				<div class="chzl">
					<a  href="OtherPersonAction.html?userId= ${otherPost.userId}">查看资料</a>
				</div>


			</td>
			<td  width="80%" valign="top">
				<div class="tdcon">
					${otherPost.postContent}
						

				</div>
			
			
			</td>
		</tr>
	
	</table>
	
	<c:choose>
	<c:when test="${otherPostReplyList== null || fn:length(otherPostReplyList) == 0}">
	
	<table class="tiezicon" width="100%" cellspacing="0">
		
		<tr>
			
			<td style="height: 100px;text-align: center;">当前没有回复！！！</td>
		</tr>
	
	</table>
	 </c:when>
	<c:otherwise>
		<c:forEach items="${otherPostReplyList}" var="otherPostReply"  >
	<table class="tiezicon" width="100%" cellspacing="0">
		<tr >
			<td width="20%" class="bg tdul" ><span >${otherPostReply.nickName}</span> </td>
			<td  width="80%" class="td2 tdul" ><span style="margin-left: 20px;"> 回复发表于 ${otherPostReply.replyTime}</span> </td>
		</tr>
		<tr>
			<td width="20%" valign="top" class="bg">


				<div class="tdpic">
					<img src="WEB/Image/${otherPostReply.userhead}" width="100%" height="100%">
				</div>
				<div class="chzl">
					<a href="OtherPersonAction.html?userId=${otherPostReply.userId}">查看资料</a>
				</div>


			</td>
			<td  width="80%" valign="top">
				<div class="tdcon">
					 ${otherPostReply.replyContent}
				</div>
			
			
			</td>
		</tr>
	
	</table>
	</c:forEach>
	<div class="pagination ">

		<div class="xiayiye pb"  onclick="pageprev()">下一页</div>
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
	</c:otherwise>
   </c:choose>
	
	
	
	<div class="reply center-vertical" >
		<div class="userphoto "><img alt="" src="WEB/Image/${sessionScope.user.userHead}" width="130px" height="130px"> </div>
		<div class="editordiv">
		
		         <textarea id="editor_id" rows="12" cols="100"></textarea>
		
		          <div class="fbht" id="replyeditor" onclick="getKindEditorhtml()"> </div>
		</div>
	          
	</div>
	<div><jsp:include page="/WEB/Common/jsp/footer.jsp" flush="true" /></div>
	<script src="TOOL/jquery.min.js"></script>
	<script src="WEB/Page/js/otherpostdetail.js"></script>
	<script>
      $(function(){  
    	  
          $("#pageselect option[value='<%= newpage%>']").attr("selected",true);
    	 
      });
           
     </script>
	<script charset="utf-8" src="TOOL/kindeditor-4.1.10/kindeditor-min.js"></script>
	<script charset="utf-8" src="TOOL/kindeditor-4.1.10/lang/zh_CN.js"></script>
	
</body>
</html>