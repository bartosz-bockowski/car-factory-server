package com.example.carfactory.service;

import com.example.carfactory.domain.Order;
import com.example.carfactory.exception.NotFoundException;
import com.example.carfactory.message.MessageSender;
import com.example.carfactory.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final MessageSender messageSender;

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public void completeById(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundException("order not found"));
        orderRepository.deleteById(orderId);
        messageSender.sendOrderDTO(order);
    }
}
