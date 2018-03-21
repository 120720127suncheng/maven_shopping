package com.iotek.controller;

import com.iotek.po.AdvertiseFor;
import com.iotek.po.Department;
import com.iotek.po.Position;
import com.iotek.po.Staff;
import com.iotek.service.AdvertiseForService;
import com.iotek.service.DepartmentService;
import com.iotek.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @date 2018/3/21 22:50
 */
@Controller
@RequestMapping(value = "/advertiseFor")
public class AdvertiseForController {
    @Autowired
    private AdvertiseForService advertiseForService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private DepartmentService departmentService;
    @RequestMapping(value = "jumpToAddAdvertiseFor")
    public String jumpToAddAdvertiseFor(Model model){
        List<Department> departmentList=departmentService.findExistDepartment();
        if(departmentList==null||departmentList.size()==0){
            model.addAttribute("departmentList","暂无任何部门!");
            return "staff/addAdvertiseFor";
        }else {
            model.addAttribute("departmentList",departmentList);
            return "staff/addAdvertiseFor";
        }
    }
    @RequestMapping(value = "addAdvertiseFor.do")
    @ResponseBody
    public String addAdvertiseFor(HttpServletRequest request,AdvertiseFor advertiseFor, Model model, Position position, Department department){
        if(position.getPositionName()==null||department.getDepartmentName()==null){
            return "false";
        }else {
            department=departmentService.findDepartmentByName(department);
            position.setDepartmentId(department.getId());
            position=positionService.findPositionByNameAndDId(position);
            Staff staff = (Staff) request.getSession().getAttribute("staff");
            advertiseFor.setStaffId(staff.getId());
            advertiseFor.setPositionId(position.getId());
            System.err.println(advertiseFor);
            if(advertiseForService.addAdvertiseFor(advertiseFor)){
                return "true";
            }else {
                return "false";
            }
        }
    }
}