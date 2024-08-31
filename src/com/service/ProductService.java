package com.service;

import com.db.ConnectionDto;
import com.model.Product;

import java.util.List;

public interface ProductService {


    void addProduct(Product pd);
    void deleteProduct(int id);
    List<Product> getAllProducts();
}
