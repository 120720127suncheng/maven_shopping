package com.iotek.controller;

import com.iotek.po.Visitor;
import com.iotek.po.VisitorBaseMessage;
import com.iotek.service.VisitorBaseMessageService;
import com.iotek.service.VisitorService;
import com.iotek.util.RegularExpressCheck;
import com.iotek.util.SaveFiles;
import com.iotek.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
    @Autowired
    private VisitorBaseMessageService visitorBaseMessageService;
    @RequestMapping(value = "visitorLogin.do")
    public String visitorLogin(String visitorEmailOrPhone, String visitorPassword,
                               @RequestParam(value = "isRemember",required = false)String isRemember,
                               HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model){
        session=request.getSession();
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
        visitor.setVisitorLoginTime(TimeUtil.getTimestamp());
        visitorService.afterVisitorLogin(visitor);
        visitor=visitorService.findVisitorByVId(visitor);
        session.setAttribute("visitor",visitor);
        /*设置状态为已登录*/
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
    @RequestMapping(value = "visitorViewMessage.do")
    public String visitorViewMessage(HttpSession httpSession,Model model,HttpServletRequest request){
        httpSession=request.getSession();
        if(httpSession==null){
            model.addAttribute("info","信息异常,请重新登录");
            return "allIndex";
        }
        Visitor visitor= (Visitor) httpSession.getAttribute("visitor");
        if(visitor.getVisitorPassword()==null||visitor.getVisitorPhone()==null){
            model.addAttribute("info","信息异常,请重新登录");
            return "allIndex";
        }
        visitor=visitorService.findVisitorByPassword(visitor);
        if(visitor==null){
            model.addAttribute("info","信息异常,请重新登录");
            return "allIndex";
        }else {
            return "visitor/showVisitorMessage";
        }
    }
    @RequestMapping(value = "updateBaseMessage.do")
    public String updateBaseMessage(@RequestParam(value = "file_upload",required=false) MultipartFile file
            ,Visitor visitor, Model model, HttpServletRequest request, VisitorBaseMessage visitorBaseMessage){
        HttpSession session=request.getSession();
        Visitor visitor1 = (Visitor) session.getAttribute("visitor");
        visitor.setId(visitor1.getId());
        visitor.setVisitorModifiedTime(TimeUtil.getTimestamp());
        visitorBaseMessage.setVisitorId(visitor1.getId());

        String baseFile=SaveFiles.saveFile(file,request);/*存储图片*/

        visitorBaseMessage.setPhoto(baseFile);
        //根据游客id查找相应的基本信息记录，若找到了就执行更新操作，没找到就执行添加操作
        if(visitorBaseMessageService.findByVisitor(visitor)==null){
            visitorBaseMessage.setVisitorCreateTime(TimeUtil.getTimestamp());
            if(visitorBaseMessageService.addVisitorBaseMessage(visitorBaseMessage)){
                visitor.setVisitorBaseMessage(visitorBaseMessage);
            }else {
                model.addAttribute("info","信息修改失败!");
                return "visitor/showVisitorMessage";
            }
        }
        visitorBaseMessage.setVisitorModifiedTime(TimeUtil.getTimestamp());
        if(visitorService.updateVisitorMessage(visitor,visitorBaseMessage)){
            model.addAttribute("info","修改成功!");
            visitor=visitorService.findVisitorByVId(visitor);
            session.setAttribute("visitor",visitor);
            return "visitor/showVisitorMessage";
        }else {
            model.addAttribute("info","信息修改失败!");
            return "visitor/showVisitorMessage";
        }
    }
    @RequestMapping(value = "updateBaseMessage.view")
    public String updateBaseMessageView(){
        return "visitor/updateVisitorMessage";
    }
    @RequestMapping(value = "updateVisitorPhone.do")
    @ResponseBody
    public String updateVisitorPhone(String visitorPhone,HttpServletRequest request){
        HttpSession session=request.getSession();
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        if(visitorPhone.equals(visitor.getVisitorPhone())){
            return "is_himself_phone";
        }else if(visitorService.findVisitorPhone(visitorPhone)==null){
            return "is_not_exist";
        }
        return "is_exist";
    }
    @RequestMapping(value = "updateVisitorEmail.do")
    @ResponseBody
    public String updateVisitorEmail(String visitorEmail,HttpServletRequest request){
        HttpSession session=request.getSession();
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        if(visitorEmail.equals(visitor.getVisitorEmail())){
            return "is_himself_email";
        }else if(visitorService.findVisitorEmail(visitorEmail)==null){
            return "is_not_exist";
        }
        return "is_exist";
    }
}