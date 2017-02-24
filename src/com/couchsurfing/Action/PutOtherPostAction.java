package com.couchsurfing.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.couchsurfing.dao.impl.PostDaoImpl;
import com.couchsurfing.entity.OtherPost;
import com.couchsurfing.tool.GetDate;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class PutOtherPostAction
 */
@WebServlet("/PutOtherPostAction.html")
public class PutOtherPostAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PutOtherPostAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userId  = Integer.parseInt(request.getParameter("userId").trim());
		String postTheme =  request.getParameter("postTheme");
		String postType =  request.getParameter("postType");
		String postContent =  request.getParameter("postContent");
		
		OtherPost OtherPost = new OtherPost();
		OtherPost.setUserId(userId);
		OtherPost.setPostTime(GetDate.getdate());
		OtherPost.setPostContent(postContent);
		OtherPost.setPostTheme(postTheme);
		OtherPost.setPostType(postType);
		
		PostDaoImpl postDaoImpl =  new PostDaoImpl();
		boolean flag = postDaoImpl.saveOtherPost(OtherPost);
		

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
