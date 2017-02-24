package com.couchsurfing.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OtherPostReply {
	private int postReplyId;
	private int otherPostId;
	private int userId;
	private String nickName;
	private String userhead;
	private String replyContent;
	private String replyTime;
	public OtherPostReply() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<OtherPostReply>  makeResultSet(ResultSet rs) throws SQLException{
		List<OtherPostReply>  OtherPostReplyList = new ArrayList<OtherPostReply>();
		while(rs.next()){
			OtherPostReply OtherPostReply= new OtherPostReply();
		
		
			OtherPostReply.setNickName(rs.getString("nickName"));
			OtherPostReply.setUserhead(rs.getString("userHead"));
			OtherPostReply.setReplyContent(rs.getString("replyContent"));
			OtherPostReply.setOtherPostId(rs.getInt("otherPostId"));
			OtherPostReply.setUserId(rs.getInt("userId"));
			OtherPostReply.setReplyTime(rs.getString("replyTime"));
			
			OtherPostReplyList.add(OtherPostReply);
		}
		
		return OtherPostReplyList;
	
	}
	public int getPostReplyId() {
		return postReplyId;
	}
	public void setPostReplyId(int postReplyId) {
		this.postReplyId = postReplyId;
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
	@Override
	public String toString() {
		return "OtherPostReply [postReplyId=" + postReplyId + ", otherPostId=" + otherPostId + ", userId=" + userId
				+ ", nickName=" + nickName + ", userhead=" + userhead + ", replyContent=" + replyContent
				+ ", replyTime=" + replyTime + "]";
	}
	
	

}
