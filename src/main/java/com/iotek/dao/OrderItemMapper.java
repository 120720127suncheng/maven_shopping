package com.iotek.dao;

import com.iotek.po.OrderList;

import java.util.List;

/**
 * com.iotek.dao
 *
 * @author <Author Administrator>
 * @date 2018/3/3 10:23
 */
public interface OrderItemMapper {
    List<OrderList> findOrderItemByOrderListId(OrderList orderList);
}