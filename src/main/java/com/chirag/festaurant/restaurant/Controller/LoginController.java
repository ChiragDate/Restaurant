package com.chirag.festaurant.restaurant.Controller;

import com.chirag.festaurant.restaurant.Service.LoginService;
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
@RequestMapping("/api/login")
public class LoginController {

    private final LoginService service;

    @PostMapping()
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequest loginrequest) {
        return ResponseEntity.ok(service.loginApi(loginrequest));
    }
}
