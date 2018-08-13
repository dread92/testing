package io.reade.testing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableJms
public class TestingApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TestingApplication.class, args);

        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

        System.out.println("Sending an email message.");
        jmsTemplate.convertAndSend("mailbox", new Email("info@example.com", "Hello"));
    }
}
