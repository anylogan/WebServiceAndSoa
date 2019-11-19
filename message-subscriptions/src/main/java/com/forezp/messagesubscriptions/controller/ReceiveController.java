package com.forezp.messagesubscriptions.controller;

import com.forezp.messagesubscriptions.entity.Subscriptions;
import com.forezp.messagesubscriptions.entity.SubscriptionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ReceiveController {
    private  String message;
    @StreamListener("message")
    public void onReceive(String messageInfo) {
        System.out.println("接受到的消息：" + messageInfo);
        message=messageInfo;
        //判断一下  如果id已经存在  那么update  否则add
       String []arr= messageInfo.split(" ");
        String id=arr[0];
        String channel=arr[1];
        Subscriptions user=subscriptionsRepository.findById(id);
        if (user == null) {
            add();
        } else {
            user.setChannel(channel);
            subscriptionsRepository.save(user);
        }
    }

    @Autowired
    private SubscriptionsRepository subscriptionsRepository;

    public List<Subscriptions> queryAll(){
        List<Subscriptions> list = new ArrayList<Subscriptions>();
        list = subscriptionsRepository.findAll();
        return list;
    }

    public  void add(){
        Subscriptions user = new Subscriptions();
         String []chanel=message.split(" ");
         user.setId(chanel[0]);
        user.setChannel(chanel[1]);
        subscriptionsRepository.save(user);
    }


}
