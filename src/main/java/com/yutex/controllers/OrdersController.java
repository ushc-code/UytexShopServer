package com.yutex.controllers;

import com.yutex.model.entities.Orders;
import com.yutex.model.services.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController()
@RequiredArgsConstructor
public class OrdersController {
    private final OrdersService ordersService;
    @RequestMapping(value = "/orders", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<Void> save(@RequestBody Orders orders) {
        if(orders != null){
            System.out.println(orders);
            orders.setDate(new Date());
            ordersService.save(orders);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @GetMapping(value = "/orders")
    public ResponseEntity<List<Orders>> read(){
        List<Orders> orders = ordersService.getAll();

        return !(orders == null || orders.isEmpty()) ?
                new ResponseEntity<>(orders, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    /*@GetMapping(value = "/orders",params = {"basketId"})
    public ResponseEntity<List<Orders>> readByBasketId(@RequestParam (name = "basketId")Integer id){
        List<Orders> orders = ordersService.getByBasketId(id);
        return !(orders == null || orders.isEmpty()) ?
                new ResponseEntity<>(orders, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }*/


    @GetMapping(value = "/orders", params = {"id_order"})
    public ResponseEntity<Orders> read(@RequestParam(name = "id_order") int id){
        Orders orders = ordersService.getById(id);

        return orders != null ? new ResponseEntity<>(orders, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/orders", params = {"id_order"} )
    public ResponseEntity<Void> delete(@RequestParam(name = "id_order") int id) {
        Orders orders = ordersService.getById(id);
        if (ordersService.exist(orders)) {
            ordersService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @RequestMapping(value = "/orders",params = {"id"},method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<Void> update(@RequestBody Orders orders, @RequestParam(name = "id") int id) {

        if(orders != null){
            ordersService.updateById(orders.getStatus(), id );
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
   @RequestMapping(value = "/orders/status",params = {"id"},method = {RequestMethod.GET})
    public ResponseEntity<String> update(@RequestParam(name = "id") int id) {
        String status =ordersService.getStatus(id);
        return new ResponseEntity<>(status,HttpStatus.OK);
    }
}
