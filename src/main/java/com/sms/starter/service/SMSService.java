package com.sms.starter.service;

import com.alibaba.fastjson.JSONObject;
import com.sms.starter.common.SMSURLEnum;
import com.sms.starter.config.SMSProperties;
import com.sms.starter.dto.SendSMSDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class SMSService {

    @Autowired
    private RestTemplate restTemplate;
    private String appid;
    private String accountSid;
    private String authToken;

    /**
     * 初始化
     */
    public SMSService(SMSProperties smsProperties) {
        this.appid = smsProperties.getAppid();
        this.accountSid = smsProperties.getAccountSid();
        this.authToken = smsProperties.getAuthToken();
    }

    /**
     * 单独发送
     */
    public String sendSMS(SendSMSDTO sendSMSDTO){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sid", accountSid);
        jsonObject.put("token", authToken);
        jsonObject.put("appid", appid);
        jsonObject.put("templateid", sendSMSDTO.getTemplateid());
        jsonObject.put("param", sendSMSDTO.getParam());
        jsonObject.put("mobile", sendSMSDTO.getMobile());
        if (sendSMSDTO.getUid()!=null){
            jsonObject.put("uid",sendSMSDTO.getUid());
        }else {
            jsonObject.put("uid","");
        }
        String json = JSONObject.toJSONString(jsonObject);
        //使用restTemplate进行访问远程Http服务
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> httpEntity = new HttpEntity<String>(json, headers);
        String result = restTemplate.postForObject(SMSURLEnum.SENDSMS.getUrl(), httpEntity, String.class);
        return result;
    }

    /**
     * 群体发送
     */
    public String sendBatchSMS(SendSMSDTO sendSMSDTO){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sid", accountSid);
        jsonObject.put("appid", appid);
        jsonObject.put("token", authToken);
        jsonObject.put("templateid", sendSMSDTO.getTemplateid());
        jsonObject.put("mobile", sendSMSDTO.getMobile());
        jsonObject.put("param", sendSMSDTO.getParam());
        if (sendSMSDTO.getUid()!=null){
            jsonObject.put("uid",sendSMSDTO.getUid());
        }else {
            jsonObject.put("uid","");
        }
        HttpHeaders headers = new HttpHeaders();
        String json = JSONObject.toJSONString(jsonObject);
        //使用restTemplate进行访问远程Http服务
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> httpEntity = new HttpEntity<String>(json, headers);
        String result = restTemplate.postForObject(SMSURLEnum.SENDBATCHSMS.getUrl(), httpEntity, String.class);
        return result;
    }
}
