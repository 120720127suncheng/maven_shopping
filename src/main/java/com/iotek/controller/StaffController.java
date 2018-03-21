package com.iotek.controller;

import com.iotek.po.Staff;
import com.iotek.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * com.iotek.controller
 *
 * @author <Author Administrator>
 * @date 2018/3/20 15:24
 */
@Controller
@RequestMapping(value = "/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;
    @RequestMapping(value = "staffLogin.do")
    public String staffLogin(Staff staff, Model model, HttpServletRequest request){
        if(staff.getStaffEmail()==null||staff.getStaffPassword()==null){
            if(request.getSession().getAttribute("staff")==null){
                return "staff/login";
            }else {
                return "staff/staffIndex";
            }
        }
        staff=staffService.findStaffByPassword(staff);
        if(staff==null){
            model.addAttribute("info","账号信息错误，请重新输入!");
            return "staff/login";
        }else if(staff.getStaffIsLogin()==1){
            model.addAttribute("info","该账号已被登录,如有异议请快速联系总管理员!");
            return "staff/login";
        }
        if(staffService.updateStaffAfterLogin(staff)){
            staff=staffService.findStaffBySId(staff);
            request.getSession().setAttribute("staff",staff);
            return "staff/staffIndex";
        }else {
            model.addAttribute("info","登录异常,请重新登录!");
            return "staff/login";
        }
    }
    @RequestMapping(value = "addJobSearch.do")
    public String addJobSearch(){
        return "";
    }
}