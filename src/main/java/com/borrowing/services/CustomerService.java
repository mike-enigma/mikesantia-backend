package com.borrowing.services;

import com.borrowing.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer saveDataCustomer(Customer customer);

    Customer updateDataCustomer(Customer customer);

    Customer getDataCustomerByCif(String cif);

    List<Customer> getAllDataCustomer();

    void deleteDataCustomerByCif(String cif);

    List<Customer> searchCustomerByFirstName(String firstName);
}
