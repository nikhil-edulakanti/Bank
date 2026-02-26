package com.nikki.bank.service;


import com.nikki.bank.model.Customer;
import com.nikki.bank.payload.CustomerDTO;
import com.nikki.bank.payload.CustomerResponse;

import java.util.List;

public interface CustomerService {

    CustomerResponse getAllCustomers(Integer pageSize, Integer pageNumber);

    CustomerDTO getCustomerById(Long customerId);

    CustomerDTO addCustomer(CustomerDTO customerDTO);

    CustomerDTO updateCustomer(Long customerId, CustomerDTO customerDTO);

    CustomerDTO deleteCustomer(Long customerId);
}
