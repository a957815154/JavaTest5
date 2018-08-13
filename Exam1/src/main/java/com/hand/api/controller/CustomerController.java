package com.hand.api.controller;

import com.hand.api.service.AddressService;
import com.hand.api.service.CustomerService;
import com.hand.domain.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RequestMapping("/customer")
@RestController
public class CustomerController {
    private int addressid = 0;
    private Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AddressService addressService;

    @PostMapping("/login")
    public int login(@RequestParam String username, @RequestParam String password) {

        int flag = customerService.login(username, password);
        if (flag > 0) {
            logger.info("login success!welcome " + username);
        } else {
            logger.info("login error !");
        }
        return flag;

    }

    @PutMapping("/")
    public void add(@RequestParam String first_name, @RequestParam String last_name,
                    @RequestParam String email, @RequestParam String address) {
        Integer i = addressService.checkAddress(address);
        if (i != null) {
            Customer customer = new Customer();
            customer.setFirstName(first_name);
            customer.setLastName(last_name);
            customer.setEmail(email);
            customer.setStoreId((byte) 1);
            customer.setActive(true);
            customer.setAddressId((short) i.intValue());
            customer.setCreateDate(new Date());
            customerService.insertCustomer(customer);
            logger.info("insert customer" + customer.toString());
        } else {
            logger.info("address error");
        }


    }

    @PostMapping("/")
    public void update( @RequestBody Customer customer) {
        Integer i = customerService.update(customer);

        if (i == null) {
            logger.info("Please check the data you input!");
        } else {
            logger.info("success");
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void delete(@CookieValue("id") Integer id) {
        if (customerService.delete(id) != 0) {
            logger.info("delete success");
        } else {
            logger.info("delete fail");
        }

    }
}
