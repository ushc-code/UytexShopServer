package com.yutex.model.services;

import com.yutex.model.entities.Orders;
import com.yutex.model.repositories.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersService {
    private final OrdersRepository ordersRepository;

    public  void save(Orders orders){
        ordersRepository.save(orders);
    }
    /*public List<Orders> getByBasketId(Integer id_basket){return ordersRepository.getALlByid_basket(id_basket);}*/
    public List<Orders> getAll(){
        return ordersRepository.findAll();
    }
    public Orders getById(Integer id){
        return ordersRepository.findById(id).isPresent() ? ordersRepository.findById(id).get() : null;
    }
    public void  deleteById(Integer id){
        ordersRepository.deleteById(id);
    }
    public  Boolean exist(Orders orders){
        return ordersRepository.exists(Example.of(orders));
    }
   public  void updateById(String status, Integer id_order){
        ordersRepository.update(status, id_order);
   }
  public String getStatus(Integer  id){
        return ordersRepository.getStatus(id);
  }
}
