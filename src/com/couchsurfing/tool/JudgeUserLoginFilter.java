package com.couchsurfing.tool;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;  

import org.apache.commons.lang.StringUtils;

public class JudgeUserLoginFilter implements Filter {

	private String unUrl;
	private List<String> unUrlList;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response; 
		String servletPath = req.getServletPath();
		
		/*System.out.println("servletPath��"+servletPath);*/
		if(unUrlList.contains(servletPath)) {
			chain.doFilter(request, response);   
			
		}else{
			 HttpSession session = req.getSession();
			 if(session == null || session.getAttribute("user")==null){
				
					PrintWriter out = res.getWriter();
					out.println("<script>alert('请先登录!');window.location.href='/CouchSurfing/IndexAction.html';</script>");
					out.flush();
					out.close();
				    
			 }else{
				 chain.doFilter(request, response);    
			 }
			
		}
			  
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		unUrl = fConfig.getInitParameter("unUrl");
		if (StringUtils.isNotEmpty(unUrl)) {
			unUrlList = Arrays.asList(unUrl.split(","));
		}
		
	}

}
