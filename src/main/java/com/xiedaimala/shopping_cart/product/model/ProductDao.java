package com.xiedaimala.shopping_cart.product.model;

import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
    DAO -- Data access object
    专门用来处理数据读取, Product相关的数据访问的逻辑!
 */
@Component
public class ProductDao {
    private Statement statement;

    public ProductDao(Statement statement) {
        this.statement = statement;

        // 测试代码
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM `product`");
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Failed to query product from DB.");
        }
    }

    public Product get(int id) {
        try {
            // 构造SQL查询语句, 然后执行
            String query = "SELECT * FROM `product` WHERE id = " + id;
            System.out.println(query);
            ResultSet rs = statement.executeQuery(query);

            //根据SQL查询的结果, 构造Product对象, 并返回
            if (rs.next()) {
                return new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("price")
                );
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Failed to query product from DB.");
        }

        return null;
    }
}
