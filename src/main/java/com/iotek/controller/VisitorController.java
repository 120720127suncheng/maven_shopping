package com.iotek.controller;

import com.iotek.po.Visitor;
import com.iotek.service.VisitorService;
import com.iotek.util.RegularExpressCheck;
import com.iotek.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

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
        }else if(visitor.getVisitorIsOn()==1){
            model.addAttribute("info","该账号已被登录,请及时更新密码!");
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
        /*设置状态为已登录*/
        visitor.setVisitorLoginTime(TimeUtil.getTimestamp());
        visitorService.afterVisitorLogin(visitor);
        return "visitor/visitorIndex";
    }
    @RequestMapping(value = "visitorRegister.do")
    public String visitorRegister(Visitor visitor,Model model){
            if(visitor.getVisitorPhone()==null||visitor.getVisitorEmail()==null||visitor.getVisitorPassword()==null){
                model.addAttribute("info","注册失败!小子,谁让你复制粘贴url了");
                return "visitor/visitorRegister";
            }
            boolean addVisitor=visitorService.addVisitor(visitor);
            if(addVisitor){
                model.addAttribute("visitor",visitor);
                return "visitor/visitorRegisterBaseMessage";
            }else {
                model.addAttribute("info","注册失败");
              return "visitor/visitorRegister";
            }
    }
    @RequestMapping(value = "checkVisitorPhone.do")
    @ResponseBody
    public String checkVisitorPhone(String visitorPhone){
        Visitor visitor=visitorService.findVisitorPhone(visitorPhone);
        if(visitor==null){
            return "is_not_exist";
        }else {
            return "is_exist";
        }
    }
    @RequestMapping(value = "checkVisitorEmail.do")
    @ResponseBody
    public String checkVisitorEmail(String visitorEmail){
        Visitor visitor=visitorService.findVisitorEmail(visitorEmail);
        if(visitor==null){
            return "is_not_exist";
        }else {
            return "is_exist";
        }
    }
}