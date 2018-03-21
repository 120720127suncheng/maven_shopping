package com.iotek.controller;

import com.iotek.po.Department;
import com.iotek.po.Position;
import com.iotek.service.DepartmentService;
import com.iotek.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * com.iotek.controller
 *
 * @author <Author Administrator>
 * @date 2018/3/21 15:06
 */
@Controller
@RequestMapping(value = "/position")
public class PositionController {
    @Autowired
    private PositionService positionService;
    @Autowired
    private DepartmentService departmentService;
    @RequestMapping(value = "jumpToAddPositionView")
    public String jumpToAddPosition(Model model){
        List<Department> departmentList=departmentService.findExistDepartment();
        if(departmentList==null||departmentList.size()==0){
            model.addAttribute("departmentList","暂无任何部门!");
            return "admin/addPosition";
        }else {
            model.addAttribute("departmentList",departmentList);
            return "admin/addPosition";
        }
    }
    @RequestMapping(value = "showPosition.do")
    public @ResponseBody List<Position> showPosition(Department department){
        department=departmentService.findDepartmentByName(department);
        List<Position> positionList=positionService.findPositionByDepartment(department);
        return positionList;
    }
    @RequestMapping(value = "addPosition.do")
    @ResponseBody
    public String addPosition(Department department,Position position){
        if(department.getDepartmentName()==null||position.getPositionName()==null){
            return "false";
        }
        department=departmentService.findDepartmentByName(department);
            for(Position position1:positionService.findPositionByDepartment(department)){
                    if(position1.getPositionName().equals(position.getPositionName())){
                        return "is_exist";
                    }
            }
            position.setDepartmentId(department.getId());
            positionService.addPosition(position);
        return "true";
    }
    @RequestMapping(value = "deletePosition.do")
    @ResponseBody
    public String deletePosition(Department department,Position position){
        if(department.getDepartmentName()==null||position.getPositionName()==null){
            return "false";
        }
        /*看该部门里有没有该职位*/
        department=departmentService.findDepartmentByName(department);
        List<Position> positionList=positionService.findPositionByDepartment(department);
        List<Position> positionList1=positionService.findPositionByName(position);
        for(Position p1:positionList){
            for (Position p2:positionList1){
                /*看有没有人担任该职位*/
                if(p1.getPositionName().equals(p2.getPositionName())){
                        if(p1.getStaff()!=null&&p1.getStaff().size()>0){
                            return "staff_is_exist";
                        }else {
                            if(positionService.deletePosition(p1)){
                                return "true";
                            }else {
                                return "false";
                            }
                        }
                }
            }
        }
        return "is_not_exist";
    }
}