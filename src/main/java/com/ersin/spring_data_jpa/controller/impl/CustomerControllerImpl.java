package com.ersin.spring_data_jpa.controller.impl;

import com.ersin.spring_data_jpa.controller.ICustomerController;
import com.ersin.spring_data_jpa.dto.DtoCustomer;
import com.ersin.spring_data_jpa.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/api")
public class CustomerControllerImpl implements ICustomerController {

    @Autowired
    private ICustomerService customerService;
    @GetMapping(path = "/customer/{id}")
    @Override
    public DtoCustomer findCustomerById(@PathVariable(name = "id") Long id) {
        return customerService.findCustomerById(id);
    }

    @GetMapping(path = "/customers")
    @Override
    public List<DtoCustomer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}
