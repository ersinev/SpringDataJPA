package com.ersin.spring_data_jpa.services;

import com.ersin.spring_data_jpa.dto.DtoCustomer;

import java.util.List;

public interface ICustomerService {
    public DtoCustomer findCustomerById(Long id);
    public List<DtoCustomer> getAllCustomers();
}
