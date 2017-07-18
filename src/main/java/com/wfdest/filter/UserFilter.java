package com.wfdest.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by feiwei on 2017/7/17.
 */
@WebFilter(filterName = "userFilter",urlPatterns = "/*")
public class UserFilter implements Filter {
    private static Logger logger = Logger.getLogger(UserFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("##################过滤用户");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
