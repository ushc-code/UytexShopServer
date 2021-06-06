package com.yutex.model.services;

import com.yutex.model.entities.Basket;
import com.yutex.model.entities.BasketProdKey;
import com.yutex.model.entities.Basket_Product;
import com.yutex.model.entities.Product;
import com.yutex.model.repositories.Basket_ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Basket_ProductService {
    private final Basket_ProductRepository basket_productRepository;
    public  void save(Basket_Product basket_product){
        basket_productRepository.save(basket_product);
    }
    public Basket_Product getById(Integer id){
        return basket_productRepository.findById(id).isPresent() ? basket_productRepository.findById(id).get() : null;
    }
    public List<Basket_Product> getByBasketId(Integer basketId){
        List<Basket_Product> basketProductList = basket_productRepository.findAll();
        Basket_Product basketProduct;
        List<Basket_Product> outputProductList=new LinkedList<>();
        for(int i=0;i<basketProductList.size();i++){
            basketProduct=basketProductList.get(i);
            if(basketProduct.getBasket().getId_basket().equals(basketId)){
                outputProductList.add(basketProduct);
            }
        }
        return outputProductList;
    }
    public List<Integer> getIdProductsByBasketId(Integer basketId){
        List<Basket_Product> basketProductList = basket_productRepository.findAll();
        Basket_Product basketProduct;
        List<Integer> outputProductList=new LinkedList<>();
        for(int i=0;i<basketProductList.size();i++){
            basketProduct=basketProductList.get(i);
            if(basketProduct.getBasket().getId_basket().equals(basketId)){
                outputProductList.add(basketProduct.getProduct().getId());
            }
        }
        return outputProductList;
    }
    public List<Basket_Product> findAll(){return basket_productRepository.findAll();}
    public void delete(Product product, Basket basket){basket_productRepository.deleteBasket_ProductByBasketAndProduct(basket,product);}
    public void  deleteById(Basket_Product basketProduct){
        basket_productRepository.delete(basketProduct);
    }
    public boolean exist(Basket_Product basketProduct){return basketProduct !=null && basket_productRepository.exists(Example.of(basketProduct));}
    public Basket_Product findByBasketProductKey (BasketProdKey basketProdKey){
        List<Basket_Product> basketProductList = basket_productRepository.findAll();
        Basket_Product basketProduct;
        Basket_Product outputProduct=new Basket_Product();
        for(int i=0;i<basketProductList.size();i++){
            basketProduct=basketProductList.get(i);
            if(basketProductList.get(i).getBasket().getId_basket().equals(basketProdKey.getIdBasket())&&
            basketProduct.getProduct().getId().equals(basketProdKey.getIdProduct())){
                outputProduct.setProduct(basketProduct.getProduct());
                outputProduct.setBasket(basketProduct.getBasket());
                outputProduct.setCount(basketProduct.getCount());
            }
        }
        return outputProduct;
    }
}
