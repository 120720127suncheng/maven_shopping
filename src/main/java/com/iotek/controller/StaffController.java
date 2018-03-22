package com.iotek.controller;

import com.iotek.po.Department;
import com.iotek.po.Position;
import com.iotek.po.Staff;
import com.iotek.service.DepartmentService;
import com.iotek.service.PositionService;
import com.iotek.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    @Autowired
    private PositionService positionService;
    @Autowired
    private DepartmentService departmentService;
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
    @RequestMapping(value = "addStaff.do")
    public  String addStaff(Staff staff, Department department, Position position,Model model){
        department=departmentService.findDepartmentByName(department);
        position.setDepartmentId(department.getId());
        position=positionService.findPositionByNameAndDId(position);
        staff.setStaffPassword(staff.getStaffPhone());
        staff.setPositionId(position.getId());
        if(staffService.addStaff(staff)){
            model.addAttribute("info","增加成功!");
           return "admin/adminIndex";
        }
        model.addAttribute("info","增加失败!");
            return  "admin/adminIndex";
    }
    @RequestMapping(value = "checkStaffPhone.do")
    @ResponseBody
    public String checkStaffPhone(Staff staff){
        if(staff.getStaffPhone()==null){
            return "false";
        }else {
            if(staffService.findStaffByPhone(staff)==null){
            return "is_not_exist";
            }else {
                return "is_exist";
            }
        }
    }
    @RequestMapping(value = "checkStaffEmail.do")
    @ResponseBody
    public String checkStaffEmail(Staff staff){
        if(staff.getStaffEmail()==null){
            return "false";
        }else {
            if(staffService.findStaffByEmail(staff)==null){
                return "is_not_exist";
            }else {
                return "is_exist";
            }
        }
    }
}