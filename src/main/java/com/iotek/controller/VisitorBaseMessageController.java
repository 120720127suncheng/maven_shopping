package com.iotek.controller;
import com.iotek.po.Visitor;
import com.iotek.po.VisitorBaseMessage;
import com.iotek.service.VisitorBaseMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * com.iotek.controller
 *
 * @author <Author Administrator>
 * @date 2018/3/16 16:29
 */
@Controller
@RequestMapping(value = "/visitorBaseMessage")
public class VisitorBaseMessageController {
    @Autowired
    private VisitorBaseMessageService visitorBaseMessageService;
    @RequestMapping(value = "visitorRegisterBaseMessage.do")
    public String addVisitorBaseMessage(VisitorBaseMessage visitorBaseMessage, Model model,String province,String city,String country,String street){
            if(visitorBaseMessage.getVisitorAge()==null||visitorBaseMessage.getVisitorName()==null
                    ||visitorBaseMessage.getVisitorNational()==null
                    ||visitorBaseMessage.getVisitorSex()==null
                    ||province==null||city==null||country==null||street==null){
                model.addAttribute("info","个人信息填写失败!");
                return "visitor/visitorRegisterBaseMessage";
            }else {/*先检查有没有该人的个人信息,有就不让他添加*/
                Visitor visitor=new Visitor();
                visitor.setId(visitorBaseMessage.getVisitorId());
                if(visitorBaseMessageService.findByVisitor(visitor)!=null){
                    model.addAttribute("info","你已经有个人信息了!");
                    return "visitor/visitorRegisterBaseMessage";
                }else {/*否则就添加*/
                    visitorBaseMessage.setVisitorAddress(province+city+country+street);
                    if(visitorBaseMessageService.addVisitorBaseMessage(visitorBaseMessage)){
                        return "allIndex";
                    }else {
                        model.addAttribute("info","个人信息填写失败!");
                        return "visitor/visitorRegisterBaseMessage";
                    }
                }

            }
    }
}