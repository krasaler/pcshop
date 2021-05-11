package Filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FltRussian implements Filter {
	String rqEnc, resEnc;

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		response.setContentType(resEnc);
		((HttpServletResponse)response).setHeader("cache-control", "no-cache");
		((HttpServletRequest)request).setCharacterEncoding("UTF-8");
		chain.doFilter(request,response);
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		resEnc= fConfig.getInitParameter("responseEncoding");
		if (resEnc == null)
			resEnc = "text/html;charset=UTF-8";
		else
			resEnc = "text/html;charset="+resEnc;
	}

}
