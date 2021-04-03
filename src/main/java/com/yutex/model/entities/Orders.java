package com.yutex.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="Orders")
public class Orders {
    @Id
    @SequenceGenerator(name="orderIdSeq", sequenceName = "order_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "orderIdSeq")
    @Column(name = "id_order")
    private Integer id_order;

    @Column(name="id_basket")
    private Integer id_basket;

    @Column(name="status")
    private String status;

    @Column(name="order_date")
    private String date;

}
