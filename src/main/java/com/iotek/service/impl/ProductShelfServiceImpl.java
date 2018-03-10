package com.iotek.service.impl;


import com.iotek.dao.ProductShelfMapper;
import com.iotek.po.ProductShelf;

import com.iotek.service.ProductShelfService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * com.iotek.Service.impl
 *
 * @author <Author Administrator>
 * @date 2018/3/1 17:14
 */
@Transactional
@Component(value = "productShelfService")
public class ProductShelfServiceImpl implements ProductShelfService {
    @Autowired
    private  ProductShelfMapper productShelfMapper;
    @Override
    public ProductShelf queryProductShelfByPId(int id) {
        return null;
    }

    @Override
    public List<ProductShelf> queryAllProduct() {
        return productShelfMapper.queryAllProduct();
    }
}