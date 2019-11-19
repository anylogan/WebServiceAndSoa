package com.forezp.subscriptions.messageservice;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface MessageService {
    //自定义通道名为message
    @Output(value = "message")
    SubscribableChannel getOutput();
    @Input(value = "data")
    SubscribableChannel getInput();
}