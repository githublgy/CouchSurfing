package com.couchsurfing.Action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.couchsurfing.dao.impl.UserDaoImpl;
import com.couchsurfing.entity.User;

/**
 * Servlet implementation class CropAction
 */
@WebServlet("/CropAction.html")
@MultipartConfig  
public class CropAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CropAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userId = request.getParameter("userId").trim();
		InputStream is = request.getPart("image").getInputStream();
		String path = "user_"+userId+".jpg";
		String  newpath = "/WEB/Image/"+path;
		String filepath = request.getServletContext().getRealPath(newpath.trim());
	//	System.out.println(filepath);
		byte [] buf = new byte[1024];
		int i=-1;
		
		FileOutputStream fos = new FileOutputStream(new File (filepath));
		while((i = is.read(buf))!=-1){
		
			fos.write(buf, 0, i);
			
		}
		is.close();
		fos.close();
		
		UserDaoImpl daoUser = new UserDaoImpl();
		daoUser.saveUserHead(path, Integer.parseInt(userId));
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		user=daoUser.verifyUser(user.getUserName(), user.getUserPassWord());
		  session.setAttribute("user", user);
		
		response.sendRedirect("PersonAction.html?"+new Date().getTime());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
