package com.chirag.festaurant.restaurant.Mapper;

import com.chirag.festaurant.restaurant.Model.Product;
import com.chirag.festaurant.restaurant.dto.ProductRequest;
import com.chirag.festaurant.restaurant.dto.ProductResponse;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public Product toProduct(ProductRequest request) {
        return Product.builder().
                name(request.name()).
                price(request.price()).
                build();
    }

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(product.getName(), product.getPrice());
    }
}
