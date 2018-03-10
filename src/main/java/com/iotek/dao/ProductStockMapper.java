package com.iotek.dao;

import com.iotek.po.ProductStock;

/**
 * com.iotek.dao
 *
 * @author <Author Administrator>
 * @date 2018/3/1 16:55
 */
public interface ProductStockMapper {
    ProductStock queryProductStockByPId(int id);
}