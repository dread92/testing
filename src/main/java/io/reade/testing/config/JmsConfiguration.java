package io.reade.testing.config;

import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;

@Configuration
public class JmsConfiguration {
    @Bean
    public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
                                                    DefaultJmsListenerContainerFactoryConfigurer configurer) {

        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();

        // This provides all of Spring boots defaults to this factory, including the message converter.
        configurer.configure(factory, connectionFactory);

        // You could still override some of Boot's defaults if needed.
        return factory;
    }

    @Bean // Serialize message content to json using TextMessage
    public MessageConverter jacksonJmsMessageConverter() {

        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();

        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");

        return converter;
    }


}
