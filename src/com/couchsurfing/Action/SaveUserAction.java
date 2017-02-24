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
 * Servlet implementation class SaveUserAction
 */
@WebServlet("/SaveUserAction.html")
public class SaveUserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveUserAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userName = request.getParameter("userName");
		int userId = Integer.parseInt(request.getParameter("userId").trim());
		String userQq = request.getParameter("userQq");
		String nickName = request.getParameter("nickName");
		String userEmail = request.getParameter("userEmail");
		String userRegion = request.getParameter("userRegion");
		String userSex = request.getParameter("userSex");
		String userSignature = request.getParameter("userSignature");
	//	String userPassword = request.getParameter("userPassword");
		
		User  user = new User();
		user.setUserName(userName);
		user.setUserId(userId);
		user.setUserQq(userQq);
		user.setUserRegion(userRegion);
		user.setUserSex(userSex);
		user.setUserSignature(userSignature);
		user.setUserEmail(userEmail);
		user.setNickName(nickName);
	//	user.setUserPassWord(userPassword);
		
		boolean flag = false;
		UserDaoImpl daoUser = new UserDaoImpl();
		flag =  daoUser.modfiyUser(user);
		if(flag){
			HttpSession session = request.getSession();
			user = daoUser.getUserById(user.getUserId());
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
