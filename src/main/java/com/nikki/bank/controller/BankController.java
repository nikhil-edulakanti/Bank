package com.nikki.bank.controller;

import com.nikki.bank.model.Customer;
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
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getAllCustomers());
    }

    @PostMapping("/api/customers")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer){
        String result = customerService.addCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/api/customers/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getCustomerById(customerId));
    }

    @PutMapping("/api/customers/{customerId}")
    public ResponseEntity<String> updateCustomer(@RequestBody Customer customer, @PathVariable Long customerId){
        try{
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerService.updateCustomer(customerId, customer));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/api/customers/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long customerId){

        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerService.deleteCustomer(customerId));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
}
