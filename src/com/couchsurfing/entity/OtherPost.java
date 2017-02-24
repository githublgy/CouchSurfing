package com.couchsurfing.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OtherPost {
	private int otherPostId;
	private int userId;
	private String nickName;
	private String userhead;
	private String postTheme;
	private String PostType;
	private String postContent;
	private String postTime;
	public OtherPost(int otherPostId, int userId, String nickName, String userhead, String postTheme, String postType,
			String postContent, String postTime) {
		super();
		this.otherPostId = otherPostId;
		this.userId = userId;
		this.nickName = nickName;
		this.userhead = userhead;
		this.postTheme = postTheme;
		PostType = postType;
		this.postContent = postContent;
		this.postTime = postTime;
	}
	public OtherPost() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OtherPost  makeResultSet(ResultSet rs) throws SQLException{
		OtherPost  OtherPost = new OtherPost();

		
		try {
			OtherPost.setNickName(rs.getString("nickName"));
			
			OtherPost.setPostTheme(rs.getString("postTheme"));
			OtherPost.setPostTime(rs.getString("postTime"));
			OtherPost.setPostType(rs.getString("postType"));
			OtherPost.setOtherPostId(rs.getInt("otherPostId"));
			OtherPost.setUserId(rs.getInt("userId"));
			OtherPost.setUserhead(rs.getString("userHead"));
			OtherPost.setPostContent(rs.getString("postContent"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("sofaPost解析错误！");
			e.printStackTrace();
		}
	return OtherPost;

}
	public int getOtherPostId() {
		return otherPostId;
	}
	public void setOtherPostId(int otherPostId) {
		this.otherPostId = otherPostId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUserhead() {
		return userhead;
	}
	public void setUserhead(String userhead) {
		this.userhead = userhead;
	}
	public String getPostTheme() {
		return postTheme;
	}
	public void setPostTheme(String postTheme) {
		this.postTheme = postTheme;
	}
	public String getPostType() {
		return PostType;
	}
	public void setPostType(String postType) {
		PostType = postType;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getPostTime() {
		return postTime;
	}
	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}
	@Override
	public String toString() {
		return "OtherPost [otherPostId=" + otherPostId + ", userId=" + userId + ", nickName=" + nickName + ", userhead="
				+ userhead + ", postTheme=" + postTheme + ", PostType=" + PostType + ", postContent=" + postContent
				+ ", postTime=" + postTime + "]";
	}
	
	

}
