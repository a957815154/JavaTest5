package com.hand.api.service;

import com.hand.domain.entity.Customer;

public interface CustomerService {


    int login(String username, String password);

    int insertCustomer(Customer customer);


    int update(Customer customer);

    Customer select(int id);

    int delete(int id);

    Customer selectById(Integer id);
}
