package com.iotek.service.impl;
import com.iotek.po.Product;
import com.iotek.service.ProductService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Override
    public boolean addProduct(Product product) {
        return false;
    }

    @Override
    public boolean deleteProduct(Product product) {
        return false;
    }

    @Override
    public boolean updateProductName(Product product) {
        return false;
    }

    @Override
    public List<Product> queryAllProduct() {
        return null;
    }

    @Override
    public List<Product> queryProductByName(Product product) {
        return null;
    }

    @Override
    public Product queryProductById(int id) {
        return null;
    }
}