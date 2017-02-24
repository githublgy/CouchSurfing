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
 * Servlet implementation class ZhuceUser
 */
@WebServlet("/ZhuceUser.html")
public class ZhuceUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZhuceUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName");
		String nickName = request.getParameter("nickName");
		String userPassword = request.getParameter("userPassword");
		User  user = new User();
		user.setUserName(userName);
		user.setUserPassWord(userPassword);
		user.setNickName(nickName);
		user.setUserHead("userpic.gif".trim());
		HttpSession session = request.getSession();
		boolean flag = false;
		UserDaoImpl daoUser = new UserDaoImpl();
		  flag =  daoUser.zhuceUser(user);
		  
			if(flag){
				user=daoUser.verifyUser(userName, userPassword);
				  session.setAttribute("user", user);
				
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
