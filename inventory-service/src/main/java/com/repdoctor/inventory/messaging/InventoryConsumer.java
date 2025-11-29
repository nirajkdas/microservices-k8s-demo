package com.repdoctor.inventory.messaging;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class InventoryConsumer {

    @KafkaListener(topics = "orders", groupId = "inventory-group")
    public void handleOrderEvent(String message) {
        System.out.println("[inventory] received: " + message);
    }
}
