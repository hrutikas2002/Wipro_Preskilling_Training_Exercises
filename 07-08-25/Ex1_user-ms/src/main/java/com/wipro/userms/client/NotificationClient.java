package com.wipro.userms.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.wipro.userms.dto.NotificationDTO;

@FeignClient(name = "notification-ms")
public interface NotificationClient {
    @PostMapping("/notify")
    void sendNotification(@RequestBody NotificationDTO request);
}
