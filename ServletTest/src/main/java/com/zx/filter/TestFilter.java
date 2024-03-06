package com.zx.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;

import java.io.IOException;

/**
 * <p>
 * description:  <br>
 * create: 2024-03-06 15:45 <br>
 * </p>
 *
 * @author zhou  xun
 */
@WebFilter(filterName="testFilter",urlPatterns="/*", initParams = {
        @WebInitParam(name = "noLoginPaths", value = "index.jsp;fail.jsp;/LoginServlet")
})
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
