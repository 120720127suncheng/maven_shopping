package com.iotek.service.impl;

import com.iotek.dao.VisitorBaseMessageMapper;
import com.iotek.dao.VisitorMapper;
import com.iotek.po.Visitor;
import com.iotek.po.VisitorBaseMessage;
import com.iotek.service.VisitorService;
import com.iotek.util.Validate;
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
    @Autowired
    private VisitorBaseMessageMapper visitorBaseMessageMapper;

    @Override
    public Visitor findVisitorByVId(Visitor visitor) {
        return visitorMapper.findVisitorByVId(visitor);
    }

    public boolean addVisitor(Visitor visitor) {
        return visitorMapper.addVisitor(visitor);
    }

    public Visitor findVisitorByPassword(Visitor visitor) {
        return visitorMapper.findVisitorByPassword(visitor);
    }

    @Override
    public Visitor findVisitorPhone(String visitorPhone) {
        return visitorMapper.findVisitorPhone(visitorPhone);
    }

    @Override
    public Visitor findVisitorEmail(String visitorEmail) {
        return visitorMapper.findVisitorEmail(visitorEmail);
    }

    @Override
    public boolean afterVisitorLogin(Visitor visitor) {
        return visitorMapper.afterVisitorLogin(visitor);
    }
    @Override
    public boolean updateVisitorMessage(Visitor visitor,VisitorBaseMessage visitorBaseMessage) {
        if(visitor==null){
            Validate.throwNull("游客为空!");
        }
        //若该游客有账户信息却无基本信息，则增加基本信息
        if(visitorMapper.updateVisitor(visitor)&&visitorBaseMessageMapper.updateVisitorBaseMessage(visitorBaseMessage)){
            return true;
        }

        return false;
    }
}