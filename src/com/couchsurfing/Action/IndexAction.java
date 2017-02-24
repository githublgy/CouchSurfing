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
import com.couchsurfing.entity.SofaPost;

/**
 * Servlet implementation class IndexAction
 */
@WebServlet("/IndexAction.html")
public class IndexAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PostDaoImpl postDaoImpl =  new PostDaoImpl();
	       List<SofaPost> sofaPostList = postDaoImpl.getAllSofaPost(1,"");
	       int sofaPostcount = postDaoImpl.getAllSofaPostCount("");
	       
	   	List<OtherPost> tripPostlist =  postDaoImpl.getAllOtherPost(1, "1");
	 	
 		int tripcount = postDaoImpl.getAllOtherPostCount("1");
 		
	List<OtherPost> newmanPostlist =  postDaoImpl.getAllOtherPost(1, "2");
	 	
 		int newmancount = postDaoImpl.getAllOtherPostCount("2");
	List<OtherPost> xianyanPostlist =  postDaoImpl.getAllOtherPost(1, "3");
	 	
 		int xianyancount = postDaoImpl.getAllOtherPostCount("3");
 		
 		
    request.setAttribute("tripPostlist", tripPostlist);   
      request.setAttribute("tripcount", tripcount);   
      
      request.setAttribute("newmanPostlist", newmanPostlist);   
      request.setAttribute("newmancount", newmancount);   
      
      request.setAttribute("xianyanPostlist", xianyanPostlist);   
      request.setAttribute("xianyancount", xianyancount);   
	       
	       request.setAttribute("sofaPostList", sofaPostList);   
	      
	       request.setAttribute("sofaPostcount", sofaPostcount);  
	       
		
	       request.getRequestDispatcher("/WEB/Page/jsp/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
