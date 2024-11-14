package com.ersin.spring_data_jpa.services.impl;

import com.ersin.spring_data_jpa.dto.DtoAddress;
import com.ersin.spring_data_jpa.dto.DtoCustomer;
import com.ersin.spring_data_jpa.entites.Address;
import com.ersin.spring_data_jpa.entites.Customer;
import com.ersin.spring_data_jpa.repository.CustomerRepository;
import com.ersin.spring_data_jpa.services.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public DtoCustomer findCustomerById(Long id) {
        DtoCustomer dtoCustomer = new DtoCustomer();
        DtoAddress dtoAddress = new DtoAddress();
        Optional<Customer> optional = customerRepository.findById(id);

        if(optional.isPresent()){
            Customer customer = optional.get();
            Address address = optional.get().getAddress();
            BeanUtils.copyProperties(customer, dtoCustomer);
            BeanUtils.copyProperties(address, dtoAddress);
            dtoCustomer.setAddress(dtoAddress);

            return dtoCustomer;
        }else{
            throw new RuntimeException("Customer with id " +id+ " not found");
        }

    }

    @Override
    public List<DtoCustomer> getAllCustomers() {
        List<Customer> customers = customerRepository.getAllCustomers();
        List<DtoCustomer> customersDto = new ArrayList<>();

        for (Customer customer : customers) {
            DtoCustomer dtoCustomer = new DtoCustomer();
            BeanUtils.copyProperties(customer, dtoCustomer);
            DtoAddress dtoAddress = new DtoAddress();
            BeanUtils.copyProperties(customer.getAddress(), dtoAddress);
            dtoCustomer.setAddress(dtoAddress);
            customersDto.add(dtoCustomer);
        }
        return customersDto;

    }
}
