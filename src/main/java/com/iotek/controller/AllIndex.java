package com.iotek.controller;

import com.iotek.po.Visitor;
import com.iotek.service.VisitorService;
import com.iotek.util.RegularExpressCheck;
import com.iotek.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

/**
 * com.iotek.controller
 *
 * @author <Author Administrator>
 * @date 2018/3/14 10:51
 */
@Controller
public class AllIndex {
    @Autowired
    private VisitorService visitorService;
    /*指向总的一个登录界面*/
    @RequestMapping(value = "")
    public String jumpToIndex(){
        return "redirect:visitorLogin";
    }
    @RequestMapping(value = "visitorLogin")
    public String visitorLogin(HttpServletRequest request, HttpSession session, Model model, Visitor visitor){
       /*先查询有没有cookie，没有就直接跳到起始页面*/
        Cookie[] cookies=request.getCookies();
        if(cookies==null){
            return "allIndex";
        }
        String visitorAccount=null;
        String visitorPassword=null;
        /*若有就查询cookie里是否存储了跟visitor有关的正确账号信息*/
        for (Cookie cookie : cookies) {
            if("visitorAccount".equals(cookie.getName())){
                visitorAccount=cookie.getValue();
            }
            if("visitorPassword".equals(cookie.getName())){
                visitorPassword=cookie.getValue();
            }
        }
        if(visitorAccount==null||visitorPassword==null){
            return  "allIndex";
        }/*解析是邮箱还是手机号*/
        if(RegularExpressCheck.checkEmail(visitorAccount)){
            visitor.setVisitorEmail(visitorAccount);
        }else if(RegularExpressCheck.checkPhone(visitorAccount)){
            visitor.setVisitorPhone(visitorAccount);
        }else {
            return "allIndex";
        }
        visitor.setVisitorPassword(visitorPassword);
        visitor=visitorService.findVisitorByPassword(visitor);
        if(visitor==null){
            return "allIndex";
        }/*若账号已被登录就跳至起始页面*/
        if(visitor.getVisitorIsOn()==1){
            return "allIndex";
        }
        /*存储一下session并转到visitor的主界面*/
        session.setAttribute("visitor",visitor);
       /*设置账号已经登录了*/
        visitor.setVisitorLoginTime(TimeUtil.getTimestamp());
        visitorService.afterVisitorLogin(visitor);
        return "visitor/visitorIndex";
    }
    @RequestMapping(value = "jumpToVisitorRegisterView")
    public String jumpToVisitorRegisterView(){
        return "visitor/visitorRegister";
    }
}