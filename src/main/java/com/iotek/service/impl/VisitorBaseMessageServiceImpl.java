package com.iotek.service.impl;

import com.iotek.dao.VisitorBaseMessageMapper;
import com.iotek.po.Visitor;
import com.iotek.po.VisitorBaseMessage;
import com.iotek.service.VisitorBaseMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * com.iotek.service.impl
 *
 * @author <Author Administrator>
 * @date 2018/3/16 15:48
 */
@Transactional
@Component(value = "visitorBaseMessageService")
public class VisitorBaseMessageServiceImpl implements VisitorBaseMessageService {
    @Autowired
    private VisitorBaseMessageMapper visitorBaseMessageMapper;
    @Override
    public boolean addVisitorBaseMessage(VisitorBaseMessage visitorBaseMessage) {
        return visitorBaseMessageMapper.addVisitorBaseMessage(visitorBaseMessage);
    }

    @Override
    public VisitorBaseMessage findByVisitor(Visitor visitor) {
        return visitorBaseMessageMapper.findByVisitor(visitor);
    }
}