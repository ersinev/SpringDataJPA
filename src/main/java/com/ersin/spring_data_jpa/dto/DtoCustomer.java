package com.ersin.spring_data_jpa.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DtoCustomer {

    private Long id;

    private String name;

    private DtoAddress address;
}
