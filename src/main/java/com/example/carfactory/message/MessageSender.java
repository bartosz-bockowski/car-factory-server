package com.example.carfactory.message;

import com.example.carfactory.constants.Constants;
import com.example.carfactory.domain.Order;
import com.example.carfactory.dto.OrderDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageSender {

    private final RabbitTemplate rabbitTemplate;

    private final ModelMapper modelMapper;

    public void sendOrderDTO(Order order) {
        OrderDTO message = modelMapper.map(order, OrderDTO.class);
        log.info("RabbitMQ: Object sent to the client. " + message);
        rabbitTemplate.convertAndSend(Constants.CAR_PRODUCED_QUEUE, message);
    }
}
