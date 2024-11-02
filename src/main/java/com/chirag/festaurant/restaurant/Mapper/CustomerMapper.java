package com.chirag.festaurant.restaurant.Mapper;

import com.chirag.festaurant.restaurant.Model.Customer;
import com.chirag.festaurant.restaurant.dto.CustomerRequest;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {

    public Customer toEntity(CustomerRequest request) {
        return Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(request.password())
                .address(request.address())
                .city(request.city())
                .pincode(request.pincode())
                .build();
    }
}
