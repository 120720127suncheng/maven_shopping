package com.iotek.service;

import com.iotek.po.Department;

import java.util.List;

/**
 * com.iotek.service
 *
 * @author <Author Administrator>
 * @date 2018/3/20 20:19
 */
public interface DepartmentService {
    boolean addDepartment(Department department);
    Department findDepartmentByName(Department department);
    Department findDepartmentByDId(Department department);
    boolean updateDepartment(Department department);
    List<Department> findAllDepartment();
    boolean deleteDepartment(Department department);
    List<Department> findExistDepartment();
}