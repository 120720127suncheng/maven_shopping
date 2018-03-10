package com.iotek.dao;

import com.iotek.po.Product;

import java.util.List;

public interface ProductMapper {
    boolean addProduct(Product product);
    boolean deleteProduct(Product product);
    boolean updateProductName(Product product);
    List<Product> queryAllProduct();
    List<Product> queryProductByName(Product product);
    Product queryProductById(int id);
}