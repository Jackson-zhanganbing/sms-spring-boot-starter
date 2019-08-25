package com.sms.starter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "sms-config")
public class SMSProperties {
    private String appid;
    private String accountSid;
    private String authToken;
}