package com.example.carfactory.message;

import com.example.carfactory.constants.Constants;
import com.example.carfactory.domain.Order;
import com.example.carfactory.dto.OrderDTO;
import com.example.carfactory.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
@Slf4j
public class MessageReceiver {

    private final OrderService orderService;

    private final ModelMapper modelMapper;

    @RabbitListener(queues = Constants.CAR_REQUEST_QUEUE)
    public void receiveMessage(OrderDTO message) {
        if (Objects.isNull(message)) {
            return;
        }
        log.info("RabbitMQ: Object received from the client. " + message);
        orderService.save(modelMapper.map(message, Order.class));
    }
}
