package com.yutex.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class BasketDto {
    private Integer id_basket;
    private Integer id_user;
    private Integer count;
    private Integer id_product;
    private Integer id_basket_product;
}

