package com.chirag.festaurant.restaurant.Service;

import com.chirag.festaurant.restaurant.Mapper.CustomerMapper;
import com.chirag.festaurant.restaurant.Model.Customer;
import com.chirag.festaurant.restaurant.Repository.CustomerRepo;
import com.chirag.festaurant.restaurant.dto.CustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {


    private final CustomerRepo repo;
    private final CustomerMapper mapper;

    public String createCustomer(CustomerRequest request) {
        Customer customer = mapper.toEntity(request);
        repo.save(customer);
        return "Added Customer";
    }
}
