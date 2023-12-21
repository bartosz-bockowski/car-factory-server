package com.example.carfactory.message;

import com.example.carfactory.constants.Constants;
import com.example.carfactory.domain.Order;
import com.example.carfactory.dto.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageSender {

    private final RabbitTemplate rabbitTemplate;

    private final ModelMapper modelMapper;

    public void sendOrderDTO(Order order) {
        rabbitTemplate.convertAndSend(Constants.CAR_PRODUCED_QUEUE, modelMapper.map(order, OrderDTO.class));
    }
}
