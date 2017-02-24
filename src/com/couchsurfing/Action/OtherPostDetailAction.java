package com.couchsurfing.Action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.couchsurfing.dao.impl.PostDaoImpl;
import com.couchsurfing.entity.OtherPost;
import com.couchsurfing.entity.OtherPostReply;
import com.couchsurfing.entity.SofaPostReply;

/**
 * Servlet implementation class OtherPostDetailAction
 */
@WebServlet("/OtherPostDetailAction.html")
public class OtherPostDetailAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OtherPostDetailAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page = 1;
		int OtherPostId = 0;
		
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			
			
			if (page <= 0)
				page = 1;
		}
		if (request.getParameter("pid") != null) {
			try {
				
				OtherPostId = Integer.parseInt(request.getParameter("pid"));
				
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				OtherPostId=0;
				e.printStackTrace();
			}
			
		}
		PostDaoImpl postDaoImpl =  new PostDaoImpl();
	     OtherPost	OtherPost = postDaoImpl.getOtherPostById(OtherPostId);
	     
	     List<OtherPostReply> OtherPostReplyList = postDaoImpl.getAllOtherPostReplyById(OtherPostId, page);
	     
	     
		    int count = postDaoImpl.getAllOtherPostReplyCountById(OtherPostId);
		    
		    
		    request.setAttribute("otherPost", OtherPost); 
		    request.setAttribute("otherPostReplyList", OtherPostReplyList);   
		      request.setAttribute("replycount", count);   
		      request.setAttribute("page", page); 
			
			
			
			
			 request.getRequestDispatcher("/WEB/Page/jsp/otherpostdetail.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
