package com.iotek.service;

import com.iotek.po.Visitor;
import com.iotek.po.VisitorBaseMessage;

/**
 * com.iotek.service
 *
 * @author <Author Administrator>
 * @date 2018/3/14 10:20
 */
public interface VisitorService {
    Visitor findVisitorByVId(Visitor visitor);
    boolean addVisitor(Visitor visitor);
    Visitor findVisitorByPassword(Visitor visitor);
    Visitor findVisitorPhone(String visitorPhone);
    Visitor findVisitorEmail(String visitorEmail);
    boolean afterVisitorLogin(Visitor visitor);
    boolean updateVisitorMessage(Visitor visitor, VisitorBaseMessage visitorBaseMessage);
}