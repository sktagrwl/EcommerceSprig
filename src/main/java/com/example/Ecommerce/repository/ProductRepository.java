package com.example.Ecommerce.repository;

import com.example.Ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    //Find all the expensive products > find all products which have a price > min price
    //This is a custom query method using HQL . Explicitly define the query logic
    @Query("SELECT p from Product p WHERE p.price > :minPrice")
    List<Product> findExpensiveProducts(@Param("minPrice") double minPrice);


    //LIMIT
    //REGEX
    //ILIKE
    @Query(value="Select * FROM product WHERE MATCH(name, description) AGAINST (:keyword)", nativeQuery = true)
    List<Product> searchFullText(@Param("keyword") String keyword);


    //:minPrice < "minPrice" in @Param("minPrice"
    //:brand < "brand" in @Param("brand")
    @Query("SELECT p from Product p WHERE p.price > :minPrice AND p.brand = :brand")
    List<Product> findByBrandAndPrice(
            @Param("minPrice") int price,
            @Param("brand") String brandName
    );



}
