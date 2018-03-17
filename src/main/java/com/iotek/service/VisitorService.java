package com.iotek.service;

import com.iotek.po.Visitor;

/**
 * com.iotek.service
 *
 * @author <Author Administrator>
 * @date 2018/3/14 10:20
 */
public interface VisitorService {
    boolean addVisitor(Visitor visitor);
    Visitor findVisitorByPassword(Visitor visitor);
    Visitor findVisitorPhone(String visitorPhone);
    Visitor findVisitorEmail(String visitorEmail);
    boolean afterVisitorLogin(Visitor visitor);
}