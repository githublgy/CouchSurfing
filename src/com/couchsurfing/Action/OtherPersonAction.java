package com.couchsurfing.Action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.couchsurfing.dao.impl.UserDaoImpl;
import com.couchsurfing.entity.User;

/**
 * Servlet implementation class OtherPersonAction
 */
@WebServlet("/OtherPersonAction.html")
public class OtherPersonAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OtherPersonAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userId = Integer.parseInt(request.getParameter("userId").trim());
		User  user = new User();
		UserDaoImpl daoUser = new UserDaoImpl();
		user = daoUser.getUserById(userId);
		request.setAttribute("user", user);
		 request.getRequestDispatcher("/WEB/Page/jsp/otherpersoninfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
