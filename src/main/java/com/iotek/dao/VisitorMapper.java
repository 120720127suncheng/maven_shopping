package com.iotek.dao;

import com.iotek.po.Visitor;

/**
 * com.iotek.dao
 *
 * @author <Author Administrator>
 * @date 2018/3/13 22:36
 */
public interface VisitorMapper {
    boolean addVisitor(Visitor visitor);
    Visitor findVisitorByPassword(Visitor visitor);
    Visitor findVisitorPhone(String visitorPhone);
    Visitor findVisitorEmail(String visitorEmail);
    boolean afterVisitorLogin(Visitor visitor);
}