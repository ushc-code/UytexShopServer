package com.yutex.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="Product")
public class Product {
    @SequenceGenerator(name="productIdSeq", sequenceName = "product_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "productIdSeq")
    @Id
    @Column(name="id_product")
    private Integer id;

    @Column(name="name_model")
    private String name;

    @Column(name="length_model")
    private Integer length_model;

    @Column(name="width")
    private Integer width;

    @Column(name="height")
    private  Integer height;

    @Column(name="vendor")
    private  String vendor;

    @Column(name="cost_model")
    private Float cost;

}
