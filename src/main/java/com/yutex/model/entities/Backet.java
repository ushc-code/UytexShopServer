package com.yutex.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="Basket")
public class Backet {
    @Id
    @SequenceGenerator(name="basketIdSeq", sequenceName = "basket_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "backetIdSeq")
    @Column(name="id_basket")
    private Integer id_basket;


    @Column(name="id_user")
    private Integer id_user;


    @Column(name="id_basket_product")
    private Integer id_basket_product;
}
