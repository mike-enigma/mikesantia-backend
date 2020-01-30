package com.borrowing.services.serviceImpl;

import com.borrowing.constanta.ConstantaCustomer;
import com.borrowing.entity.Customer;
import com.borrowing.exception.NotFound;
import com.borrowing.repositories.CustomerRepository;
import com.borrowing.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements com.borrowing.services.CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer saveDataCustomer(Customer customer){
        customer.setCif(Utility.generateIdLength10());
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateDataCustomer(Customer customer){
        getDataCustomerByCif(customer.getCif());
        return customerRepository.save(customer);

    }
    @Override
    public Customer getDataCustomerByCif(String cif){
        if (!customerRepository.findById(cif).isPresent()){
            throw new NotFound(String.format(ConstantaCustomer.MESSAGE_CIF_NOT_FOUND, cif));
        }
        return customerRepository.findById(cif).get();
    }

    @Override
    public List<Customer> getAllDataCustomer(){
        return customerRepository.findAll();
    }

    @Override
    public void deleteDataCustomerByCif(String cif){
        customerRepository.deleteById(cif);
    }

    @Override
    public List<Customer> searchCustomerByFirstName(String firstName){
       return customerRepository.findByFirstName(firstName);
    }
}
