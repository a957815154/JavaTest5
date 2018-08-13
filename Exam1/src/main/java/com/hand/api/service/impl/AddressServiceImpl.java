package com.hand.api.service.impl;


import com.hand.api.service.AddressService;
import com.hand.infra.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;
    @Override
    public Integer checkAddress(String address) {
       return addressMapper.checkAddress(address);
    }



}