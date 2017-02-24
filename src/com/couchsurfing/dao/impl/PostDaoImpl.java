package com.couchsurfing.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.couchsurfing.entity.OtherPost;
import com.couchsurfing.entity.OtherPostReply;
import com.couchsurfing.entity.SofaPost;
import com.couchsurfing.entity.SofaPostReply;
import com.couchsurfing.tool.JdbcUtils_DBCP;

public class PostDaoImpl {
	
	/**
	 * ������page
	 * ���ܣ���ȡ����ɳ������
	 * @return User
	 */
	public List<SofaPost> getAllSofaPost(int page,String region ){
		SofaPost sofaPost  = new SofaPost();
		List<SofaPost>  sofaPostList = new ArrayList<SofaPost>();
		Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    int startPos = (page - 1) * 20;
	    boolean flag = false;
	    String sql = "Select s.*,u.nickName from sofapost s,user u where s.userId=u.userId ORDER BY s.sofaPostId DESC limit ?,20 ";
	    if(region.equals("")||region==null){
	    	flag =true;
		    sql = "Select s.*,u.nickName from sofapost s,user u where s.userId=u.userId  ORDER BY sofaPostId DESC limit ?,20";
	    }else{
	    	 sql = "Select s.*,u.nickName from sofapost s,user u where s.userId=u.userId and postRegion = ?  ORDER BY sofaPostId DESC limit ?,20";
	    	
	    }
		try {	
			 conn =  JdbcUtils_DBCP.getConnection();
			ps = conn.prepareStatement(sql);
			
			 if(flag){
				 ps.setInt(1, startPos);
			  }else{
				  ps.setString(1, region);
				  ps.setInt(2, startPos);
				  
			    }
			
		     rs = ps.executeQuery();
		     sofaPostList =  sofaPost.makeResultSet(rs) ;
		     
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JdbcUtils_DBCP.release(conn, ps, rs);
		}
		return sofaPostList;
	}
	/**
	 * ������
	 * ���ܣ���ȡ����ɳ��������Ŀ
	 * @return count
	 */
	public int getAllSofaPostCount(String region){
		int count = 0;
		 boolean flag = false;
		Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
		String sql = "select count(*) from sofapost";
		
		 if(region.equals("")||region==null){
		    	flag =true;
		    	 sql = "select count(*) from sofapost";
		    }else{
		    	 sql = "select count(*) from sofapost where postRegion = ? ";
		    	
		    }
		try {	
			 conn =  JdbcUtils_DBCP.getConnection();
			ps = conn.prepareStatement(sql);
			 if(flag){
				
			  }else{
				  ps.setString(1, region);
			    }
			rs = ps.executeQuery();
			 if(rs.next()){
				 count = rs.getInt(1);
			 }
		     
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JdbcUtils_DBCP.release(conn, ps, rs);
		}
		return count;
	}
	
