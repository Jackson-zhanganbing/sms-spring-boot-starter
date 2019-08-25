package com.sms.starter.config;

import com.sms.starter.service.SMSService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(SMSProperties.class)//使@ConfigurationProperties注解生效
public class SmsAutoConfiguration {
    @Bean
    public SMSService getBean(SMSProperties smsProperties){
        SMSService smsService = new SMSService(smsProperties);
        return smsService;
    }
}