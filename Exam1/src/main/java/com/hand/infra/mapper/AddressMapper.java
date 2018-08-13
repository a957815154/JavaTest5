package com.hand.infra.mapper;

import com.hand.domain.entity.Address;
import com.hand.infra.util.MyMapper;
import org.apache.ibatis.annotations.Param;

public interface AddressMapper extends MyMapper<Address> {
    Integer checkAddress(@Param("address") String address);
}