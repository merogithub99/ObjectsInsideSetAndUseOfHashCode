package com.view;

import com.model.Product;
import com.service.ProductService;
import com.service.ProductServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("adding the products..........");
        addBtn();
        System.out.println("all products list");
        getAll();
        System.out.println("deleting the product..........");
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
           System.out.println("Enter name of product:");
           product.setName(scanner.nextLine());
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
         productList.forEach(System.out::println);
    }


    static  void deleteBtn(){
        Scanner scanner = new Scanner(System.in);
        ProductService productService= new ProductServiceImpl();
        System.out.println("which id to delete from the db?");
        productService.deleteProduct(scanner.nextInt());
        getAll();//get all product after deletion
    }
}
