package com.nikki.bank.service;


import com.nikki.bank.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Customer getCustomerById(Long customerId);

    String addCustomer(Customer customer);

    String updateCustomer(Long customerId, Customer customer);

    String deleteCustomer(Long customerId);
}