	/**
	 * ������SofaPost
	 * ���ܣ�baocunɳ������
	 * @return boolean
	 */
	public boolean saveSofaPost(SofaPost sofaPost ){
		boolean flag = true;
		Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    String sql = " INSERT INTO `couchsurfing`.`sofapost` (`postRegion`, `postAddress`, `postTheme`, `postType`, `postTime`, "
	    		+ "`postRenshu`, `postHasTime`, `postSex`, `postAge`, `postDays`,"
	    		+ "`postGoodOwned`, `postRemark`, `postContact`, `userId`) VALUES (?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?)";
		try {	
			 conn =  JdbcUtils_DBCP.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, sofaPost.getPostRegion());
			ps.setString(2, sofaPost.getPostAddress());
			ps.setString(3, sofaPost.getPostTheme());
			ps.setString(4, sofaPost.getPostType());
			ps.setString(5, sofaPost.getPostTime());
			
			ps.setString(6, sofaPost.getPostRenshu());
			ps.setString(7, sofaPost.getPostHasTime());
			ps.setString(8, sofaPost.getPostSex());
			ps.setString(9, sofaPost.getPostAge());
			ps.setString(10, sofaPost.getPostDays());
			
			
			ps.setString(11, sofaPost.getPostGoodOwned());
			ps.setString(12, sofaPost.getPostRemark());
			ps.setString(13, sofaPost.getPostContact());
			ps.setInt(14, sofaPost.getUserId());
			
			
			ps.execute();
		     
		} catch (SQLException e) {
			flag = false;
			e.printStackTrace();
		}finally {
			JdbcUtils_DBCP.release(conn, ps, rs);
		}
		return flag;
	}
	
	public SofaPost getSofaPostById(int  sofapostId){
		Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    SofaPost sofaPost  = new SofaPost();
		String sql = "select s.*,u.nickName,u.userHead from sofapost s,user u where s.userId=u.userId and sofaPostId= ?";
		try {	
			 conn =  JdbcUtils_DBCP.getConnection();
			ps = conn.prepareStatement(sql);
		    ps.setInt(1, sofapostId);
			rs = ps.executeQuery();
			if(rs.next()){
				
				sofaPost = sofaPost.makeResultSet2(rs) ;
			}
		     
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JdbcUtils_DBCP.release(conn, ps, rs);
		}
		
		return sofaPost;
		
		
	}
	
	public int getAllSofaPostReplyCountById(int  sofapostId){
		int count = 0;
		Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
		String sql = "select count(*) from sofapostreply where sofaPostId = ?";
		
		try {	
			 conn =  JdbcUtils_DBCP.getConnection();
			ps = conn.prepareStatement(sql);
			 ps.setInt(1, sofapostId);
		   	rs = ps.executeQuery();
			 if(rs.next()){
				 count = rs.getInt(1);
			 }
		     
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JdbcUtils_DBCP.release(conn, ps, rs);
		}
		return count;
	}
	public int getAllOtherPostReplyCountById(int  otherpostId){
		int count = 0;
		Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
		String sql = "select count(*) from otherpostreply where otherPostId = ?";
		
		try {	
			 conn =  JdbcUtils_DBCP.getConnection();
			ps = conn.prepareStatement(sql);
			 ps.setInt(1, otherpostId);
		   	rs = ps.executeQuery();
			 if(rs.next()){
				 count = rs.getInt(1);
			 }
		     
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JdbcUtils_DBCP.release(conn, ps, rs);
		}
		return count;
	}
	public List<SofaPostReply> getAllSofaPostReplyById(int  sofapostId,int page){
		SofaPostReply sofaPostReplay = new SofaPostReply();
		 List<SofaPostReply>  sofaPostReplaylist = new ArrayList<SofaPostReply>();
		Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
		String sql = "select s.*, u.nickName ,u.userHead from sofapostreply s,user u where  s.userId=u.userId and sofapostId= ? ORDER BY sofaPostReplyId DESC  limit ?,5";
		  int startPos = (page - 1) * 5;
		try {	
			 conn =  JdbcUtils_DBCP.getConnection();
			ps = conn.prepareStatement(sql);
			 ps.setInt(1, sofapostId);
			 ps.setInt(2, startPos);
		     	rs = ps.executeQuery();
		   	sofaPostReplaylist = sofaPostReplay.makeResultSet(rs);
		     
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JdbcUtils_DBCP.release(conn, ps, rs);
		}
		return sofaPostReplaylist;
	}
	public boolean saveSofaPostReply(SofaPostReply sofaPostReply ){
		boolean flag = true;
		Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    String sql = "INSERT INTO `couchsurfing`.`sofapostreply` ( `sofaPostId`, `userId`, `replyContent`, `replytime`) VALUES (?, ?, ?, ?)";
		try {	
			 conn =  JdbcUtils_DBCP.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sofaPostReply.getSofaPostId());
			ps.setInt(2, sofaPostReply.getUserId());
			ps.setString(3, sofaPostReply.getReplyContent());
			ps.setString(4, sofaPostReply.getReplyTime());
			
			
			
			
			ps.execute();
		     
		} catch (SQLException e) {
			flag = false;
			e.printStackTrace();
		}finally {
			JdbcUtils_DBCP.release(conn, ps, rs);
		}
		return flag;
	}
	public List<OtherPostReply> getAllOtherPostReplyById(int  otherpostId,int page){
		OtherPostReply OtherPostReply = new OtherPostReply();
		 List<OtherPostReply>  otherpostreplylist = new ArrayList<OtherPostReply>();
		Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
		String sql = "select s.*, u.nickName ,u.userHead from otherpostreply s,user u where  s.userId=u.userId and otherPostId=? ORDER BY otherPostReplyId DESC  limit ?,5";
		  int startPos = (page - 1) * 5;
		try {	
			 conn =  JdbcUtils_DBCP.getConnection();
			ps = conn.prepareStatement(sql);
			 ps.setInt(1, otherpostId);
			 ps.setInt(2, startPos);
		     	rs = ps.executeQuery();
		     	 otherpostreplylist = OtherPostReply.makeResultSet(rs);
		     
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JdbcUtils_DBCP.release(conn, ps, rs);
		}
		return otherpostreplylist;
	}
	public boolean saveOtherPostReply(OtherPostReply OtherPostReply ){
		boolean flag = true;
		Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    String sql = "INSERT INTO `couchsurfing`.`otherpostreply` ( `otherPostId`, `userId`, `replyContent`, `replytime`) VALUES (?, ?, ?, ?)";
		try {	
			 conn =  JdbcUtils_DBCP.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, OtherPostReply.getOtherPostId());
			ps.setInt(2, OtherPostReply.getUserId());
			ps.setString(3, OtherPostReply.getReplyContent());
			ps.setString(4, OtherPostReply.getReplyTime());
			
			
			
			
			ps.execute();
		     
		} catch (SQLException e) {
			flag = false;
			e.printStackTrace();
		}finally {
			JdbcUtils_DBCP.release(conn, ps, rs);
		}
		return flag;
	}
	
	public int getAllOtherPostCount(String type){
		int count = 0;
		
		Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
		String sql = "select count(*) from otherpost where postType=?";
		try {	
			 conn =  JdbcUtils_DBCP.getConnection();
			ps = conn.prepareStatement(sql);
				  ps.setString(1, type);
			rs = ps.executeQuery();
			 if(rs.next()){
				 count = rs.getInt(1);
			 }
		     
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JdbcUtils_DBCP.release(conn, ps, rs);
		}
		return count;
	}
	
	public OtherPost getOtherPostById(int  OtherPostId){
		Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    OtherPost otherPost  = new OtherPost();
		String sql = "select s.*,u.nickName,u.userHead from otherpost s,user u where s.userId=u.userId and otherPostId= ?";
		try {	
			 conn =  JdbcUtils_DBCP.getConnection();
			ps = conn.prepareStatement(sql);
		    ps.setInt(1, OtherPostId);
			rs = ps.executeQuery();
			if(rs.next()){
				otherPost = otherPost.makeResultSet(rs);                                                                                                                                                                          
			}
		     
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JdbcUtils_DBCP.release(conn, ps, rs);
		}
		
		return otherPost;
		
		
	}
	
	
	public boolean saveOtherPost(OtherPost OtherPost ){
		boolean flag = true;
		Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    String sql = " INSERT INTO `couchsurfing`.`otherpost` ( `userId`, `postType`, `postTheme`, `postContent`, `postTime`) VALUES (?, ?, ?, ?, ?);";
		try {	
			 conn =  JdbcUtils_DBCP.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, OtherPost.getUserId());
			ps.setString(2, OtherPost.getPostType());
			ps.setString(3, OtherPost.getPostTheme());
			ps.setString(4, OtherPost.getPostContent());
			ps.setString(5, OtherPost.getPostTime());
		
			
			
			
			ps.execute();
		     
		} catch (SQLException e) {
			flag = false;
			e.printStackTrace();
		}finally {
			JdbcUtils_DBCP.release(conn, ps, rs);
		}
		return flag;
	}
	
	public List<OtherPost> getAllOtherPost(int page,String type){
		
		List<OtherPost>  OtherPostList = new ArrayList<OtherPost>();
		Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    int startPos = (page - 1) * 20;
	  
	    String sql = "Select s.*,u.nickName,u.userHead from otherpost s,user u where s.userId=u.userId and s.postType= ? ORDER BY s.otherPostId DESC limit ?,20 ";
	  
	    
		try {	
			 conn =  JdbcUtils_DBCP.getConnection();
			ps = conn.prepareStatement(sql);
				 ps.setString(1, type);
				 ps.setInt(2,  startPos);
		     rs = ps.executeQuery();
		     while(rs.next()){
		    	 OtherPost otherPost  = new OtherPost();
		    	 OtherPostList .add(otherPost.makeResultSet(rs));
		     }
		  
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JdbcUtils_DBCP.release(conn, ps, rs);
		}
		return OtherPostList;
	}
}
