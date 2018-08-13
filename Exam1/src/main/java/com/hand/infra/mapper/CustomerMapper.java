package com.hand.infra.mapper;

import com.hand.domain.entity.Customer;
import com.hand.infra.util.MyMapper;
import org.apache.ibatis.annotations.Param;

public interface CustomerMapper extends MyMapper<Customer> {
    int login(@Param("username") String username,@Param("password") String password);
}