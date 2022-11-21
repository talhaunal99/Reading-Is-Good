package com.example.RiG.service;

import com.example.RiG.model.Customer;
import com.example.RiG.repository.ICustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    private final ICustomerRepository customerRepository;


    @Transactional
    public Customer registerCustomer(Customer customer) {

        if(customerRepository.findByEmail(customer.getEmail()).isPresent()) {
            log.info("Customer already registered before with e-mail: {}", customer.getEmail());
            return null;
        }

        customerRepository.save(customer);
        log.info("Customer registered successfully with email: {}", customer.getEmail());

        return customer;
    }


}
