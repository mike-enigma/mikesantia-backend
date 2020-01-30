package com.borrowing.controller;

import com.borrowing.entity.Customer;
import com.borrowing.response.CustomerResponse;
import com.borrowing.services.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
@Api(value = "Customer Api", description = "Customer Api")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    private CustomerResponse customerResponse = null;

    @ApiOperation(value = "Add Customer", response = CustomerResponse.class)
    @PostMapping("customer")
    public ResponseEntity<CustomerResponse> saveDataCustomer(
            @ApiParam(value = "Customer Object", required = true)
            @RequestBody Customer customer) {
        Customer saveCustomer = customerService.saveDataCustomer(customer);
        customerResponse = new CustomerResponse(HttpStatus.CREATED.value(), "Success Add Customer " + saveCustomer, null, null);
        return new ResponseEntity<CustomerResponse>(customerResponse, HttpStatus.CREATED);
    }
    @ApiOperation(value = "Edit Customer", response = CustomerResponse.class)
    @PutMapping("customer")
    public ResponseEntity<CustomerResponse> updateDataCustomer(
            @ApiParam(value = "Customer Object", required = true)
            @RequestBody Customer customer) {
        Customer update = customerService.updateDataCustomer(customer);
        customerResponse = new CustomerResponse(HttpStatus.CREATED.value(), "Success Update Customer " + update, null, null);
        return new ResponseEntity<CustomerResponse>(customerResponse, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get Customer By cif", response = CustomerResponse.class)
    @GetMapping("customer/{cif}")
    public ResponseEntity<CustomerResponse> getCustomerByCif(
            @ApiParam(value = "Cif Customer", required = true)
            @PathVariable String cif) {
        Customer customer = customerService.getDataCustomerByCif(cif);
        customerResponse = new CustomerResponse(HttpStatus.OK.value(), "Customer By Cif " + customer.getCif(), customer, null);
        return new ResponseEntity<CustomerResponse>(customerResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Get List Customer", response = CustomerResponse.class)
    @GetMapping("customers")
    public ResponseEntity<CustomerResponse> getAllCustomer() {
        List<Customer> customers = customerService.getAllDataCustomer();
        customerResponse = new CustomerResponse(HttpStatus.OK.value(), "List Customer", null, customers);
        return new ResponseEntity<CustomerResponse>(customerResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Search Customer By FirstName", response = CustomerResponse.class)
    @GetMapping("customer")
    public ResponseEntity<CustomerResponse> searchDataCustomerByFirstName(
            @ApiParam(value = "FirstName Customer", required = true) @RequestParam String firstName) {
        List<Customer> customers = customerService.searchCustomerByFirstName(firstName);
        customerResponse = new CustomerResponse(HttpStatus.OK.value(),"Data Customer", null, customers);
        return new ResponseEntity<CustomerResponse>(customerResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete Customer By Cif", response = CustomerResponse.class)
    @DeleteMapping("customer/{cif}")
    public void deleteCustomerByCif(
            @ApiParam(value = "Cif Customer", required = true)
            @PathVariable String cif) {
        customerService.deleteDataCustomerByCif(cif);
    }
}
