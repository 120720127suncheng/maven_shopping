package com.iotek.dao;

import com.iotek.po.Position;
import com.iotek.po.Staff;

import java.util.List;

/**
 * com.iotek.dao
 *
 * @author <Author Administrator>
 * @date 2018/3/20 13:33
 */
public interface StaffMapper {
    boolean addStaff(Staff staff);
    Staff findStaffByPassword(Staff staff);
    boolean updateStaff(Staff staff);
    Staff findStaffBySId(Staff staff);
    List<Staff> findStaffByPosition(Position position);
}