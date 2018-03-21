package com.iotek.service.impl;

import com.iotek.dao.DepartmentMapper;
import com.iotek.po.Department;
import com.iotek.service.DepartmentService;
import com.iotek.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * com.iotek.service.impl
 *
 * @author <Author Administrator>
 * @date 2018/3/20 20:20
 */
@Transactional
@Component(value = "departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public boolean addDepartment(Department department) {
        return departmentMapper.addDepartment(department);
    }

    @Override
    public Department findDepartmentByName(Department department) {
        return departmentMapper.findDepartmentByName(department);
    }

    @Override
    public Department findDepartmentByDId(Department department) {
        return departmentMapper.findDepartmentByDId(department);
    }

    @Override
    public boolean updateDepartment(Department department) {
        return departmentMapper.updateDepartment(department);
    }

    @Override
    public List<Department> findAllDepartment() {
        return departmentMapper.findAllDepartment();
    }

    @Override
    public boolean deleteDepartment(Department department) {
        if(department.getDepartmentName()==null){
            return false;
        }
        department=departmentMapper.findDepartmentByName(department);
        department.setDepartmentIsDeleted(1);
        department.setDepartmentModifiedTime(TimeUtil.getTimestamp());
        return departmentMapper.updateDepartment(department);
    }

    @Override
    public List<Department> findExistDepartment() {
        return departmentMapper.findExistDepartment();
    }
}