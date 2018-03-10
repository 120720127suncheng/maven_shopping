package com.iotek.dao;

import com.iotek.po.ProductShelf;

import java.util.List;

/**
 * com.iotek.dao
 *
 * @author <Author Administrator>
 * @date 2018/3/1 16:52
 */
public interface ProductShelfMapper {
    ProductShelf queryProductShelfByPId(int id);
    List<ProductShelf> queryAllProduct();
}