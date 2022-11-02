package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;




public interface ProductRepository extends CrudRepository<Product, Integer>{

    @Query("SELECT ptype FROM ProductType ptype WHERE ptype.name = ?1")
	ProductType findProductTypes(String name) throws DataAccessException;

    @Query("SELECT prod FROM Product prod WHERE prod.price < ?1")
    List<Product> findByPriceLessThan(Double price);

    List<Product> findAll();
    
    
    @Query("SELECT ptype FROM ProductType ptype")
    List<ProductType> findAllProductTypes();

    Optional<Product> findById(int id);
    Product findByName(String name);
}
