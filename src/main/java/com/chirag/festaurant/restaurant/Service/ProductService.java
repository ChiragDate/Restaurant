package com.chirag.festaurant.restaurant.Service;

import com.chirag.festaurant.restaurant.Mapper.ProductMapper;
import com.chirag.festaurant.restaurant.Model.Customer;
import com.chirag.festaurant.restaurant.Model.Product;
import com.chirag.festaurant.restaurant.Repository.ProductRepo;
import com.chirag.festaurant.restaurant.dto.ProductRequest;
import exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;
    private final ProductMapper productMapper;

    public String createProduct(ProductRequest request) {
        Product prod = productMapper.toProduct(request);
        productRepo.save(prod);
        return "Successfully created product";
    }

    public Product getProduct(String name) {
        return productRepo.getProductByName(name)
                .orElseThrow(() -> new ProductNotFoundException(
                        format("Cannot get Product:: No product found with the provided name:: %s", name)
                ));
    }

    public String deleteProduct(Long id) {
        productRepo.deleteById(id);
        return "Deleted successfully";
    }

    public String updateProduct(ProductRequest request, String productName) {
        Product existingProduct = productRepo.getProductByName(productName)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (request.name() != null && !request.name().equals(existingProduct.getName())) {
            existingProduct.setName(request.name());
        }
        if (request.price() != null && !request.price().equals(existingProduct.getPrice())) {
            existingProduct.setPrice(request.price());
        }

        productRepo.save(existingProduct);

        return "Updated successfully";
    }

    public List<Product> getTop2ProductsInRange() {
        return productRepo.findTop2ProductsInRange();
    }
}
