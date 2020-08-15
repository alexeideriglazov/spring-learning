package de.springboot.web;

import de.springboot.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
    @Autowired
    private HealthService healthService;

    @RequestMapping("/check")
    public String checkStatus() {
        healthService.clearAttempt();
        return healthService.getHealth();
    }
}
