package com.couchsurfing.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.couchsurfing.dao.impl.PostDaoImpl;
import com.couchsurfing.entity.OtherPostReply;
import com.couchsurfing.tool.GetDate;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class OtherPostReplayAction
 */
@WebServlet("/OtherPostReplayAction.html")
public class OtherPostReplayAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OtherPostReplayAction() {
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
		OtherPostReply otherPostReply = new OtherPostReply();
		otherPostReply.setReplyContent(replyContent);
		otherPostReply.setOtherPostId(postId);
		otherPostReply.setUserId(userId);
		otherPostReply.setReplyTime(GetDate.getdate());
		
		PostDaoImpl postDaoImpl =  new PostDaoImpl();
		boolean flag = postDaoImpl.saveOtherPostReply(otherPostReply);
		

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
