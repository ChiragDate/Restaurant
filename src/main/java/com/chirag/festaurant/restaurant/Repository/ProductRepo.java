package com.chirag.festaurant.restaurant.Repository;

import com.chirag.festaurant.restaurant.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Long> {
    Optional<Product> getProductByName(String name);

    @Query("SELECT p FROM Product p WHERE p.price BETWEEN 15 AND 30 ORDER BY p.price ASC ")
    List<Product> findTop2ProductsInRange();
}
