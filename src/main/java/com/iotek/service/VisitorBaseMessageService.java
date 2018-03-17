package com.iotek.service;

import com.iotek.po.Visitor;
import com.iotek.po.VisitorBaseMessage;

/**
 * com.iotek.service
 *
 * @author <Author Administrator>
 * @date 2018/3/16 15:47
 */
public interface VisitorBaseMessageService {
    boolean addVisitorBaseMessage(VisitorBaseMessage visitorBaseMessage);
    VisitorBaseMessage findByVisitor(Visitor visitor);
}