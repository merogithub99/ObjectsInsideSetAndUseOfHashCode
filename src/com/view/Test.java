package com.view;

import com.model.Product;
import com.service.ProductService;
import com.service.ProductServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        addBtn();
        getAll();
        deleteBtn();
    }




    
    static void addBtn(){
        Scanner scanner = new Scanner(System.in);
        char flag='y';
       do{
           Product product  = new Product();
           ProductService productService= new ProductServiceImpl();
           System.out.println("Enter id:");
           product.setId(scanner.nextInt());
           product.setName("Mobile");
           product.setCompany("abc");
           product.setMfd(LocalDate.now());
           product.setExpDate(LocalDate.now().plusYears(5));
           product.setPrice(15000);
           System.out.println("do you want to add more");
           flag=scanner.next().charAt(0);
           productService.addProduct(product);

       }while(flag=='y');
    }

   static void getAll(){
        ProductService productService = new ProductServiceImpl();
       List<Product> productList = productService.getAllProducts();
       System.out.println(productList);
    }


    static  void deleteBtn(){
        ProductService productService= new ProductServiceImpl();
        productService.deleteProduct(0);
        getAll();//get all product after deletion
    }
}
