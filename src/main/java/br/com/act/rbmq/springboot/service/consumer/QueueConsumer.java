package br.com.act.rbmq.springboot.service.consumer;


import br.com.act.rbmq.springboot.service.configs.RabbitMQConfig;
import br.com.act.rbmq.springboot.service.dtos.ProductDTO;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static br.com.act.rbmq.springboot.service.configs.RabbitMQConfig.*;
import static br.com.act.rbmq.springboot.service.constants.DefaultSystemMessages.MSG_CONSUME_RABBITMQ;
import static br.com.act.rbmq.springboot.service.constants.DefaultSystemMessages.MSG_PRODUCE_RABBITMQ;

@Component
@Log4j2
public class QueueConsumer {

//    @RabbitListener(queues = {QUEUE_PRODUCT_LOG})
//    public void messageQueueConsumer(String message){
//        log.info("\u001B[42m" + MSG_CONSUME_RABBITMQ + message + "\u001B[40m");
//    }

    @RabbitListener(queues = {QUEUE_PRODUCT_LOG})
    public void messageQueueConsumer(@NotNull ProductDTO dto) {
        log.info("\u001B[42m" + MSG_CONSUME_RABBITMQ + dto.toString() + "\u001B[40m");
    }

}
