package com.xiedaimala.shopping_cart.web.order.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao extends CrudRepository<Order, Long> {

    Order getById(long id);

    List<Order> findAll();

    Order save(Order order);

    void delete(Order order);
}
