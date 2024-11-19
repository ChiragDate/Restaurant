package com.chirag.festaurant.restaurant.Service;

import com.chirag.festaurant.restaurant.Mapper.ProductMapper;
import com.chirag.festaurant.restaurant.Model.Product;
import com.chirag.festaurant.restaurant.Repository.ProductRepo;
import exception.CustomerNotFoundException;
import exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;
    private final ProductMapper productMapper;

    public String createProduct(Product product) {
        productRepo.save(product);
        return "Succesfully created product";
    }

    public Product getProduct(String name) {
        return productRepo.getProductByName(name)
                .orElseThrow(() -> new ProductNotFoundException(
                        format("Cannot get Product:: No product found with the provided name:: %s", name)
                ));
    }

    public String deleteProduct(Product product) {
        productRepo.delete(product);
        return "Deleted successfully";
    }
}
