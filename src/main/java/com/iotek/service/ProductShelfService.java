package com.iotek.service;


import com.iotek.po.ProductShelf;

import java.util.List;

/**
 * com.iotek.Service
 *
 * @author <Author Administrator>
 * @date 2018/3/1 17:03
 */
public interface ProductShelfService {
    ProductShelf queryProductShelfByPId(int id);
    List<ProductShelf> queryAllProduct();
}