package com.yutex.model.repositories;

import com.yutex.model.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Integer> {
    @Modifying
    @Transactional
    @Query("update Orders o set o.status=?1 where o.id_order=?2")
    void  update(@Param("status") String status, @Param("id_order") Integer id_order);
}
