package com.chirag.festaurant.restaurant.Controller;

import com.chirag.festaurant.restaurant.dto.CustomerRequest;
import com.chirag.festaurant.restaurant.Service.CustomerService;
import com.chirag.festaurant.restaurant.dto.CustomerResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest request) {
        System.out.println("Entered customer");
        return ResponseEntity.ok(customerService.createCustomer(request));
    }

    @GetMapping("/{email}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable("email") String email) {
        return ResponseEntity.ok(customerService.retrieveCustomer(email));
    }

}
