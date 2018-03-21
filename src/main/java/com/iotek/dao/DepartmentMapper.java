package com.iotek.dao;

import com.iotek.po.Department;

import java.util.List;

/**
 * com.iotek.dao
 *
 * @author <Author Administrator>
 * @date 2018/3/20 19:35
 */
public interface DepartmentMapper {
    boolean addDepartment(Department department);
    Department findDepartmentByName(Department department);
    Department findDepartmentByDId(Department department);
    boolean updateDepartment(Department department);
    List<Department> findAllDepartment();
    List<Department> findExistDepartment();
}