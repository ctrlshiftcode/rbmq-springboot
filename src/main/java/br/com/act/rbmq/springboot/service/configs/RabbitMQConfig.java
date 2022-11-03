package br.com.act.rbmq.springboot.service.configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

public class RabbitMQConfig {

    public static final String EXG_NAME_MARKETPLACE = "marketplace.direct";
    public static final String QUEUE_PRODUCT_LOG    = "product.log";
    public static final String RK_PRODUCT_LOG       = "product.log";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_PRODUCT_LOG, false, false, false );
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(EXG_NAME_MARKETPLACE, false, false);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder
                .bind(this.queue())
                .to(this.directExchange())
                .with(RK_PRODUCT_LOG);
    }

}
