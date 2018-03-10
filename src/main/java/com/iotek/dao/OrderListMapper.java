package com.iotek.dao;

import com.iotek.po.OrderList;

import java.util.List;

/**
 * com.iotek.dao
 *
 * @author <Author Administrator>
 * @date 2018/3/3 9:25
 */
public interface OrderListMapper {
    List<OrderList> findOrderListByCId(int id);
}