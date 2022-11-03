package org.springframework.samples.petclinic.product;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.samples.petclinic.pet.PetType;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeFormatter implements Formatter<ProductType>{

    private final ProductService pService;
    
    @Autowired
	public ProductTypeFormatter(ProductService pService){
        this.pService = pService;
    }

    @Override
    public String print(ProductType productType, Locale locale) {
        return productType.getName();
    }

    @Override
    public ProductType parse(String text, Locale locale) throws ParseException {
        ProductType product= this.pService.getProductType(text);
        if(product == null){
            throw new ParseException("product not found: " + text, 0);

        }
        return product;
    }
    
}
