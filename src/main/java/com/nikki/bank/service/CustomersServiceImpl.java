package com.nikki.bank.service;


import com.nikki.bank.exceptions.CustomerExceptions;
import com.nikki.bank.model.Customer;
import com.nikki.bank.repo.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CustomersServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomersServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        Customer fetchedCustomer = customerRepository.findById(customerId)
                .orElseThrow(()->new CustomerExceptions("Customer not found"));
        return fetchedCustomer;
    }

    @Override
    public String addCustomer(Customer customer) {
        customerRepository.save(customer);
        return "Customer added";
    }

    @Override
    public String updateCustomer(Long customerId, Customer customer) {
        Customer fetchedCustomer = customerRepository.findById(customerId)
                .orElseThrow(()->new RuntimeException("Customer not found"));
        fetchedCustomer.setFirstName(customer.getFirstName());
        fetchedCustomer.setLastName(customer.getLastName());
        fetchedCustomer.setEmail(customer.getEmail());
        fetchedCustomer.setPhoneNumber(customer.getPhoneNumber());
        customerRepository.save(fetchedCustomer);
        return "Customer updated";
    }

    @Override
    public String deleteCustomer(Long customerId) {
        Customer fetchedCustomer = customerRepository.findById(customerId)
                .orElseThrow(()->new RuntimeException("Customer not found"));
        customerRepository.delete(fetchedCustomer);
        return "Customer deleted";
    }
}
