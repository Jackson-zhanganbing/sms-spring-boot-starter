package com.sms.starter.dto;

import lombok.Data;

@Data
public class SendSMSDTO {
    /**
     * 模板ID
     */
    private String templateid;
    /**
     * 参数
     */
    private String param;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 用户穿透ID，可以为空
     */
    private String uid;
}