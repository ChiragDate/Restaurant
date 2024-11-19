package com.chirag.festaurant.restaurant.Service;

import com.chirag.festaurant.restaurant.Mapper.CustomerMapper;
import com.chirag.festaurant.restaurant.Model.Customer;
import com.chirag.festaurant.restaurant.Repository.CustomerRepo;
import com.chirag.festaurant.restaurant.dto.CustomerRequest;
import com.chirag.festaurant.restaurant.dto.CustomerResponse;
import com.chirag.festaurant.restaurant.dto.LoginRequest;
import com.chirag.festaurant.restaurant.helper.EncryptionService;
import com.chirag.festaurant.restaurant.helper.JWTHelper;
import exception.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CustomerService {


    private final CustomerRepo repo;
    private final CustomerMapper mapper;
    private final EncryptionService encryptionService;
    private final JWTHelper jwtHelper;

    public String createCustomer(CustomerRequest request) {
        Customer customer = mapper.toCustomer(request);
        customer.setPassword(encryptionService.encode(customer.getPassword()));
        repo.save(customer);
        return "Added Customer";
    }

    public Customer getCustomer(String email) {
        return repo.findCustomerByEmail(email)
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("Cannot update Customer:: No customer found with the provided ID:: %s", email)
                ));
    }

    public CustomerResponse retrieveCustomer(String email) {
        Customer customer = getCustomer(email);
        return mapper.toCustomerResponse(customer);
    }

    public String loginApi(LoginRequest request) {
        Customer customer = getCustomer(request.email());
        if (encryptionService.validatePassword(request.password(), customer.getPassword())) {
            return "Wrong Email or Password";
        }

        return jwtHelper.generateToken(request.email());
    }
}
