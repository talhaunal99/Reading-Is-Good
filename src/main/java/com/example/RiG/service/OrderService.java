package com.example.RiG.service;

import com.example.RiG.model.Order;
import com.example.RiG.repository.IBookRepository;
import com.example.RiG.repository.IOrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final IOrderRepository orderRepository;
    private final IBookRepository bookRepository;

//    public Order createOrder(Order order) {
//        return null;
//    }
}
