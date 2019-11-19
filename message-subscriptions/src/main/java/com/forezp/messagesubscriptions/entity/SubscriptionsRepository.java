package com.forezp.messagesubscriptions.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionsRepository extends JpaRepository<Subscriptions,Integer> {
    Subscriptions findById(String id);
}