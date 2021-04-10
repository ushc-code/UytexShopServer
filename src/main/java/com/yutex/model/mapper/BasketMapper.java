package com.yutex.model.mapper;

import com.yutex.model.dto.BasketDto;
import com.yutex.model.entities.Basket;
import com.yutex.model.entities.Basket_Product;
import com.yutex.model.services.AdminService;
import com.yutex.model.services.BasketService;
import com.yutex.model.services.Basket_ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketMapper {
    private final BasketService basketService;
    private final Basket_ProductService basket_productService;

    // From entity to dto
    public BasketDto mapToDto(Object[] objects) {
        BasketDto dto = null;
        if (objects != null) {
            dto = new BasketDto()
                    .setId_basket((Integer) objects[0])
                    .setId_user((Integer) objects[1])
                    .setCount((Integer) objects[2])
                    .setId_product((Integer) objects[3])
                    .setId_basket_product((Integer) objects[4]);
        }
        return dto;
    }
    public BasketDto mapToDto(BasketDto basket) {
        BasketDto dto = null;
        if (basket != null) {
            dto = new BasketDto()
                    .setId_basket(basket.getId_basket())
                    .setId_user(basket.getId_user())
                    .setCount(basket.getCount())
                    .setId_product(basket.getId_product())
                    .setId_basket_product(basket.getId_basket_product());

        }
        return dto;
    }
    public BasketDto mapToDtoById(Integer id) {
        BasketDto dto = null;
        Object[] objects = basketService.joinBasket(id);
        dto = new BasketDto()
                .setId_basket((Integer) objects[1])
                .setId_user((Integer) objects[3])
                .setCount((Integer) objects[0])
                .setId_product((Integer) objects[2])
                .setId_basket_product((Integer) objects[4]);

        return dto;
    }
    // From dto to entity
    public void insertFromDto(BasketDto dto) {
        //CarEntity entity = null;
        Basket basket=null;
        Basket_Product basket_product=null;
        if (dto != null) {
            basket = new Basket();
            basket.setId_basket_product(dto.getId_basket_product());
            basket.setId_user(dto.getId_user());
            basket.setId_basket(dto.getId_basket());
            basket_product = new Basket_Product();
            basket_product.setId_product(dto.getId_product());
            basket_product.setId_basket_product(dto.getId_basket_product());
            basket_product.setCount(dto.getCount());
            basket_productService.save(basket_product);
            basketService.save(basket);
        }
    }
    public void deleteFromDatabaseById(Integer id){
        basket_productService.deleteById(id);
    }

}
