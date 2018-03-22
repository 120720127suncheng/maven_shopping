package com.iotek.controller;

import com.iotek.po.Admin;
import com.iotek.po.Department;
import com.iotek.po.Position;
import com.iotek.service.AdminService;
import com.iotek.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * com.iotek.controller
 *
 * @author <Author Administrator>
 * @date 2018/3/19 23:01
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private DepartmentService departmentService;
    @RequestMapping(value = "adminLogin.do")
    public String adminLogin(Admin admin, Model model, HttpServletRequest request){
        if(admin.getAdminName()==null||admin.getAdminPassword()==null){
            if(request.getSession().getAttribute("admin")==null){
                    return "staff/login";
            }else {
                    return "admin/adminIndex";
            }
        }
        admin=adminService.findAdminByPassword(admin);
        if(admin==null){
            model.addAttribute("info","账号信息错误，请重新输入!");
            return "staff/login";
        }else if(admin.getAdminIsLogin()==1){
            model.addAttribute("info","该账号已被登录,如有异议请快速联系总管理员!");
            return "staff/login";
        }
        if(adminService.updateAdminAfterLogin(admin)){
            admin=adminService.findAdminByAId(admin);
            request.getSession().setAttribute("admin",admin);
            return "admin/adminIndex";
        }else {
            model.addAttribute("info","登录异常,请重新登录!");
            return "staff/login";
        }
    }
    @RequestMapping(value = "jumpToAddDepartView")
    public String jumpToAddDepart(Model model){
        List<Department> departmentList=departmentService.findExistDepartment();
        if(departmentList.size()==0||departmentList==null){
            model.addAttribute("departmentList","暂无任何部门!");
            return "admin/addDepartment";
        }
        model.addAttribute("departmentList",departmentService.findExistDepartment());
        return "admin/addDepartment";
    }
    @RequestMapping(value = "addDepartment.do")
    public String addDepartment(Department department,Model model){
        if(department.getDepartmentName()==null){
            model.addAttribute("info","部门添加失败!");
            return "admin/addDepartment";
        }
        if(departmentService.findDepartmentByName(department)!=null){
            model.addAttribute("info","该部门已存在,请勿重复添加!");
            return "admin/addDepartment";
        }
        if(departmentService.addDepartment(department)){
            model.addAttribute("departmentList",departmentService.findExistDepartment());
            model.addAttribute("info","添加成功!");
            return "admin/addDepartment";
        }
        model.addAttribute("info","添加失败");
        return "admin/addDepartment";
    }
    @RequestMapping(value = "jumpToAddStaffView")
    public String jumpToAddStaffView(Model model){
        List<Department> departmentList=departmentService.findExistDepartment();
        if(departmentList==null||departmentList.size()==0){
            model.addAttribute("departmentList","暂无任何部门!");
            return  "admin/addStaff";
        }else {
            model.addAttribute("departmentList",departmentList);
            return  "admin/addStaff";
        }
    }
}