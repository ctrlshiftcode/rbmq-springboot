package br.com.act.rbmq.springboot.service.services;

import br.com.act.rbmq.springboot.service.constants.DefaultSystemMessages;
import br.com.act.rbmq.springboot.service.dtos.ProductDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static br.com.act.rbmq.springboot.service.configs.RabbitMQConfig.*;
import static br.com.act.rbmq.springboot.service.constants.DefaultSystemMessages.*;

@Log4j2
@RequiredArgsConstructor
@Service
public class MessageService {

    private final RabbitTemplate rabbitTemplate;

    public void produceMessage(String message){
        log.info("\u001B[42m" + MSG_PRODUCE_RABBITMQ + message + "\u001B[40m");
        rabbitTemplate.convertAndSend(EXG_NAME_MARKETPLACE, RK_PRODUCT_LOG, message);
    }

    public ProductDTO produceProduct(ProductDTO dto){
        log.info("\u001B[42m" + MSG_PRODUCE_RABBITMQ + dto.toString() + "\u001B[40m");
        rabbitTemplate.convertAndSend(EXG_NAME_MARKETPLACE, RK_PRODUCT_LOG, dto);
        return dto;
    }

}
