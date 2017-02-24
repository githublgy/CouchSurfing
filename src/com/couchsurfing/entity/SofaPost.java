package com.couchsurfing.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class SofaPost {
	
	private int userId;
	private String nickName;
	private String userhead;
	
	private int sofaPostId;
	private String postRegion;
	private String postAddress;
	private String postTheme;
	
	
	private String postType;
	private String postTime;
	private String postRenshu;
	private String postHasTime;
	
	private String postSex;
	private String postAge;
	private String postDays;
	
	
	private String postGoodOwned;
	private String postRemark;
	private String postContact;
	
	
	public SofaPost() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public SofaPost  makeResultSet2(ResultSet rs) throws SQLException{
		     SofaPost  sofaPost = new SofaPost();
	
			
			try {
				sofaPost.setNickName(rs.getString("nickName"));
				sofaPost.setPostAddress(rs.getString("postAddress"));
				sofaPost.setPostAge(rs.getString("postAge"));
				sofaPost.setPostContact(rs.getString("postContact"));
				sofaPost.setPostDays(rs.getString("postDays"));
				sofaPost.setPostGoodOwned(rs.getString("postGoodOwned"));
				sofaPost.setPostHasTime(rs.getString("postHasTime"));
				sofaPost.setPostRegion(rs.getString("postRegion"));
				sofaPost.setPostRemark(rs.getString("postRemark"));
				sofaPost.setPostRenshu(rs.getString("postRenshu"));
				sofaPost.setPostSex(rs.getString("postSex"));
				sofaPost.setPostTheme(rs.getString("postTheme"));
				sofaPost.setPostTime(rs.getString("postTime"));
				sofaPost.setPostType(rs.getString("postType"));
				sofaPost.setSofaPostId(rs.getInt("sofaPostId"));
				sofaPost.setUserId(rs.getInt("userId"));
				sofaPost.setUserhead(rs.getString("userHead"));
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("sofaPost解析错误！");
				e.printStackTrace();
			}
		return sofaPost;
	
	}

	public List<SofaPost>  makeResultSet(ResultSet rs) throws SQLException{
		List<SofaPost>  sofaPostList = new ArrayList<SofaPost>();
		while(rs.next()){
			SofaPost sofaPost = new SofaPost();
			sofaPost.setNickName(rs.getString("nickName"));
		//	System.out.println("nickName"+rs.getString("nickName"));
			sofaPost.setPostAddress(rs.getString("postAddress"));
			sofaPost.setPostAge(rs.getString("postAge"));
			sofaPost.setPostContact(rs.getString("postContact"));
			sofaPost.setPostDays(rs.getString("postDays"));
			sofaPost.setPostGoodOwned(rs.getString("postGoodOwned"));
			sofaPost.setPostHasTime(rs.getString("postHasTime"));
			sofaPost.setPostRegion(rs.getString("postRegion"));
			sofaPost.setPostRemark(rs.getString("postRemark"));
			sofaPost.setPostRenshu(rs.getString("postRenshu"));
			sofaPost.setPostSex(rs.getString("postSex"));
			sofaPost.setPostTheme(rs.getString("postTheme"));
			sofaPost.setPostTime(rs.getString("postTime"));
			sofaPost.setPostType(rs.getString("postType"));
			sofaPost.setSofaPostId(rs.getInt("sofaPostId"));
			sofaPost.setUserId(rs.getInt("userId"));
		//	sofaPost.setUserhead(rs.getString("userHead"));
			
			sofaPostList.add(sofaPost);
		}
		
		return sofaPostList;
	
	}
	




	


	public String getUserhead() {
		return userhead;
	}


	public void setUserhead(String userhead) {
		this.userhead = userhead;
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
	public int getSofaPostId() {
		return sofaPostId;
	}
	public void setSofaPostId(int sofaPostId) {
		this.sofaPostId = sofaPostId;
	}
	public String getPostRegion() {
		return postRegion;
	}
	public void setPostRegion(String postRegion) {
		this.postRegion = postRegion;
	}
	public String getPostAddress() {
		return postAddress;
	}
	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	}
	public String getPostTheme() {
		return postTheme;
	}
	public void setPostTheme(String postTheme) {
		this.postTheme = postTheme;
	}
	public String getPostType() {
		return postType;
	}
	public void setPostType(String postType) {
		this.postType = postType;
	}
	public String getPostTime() {
		return postTime;
	}
	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}
	public String getPostRenshu() {
		return postRenshu;
	}
	public void setPostRenshu(String postRenshu) {
		this.postRenshu = postRenshu;
	}
	public String getPostSex() {
		return postSex;
	}
	public void setPostSex(String postSex) {
		this.postSex = postSex;
	}
	public String getPostAge() {
		return postAge;
	}
	public void setPostAge(String postAge) {
		this.postAge = postAge;
	}
	public String getPostDays() {
		return postDays;
	}
	public void setPostDays(String postDays) {
		this.postDays = postDays;
	}
	public String getPostGoodOwned() {
		return postGoodOwned;
	}
	public void setPostGoodOwned(String postGoodOwned) {
		this.postGoodOwned = postGoodOwned;
	}
	public String getPostRemark() {
		return postRemark;
	}
	public void setPostRemark(String postRemark) {
		this.postRemark = postRemark;
	}
	public String getPostContact() {
		return postContact;
	}
	public void setPostContact(String postContact) {
		this.postContact = postContact;
	}





	public String getPostHasTime() {
		return postHasTime;
	}





	public void setPostHasTime(String postHasTime) {
		this.postHasTime = postHasTime;
	}


	@Override
	public String toString() {
		return "SofaPost [userId=" + userId + ", nickName=" + nickName + ", userhead=" + userhead + ", sofaPostId="
				+ sofaPostId + ", postRegion=" + postRegion + ", postAddress=" + postAddress + ", postTheme="
				+ postTheme + ", postType=" + postType + ", postTime=" + postTime + ", postRenshu=" + postRenshu
				+ ", postHasTime=" + postHasTime + ", postSex=" + postSex + ", postAge=" + postAge + ", postDays="
				+ postDays + ", postGoodOwned=" + postGoodOwned + ", postRemark=" + postRemark + ", postContact="
				+ postContact + "]";
	}










	





	

	
	
	
	
	
	
	

}
