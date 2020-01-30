package com.borrowing.response;

import com.borrowing.entity.Customer;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerResponse extends BaseResponse{
    private Customer customer;
    private List<Customer> customers;

    public CustomerResponse(Integer httpCode, String message, Customer customer, List<Customer> customers) {
        super(httpCode, message);
        this.customer = customer;
        this.customers = customers;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
