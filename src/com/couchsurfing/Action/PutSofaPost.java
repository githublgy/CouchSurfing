package com.couchsurfing.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.couchsurfing.dao.impl.PostDaoImpl;
import com.couchsurfing.entity.SofaPost;
import com.couchsurfing.tool.GetDate;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class PutSofaPost
 */
@WebServlet("/PutSofaPost.html")
public class PutSofaPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PutSofaPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			int userId  = Integer.parseInt(request.getParameter("userId").trim());
			String sofaarea =  request.getParameter("sofaarea");
			String postTheme =  request.getParameter("postTheme");
			String postAddress =  request.getParameter("postAddress");
			String postType =  request.getParameter("postType");
			String postHasTime =  request.getParameter("postHasTime");
			String postRenshu =  request.getParameter("postRenshu");
			
			String postSex =  request.getParameter("postSex");
			String postAge =  request.getParameter("postAge");
			String postdays =  request.getParameter("postdays");
			String PostGoods =  request.getParameter("PostGoods");
			String PostRemark =  request.getParameter("PostRemark");
			String PostContact =  request.getParameter("PostContact");
		
		
		SofaPost sofaPost = new SofaPost();
		sofaPost.setPostAddress(postAddress);
		sofaPost.setPostContact(PostContact);
		sofaPost.setPostTime(GetDate.getdate());
		sofaPost.setPostRegion(sofaarea);
		sofaPost.setPostHasTime(postHasTime);
		sofaPost.setPostTheme(postTheme);
		sofaPost.setPostAge(postAge);
		sofaPost.setPostDays(postdays);
		sofaPost.setUserId(userId);
		sofaPost.setPostRenshu(postRenshu);
		sofaPost.setPostRemark(PostRemark);
		sofaPost.setPostSex(postSex);
		sofaPost.setPostType(postType);
		sofaPost.setPostGoodOwned(PostGoods);
		
		
		
		
		
		
		PostDaoImpl postDaoImpl =  new PostDaoImpl();
		boolean flag = postDaoImpl.saveSofaPost(sofaPost);
		

		JSONObject rp = new JSONObject();
		
	

		rp.put("flag", flag);
		PrintWriter out = response.getWriter();
		out.println(rp);
		out.flush();
		out.close();
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
