package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.sym.Name;
@Service
public class ProductService {

    @Autowired
    private ProductRepository pr;

    public List<Product> getAllProducts(){
        return pr.findAll();
    }

    public List<Product> getProductsCheaperThan(double price) {
        return pr.findByPriceLessThan(price);
    }

    public ProductType getProductType(String typeName) {
        return pr.findProductTypes(typeName);
    }

    public List<ProductType> findAllProductTypes(){
        return pr.findAllProductTypes();
    }

    public Product save(Product p){
        return pr.save(p);       
    }

    
}
