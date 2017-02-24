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
		<div class="fusft1">发布沙发<span style="display:none;" id="userId"> ${sessionScope.user.userId}</span></div>

	</div>
	<div class="sflxhzt">
		<span>&nbsp;选择沙发地区</span> <select id="sofaarea">

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
			<option value="内蒙古">内蒙古自治区</option>
			<option value="西藏">西藏自治区</option>
		</select> <span>主题</span> <input type="text"  id="postTheme"style="width: 250px;"
			placeholder="请输入沙发主题(最多八十字)">
	</div>
	<div class="ftjtnrdiv">
		<table class="ftjtnr" border="0" cellpadding="3" cellspacing="0"
			width="100%">
			<tr>
				<td width="10%">沙发详情</td>
				<td></td>

			</tr>

			<tr>
				<td width="15%" valign="top">提供沙发地点</td>
				<td><span class="red">*&nbsp;</span><input id="postAddress" type="text"
					style="width: 250px;"><br> <span class="tishi">您能提供沙发的地点，建议精确到区或者县，也可以精确到小区名，但强烈不建议填写单元门牌号。</span>
				</td>

			</tr>
			<tr>
				<td width="15%" valign="top">沙发类型</td>
				<td><span class="red">*&nbsp;</span> <select class="aselect" id="postType">
						<option value="沙发——你不会介意吧">沙发——你不会介意吧</option>
						<option value="地铺——你可以打地铺">地铺——你可以打地铺</option>
						<option value="客房——客房或者空床">客房——客房或者空床</option>
						<option value="床位——单位或者寝室">床位——单位或者寝室</option>
						<option value="空地——你可以搭帐篷">空地——你可以搭帐篷</option>
						<option value="其他——我会在下面说明">其他——我会在下面说明</option>
						<option value="可能我没有沙发，但可以一起逛逛">可能我没有沙发，但可以一起逛逛</option>

				</select><br> <span class="tishi">您可以免费提供怎样的地方让别的沙发客休息住宿？</span></td>

			</tr>
			<tr>
				<td width="15%" valign="top">沙发时间</td>
				<td><span class="red">*&nbsp;</span><select class="aselect" id="postHasTime">
						<option value="都行——一般我不外出都可以">都行——一般我不外出都可以</option>
						<option value="周末——只能周末你可以过来">周末——只能周末你可以过来</option>
						<option value="假期——只有寒暑假你可以来">假期——只有寒暑假你可以来</option>
						<option value="平时——只有不放假的时候行">平时——只有不放假的时候行</option>
						<option value="没准——你得提前联系我才行">没准——你得提前联系我才行</option>
						<option value="其他——我会在下面说明">其他——我会在下面说明</option>


				</select><br> <span class="tishi">什么时候方便提供沙发呢？</span></td>

			</tr>
			<tr>
				<td width="15%" valign="top">接待人数</td>
				<td><span class="red">*&nbsp;</span><select class="aselect" id="postRenshu">
						<option value="1人">1人</option>
						<option value=" 2"人>2人</option>
						<option value="3人">3人</option>
						<option value="4人">4人</option>
						<option value="更多人">更多人</option>
						<option value="其他——我会在下面说明">其他——我会在下面说明</option>


				</select><br> <span class="tishi">最多可以来几个沙友？</span></td>

			</tr>
			<tr>
				<td width="15%" valign="top">性别限制</td>
				<td><span class="red">*&nbsp;</span><select class="aselect"  id="postSex">
						<option value="男女都可以，没有特别限制">男女都可以，没有特别限制</option>
						<option value="都可以，但是不接待男女结伴">都可以，但是不接待男女结伴</option>
						<option value="我只能接待女生">我只能接待女生</option>
						<option value="我只能接待男生">我只能接待男生</option>
						
						<option value="其他——我会在下面说明">其他——我会在下面说明</option>


				</select><br> <span class="tishi">您可以接待沙友的性别。</span></td>

			</tr>
			<tr>
				<td width="15%" valign="top">年龄限制</td>
				<td><span class="red">*&nbsp;</span><select class="aselect" id="postAge">
						<option value="各个年龄段都可以">各个年龄段都可以</option>
						<option value="学生">学生</option>
						<option value="年轻人">年轻人</option>
						<option value="中年人">中年人</option>
						<option value="老年人">老年人</option>
						<option value="提前和我联系，看情况">提前和我联系，看情况</option>
						<option value="其他——我会在下面说明">其他——我会在下面说明</option>


				</select><br> <span class="tishi">您希望接待沙友的期望年龄。比如，您如果是学校寝室，只能接待学生之类的。</span></td>

			</tr>
			<tr>
				<td width="15%" valign="top">最多天数</td>
				<td><span class="red">*&nbsp;</span><select class="aselect" id="postdays">
						<option value="只能一天">只能一天</option>
						<option value="三天以内比较合适">三天以内比较合适</option>
						<option value="如果我和你聊得来，住多久都可以">如果我和你聊得来，住多久都可以</option>
						<option value="看具体情况而定">看具体情况而定</option>
				</select><br> <span class="tishi">可以借宿的大致天数。</span></td>

			</tr>
<tr>
				<td width="15%" valign="top">自备物品</td>
				<td><span class="red">*&nbsp;</span>
				<input type="checkbox"  class="PostGoods" value="牙杯牙刷毛巾">	<span>牙杯牙刷毛巾</span>			
				<input type="checkbox" class="PostGoods" value="床单">	<span>床单</span>	
				<input type="checkbox" class="PostGoods" value="拖鞋">	<span>拖鞋</span>	
				<input type="checkbox" class="PostGoods" value="睡袋">	<span>睡袋</span>	
				
				<input type="checkbox" class="PostGoods" value="脸盆">	<span>脸盆</span>	
				<input type="checkbox" class="PostGoods" value="水杯">	<span>水杯</span>	
				<input type="checkbox" class="PostGoods"  value="其他，我会在下面注明">	<span>其他，我会在下面注明</span>	
				
				<br> <span class="tishi">沙友需要自带哪些物品，您无法提供的。①强烈建议沙主勾选。</span></td>

			</tr>
			<tr>
			
			<td width="15%" valign="top">特别备注</td>
				<td><span class="red">*&nbsp;</span>
						<textarea cols="40" rows="4"  id="PostRemark"></textarea>
				
				<br> <span class="tishi">有无什么宗教信仰，生活习惯之类的需要特别说明的内容。</span></td>
			
			</tr>
			<tr>
			
			<td width="15%" valign="top">我的联系方式</td>
				<td><span class="red">*&nbsp;</span>
						<input type="text" style="width: 200px" id="PostContact"> 
				
				<br> <span class="tishi">此联系方式所有实名认证沙友可见。建议留下QQ号，请注意选择性接待实名认证的沙友。</span></td>
			
			</tr>

		</table>
	</div>
	<div class="fbtz" style="padding: 5px 10px;" onclick="putpost()">
				<img alt="" src="WEB/Page/image/fbtz.png" style="cursor: pointer;">
	 </div>



	<div><jsp:include page="/WEB/Common/jsp/footer.jsp" flush="true" /></div>
	<script src="TOOL/jquery.min.js"></script>
	<script src="WEB/Page/js/putsofa.js"></script>
</body>
</html>