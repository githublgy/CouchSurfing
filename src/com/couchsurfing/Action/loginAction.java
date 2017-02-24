package com.couchsurfing.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.couchsurfing.dao.impl.UserDaoImpl;
import com.couchsurfing.entity.User;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class loginAction
 */
@WebServlet("/loginAction.html")
public class loginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
	
		User  user = null;
		boolean flag = false;
		String userName = request.getParameter("username");
		String userPassWord = request.getParameter("password");
		if (userName != null && !userName.equals("") && userPassWord != null && !userPassWord.equals("")) {
		   UserDaoImpl daoUser = new UserDaoImpl();
		   user = daoUser.verifyUser(userName, userPassWord);
		   if(user!=null){
		       session.setAttribute("user", user);
		       flag=true;
		   }
		}
		
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
