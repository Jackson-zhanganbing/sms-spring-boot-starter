package com.sms.starter.common;

import lombok.Getter;

@Getter
public enum SMSURLEnum {
    SENDSMS("https://open.ucpaas.com/ol/sms/sendsms"),
    SENDBATCHSMS("https://open.ucpaas.com/ol/sms/sendsms_batch");
    private String url;
    SMSURLEnum(String url) {
        this.url = url;
    }
}