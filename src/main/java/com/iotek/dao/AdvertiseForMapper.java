package com.iotek.dao;

import com.iotek.po.AdvertiseFor;

/**
 * com.iotek.dao
 *
 * @author <Author Administrator>
 * @date 2018/3/20 19:37
 */
public interface AdvertiseForMapper {
    boolean addAdvertiseFor(AdvertiseFor advertiseFor);
    AdvertiseFor findAdvertiseForById(AdvertiseFor advertiseFor);
    boolean updateAdvertiseFor(AdvertiseFor advertiseFor);
}