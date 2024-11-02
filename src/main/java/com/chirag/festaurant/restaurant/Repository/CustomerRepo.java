package com.chirag.festaurant.restaurant.Repository;

import com.chirag.festaurant.restaurant.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
    public Customer findCustomerByEmail(String email);
}
