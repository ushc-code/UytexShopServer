package com.yutex.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@Accessors(chain = true)
public class StatsDto {
    private Integer id_basket;
    private BigInteger count_products;
    private  String name_model;
}
