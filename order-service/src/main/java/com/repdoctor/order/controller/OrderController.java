package com.repdoctor.order.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public OrderController(KafkaTemplate<String, String> kafkaTemplate) { this.kafkaTemplate = kafkaTemplate; }

    @PostMapping
    public ResponseEntity<Map<String, String>> placeOrder(@RequestBody Map<String, Object> payload) {
        String orderId = UUID.randomUUID().toString();
        kafkaTemplate.send("orders", orderId + ":" + payload.getOrDefault("productId","unknown"));
        return ResponseEntity.ok(Map.of("orderId", orderId));
    }
}
