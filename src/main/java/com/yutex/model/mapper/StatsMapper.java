package com.yutex.model.mapper;


import com.yutex.model.dto.StatsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatsMapper {
    public StatsDto mapToDto(Object[] objects) {
        StatsDto dto = null;
        if (objects != null) {
            dto = new StatsDto()
                    .setId_basket((Integer) objects[1])
                    .setCount_products((BigInteger)objects[0])
                    .setName_model((String) objects[2]);
        }
        return dto;
    }
    public List<StatsDto> mapAllToDto(List<Object[]> objectsList) {
        List<StatsDto> dtoList = null;
        if (objectsList != null) {
            dtoList = new ArrayList<>(objectsList.size());
            for (Object[] objArray : objectsList) {
                dtoList.add(mapToDto(objArray));
            }
        }
        return dtoList;
    }
}
