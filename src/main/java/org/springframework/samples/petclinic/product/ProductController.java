package org.springframework.samples.petclinic.product;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ProductController {
    private ProductService productService;

    @ModelAttribute("product_types")
	public List<ProductType> populateProductTypes() {
		return this.productService.findAllProductTypes();
	}

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/product/create")
    public ModelAndView addProduct(){
        ModelAndView result = new ModelAndView("products/createOrUpdateProductForm");
        result.addObject("product", new Product());
        result.addObject("product_types", productService.findAllProductTypes());
        return result;


    }

    @PostMapping("/product/create")
    public ModelAndView saveAddedProduct(@Valid Product p){
        productService.save(p);
        ModelAndView result = new ModelAndView("redirect:/welcome");
        result.addObject("message", "Product created sucessfully!");
        return new ModelAndView("redirect:/welcome");

    } 
    
}
