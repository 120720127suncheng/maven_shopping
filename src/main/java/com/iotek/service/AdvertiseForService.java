package com.iotek.service;

import com.iotek.po.AdvertiseFor;

/**
 * com.iotek.service
 *
 * @author <Author Administrator>
 * @date 2018/3/21 22:45
 */
public interface AdvertiseForService {
    boolean addAdvertiseFor(AdvertiseFor advertiseFor);
    AdvertiseFor findAdvertiseForById(AdvertiseFor advertiseFor);
    boolean updateAdvertiseFor(AdvertiseFor advertiseFor);
}