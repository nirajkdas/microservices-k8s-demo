package com.repdoctor.inventory.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @GetMapping("/actuator/health")
    public String health() {
        return "OK - inventory-service";
    }
}
