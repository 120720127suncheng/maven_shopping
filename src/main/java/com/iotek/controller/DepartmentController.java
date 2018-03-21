package com.iotek.controller;

import com.iotek.po.Department;
import com.iotek.po.Position;
import com.iotek.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * com.iotek.controller
 *
 * @author <Author Administrator>
 * @date 2018/3/21 9:18
 */
@Controller
@RequestMapping(value = "/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @RequestMapping(value = "addDepartment.do")
    @ResponseBody
    public String addDepartment(Department department){
        if(departmentService.findDepartmentByName(department)!=null){
            return "is_exist";
        }else if(departmentService.addDepartment(department)){
            return "true";
        }else {
            return "false";
        }
    }
    @RequestMapping(value = "deleteDepartment.do")
    @ResponseBody
    public String deleteDepartment(Department department){
        department=departmentService.findDepartmentByName(department);
        if(department.getPosition()==null||department.getPosition().size()==0){
            if(departmentService.deleteDepartment(department)){
                return "true";
            }else {
                return "false";
            }
        }else {
            return "position_is_exist";
        }
    }
}