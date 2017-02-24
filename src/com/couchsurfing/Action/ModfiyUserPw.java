package com.couchsurfing.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.couchsurfing.dao.impl.UserDaoImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class ModfiyUserPw
 */
@WebServlet("/ModfiyUserPw.html")
public class ModfiyUserPw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModfiyUserPw() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userPassword = request.getParameter("userPassword");
		int userId = Integer.parseInt(request.getParameter("userId").trim());

		boolean flag = false;
		UserDaoImpl daoUser = new UserDaoImpl();
		flag =  daoUser.modfiyUserPassWord(userPassword, userId);

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
