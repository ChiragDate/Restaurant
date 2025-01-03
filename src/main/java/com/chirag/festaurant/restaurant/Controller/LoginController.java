package com.chirag.festaurant.restaurant.Controller;

import com.chirag.festaurant.restaurant.Service.CustomerService;
import com.chirag.festaurant.restaurant.dto.LoginRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class LoginController {

    private final CustomerService service;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequest loginrequest) {
        return ResponseEntity.ok(service.loginApi(loginrequest));
    }
}
