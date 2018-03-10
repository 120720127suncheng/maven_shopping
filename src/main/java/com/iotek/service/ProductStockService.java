package com.iotek.service;

import com.iotek.po.ProductStock;

/**
 * com.iotek.Service
 *
 * @author <Author Administrator>
 * @date 2018/3/1 17:05
 */
public interface ProductStockService {
    ProductStock queryProductStockByPId(int id);
}