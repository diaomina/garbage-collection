package com.soft.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class CharactorFilter
 */
public class CharactorFilter implements Filter {

	// 字符编码
	String encoding = null;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		if (encoding != null) {
			String url=((HttpServletRequest) request).getRequestURI();
			if(url.indexOf(".css")>0||url.indexOf(".js")>0||url.indexOf(".jpg")>0
					||url.indexOf(".png")>0||url.indexOf(".eot")>0||url.indexOf(".svg")>0
					||url.indexOf(".ttf")>0||url.indexOf(".woff")>0||url.indexOf(".woff2")>0
					||url.indexOf(".jpge")>0) {
	            chain.doFilter(request, response);
	            return;
	        }
			// 设置request字符编码
			request.setCharacterEncoding(encoding);
			// 设置response字符编码
			response.setContentType("text/html;charset=" + encoding);
		}

		// 传递给下一个过滤器
		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 获取初始化参数
		encoding = filterConfig.getInitParameter("encoding");

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		encoding = null;
	}

}
