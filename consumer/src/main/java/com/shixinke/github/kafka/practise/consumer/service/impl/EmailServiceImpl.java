package com.shixinke.github.kafka.practise.consumer.service.impl;

import com.shixinke.github.kafka.practise.consumer.service.EmailService;

/**
 * @author shixinke
 * @version 1.0
 * @Description
 * @Date 19-2-1 下午5:06
 */
public class EmailServiceImpl implements EmailService {

    /**
     * 发送邮件
     * @param receiver
     * @param receiverEmail
     * @param title
     * @param content
     * @param sender
     * @param senderEmail
     * @return
     */
    @Override
    public int send(String receiver, String receiverEmail,  String title, String content, String sender, String senderEmail) {
        return 1;
    }
}
