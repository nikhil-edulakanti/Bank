package com.nikki.bank.service;


import com.nikki.bank.exceptions.CustomerExceptions;
import com.nikki.bank.model.Customer;
import com.nikki.bank.payload.CustomerDTO;
import com.nikki.bank.payload.CustomerResponse;
import com.nikki.bank.repo.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.xml.catalog.Catalog;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomersServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CustomersServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerResponse getAllCustomers(Integer pageSize, Integer pageNumber) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Customer> customers = customerRepository.findAll(pageable);
        if(customers.isEmpty()){
            throw new CustomerExceptions("No customers found");
        }
        List<CustomerDTO> customerDTOList = customers.stream().map(c->modelMapper.map(c,CustomerDTO.class)).collect(Collectors.toList());
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setCustomerDTOList(customerDTOList);
        customerResponse.setPageSize(customers.getSize());
        customerResponse.setPageNumber(customers.getNumber());
        customerResponse.setTotalElements(customers.getTotalElements());
        customerResponse.setLastPage(customers.isLast());
        return customerResponse;
    }

    @Override
    public CustomerDTO getCustomerById(Long customerId) {
        Customer fetchedCustomer = customerRepository.findById(customerId)
                .orElseThrow(()->new CustomerExceptions("Customer not found"));
        return modelMapper.map(fetchedCustomer, CustomerDTO.class);
    }

    @Override
    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        Customer toAdd = modelMapper.map(customerDTO, Customer.class);
        customerRepository.save(toAdd);
        return modelMapper.map(toAdd, CustomerDTO.class);
    }

    @Override
    public CustomerDTO updateCustomer(Long customerId, CustomerDTO customerDTO) {
        Customer fetchedCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerExceptions("Customer not found"));
        Customer toUpdate = modelMapper.map(customerDTO, Customer.class);
        fetchedCustomer.setFirstName(toUpdate.getFirstName());
        fetchedCustomer.setLastName(toUpdate.getLastName());
        fetchedCustomer.setPhoneNumber(toUpdate.getPhoneNumber());
        return modelMapper.map(customerRepository.save(fetchedCustomer), CustomerDTO.class);
    }

    @Override
    public CustomerDTO deleteCustomer(Long customerId) {
        Customer fetchedCustomer = customerRepository.findById(customerId)
                .orElseThrow(()->new RuntimeException("Customer not found"));

        CustomerDTO deletedCustomerDTO = modelMapper.map(fetchedCustomer, CustomerDTO.class);
        customerRepository.delete(fetchedCustomer);
        return deletedCustomerDTO;
    }
}
