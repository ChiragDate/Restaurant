package com.chirag.festaurant.restaurant.Controller;

import com.chirag.festaurant.restaurant.Model.Product;
import com.chirag.festaurant.restaurant.Service.ProductService;
import com.chirag.festaurant.restaurant.dto.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/v1/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
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

    @PutMapping("/update/{productName}")
    public ResponseEntity<String> updateProduct(
            @PathVariable String productName,
            @RequestBody ProductRequest request) {
        String response = productService.updateProduct(request, productName);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/top2")
    public ResponseEntity<List<Product>> getTop2ProductsInRange() {
        List<Product> products = productService.getTop2ProductsInRange();
        return ResponseEntity.ok(products);
    }
}

