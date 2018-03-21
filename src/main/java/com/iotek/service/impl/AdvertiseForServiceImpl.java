package com.iotek.service.impl;

import com.iotek.dao.AdvertiseForMapper;
import com.iotek.po.AdvertiseFor;
import com.iotek.service.AdvertiseForService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * com.iotek.service.impl
 *
 * @author <Author Administrator>
 * @date 2018/3/21 22:45
 */
@Transactional
@Component(value = "advertiseForService")
public class AdvertiseForServiceImpl implements AdvertiseForService {
    @Autowired
    private AdvertiseForMapper advertiseForMapper;
    @Override
    public boolean addAdvertiseFor(AdvertiseFor advertiseFor) {
        return advertiseForMapper.addAdvertiseFor(advertiseFor);
    }

    @Override
    public AdvertiseFor findAdvertiseForById(AdvertiseFor advertiseFor) {
        return advertiseForMapper.findAdvertiseForById(advertiseFor);
    }

    @Override
    public boolean updateAdvertiseFor(AdvertiseFor advertiseFor) {
        return advertiseForMapper.updateAdvertiseFor(advertiseFor);
    }
}