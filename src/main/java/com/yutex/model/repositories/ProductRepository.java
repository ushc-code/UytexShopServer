package com.yutex.model.repositories;

import com.yutex.model.entities.Product;
import lombok.Data;
import org.hibernate.type.IntegerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Modifying
    @Transactional
    @Query("update Product  p set p.name=?1, p.length_model=?2, p.width=?3, p.height=?4, p.vendor=?5, p.cost=?6  where p.id=?7")
    void update(@Param("name") String name,@Param("length_model") Integer length_model,
                @Param("width") Integer width,@Param("height") Integer height,
                @Param("vendor") String vendor, @Param("cost") Float cost, @Param("id") Integer id);
    List<Product> findAllByOrderByCostDesc();
    @Query(
            value = "select sum(b_p.count_products) as s, b.id_basket, p.name_model "+
            "from basket as b"+
           " join basket_product as b_p on b.id_basket_product = b_p.id_basket_product "+
            "join (select id_product,name_model, length_model, width, height,vendor,cost_model "+
                    "from product) as p "+
            "on b_p.id_product = p.id_product where b.id_basket in (select id_basket from orders) "+
            "group by p.name_model,b.id_basket", nativeQuery = true

    )
    List<Object[]> join();
    List<Product> findAll();
}
