package com.nikki.bank.controller;

import com.nikki.bank.model.Customer;
import com.nikki.bank.payload.CustomerDTO;
import com.nikki.bank.payload.CustomerResponse;
import com.nikki.bank.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankController {

    private CustomerService customerService;

    public BankController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/api/customers")
    public ResponseEntity<CustomerResponse> getAllCustomers(@RequestParam(name = "pageSize" , required = false) Integer pageSize,
                                                            @RequestParam(name = "pageNumber",required = false) Integer pageNumber) {

        CustomerResponse result = customerService.getAllCustomers(pageSize, pageNumber);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/api/customers")
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO){
        CustomerDTO result = customerService.addCustomer(customerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/api/customers/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long customerId){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getCustomerById(customerId));
    }

    @PutMapping("/api/customers/{customerId}")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO, @PathVariable Long customerId){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerService.updateCustomer(customerId,customerDTO));
    }

    @DeleteMapping("/api/customers/{customerId}")
    public ResponseEntity<CustomerDTO> deleteCustomer(@PathVariable Long customerId){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerService.deleteCustomer(customerId));
    }
}
