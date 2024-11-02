package com.chirag.festaurant.restaurant.Mapper;

import com.chirag.festaurant.restaurant.Model.Login;
import com.chirag.festaurant.restaurant.dto.CustomerRequest;
import com.chirag.festaurant.restaurant.dto.LoginRequest;
import org.springframework.stereotype.Service;


@Service
public class LoginMapper {

    public Login toEntity(LoginRequest request) {
        return Login.builder()
                .email(request.email())
                .password(request.password()).
                build();
    }
}
