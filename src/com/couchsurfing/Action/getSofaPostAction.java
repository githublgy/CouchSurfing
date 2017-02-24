package com.couchsurfing.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.couchsurfing.dao.impl.PostDaoImpl;
import com.couchsurfing.entity.SofaPost;


import net.sf.json.JSONObject;

/**
 * Servlet implementation class getSofaPostAction
 */
@WebServlet("/getSofaPostAction.html")
public class getSofaPostAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getSofaPostAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page = 1;
		String region = "";
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			if (page <= 0)
				page = 1;
		}
		
		if (request.getParameter("region") != null) {
			//System.out.println(request.getParameter("region"));
			region = new String(request.getParameter("region").getBytes("ISO-8859-1"),"utf-8");
			//System.out.println(region);
			if(region.equals("不限")){
				region="";
			}
			
		}
		
	      	PostDaoImpl postDaoImpl =  new PostDaoImpl();
		       List<SofaPost> sofaPostList = postDaoImpl.getAllSofaPost(page,region);
		      int count = postDaoImpl.getAllSofaPostCount(region);
		      
		      request.setAttribute("sofaPostList", sofaPostList);   
		      request.setAttribute("count", count);   
		      request.setAttribute("page", page);  
		      if(region.equals("")){
		    	  region = "不限";
		      }
		      request.setAttribute("region", region);  
		      
		      System.out.println(sofaPostList.toString());
		      
		      
		      
		      request.getRequestDispatcher("/WEB/Page/jsp/sofalist.jsp").forward(request, response);
		    
//		JSONObject rp = new JSONObject();
		
//		rp.put("sofaPostList", sofaPostList);
//		System.out.println(sofaPostList.toString());
//		rp.put("count", count);
//		PrintWriter out = response.getWriter();
//		out.println(rp);
//		out.flush();
//		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
