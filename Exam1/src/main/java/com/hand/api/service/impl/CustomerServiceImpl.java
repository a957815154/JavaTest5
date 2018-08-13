package com.hand.api.service.impl;

import com.hand.api.service.CustomerService;
import com.hand.domain.entity.Customer;
import com.hand.infra.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Customer selectById(Integer id) {
       return customerMapper.selectByPrimaryKey(id);
    }

    @Override
    public int login(String username, String password) {
        return customerMapper.login(username, password);
    }

    @Override
    public int insertCustomer(Customer customer) {
      return   customerMapper.insert(customer);
    }


    @Override
    public int update(Customer customer)
    {
        return customerMapper.updateByPrimaryKey(customer);
    }

    @Override
    public Customer select(int id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(int id) {
      return  customerMapper.deleteByPrimaryKey((short)id);
    }
}
