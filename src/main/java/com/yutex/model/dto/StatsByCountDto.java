package com.yutex.model.dto;

import com.yutex.model.entities.Product;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class StatsByCountDto {
    private Integer id;
    private Product product;
    private Integer count;

    public StatsByCountDto(int id, Product product, Integer count) {
        this.id=id;
        this.product=product;
        this.count=count;
    }
}
