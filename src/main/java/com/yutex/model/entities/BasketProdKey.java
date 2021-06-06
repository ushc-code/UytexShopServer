package com.yutex.model.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Data
@Embeddable
public class BasketProdKey implements Serializable {
    @Column(name="id_basket")
    private Integer idBasket;

    @Column(name="id_product")
    private Integer idProduct;

    public BasketProdKey(Integer idBasket, Integer idProduct) {
        this.idBasket = idBasket;
        this.idProduct = idProduct;
    }
}
