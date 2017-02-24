package com.couchsurfing.test;

import com.couchsurfing.dao.impl.PostDaoImpl;
import com.couchsurfing.dao.impl.UserDaoImpl;
import com.couchsurfing.entity.OtherPost;
import com.couchsurfing.entity.OtherPostReply;
import com.couchsurfing.entity.SofaPost;
import com.couchsurfing.entity.SofaPostReply;
import com.couchsurfing.entity.User;
import com.couchsurfing.tool.GetDate;
import com.couchsurfing.tool.JdbcUnit;

public class jdbc {

	public static void main(String[] args) {
		
        //user
      // System.out.println( new UserDaoImpl().verifyUser("1", "1"));
//		System.out.println( new UserDaoImpl().saveUserHead("user_1.jpg", 1));
		User user = new User();
		user.setUserId(2);
		user.setUserName("5");
		user.setNickName("哈哈哈");
		user.setUserEmail("1275389235@qq.com");
		user.setUserRegion("浙江省");
		user.setUserQq("1275389235");
		user.setUserSex("男");
		user.setUserSignature("开心每一天！");
		user.setUserHead("userpic.gif");
		user.setUserPassWord("5");

	//	System.out.println( new UserDaoImpl().modfiyUser(user));
	//	System.out.println( new UserDaoImpl().zhuceUser(user));
		
		//System.out.println( new UserDaoImpl().modfiyUserPassWord("123456", 5));
		System.out.println(new UserDaoImpl().PanduanUser("3"));
		
       //post
//		for(int i=0;i<40;i++){
//		SofaPost sofaPost  = new SofaPost();
//		sofaPost.setNickName("������Ȼ");
//		sofaPost.setPostAddress("���Ϻ���");
//		sofaPost.setPostAge("��ǰ������ϵ������� ");
//		sofaPost.setPostContact("17896345898");
//		sofaPost.setPostDays("�������������");
//		sofaPost.setPostGoodOwned("��������ˢë�� �ڴ��� ����Ь ��˯�� ");
//		sofaPost.setPostHasTime("û׼���������ǰ��ϵ�Ҳ���");
//		sofaPost.setPostRegion("����");
//		sofaPost.setPostRemark("");
//		sofaPost.setPostRenshu("��һ��������ǰ��ϵ��");
//		sofaPost.setPostSex("�����ԣ����ǲ��Ӵ���Ů���");
//		sofaPost.setPostTheme("�����ڣ����ṩɳ�� ");
//		sofaPost.setPostTime("2016-11-18 18:04:30");
//		sofaPost.setPostType("ɳ�������㲻������ ���̡�������Դ���� ");
//		
//		sofaPost.setUserId(1);
//		
//		System.out.println( new PostDaoImpl().saveSofaPost(sofaPost));
//		}
		
		//System.out.println( new PostDaoImpl().getAllSofaPost(1,"�Ĵ�").size());
	//	System.out.println( new PostDaoImpl().getAllSofaPostCount());
	//	System.out.println( new PostDaoImpl().getSofaPostById(2));
		//System.out.println( new PostDaoImpl().getAllSofaPostReplyCountById(0));
		//System.out.println( new PostDaoImpl().getAllSofaPostReplyById(1, 1).toString());
//		for(int i=0;i<10;i++){
//		SofaPostReply sofaPostReply = new SofaPostReply();
//		sofaPostReply.setSofaPostId(1);
//		sofaPostReply.setReplyContent("好想去你那里玩！");
//		sofaPostReply.setReplyTime("2016-05-06 08:25:36");
//		int j = i%2==0?1:2;
//		sofaPostReply.setUserId(  j );
//		System.out.println( new PostDaoImpl().saveSofaPostReply(sofaPostReply));}
	//	System.out.println( new PostDaoImpl().getAllOtherPostCount("1"));
//		for(int i=0;i<5;i++){
//		OtherPost OtherPost = new OtherPost();
//		OtherPost.setUserId(3);
//		OtherPost.setPostTime(GetDate.getdate());
//		OtherPost.setPostContent("我是一个可爱、温柔的人.求在上海的沙发，本人女，90后，安分守己，想到上海找工作，请人暂且收留我，谢谢！");
//		OtherPost.setPostTheme("厦门之行肆");
//		OtherPost.setPostType("1");
//		
//		System.out.println( new PostDaoImpl().saveOtherPost(OtherPost));
//		}
	//	System.out.println( new PostDaoImpl().getAllOtherPost(1, "2").size());
		
//		for(int i=1;i<10;i++){
//			OtherPostReply OtherPostReply = new OtherPostReply();
//			OtherPostReply.setOtherPostId(i);;
//			OtherPostReply.setReplyContent("真好！");
//			OtherPostReply.setReplyTime(GetDate.getdate());
//			int j = i%2==0?4:3;
//			OtherPostReply.setUserId(  j );
//			System.out.println( new PostDaoImpl().saveOtherPostReply(OtherPostReply));}
		
		//System.out.println( new PostDaoImpl().saveOtherPostReply(OtherPostReply));
	//	System.out.println( new PostDaoImpl().getAllOtherPostReplyById(1, 1));
	//	System.out.println( new PostDaoImpl().getAllOtherPostReplyCountById(1));
		
	}

}
