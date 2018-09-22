package wr.security.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

//@Component
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("timeFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("timeFilter start");
        Long startTime = new Date().getTime();
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("timeFilter end:"+(new Date().getTime()-startTime));
    }

    @Override
    public void destroy() {
        System.out.println("timeFilter destroy");
    }
}
