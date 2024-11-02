package com.chirag.festaurant.restaurant.Service;

import com.chirag.festaurant.restaurant.Mapper.LoginMapper;
import com.chirag.festaurant.restaurant.Model.Customer;
import com.chirag.festaurant.restaurant.Model.Login;
import com.chirag.festaurant.restaurant.Repository.CustomerRepo;
import com.chirag.festaurant.restaurant.dto.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final CustomerRepo repo;
    private final LoginMapper mapper;


    public String authenticate(String email, String password) {
        Customer user = repo.findCustomerByEmail(email);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return "User found " + user.getEmail();
            }
            return "Incorrect password";
        } else {
            return "User not found";
        }
    }

    public String loginApi(LoginRequest request) {
        Login credentials = mapper.toEntity(request);
        return authenticate(credentials.getEmail(), credentials.getPassword());
    }
}
