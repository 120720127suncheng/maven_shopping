package com.iotek.filter;
import com.iotek.po.Visitor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SessionHandlerInterceptor implements HandlerInterceptor {
    /*检查session有没有，并且该session与我登录的账号是否一致*/
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session=httpServletRequest.getSession();
        if(session==null){/*没有session直接跳到起始登录页面*/
            httpServletResponse.sendRedirect("allIndex");
            return false;
        }else {/*有就检查里面有没有visitor对象*/
            Visitor visitor= (Visitor) session.getAttribute("visitor");
            if(visitor==null){
                httpServletResponse.sendRedirect("allIndex");
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
