package com.iotek.dao;
import com.iotek.po.Visitor;
import com.iotek.po.VisitorBaseMessage;

/**
 * com.iotek.dao
 *
 * @author <Author Administrator>
 * @date 2018/3/16 15:43
 */
public interface VisitorBaseMessageMapper {
    boolean addVisitorBaseMessage(VisitorBaseMessage visitorBaseMessage);
    VisitorBaseMessage findByVisitor(Visitor visitor);
    boolean updateVisitorBaseMessage(VisitorBaseMessage visitorBaseMessage);
}