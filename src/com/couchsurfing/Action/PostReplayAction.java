package com.couchsurfing.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.couchsurfing.dao.impl.PostDaoImpl;
import com.couchsurfing.entity.SofaPostReply;
import com.couchsurfing.tool.GetDate;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class PostReplayAction
 */
@WebServlet("/PostReplayAction.html")
public class PostReplayAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostReplayAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int postId = Integer.parseInt(request.getParameter("postId").trim());
		int userId  = Integer.parseInt(request.getParameter("userId").trim());
		String replyContent =  request.getParameter("replayContent");
		SofaPostReply sofaPostReply = new SofaPostReply();
		sofaPostReply.setReplyContent(replyContent);
		sofaPostReply.setSofaPostId(postId);
		sofaPostReply.setUserId(userId);
		sofaPostReply.setReplyTime(GetDate.getdate());
		
		PostDaoImpl postDaoImpl =  new PostDaoImpl();
		boolean flag = postDaoImpl.saveSofaPostReply(sofaPostReply);
		

		JSONObject rp = new JSONObject();
		
	

		rp.put("flag", flag);
		PrintWriter out = response.getWriter();
		out.println(rp);
		out.flush();
		out.close();
		
	//	System.out.println(postId+userId+replayContent);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
