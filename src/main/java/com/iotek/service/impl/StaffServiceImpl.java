package com.iotek.service.impl;

import com.iotek.dao.StaffMapper;
import com.iotek.po.Staff;
import com.iotek.service.StaffService;
import com.iotek.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * com.iotek.service.impl
 *
 * @author <Author Administrator>
 * @date 2018/3/20 13:48
 */
@Transactional
@Component(value = "staffService")
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffMapper staffMapper;
    @Override
    public boolean addStaff(Staff staff) {
        return staffMapper.addStaff(staff);
    }

    @Override
    public Staff findStaffByPassword(Staff staff) {
        return staffMapper.findStaffByPassword(staff);
    }

    @Override
    public boolean updateStaff(Staff staff) {
        return staffMapper.updateStaff(staff);
    }

    @Override
    public boolean updateStaffAfterLogin(Staff staff) {
        staff.setStaffIsLogin(1);
        staff.setStaffLoginTime(TimeUtil.getTimestamp());
        return staffMapper.updateStaff(staff);
    }

    @Override
    public Staff findStaffBySId(Staff staff) {
        return staffMapper.findStaffBySId(staff);
    }

    @Override
    public Staff findStaffByPhone(Staff staff) {
        return staffMapper.findStaffByPhone(staff);
    }

    @Override
    public Staff findStaffByEmail(Staff staff) {
        return staffMapper.findStaffByEmail(staff);
    }
}