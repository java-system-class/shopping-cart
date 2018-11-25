package com.xiedaimala.shopping_cart.web.product.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
    DAO -- Data access object
    专门用来处理数据读取, Product相关的数据访问的逻辑!

    ORM 会帮我实现这个接口, 也就是实现其中的操作! (生成SQ语句, 执行SQL语句, 转换返回结果到JAVA对象)
 */
@Repository
public interface ProductDao extends CrudRepository<Product, Long> {

    // 根据ORM的命名惯例, 声明操作方法

    Product getById(long id);

    List<Product> findAll();

    Product save(Product product);
}
