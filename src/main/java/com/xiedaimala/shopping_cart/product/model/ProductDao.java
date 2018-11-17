package com.xiedaimala.shopping_cart.product.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
    DAO -- Data access object
    专门用来处理数据读取, Product相关的数据访问的逻辑!
 */
@Repository
public interface ProductDao extends CrudRepository<Product, Long> {

    Product getById(long id);
}
