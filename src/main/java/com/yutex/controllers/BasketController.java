package com.yutex.controllers;

import com.yutex.model.dto.BasketDto;
import com.yutex.model.entities.Orders;
import com.yutex.model.mapper.BasketMapper;
import com.yutex.model.services.BasketService;
import com.yutex.model.services.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequiredArgsConstructor
public class BasketController {
    //private final BasketService basketService;
    private final BasketMapper basketMapper;



    @RequestMapping(value = "/basket", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<Void> save(@RequestBody BasketDto basket) {
        if (basket != null) {
            basketMapper.insertFromDto(basket);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @GetMapping(value = "/basket", params = {"id"})
    public ResponseEntity <BasketDto> read(@RequestParam(name = "id") int id) {
        BasketDto basket = basketMapper.mapToDtoById(id);

        return !(basket == null) ?
                new ResponseEntity<>(basket, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @RequestMapping(value = "/basket", params = {"id"}, method = {RequestMethod.DELETE})
    public ResponseEntity <Void> delete(@RequestParam(name = "id") int id) {
        basketMapper.deleteFromDatabaseById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
/*
    @GetMapping(value = "/orders")
    public ResponseEntity<List<Orders>> read() {
        List<Orders> orders = ordersService.getAll();

        return !(orders == null || orders.isEmpty()) ?
                new ResponseEntity<>(orders, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "/orders", params = {"id_order"})
    public ResponseEntity<Orders> read(@RequestParam(name = "id_order") int id) {
        Orders orders = ordersService.getById(id);

        return orders != null ? new ResponseEntity<>(orders, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/orders", params = {"id_order"})
    public ResponseEntity<Void> delete(@RequestParam(name = "id_order") int id) {
        Orders orders = ordersService.getById(id);
        if (ordersService.exist(orders)) {
            ordersService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @RequestMapping(value = "/orders", params = {"id"}, method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<Void> update(@RequestBody Orders orders, @RequestParam(name = "id") int id) {

        if (orders != null) {
            ordersService.updateById(orders.getStatus(), id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }*/
}
