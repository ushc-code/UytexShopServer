package com.yutex.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.beans.ConstructorProperties;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@Entity
@Table(name="Basket_Product")
public class Basket_Product {

    @EmbeddedId()
    private BasketProdKey id_basket_product;

    @ManyToOne()
    @MapsId("idProduct")
    @JoinColumn(name="id_product")
    private Product product;

    @ManyToOne()
    @MapsId("idBasket")
    @JoinColumn(name="id_basket")
    private Basket basket;

    @Column(name = "count_products")
    private Integer count;
}
