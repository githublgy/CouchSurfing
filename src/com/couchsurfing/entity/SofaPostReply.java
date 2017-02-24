package com.couchsurfing.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SofaPostReply {
	private int postReplyId;
	private int sofaPostId;
	private int userId;
	private User user;
	private String replyContent;
	private String replyTime;
	
	
	public SofaPostReply() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<SofaPostReply>  makeResultSet(ResultSet rs) throws SQLException{
		List<SofaPostReply>  sofaPostList = new ArrayList<SofaPostReply>();
		while(rs.next()){
			SofaPostReply sofaPostReplay = new SofaPostReply();
			User user = new User();
			user.setNickName(rs.getString("nickName"));
			user.setUserHead(rs.getString("userHead"));
		
			//sofaPostReplay.setNickName(rs.getString("nickName"));
			sofaPostReplay.setUser(user);
			sofaPostReplay.setReplyContent(rs.getString("replyContent"));
			sofaPostReplay.setSofaPostId(rs.getInt("sofaPostId"));
			sofaPostReplay.setUserId(rs.getInt("userId"));
			sofaPostReplay.setReplyTime(rs.getString("replyTime"));
			
			sofaPostList.add(sofaPostReplay);
		}
		
		return sofaPostList;
	
	}

	public int getPostReplyId() {
		return postReplyId;
	}

	public void setPostReplyId(int postReplyId) {
		this.postReplyId = postReplyId;
	}

	public int getSofaPostId() {
		return sofaPostId;
	}

	public void setSofaPostId(int sofaPostId) {
		this.sofaPostId = sofaPostId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "SofaPostReply [postReplyId=" + postReplyId + ", sofaPostId=" + sofaPostId + ", userId=" + userId
				+ ", user=" + user + ", replyContent=" + replyContent + ", replyTime=" + replyTime + "]";
	}

	
	
	
	
	
	
	

}
