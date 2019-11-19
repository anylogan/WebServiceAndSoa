package com.forezp.messagesubscriptions.controller;

import com.forezp.messagesubscriptions.entity.Subscriptions;
import com.forezp.messagesubscriptions.entity.SubscriptionsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;


public class  SubscriptionsController {
    @Autowired
    private SubscriptionsRepository studentRepository;
    private static int cnt = 0;

    public List<Subscriptions> queryAll(){
        List<Subscriptions> list = new ArrayList<Subscriptions>();
        list = studentRepository.findAll();
        return list;
    }

    public  void add(){
        Subscriptions user = new Subscriptions();
        user.setChannel("junjun"+(cnt++));
        studentRepository.save(user);
    }
    public  void update(){
        Subscriptions user = studentRepository.findById(1).get();
        user.setChannel("duoduo");
        studentRepository.save(user);
    }

}