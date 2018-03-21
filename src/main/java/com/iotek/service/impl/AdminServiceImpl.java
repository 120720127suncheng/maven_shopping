package com.iotek.service.impl;

import com.iotek.dao.AdminMapper;
import com.iotek.po.Admin;
import com.iotek.service.AdminService;
import com.iotek.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * com.iotek.service.impl
 *
 * @author <Author Administrator>
 * @date 2018/3/19 22:59
 */
@Transactional
@Component(value = "adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public boolean addAdmin(Admin admin) {
        return adminMapper.addAdmin(admin);
    }

    @Override
    public Admin findAdminByPassword(Admin admin) {
        return adminMapper.findAdminByPassword(admin);
    }

    @Override
    public boolean updateAdmin(Admin admin) {
        return adminMapper.updateAdmin(admin);
    }

    @Override
    public boolean updateAdminAfterLogin(Admin admin) {
        admin.setAdminIsLogin(1);
        admin.setAdminLoginTime(TimeUtil.getTimestamp());
        adminMapper.updateAdmin(admin);
        if(adminMapper.findAdminByAId(admin).getAdminIsLogin()==1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Admin findAdminByAId(Admin admin) {
        return adminMapper.findAdminByAId(admin);
    }
}