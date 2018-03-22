package com.iotek.service;

import com.iotek.po.Admin;
import com.iotek.po.Staff;

/**
 * com.iotek.service
 *
 * @author <Author Administrator>
 * @date 2018/3/20 13:42
 */
public interface StaffService {
    boolean addStaff(Staff staff);
    Staff findStaffByPassword(Staff staff);
    boolean updateStaff(Staff staff);
    boolean updateStaffAfterLogin(Staff staff);
    Staff findStaffBySId(Staff staff);
    Staff findStaffByPhone(Staff staff);
    Staff findStaffByEmail(Staff staff);
}