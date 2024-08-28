package com.service;

import com.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    static List<Product> productList = new ArrayList<>();

    //static because this list is a single container means per class one
    //intialize only once
    @Override
    public void addProduct(Product pd) {

        productList.add(pd);
        System.out.println("----add success ----size=" + productList.size());

    }

    @Override
    public void deleteProduct(int index) {
        productList.remove(index);
    }

    @Override
    public List<Product> getAllProducts() {
        return productList;
    }
}
