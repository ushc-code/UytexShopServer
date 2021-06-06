package com.yutex.model.services;

import com.yutex.model.entities.Basket;
import com.yutex.model.repositories.BasketRepository;
import com.yutex.model.repositories.Basket_ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketService {
    private final BasketRepository basketRepository;
    private final Basket_ProductRepository basket_productRepository;


    public  void save(Basket basket){
        basketRepository.save(basket);
    }
    public Basket findById(Integer id){
        return basketRepository.findById(id).isPresent() ? basketRepository.findById(id).get() : null;
    }
    public Basket getByUserId(Integer id){
        List<Basket> basketProductList = basketRepository.findAll();
        Basket basket=new Basket();
        for(int i=0;i<basketProductList.size();i++){
            basket=basketProductList.get(i);
            if(basket.getId_user().equals(id)){
                return basket;
            }
        }
        return basket;
    }
    public void  deleteById(Integer id){
        basketRepository.deleteById(id);
    }
}
