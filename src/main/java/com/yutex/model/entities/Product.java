package com.yutex.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="Product")
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Product {
    @Id
    @SequenceGenerator(name="productIdSeq", sequenceName = "product_id_seq", allocationSize = 1, initialValue = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "productIdSeq")//GenerationType.AUTO)//SEQUENCE,generator = "productIdSeq")
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
