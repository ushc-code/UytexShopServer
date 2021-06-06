package com.yutex.controllers;

import com.yutex.model.dto.BasketProdDto;
import com.yutex.model.dto.StatsByCountDto;
import com.yutex.model.entities.*;
import com.yutex.model.repositories.ProductRepository;
import com.yutex.model.services.BasketService;
import com.yutex.model.services.Basket_ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController()
@RequiredArgsConstructor
public class BasketProductController {
    private final Basket_ProductService basketProductService;
    private  final BasketService basketService;
    private final ProductRepository productRepository;

    /*@RequestMapping(value = "/basket_prod",params = {"basketId","productId","count"}, method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<Void> save(@RequestParam (name = "basketId")Integer basketId, @RequestParam(name = "productId")Integer productId, @RequestParam(name = "count") Integer count) {
        if (basketId != null) {
            Basket_Product basketProduct=new Basket_Product();
            basketProduct.setBasket(basketService.findById(basketId));
            basketProduct.setProduct(productRepository.findById(productId).get());
            basketProduct.setCount(count);
            basketProduct.setId_basket_product(new BasketProdKey(basketId,productId));
            basketProductService.save(basketProduct);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }*/
    @RequestMapping(value = "/basket_prod", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<Void> save( @RequestBody BasketProdDto basketProdDto) {
        if (basketProdDto != null) {
            System.out.println(basketProdDto.toString());
            Basket_Product basketProduct=new Basket_Product();
            basketProduct.setBasket(basketService.findById(basketProdDto.getBasketId()));
            basketProduct.setProduct(productRepository.findById(basketProdDto.getProductId()).get());
            basketProduct.setCount(basketProdDto.getCount());
            basketProduct.setId_basket_product(new BasketProdKey(basketProdDto.getBasketId(),basketProdDto.getProductId()));
            basketProductService.save(basketProduct);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/basket",params = {"userId"})
    public ResponseEntity<Integer> getBasketByUserId(@RequestParam (name = "userId")Integer userId) {
        Basket basket=basketService.getByUserId(userId);
        return basket != null ? new ResponseEntity<>(basket.getId_basket(), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/basket_prod_count",params = {"basketId","productId"})
    public ResponseEntity<Integer> getCountByIdBasketAndIdProduct(@RequestParam (name = "basketId")Integer basketId, @RequestParam (name = "productId")Integer productId) {
        Basket_Product basketProduct;
        //System.out.println(basketId+" "+productId);
        basketProduct=basketProductService.findByBasketProductKey(new BasketProdKey(basketId,productId));
        //System.out.println(basketProduct.getCount());
        return basketProduct != null ? new ResponseEntity<>(basketProduct.getCount(), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/basket_prod",params = {"userId"})
    public ResponseEntity<List<Integer>> read(@RequestParam (name = "userId")Integer userId) {
            List<Integer> basketProductList;
            basketProductList=basketProductService.getIdProductsByBasketId(basketService.getByUserId(userId).getId_basket());
        return basketProductList != null ? new ResponseEntity<>(basketProductList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping(value = "/basket", params = {"basketId","productId","count"})
    public ResponseEntity<Void> delete(@RequestParam (name = "basketId")Integer basketId, @RequestParam (name = "productId")Integer productId, @RequestParam (name = "count")Integer count) {
        Basket_Product basketProduct=new Basket_Product();
        basketProduct.setBasket(basketService.findById(basketId));
        basketProduct.setProduct(productRepository.findById(productId).get());
        basketProduct.setCount(count);
        basketProduct.setId_basket_product(new BasketProdKey(basketId,productId));
        if (basketProductService.exist(basketProduct)) {
            basketProductService.deleteById(basketProduct);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    /*@GetMapping(value = "/basket")
    public ResponseEntity<List<Basket_Product>> getBasketByUserId() {
        List<Basket_Product> basket = basketProductService.findAll();
        return basket != null ? new ResponseEntity<>(basket, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }*/
    @GetMapping(value = "/basket")
    public ResponseEntity<List<StatsByCountDto>> getStats() {
        List<Basket_Product> baskets = basketProductService.findAll();
        List<StatsByCountDto> statsByCountDtos= new ArrayList<>();
        int id = 0;
        for(Basket_Product basket: baskets){
            statsByCountDtos.add(new StatsByCountDto(id,basket.getProduct(),basket.getCount()));
            id++;
        }

        return statsByCountDtos.size() != 0 ? new ResponseEntity<>(statsByCountDtos, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
