package com.couchsurfing.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.couchsurfing.entity.User;
import com.couchsurfing.tool.JdbcUtils_DBCP;




public class UserDaoImpl {
	
	public User verifyUser(String userName,String userPassWord ){
		User user = null;
		Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
		String sql = "Select * from user where userName=? and userPassword=?";
		try {	
			 conn =  JdbcUtils_DBCP.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, userPassWord);
		     rs = ps.executeQuery();
		     if(rs.next()){
		    	user = new User();
		        user.UserResultSet(rs);
		     }
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JdbcUtils_DBCP.release(conn, ps, rs);
		}
		return user;
	}
	public boolean saveUserHead(String userHead,int userId ){
		boolean flag=false;
		Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
		String sql = "UPDATE `couchsurfing`.`user` SET  `userHead`=?  WHERE userId = ?";
		try {	
			 conn =  JdbcUtils_DBCP.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userHead);
			ps.setObject(2, userId);
		   ps.execute();
		   flag = true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JdbcUtils_DBCP.release(conn, ps, rs);
		}
		return flag;
	}
	
	public boolean modfiyUser(User user ){
		boolean flag=false;
		Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
		String sql = "UPDATE `couchsurfing`.`user` SET    `userSex`=?,  `nickName`=?, `userQq`=?, `userEmail`=?, `userRegion`=?, `userSignature`=? ,`userName`=? WHERE userId = ?";
		try {	
			 conn =  JdbcUtils_DBCP.getConnection();
			ps = conn.prepareStatement(sql);
		
			ps.setObject(1, user.getUserSex());
			ps.setObject(2, user.getNickName());
			ps.setObject(3, user.getUserQq());
			ps.setObject(4, user.getUserEmail());
			ps.setObject(5, user.getUserRegion());
			ps.setObject(6, user.getUserSignature());
			ps.setObject(7, user.getUserName());
			ps.setObject(8, user.getUserId());
		    ps.execute();
		    flag = true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JdbcUtils_DBCP.release(conn, ps, rs);
		}
		return flag;
	}
	
	public boolean zhuceUser(User user ){
		
		boolean flag=false;
		if(PanduanUser(user.getUserName())){
		Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
		String sql = "INSERT INTO `couchsurfing`.`user` ( `userName`,  `userPassword`, `nickName`, `userHead`) VALUES (?, ?, ?, ?);";
		try {	
			 conn =  JdbcUtils_DBCP.getConnection();
			ps = conn.prepareStatement(sql);
		
			ps.setObject(1, user.getUserName());
			ps.setObject(2, user.getUserPassWord());
			ps.setObject(3, user.getNickName());
			ps.setObject(4, user.getUserHead());
			
		    ps.execute();
		    flag = true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JdbcUtils_DBCP.release(conn, ps, rs);
		}
		}else{
			flag=false;
			
		}
		return flag;
	}
	
	public boolean modfiyUserPassWord(String userPassWord ,int userId ){
		boolean flag=false;
		Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
		String sql = "UPDATE `couchsurfing`.`user` SET   `userPassword`=? WHERE userId = ?";
		try {	
			 conn =  JdbcUtils_DBCP.getConnection();
			ps = conn.prepareStatement(sql);
		
			ps.setObject(1, userPassWord);
			ps.setObject(2, userId);
		
		    ps.execute();
		    flag = true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JdbcUtils_DBCP.release(conn, ps, rs);
		}
		return flag;
	}
	
	public User getUserById(int userId ){
		User user = null;
		Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
		String sql = "Select * from user where userId= ?";
		try {	
			 conn =  JdbcUtils_DBCP.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setObject(1, userId);
			
		     rs = ps.executeQuery();
		     if(rs.next()){
		    	 user =new User();
		        user.UserResultSet(rs);
		     }
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JdbcUtils_DBCP.release(conn, ps, rs);
		}
		return user;
	}
	
	public boolean PanduanUser(String name ){
		boolean flag = true;
		Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
		String sql = "Select * from user where userName= ?";
		try {	
			 conn =  JdbcUtils_DBCP.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setObject(1, name);
			
		     rs = ps.executeQuery();
		     if(rs.next()){
		    	 flag = false;
		     }
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JdbcUtils_DBCP.release(conn, ps, rs);
		}
		return flag;
	}

}
