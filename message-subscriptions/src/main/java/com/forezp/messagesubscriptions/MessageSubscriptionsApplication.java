package com.forezp.messagesubscriptions;

import com.forezp.messagesubscriptions.messageservice.ReceiveMessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(ReceiveMessageService.class)
public class MessageSubscriptionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageSubscriptionsApplication.class, args);
    }

}
