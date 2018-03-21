package com.iotek.dao;

import com.iotek.po.Admin;

/**
 * com.iotek.dao
 *
 * @author <Author Administrator>
 * @date 2018/3/19 22:56
 */
public interface AdminMapper {
    boolean addAdmin(Admin admin);
    Admin findAdminByPassword(Admin admin);
    boolean updateAdmin(Admin admin);
    Admin findAdminByAId(Admin admin);
}