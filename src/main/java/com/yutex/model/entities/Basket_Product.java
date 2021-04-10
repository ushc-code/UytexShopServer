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

    @Id
    @SequenceGenerator(name="basketProductSeq", sequenceName = "basketProd_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "basketProductSeq")
    @Column(name = "id_basket_product")
    private Integer id_basket_product;


    @Column(name="id_product")
    private Integer id_product;

    @Column(name = "count_products")
    private Integer count;
}
