package com.service;

import com.db.ConnectionDto;
import com.model.Product;

import java.sql.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    ConnectionDto connectionDto = new ConnectionDto();

    @Override
    public void addProduct(Product product) {
        String addQuery = "insert into p_table values(?,?,?,?,?,?)";
        Connection connection = connectionDto.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(addQuery);
            preparedStatement.setInt(1, product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setString(3, product.getCompany());
            preparedStatement.setInt(4, product.getPrice());
            preparedStatement.setDate(5, java.sql.Date.valueOf(product.getMfd()));
            preparedStatement.setDate(6, java.sql.Date.valueOf(product.getExpDate()));
            preparedStatement.executeUpdate();
            System.out.println("success");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void deleteProduct(int id) {
        String deleteQuery = "delete from p_table where id=?";
        Connection connection = connectionDto.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, id);
            int delCount = preparedStatement.executeUpdate();

            if (delCount == 0) {
                System.out.println("no such id found in the database");
            } else {
                System.out.println("product with the id " + id + " deleted ");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();

        String fetchQuery = "select * from p_table";
        Connection connection = connectionDto.getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(fetchQuery);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String company = rs.getString(3);
                int price = rs.getInt(4);
                LocalDate mfd = rs.getDate(5).toLocalDate();
                LocalDate expDate = rs.getDate(6).toLocalDate();
                Product product = new Product(id, name, company, price, mfd, expDate);
                productList.add(product);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return productList;
    }
}
