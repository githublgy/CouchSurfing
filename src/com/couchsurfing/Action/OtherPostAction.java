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

/**
 * Servlet implementation class OtherPostAction
 */
@WebServlet("/OtherPostAction.html")
public class OtherPostAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OtherPostAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		    String type = request.getParameter("type").trim();
		    int page = 1;
		
			if (request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
				if (page <= 0)
					page = 1;
			}
		 	PostDaoImpl postDaoImpl =   new PostDaoImpl();
		 	
		 	List<OtherPost> OtherPostlist =  postDaoImpl.getAllOtherPost(page, type);
		 	
		 		int count = postDaoImpl.getAllOtherPostCount(type);
		 		
		 	
		    request.setAttribute("otherPostlist", OtherPostlist);   
		      request.setAttribute("count", count);   
		      request.setAttribute("page", page);  
		      request.setAttribute("type", type);  
		
		
		
		 request.getRequestDispatcher("/WEB/Page/jsp/otherpostlist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
