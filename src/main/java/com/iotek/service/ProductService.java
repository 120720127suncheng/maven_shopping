package com.iotek.service;

import com.iotek.po.Product;

import java.util.List;

public interface ProductService {
    boolean addProduct(Product product);
    boolean deleteProduct(Product product);
    boolean updateProductName(Product product);
    List<Product> queryAllProduct();
    List<Product> queryProductByName(Product product);
    Product queryProductById(int id);
}