package com.yutex.model.repositories;

import com.yutex.model.entities.Basket;
import com.yutex.model.entities.BasketProdKey;
import com.yutex.model.entities.Basket_Product;
import com.yutex.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Basket_ProductRepository extends JpaRepository<Basket_Product,Integer> {
    void deleteBasket_ProductByBasketAndProduct(Basket basket, Product product);
    List<Basket_Product> findAll();
}
