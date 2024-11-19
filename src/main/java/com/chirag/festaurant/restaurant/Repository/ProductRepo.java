package com.chirag.festaurant.restaurant.Repository;

import com.chirag.festaurant.restaurant.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Long> {
    Optional<Product> getProductByName(String name);
}
