package com.yutex.model.repositories;

import com.yutex.model.entities.Basket_Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Basket_ProductRepository extends JpaRepository<Basket_Product,Integer> {
}
