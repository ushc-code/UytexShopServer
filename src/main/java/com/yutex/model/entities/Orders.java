package com.yutex.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name="Orders")
public class Orders {
    @Id
    @SequenceGenerator(name="orderIdSeq", sequenceName = "order_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "orderIdSeq")
    @Column(name = "id_order")
    private Integer id_order;

    @Column(name="id_basket")
    private Integer id_basket;

    @Column(name="status")
    private String status;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name="order_date")
    private Date date;

    @Column(name = "price_order")
    private Float price_order;
}
