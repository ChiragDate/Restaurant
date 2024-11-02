package com.chirag.festaurant.restaurant.Service;

import com.chirag.festaurant.restaurant.dto.CustomerRequest;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {


    public String createCustomer(CustomerRequest request) {
        Customer customer = mapper.toEntity(customer);
    }
}
