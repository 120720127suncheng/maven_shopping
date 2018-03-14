package com.iotek.service.impl;

import com.iotek.dao.VisitorMapper;
import com.iotek.po.Visitor;
import com.iotek.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * com.iotek.service.impl
 *
 * @author <Author Administrator>
 * @date 2018/3/14 10:21
 */
@Transactional
@Component(value = "visitorService")
public class VisitorServiceImpl implements VisitorService {
    @Autowired
    private VisitorMapper visitorMapper;
    public boolean addVisitor(Visitor visitor) {
        return visitorMapper.addVisitor(visitor);
    }

    public Visitor findVisitorByPassword(Visitor visitor) {
        return visitorMapper.findVisitorByPassword(visitor);
    }
}