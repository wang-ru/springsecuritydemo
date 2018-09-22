package wr.security.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

//@Component
public class TimeInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("TimeInterceptor preHandle:");
        httpServletRequest.setAttribute("startTime", new Date().getTime());
        HandlerMethod handlerMethod = (HandlerMethod) o;
        System.out.println("Controller Name:"+handlerMethod.getBean().getClass().getName());
        System.out.println("Controller Method Name:"+handlerMethod.getMethod().getName());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("TimeInterceptor postHandle");
        System.out.println("endTime :"+((Long)httpServletRequest.getAttribute("startTime")-new Date().getTime()));
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
