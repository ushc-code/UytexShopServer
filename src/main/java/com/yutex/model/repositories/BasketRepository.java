package com.yutex.model.repositories;

import com.yutex.model.entities.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
/*"select b.count_products, b.id_basket, b.id_product, b.id_user,b_p.id_basket_product" +
        "from basket as b join basket_product as b_p on id_basket_product = b_p.id_basket_product "

select b.count_products, b.id_basket, b.id_product, b.id_user,b_p.id_basket_product " +
            "from basket as b " +
            "join basket_product as b_p on b.id_basket_product = b_p.id_basket_product " +
            "join (select product.id_product,product.name_model, product.length_model, product.width, product.height,product.vendor, product.cost_model" +
            "from product " +
            "on b_p.id_product = product.id_product

            select b.count_products, b.id_basket, b.name" +
            "from basket as b " +
            "join basket_product as b_p on b.id_basket_product = b_p.id_basket_product " +
            "join (select product.id_product,product.name_model, product.length_model, product.width, product.height,product.vendor, product.cost_model" +
            "from product " +
            "on b_p.id_product = product.id_product" +
            "group by b.name having sum(count_products ) and id_basket in (select id_basket from orders)
*/
@Repository
public interface BasketRepository extends JpaRepository<Basket,Integer> {
    @Query(value ="select b_p.count_products, b.id_basket, b_p.id_product, b.id_user,b_p.id_basket_product " +
            "from basket as b join basket_product as b_p on b.id_basket_product = b_p.id_basket_product ",
            nativeQuery = true)
    List<Object[]> joinBasket();
}
