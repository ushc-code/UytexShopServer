package com.yutex.model.services;

import com.yutex.model.entities.Product;
import com.yutex.model.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public void save(Product product){
        productRepository.save(product);
    }
    public List<Product> getAll(){
        return productRepository.findAll();
    }
    public Product getById(Integer id){
        return productRepository.findById(id).isPresent() ?
                productRepository.findById(id).get() : null;
    }
    public void deleteById(Integer id){
        productRepository.deleteById(id);
    }
    public  Boolean exist(Product product){
        return product!=null && productRepository.exists(Example.of(product));
    }
    public  void updateById(String name,Integer length_model, Integer width, Integer height,
                            String vendor,Float coast, Integer id){
        productRepository.update(name, length_model, width,height,vendor,coast,id);
    }
    public List<Product> orderByCoast( ){
        return productRepository.findAllByOrderByCostDesc();
    }

    public Object[] joinStat(Integer id) {
        if (productRepository.existsById(id)) {
            List<Object[]> objects = productRepository.join();
            for (Object[] objArray : objects) {
                if (id.equals(objArray[0]))
                    return objArray;
            }
        }
        return null;
    }

    public List<Object[]> joinStats(){
        return productRepository.join();
    }
}

