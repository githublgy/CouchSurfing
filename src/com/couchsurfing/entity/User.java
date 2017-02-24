package com.couchsurfing.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
	private int userId;
	private String userName;
	private String userPassWord;
	private String nickName;
	private String userSex;
	private String userQq;
	private String userEmail;
	private String userRegion;
	private String userSignature;
	private String userHead;
	
	public User(int userId, String userName, String userPassWord, String nickName, String userSex, String userQq,
			String userEmail, String userRegion, String userSignature, String userHead) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassWord = userPassWord;
		this.nickName = nickName;
		this.userSex = userSex;
		this.userQq = userQq;
		this.userEmail = userEmail;
		this.userRegion = userRegion;
		this.userSignature = userSignature;
		this.userHead = userHead;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
        public void UserResultSet(ResultSet rs) throws SQLException {
		
		this.userId =rs.getInt("userId");
		this.userName =rs.getString("userName");
		this.userPassWord = rs.getString("userPassWord");
		this.nickName = rs.getString("nickName");
		this.userSex =  rs.getString("userSex");
		this.userQq = rs.getString("userQq");
		this.userEmail = rs.getString("userEmail");
		this.userRegion = rs.getString("userRegion");
		this.userSignature = rs.getString("userSignature");
		this.userHead = rs.getString("userHead");
		
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassWord() {
		return userPassWord;
	}
	public void setUserPassWord(String userPassWord) {
		this.userPassWord = userPassWord;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUserQq() {
		return userQq;
	}
	public void setUserQq(String userQq) {
		this.userQq = userQq;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserRegion() {
		return userRegion;
	}
	public void setUserRegion(String userRegion) {
		this.userRegion = userRegion;
	}
	public String getUserSignature() {
		return userSignature;
	}
	public void setUserSignature(String userSignature) {
		this.userSignature = userSignature;
	}
	public String getUserHead() {
		return userHead;
	}
	public void setUserHead(String userHead) {
		this.userHead = userHead;
	}
	
	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassWord=" + userPassWord + ", nickName="
				+ nickName + ", userSex=" + userSex + ", userQq=" + userQq + ", userEmail=" + userEmail
				+ ", userRegion=" + userRegion + ", userSignature=" + userSignature + ", userHead=" + userHead + "]";
	}

	
	
	

}
