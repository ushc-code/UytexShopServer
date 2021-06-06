package com.yutex.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="Basket")
public class Basket {
    @Id
    @SequenceGenerator(name="basketIdSeq", sequenceName = "basket_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "basketIdSeq")
    @Column(name="id_basket")
    private Integer id_basket;


    @Column(name="id_user")
    private Integer id_user;
}
