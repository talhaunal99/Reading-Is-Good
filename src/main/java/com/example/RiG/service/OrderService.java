package com.example.RiG.service;

import com.example.RiG.model.Order;
import com.example.RiG.repository.IBookRepository;
import com.example.RiG.repository.ICustomerRepository;
import com.example.RiG.repository.IOrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final IOrderRepository orderRepository;
    private final ICustomerRepository customerRepository;
    private final IBookRepository bookRepository;

    public Order createOrder(Order order) {
        if(order != null) {
            if(!customerRepository.findById(order.getCustomer().getId()).isPresent()) {
                log.error("Customer is not registered with id: {}", order.getCustomer().getId());
                return null;
            } else if(!bookRepository.findById(order.getBook().getId()).isPresent()) {
                log.error("Book is not exists with id: {}", order.getBook().getId());
                return null;
            } else {
                orderRepository.save(order);
                return order;
            }
        }
        return null;
    }
}
