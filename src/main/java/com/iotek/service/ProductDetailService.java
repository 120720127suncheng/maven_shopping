package com.iotek.service;

import com.iotek.po.ProductDetail;

/**
 * com.iotek.Service.impl
 *
 * @author <Author Administrator>
 * @date 2018/3/1 14:58
 */
public interface ProductDetailService {
    ProductDetail queryProductDetailByPId(int id);
}