package com.couchsurfing.tool;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SetCharacterEncodingFilter implements Filter {
	protected String encoding = null;
	protected FilterConfig filterConfig = null;

	@Override
	public void destroy() {
		// ����������
		this.encoding = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	
		// �жϵ�ǰ�����Ƿ��Ѿ����������˱����ʽ
		if (request.getCharacterEncoding() == null) {
			String encoding = this.encoding;
			if (encoding != null) {
				// ����request��reponse�����ʽΪutf-8
				request.setCharacterEncoding(encoding);
				response.setCharacterEncoding(encoding);
			}
		}
		// ������ִ�н�����ת������һ��������
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		// ��ȡ��ʼ������
		this.encoding = filterConfig.getInitParameter("encoding");
	
	}
}
