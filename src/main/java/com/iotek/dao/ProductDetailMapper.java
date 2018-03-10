package com.iotek.dao;

import com.iotek.po.Product;
import com.iotek.po.ProductDetail;

/**
 * com.iotek.dao
 *
 * @author <Author Administrator>
 * @date 2018/3/1 14:50
 */
public interface ProductDetailMapper {
    ProductDetail queryProductDetailByPId(int id);
}