package com.example.carfactory.message;

import com.example.carfactory.config.MessageConfig;
import com.example.carfactory.domain.Order;
import com.example.carfactory.dto.OrderDTO;
import com.example.carfactory.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class MessageReceiver {

    private final OrderService orderService;

    private final ModelMapper modelMapper;

    @RabbitListener(queues = MessageConfig.CAR_REQUEST_QUEUE)
    public void receiveMessage(OrderDTO message) {
        if (Objects.isNull(message)) {
            return;
        }
        orderService.save(modelMapper.map(message, Order.class));
    }
}
