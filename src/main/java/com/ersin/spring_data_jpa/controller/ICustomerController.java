package com.ersin.spring_data_jpa.controller;

import com.ersin.spring_data_jpa.dto.DtoCustomer;

import java.util.List;

public interface ICustomerController {
    public DtoCustomer findCustomerById(Long id);

    public List<DtoCustomer> getAllCustomers();

}
