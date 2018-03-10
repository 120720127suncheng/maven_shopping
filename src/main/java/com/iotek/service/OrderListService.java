package com.iotek.service;

import com.iotek.po.OrderList;

import java.util.List;

/**
 * com.iotek.Service
 *
 * @author <Author Administrator>
 * @date 2018/3/3 9:50
 */
public interface OrderListService {
    List<OrderList> findOrderListByCId(int id);
}