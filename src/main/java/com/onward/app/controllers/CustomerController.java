package com.onward.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onward.app.entities.Customer;
import com.onward.app.services.CustomerService;
/*This file is created  edited by Vinh Huynh(issue #4) 
 * This a file about class customer
 */
@RequestMapping("/customers")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;
    //Create customer , it read json
    @PostMapping(value = "/newcustomer", consumes = "application/json")
    @CrossOrigin
    //Add customer and teh paramter of a Customer
    public Customer addCustomer(@RequestBody Customer cus){
        return customerService.saveCustomer(cus);
    }

    //Read from list of customers
    @GetMapping("/getcustomers")
    public List<Customer> fetchCustomer(){
        return customerService.fetchCustomer();
    }
    //edit customer name and role
    //TODO By id?
    @PutMapping("/editcustomer")
    public Customer editCustomer(@RequestBody Customer cus){
        return customerService.updateCustomer(cus);
    }
    //Delete customer by id
    @DeleteMapping("/deletecustomer{id}")
    public void deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomerById(id);
    }

}
