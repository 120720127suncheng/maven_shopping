package com.iotek.service;

import com.iotek.po.Admin;

/**
 * com.iotek.service
 *
 * @author <Author Administrator>
 * @date 2018/3/19 22:58
 */
public interface AdminService {
    boolean addAdmin(Admin admin);
    Admin findAdminByPassword(Admin admin);
    boolean updateAdmin(Admin admin);
    boolean updateAdminAfterLogin(Admin admin);
    Admin findAdminByAId(Admin admin);
}