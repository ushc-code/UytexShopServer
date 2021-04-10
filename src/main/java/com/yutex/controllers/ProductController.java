package com.yutex.controllers;

import com.yutex.model.dto.StatsDto;
import com.yutex.model.entities.Product;
import com.yutex.model.mapper.BasketMapper;
import com.yutex.model.mapper.StatsMapper;
import com.yutex.model.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController()
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private  final StatsMapper statsMapper;

    @RequestMapping(value = "/products", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<Void> save(@RequestBody Product product) {
        if(product != null){
            productService.save(product);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/products")
    public ResponseEntity<List<Product>> read(){
        List<Product> products = productService.getAll();

        return !(products == null || products.isEmpty()) ?
                new ResponseEntity<>(products, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "/products", params = {"id"})
    public ResponseEntity<Product> read(@RequestParam(name = "id") int id){
        Product product = productService.getById(id);

        return product != null ? new ResponseEntity<>(product, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/products", params = {"id"} )
    public ResponseEntity<Void> delete(@RequestParam(name = "id") int id) {
        Product product = productService.getById(id);
        if (productService.exist(product)) {
            productService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @RequestMapping(value = "/products",params = {"id"},method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<Void> update(@RequestBody Product product, @RequestParam(name = "id") int id) {

        if(product != null){
            productService.updateById(product.getName(),product.getLength_model(),
                    product.getWidth(),product.getHeight(),product.getVendor(),product.getCost(), id );
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @GetMapping(value = "/products/statistic")
    public  ResponseEntity<List<Product>> statistic(){
        List<Product> products=productService.orderByCoast();
        return !(products == null || products.isEmpty()) ?
                new ResponseEntity<>(products, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "products/statisticOrder")
    public  ResponseEntity<List<StatsDto>> statisticOrder(){
        List<StatsDto> statsDtos = statsMapper.mapAllToDto(productService.joinStats());

        return !(statsDtos == null || statsDtos.isEmpty()) ?
                new ResponseEntity<>(statsDtos,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
