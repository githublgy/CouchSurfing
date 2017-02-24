package com.couchsurfing.Action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.couchsurfing.dao.impl.PostDaoImpl;
import com.couchsurfing.entity.SofaPost;
import com.couchsurfing.entity.SofaPostReply;

/**
 * Servlet implementation class SofaPostDetailAction
 */
@WebServlet("/SofaPostDetailAction.html")
public class SofaPostDetailAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SofaPostDetailAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int page = 1;
		int sofapostId = 0;
		
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			
			
			if (page <= 0)
				page = 1;
		}
		if (request.getParameter("pid") != null) {
			try {
				
				sofapostId = Integer.parseInt(request.getParameter("pid"));
				
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				sofapostId=0;
				e.printStackTrace();
			}
			
		}
		PostDaoImpl postDaoImpl =  new PostDaoImpl();
		
		SofaPost sofaPost = postDaoImpl.getSofaPostById(sofapostId);
		
	    List<SofaPostReply> sofaPostReplyList = postDaoImpl.getAllSofaPostReplyById(sofapostId,page);
	    int count = postDaoImpl.getAllSofaPostReplyCountById(sofapostId);
	    request.setAttribute("sofaPost", sofaPost); 
	    request.setAttribute("sofaPostReplyList", sofaPostReplyList);   
	      request.setAttribute("replycount", count);   
	      request.setAttribute("page", page); 
		
	//	System.out.println(sofaPostReplyList);
		
		
		 request.getRequestDispatcher("/WEB/Page/jsp/postdetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
