package com.chirag.festaurant.restaurant.Controller;

import com.chirag.festaurant.restaurant.Model.Product;
import com.chirag.festaurant.restaurant.Service.ProductService;
import com.chirag.festaurant.restaurant.dto.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/v1/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/")
    public ResponseEntity<String> createProduct(@RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(productService.createProduct(productRequest));
    }

    @GetMapping("{name}")
    public ResponseEntity<Product> getProduct(@RequestBody @PathVariable("name") String name) {
        return ResponseEntity.ok(productService.getProduct(name));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@RequestBody @PathVariable("id") Long id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }
}

