package com.iotek.controller;

import com.iotek.po.Visitor;
import com.iotek.service.VisitorService;
import com.iotek.util.RegularExpressCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * com.iotek.controller
 *
 * @author <Author Administrator>
 * @date 2018/3/14 11:29
 */
@Controller
@RequestMapping(value = "/visitor")
public class VisitorController {
    @Autowired
    private VisitorService visitorService;
    @RequestMapping(value = "visitorLogin.do")
    public String visitorLogin(String visitorEmailOrPhone, String visitorPassword,
                               @RequestParam(value = "isRemember",required = false)String isRemember,
                               HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model){
        if(visitorEmailOrPhone==null||visitorPassword==null){
            if(session.getAttribute("visitor")==null){
                return "allIndex";
            }else {
                return "visitor/visitorIndex";
            }
        }
        Visitor visitor=new Visitor();
        visitor.setVisitorPassword(visitorPassword);
        if(RegularExpressCheck.checkEmail(visitorEmailOrPhone)){
            visitor.setVisitorEmail(visitorEmailOrPhone);
        }else if(RegularExpressCheck.checkPhone(visitorEmailOrPhone)){
            visitor.setVisitorPhone(visitorEmailOrPhone);
        }else {
            model.addAttribute("info","账号信息输入错误!");
            return "allIndex";
        }
        visitor=visitorService.findVisitorByPassword(visitor);
        if(visitor==null){
            model.addAttribute("info","账号信息输入错误!");
            return "allIndex";
        }
        if("on".equals(isRemember)){
            Cookie cookieLoginName=new Cookie("visitorAccount",visitorEmailOrPhone);
            cookieLoginName.setMaxAge(60*60*24);
            cookieLoginName.setPath("/");
            Cookie cookiePassword=new Cookie("visitorPassword",visitorPassword);
            cookiePassword.setMaxAge(60*60*24);
            cookiePassword.setPath("/");
            response.addCookie(cookieLoginName);
            response.addCookie(cookiePassword);
        }
        session.setAttribute("visitor",visitor);
        return "visitor/visitorIndex";
    }
}