package com.forezp.eurekaserver.messageservice;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface MessageService {
    //自定义通道名为message
    @Output(value = "data")
    SubscribableChannel getOutput();
}