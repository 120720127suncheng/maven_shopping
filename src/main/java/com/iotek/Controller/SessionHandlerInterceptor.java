package com.iotek.Controller;

import com.iotek.po.Customer;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * com.iotek.Controller
 *
 * @author <Author Administrator>
 * @date 2018/3/9 14:46
 */
public class SessionHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session=httpServletRequest.getSession();
        if(session==null){
            httpServletResponse.sendRedirect("index");
            return false;
        }else {
            Customer customer= (Customer) session.getAttribute("customer");
            if(customer==null){
                httpServletResponse.sendRedirect("index");
                return false;
            }
            return  true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}