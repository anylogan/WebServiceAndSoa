package com.forezp.subscriptions;
import com.forezp.subscriptions.messageservice.MessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableBinding(MessageService.class)
public class SubscriptionsApplication {
    public static void main(String[] args) {
        SpringApplication.run(SubscriptionsApplication.class, args);
    }

}
