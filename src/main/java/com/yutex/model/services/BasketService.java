package com.yutex.model.services;

import com.yutex.model.entities.Basket;
import com.yutex.model.entities.Orders;
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

    public Object[] joinBasket(Integer id) {
        if (basketRepository.existsById(id)) {
            List<Object[]> objects = basketRepository.joinBasket();
            for (Object[] objArray : objects) {
                if (id.equals(objArray[0]))
                    return objArray;
            }
        }
        return null;
    }

    public List<Object[]> joinBaskets(){
        return basketRepository.joinBasket();
    }
    public  void save(Basket basket){
        basketRepository.save(basket);
    }
    public Basket getById(Integer id){
        return basketRepository.findById(id).isPresent() ? basketRepository.findById(id).get() : null;
    }
    public void  deleteById(Integer id){
        basketRepository.deleteById(id);
    }
}
