package com.yutex.model.services;

import com.yutex.model.entities.Basket;
import com.yutex.model.entities.Basket_Product;
import com.yutex.model.repositories.Basket_ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Basket_ProductService {
    private final Basket_ProductRepository basket_productRepository;
    public  void save(Basket_Product basket_product){
        basket_productRepository.save(basket_product);
    }
    public Basket_Product getById(Integer id){
        return basket_productRepository.findById(id).isPresent() ? basket_productRepository.findById(id).get() : null;
    }
    public void  deleteById(Integer id){
        basket_productRepository.deleteById(id);
    }
}
