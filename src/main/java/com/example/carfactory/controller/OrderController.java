package com.example.carfactory.controller;

import com.example.carfactory.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderService orderService;

    @PatchMapping("/{orderId}")
    public HttpStatus complete(@PathVariable Long orderId) {
        orderService.completeById(orderId);
        return HttpStatus.OK;
    }
}
