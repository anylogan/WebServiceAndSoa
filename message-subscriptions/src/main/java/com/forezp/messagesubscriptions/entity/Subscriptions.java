package com.forezp.messagesubscriptions.entity;

import javax.persistence.*;

@Entity
@Table(name = "subscriptions")
public class Subscriptions{
    //自增ID
    @Id
    private String id;

    @Column(name = "channel")
    private String channel;


    //需要声明无参数的构造函数
    public Subscriptions(){  }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getChannel() {
        return channel;
    }
}