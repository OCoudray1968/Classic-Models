package com.classicModels.tools;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
 
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
 
/**
 *
 * @author philippe
 */
@WebFilter(filterName = "BlacklistURL", urlPatterns = {"/*"})
public class BlacklistURL implements Filter {
 
	private static final boolean debug = true;
	// The filter configuration object we are associated with.  If
	// this value is null, this filter instance is not currently
	// configured. 
	private FilterConfig filterConfig = null;
 
 
	private String[] blacklistedURL = {
		"/foo",
		"/bar",
	};
 
	/**
         *
         * @param request The servlet request we are processing
         * @param response The servlet response we are creating
         * @param chain The filter chain we are processing
         *
         * @exception IOException if an input/output error occurs
         * @exception ServletException if a servlet error occurs
         */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain)
			throws IOException, ServletException {
			HttpServletRequest httpRequest = (HttpServletRequest)request;
			for (String url : blacklistedURL) {
				// Si l'url est en liste noir
				if (httpRequest.getServletPath().equals(url)) {
					// Forwarding vers /blacklisted.jsp
					request.getRequestDispatcher("/blacklisted.jsp").forward(request, response);
				}
			}
 
			// l'url continue sont cours
			chain.doFilter(request, response);
	}
 
	/**
         * Destroy method for this filter
         */
	public void destroy() {		
	}
 
	/**
         * Init method for this filter
         */
	public void init(FilterConfig filterConfig) {		
		this.filterConfig = filterConfig;
	}
}

